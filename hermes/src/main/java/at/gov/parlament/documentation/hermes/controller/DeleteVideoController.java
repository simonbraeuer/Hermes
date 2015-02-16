package at.gov.parlament.documentation.hermes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import at.gov.parlament.documentation.hermes.domain.Video;
import at.gov.parlament.documentation.hermes.service.IVideoService;

@Controller
public class DeleteVideoController {
	
	@Autowired
	IVideoService videoService;

	@Autowired
	SearchVideoController searchVideoController;
	
	@RequestMapping(value = "/deleteVideo", method = RequestMethod.GET)
	public String deleteVideo(
			@RequestParam(value = "videoFile", required = false, defaultValue = "") String videoFile,
			Model model) {
		if (videoFile.isEmpty()) {
			return searchVideoController.handleSearchVideo("", model);
		}
		// get video from filename
		Video video = videoService.getVideo(videoFile);
		if (video == null || video.getFileName().isEmpty()) {
			return searchVideoController.handleSearchVideo("", model);
		}
		videoService.deleteVideo(video);
		return searchVideoController.handleSearchVideo("", model);
	}
}
