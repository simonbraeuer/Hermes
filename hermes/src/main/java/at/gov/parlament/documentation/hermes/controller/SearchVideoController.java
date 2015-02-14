package at.gov.parlament.documentation.hermes.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import at.gov.parlament.documentation.hermes.domain.Video;
import at.gov.parlament.documentation.hermes.service.IVideoService;

@Controller
public class SearchVideoController {
	
	@Autowired()
	IVideoService videoService;

	@RequestMapping(value="/searchVideo")
    public String handleSearchVideo(@RequestParam(value = "fileNameStartsWith", required = false, defaultValue = "") String fileNameStartsWith, Model model){
		List<Video> videos = videoService.getVideoListWhereNameStartsWith(fileNameStartsWith);
		if (videos != null && !videos.isEmpty()) {
			
			model.addAttribute("searchVideoModel", SearchVideoModel.createBySearchAndVideoList(fileNameStartsWith, videos));
		}
		else {
			model.addAttribute("searchVideoModel", SearchVideoModel.createBySearchAndVideoList(fileNameStartsWith, new ArrayList<Video>()));
		}
		return "searchVideo";
    }
}
