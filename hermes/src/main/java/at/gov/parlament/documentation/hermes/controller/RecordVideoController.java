package at.gov.parlament.documentation.hermes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import at.gov.parlament.documentation.hermes.service.IRecordVideoService;

@Controller
public class RecordVideoController {
	
	@Autowired()
	IRecordVideoService recordVideoService;

	@RequestMapping(value = "/recordVideo")
	public String recordVideo(Model model) {
		RecordVideoModel recordVideoModel = new RecordVideoModel();
		if(recordVideoService.isRecording()) {
			recordVideoModel.setRecordButtonAction("/recordVideo/stop");
			recordVideoModel.setRecordButtonLabel("Stoppe Aufnahme");
		}
		else {
			recordVideoModel.setRecordButtonAction("/recordVideo/start");
			recordVideoModel.setRecordButtonLabel("Starte Aufnahme");
		}
		model.addAttribute("RecordVideoModel", recordVideoModel);
		return "recordVideo";
	}
	
	@RequestMapping(value = "/recordVideo/start")
	public String recordVideoStart(@RequestParam(value = "recordFileName", required = false, defaultValue = "record.mp4") String recordFileName,Model model) {
		if(!recordVideoService.isRecording()) {
			recordVideoService.startRecord(recordFileName);
		}
		return recordVideo(model);
	}
	
	@RequestMapping(value = "/recordVideo/stop")
	public String recordVideoStop(Model model) {
		if(recordVideoService.isRecording()) {
			recordVideoService.stopRecord();
		}
		return recordVideo(model);
	}
	
}
