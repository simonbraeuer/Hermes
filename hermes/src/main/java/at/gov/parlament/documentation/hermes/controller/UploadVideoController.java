package at.gov.parlament.documentation.hermes.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
public class UploadVideoController {
	
	@Autowired()
	IVideoService videoService;

	@RequestMapping(value = "/uploadVideo", method = RequestMethod.GET)
	public String provideUploadInfo(@RequestParam(value = "message", required = false, defaultValue = "") String message, Model model) {
		model.addAttribute("message", message);
		return "uploadVideo";
	}

	@RequestMapping(value = "/uploadVideo", method = RequestMethod.POST)
	public  String handleFileUpload(
			@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file, Model model) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				Video newVideo = new Video();
				newVideo.setFileName(name);
				newVideo.setPositionMarkers(new ArrayList<PositionMarker>());
				videoService.addVideo(newVideo, bytes);
				model.addAttribute("message", "Datei erfolgreich hochgeladen!");
			} catch (Exception e) {
				model.addAttribute("message", "Fehler: " + e.getMessage());
			}
		} else {
			model.addAttribute("message", "Sie müssen eine Datei wählen!");
		}
		return "uploadVideo";
	}
}
