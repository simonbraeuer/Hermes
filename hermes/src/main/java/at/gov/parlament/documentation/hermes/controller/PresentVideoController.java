package at.gov.parlament.documentation.hermes.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import at.gov.parlament.documentation.hermes.domain.PositionMarker;
import at.gov.parlament.documentation.hermes.domain.Video;
import at.gov.parlament.documentation.hermes.service.IVideoService;

@Controller
public class PresentVideoController {
	
	@Autowired()
	IVideoService videoService;

	@RequestMapping(value = "/presentVideo", method = RequestMethod.GET)
	public String presentVideo(
			@RequestParam(value = "videoFile", required = false, defaultValue = "") String videoFile,
			Model model) {
		if (videoFile.isEmpty()) {
			return "searchVideo";
		}
		// get video from filename
		Video video = videoService.getVideo(videoFile);
		if (video == null || video.getFileName().isEmpty()) {
			return "searchVideo";
		}
		videoService.readPositionMarkers(video);
		
		// get presentation model from video
		PresentVideoModel presentVideoModel = PresentVideoModel.createByVideo(video);
		model.addAttribute("presentVideoModel", presentVideoModel);
		return "presentVideo";
	}

	@RequestMapping(value = "/presentVideo2", method = RequestMethod.GET)
	@ResponseBody
	public void presentVideo2(HttpServletResponse response) {
		try {
			String path = "hermes.mp4";
			File file = new File(path);
			response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
			response.setHeader("Content-Disposition", "attachment; filename="
					+ file.getName().replace(" ", "_"));
			InputStream iStream = new FileInputStream(file);
			IOUtils.copy(iStream, response.getOutputStream());
			response.flushBuffer();
		} catch (IOException e) {
			response.setStatus(HttpStatus.NOT_FOUND.value());
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}
}
