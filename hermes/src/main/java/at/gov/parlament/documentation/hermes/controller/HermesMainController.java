package at.gov.parlament.documentation.hermes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import at.gov.parlament.documentation.hermes.domain.MainSessionBean;

@Controller
@Scope("request")
public class HermesMainController {
	
	@Autowired
	private MainSessionBean sessionBean;
		
	@RequestMapping(value="/hermesMain/{activeModule}", method=RequestMethod.GET)
    public String handleHermesMain(@PathVariable String activeModule, Model model){
		sessionBean.setActiveModule(activeModule);
		model.addAttribute("sessionBean", sessionBean);
		return "hermesMain";
    }
}
