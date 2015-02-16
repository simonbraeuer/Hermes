package at.gov.parlament.documentation.hermes.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import at.gov.parlament.documentation.hermes.domain.Video;

@Component
public interface IVideoService {
	List<Video> getVideoListWhereNameStartsWith (String videoFileNameStartsWith);
	Video getVideo (String videoFileName);
	void addVideo(Video video, byte[] rawVideoFile);
	void readPositionMarkers (Video video);
	void deleteVideo(Video video);
}
