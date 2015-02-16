package at.gov.parlament.documentation.hermes.service;

import groovy.util.logging.Slf4j;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.crsh.console.jline.internal.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.gov.parlament.documentation.hermes.domain.PositionMarker;
import at.gov.parlament.documentation.hermes.domain.Video;

@Slf4j
@Service
public class VideoServiceDummyImpl implements IVideoService {
	private List<Video> allVideos = new ArrayList<Video>();
	private String localPath = "/opt/files/";
	
	@Autowired
	private IFastStartVideoService fastStartService;
	
	@Autowired
	private Properties applicationProperties = new Properties();

	public VideoServiceDummyImpl() {
		super();
		
		localPath = applicationProperties.getProperty("videoService.directory","/opt/files/");
		refreshVideoList();
	}

	@Override
	public List<Video> getVideoListWhereNameStartsWith(
			String videoFileNameStartsWith) {
		refreshVideoList();
		ArrayList<Video> ret = new ArrayList<Video>();
		for (Video existing : allVideos) {
			if (existing.getFileName().startsWith(videoFileNameStartsWith)) {
				ret.add(existing);
			}
		}
		return ret;
	}

	@Override
	public void readPositionMarkers(Video video) {
		if (video != null && video.getFileName() != null) {
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

			newList.add(pm1);
			newList.add(pm2);
			newList.add(pm3);

			video.setPositionMarkers(newList);
		}
	}

	@Override
	public void addVideo(Video video, byte[] rawVideoFile) {
		BufferedOutputStream stream;
		try {
			stream = new BufferedOutputStream(new FileOutputStream(new File(
					localPath + video.getFileName())));
			stream.write(rawVideoFile);
			stream.close();
			fastStartService.convert(new File(localPath+video.getFileName()));
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

	private void refreshVideoList() {
		allVideos.clear();
		// initialize video list
		for (File file : new File(localPath).listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if (pathname.isFile() && pathname.getName().endsWith(".mp4")) {
					return true;
				}
				return false;
			}
		})) {
			Video newVideo = new Video();
			newVideo.setFileName(file.getName());
			readPositionMarkers(newVideo);
			allVideos.add(newVideo);

		}
	}

	@Override
	public void deleteVideo(Video video) {
		Log.info("Delete video: " + video);
		allVideos.remove(video);
		File toDelete = new File(localPath+video.getFileName());
		toDelete.delete();
	}

}
