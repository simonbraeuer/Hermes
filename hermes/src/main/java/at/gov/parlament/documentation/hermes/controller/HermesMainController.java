package at.gov.parlament.documentation.hermes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import at.gov.parlament.documentation.hermes.domain.Video;

@Controller
public class HermesMainController {
	@RequestMapping(value="/hermesMain")
    public String handleHermesMain(Model model){
		return "hermesMain";
    }
}
