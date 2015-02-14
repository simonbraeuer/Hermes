package at.gov.parlament.documentation.hermes.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import at.gov.parlament.documentation.hermes.domain.PositionMarker;
import at.gov.parlament.documentation.hermes.domain.Video;

@Service
public class VideoServiceDummyImpl implements IVideoService{
	private List<Video> allVideos = new ArrayList<Video>();
	private String localPath = "/opt/files/";
	
	public VideoServiceDummyImpl() {
		super();
		// initialize video list
		for (File file : new File(localPath).listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				if (pathname.isFile() && pathname.getName().endsWith(".mp4")) {
					return true;
				}
				return false;
			}
		}) ) {
			Video newVideo = new Video();
			newVideo.setFileName(file.getName());
			readPositionMarkers(newVideo);
			allVideos.add(newVideo);
		}
		
	}

	@Override
	public List<Video> getVideoListWhereNameStartsWith(String videoFileNameStartsWith) {
		ArrayList<Video> ret = new ArrayList<Video>();
		for(Video existing : allVideos) {
			if (existing.getFileName().startsWith(videoFileNameStartsWith)) {
				ret.add(existing);
			}
		}
		return ret;
	}

	@Override
	public void readPositionMarkers(Video video) {
		List<PositionMarker> newList = new ArrayList<PositionMarker>();
		PositionMarker pm1 = new PositionMarker();
		PositionMarker pm2 = new PositionMarker();
		PositionMarker pm3 = new PositionMarker();
		
		pm1.setName(video.getFileName() + " 5 Sekunden");
		pm2.setName(video.getFileName() + " 13 Sekunden");
		pm3.setName(video.getFileName() + " 45 Sekunden");
		
		pm1.setOffsetSeconds(5);
		pm2.setOffsetSeconds(13);
		pm3.setOffsetSeconds(45);
	}

	@Override
	public void addVideo(Video video, byte[] rawVideoFile) {
			BufferedOutputStream stream;
			try {
				stream = new BufferedOutputStream(
						new FileOutputStream(new File(localPath + video.getFileName())));
				stream.write(rawVideoFile);
				stream.close();
				allVideos.add(video);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	@Override
	public Video getVideo(String videoFileName) {
		for (Video video : allVideos) {
			if (video.getFileName().equals(videoFileName)) {
				return video;
			}
		}
		return null;
	}

}
