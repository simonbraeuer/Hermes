package at.gov.parlament.documentation.hermes.controller;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import at.gov.parlament.documentation.hermes.domain.PositionMarker;
import at.gov.parlament.documentation.hermes.domain.Video;
import at.gov.parlament.documentation.hermes.service.IVideoService;

@Controller
public class UploadVideoController {
	
	@Autowired()
	IVideoService videoService;

	@RequestMapping(value = "/uploadVideo", method = RequestMethod.GET)
	public String provideUploadInfo() {
		return "uploadVideo";
	}

	@RequestMapping(value = "/uploadVideo", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(
			@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				Video newVideo = new Video();
				newVideo.setFileName(name);
				newVideo.setPositionMarkers(new ArrayList<PositionMarker>());
				videoService.addVideo(newVideo, bytes);
				// TODO add functionality for positionmarkers
				
				return "You successfully uploaded " + name + "!";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}
}
