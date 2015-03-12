package at.gv.parlament.documentation.hermes.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;

import at.gv.parlament.documentation.hermes.domain.RecordSetting;
import at.gv.parlament.documentation.hermes.domain.RecordSource;
import at.gv.parlament.documentation.hermes.service.record.IMasterRecordService;
import at.gv.parlament.documentation.hermes.view.IRecordPage;

@SpringComponent
public class RecordPageController implements IRecordPageController {
	private IRecordPage page;
	private RecordSource selectedSource;
	private String fileName;
	
	@Autowired
	private IMasterRecordService masterRecordService;
	
	@Override
	public void selectRecordSource(RecordSource source) {
		selectedSource = source;
	}

	@Override
	public void recordAction(boolean record) {
		if(selectedSource != null) {
			if(record && !isRecording()) {
				masterRecordService.startRecord(selectedSource, new RecordSetting(fileName));
			}
		}
	}

	private boolean isRecording() {
		return masterRecordService.isRecording(selectedSource)!=null;
	}

	@Override
	public void setRecordPage(IRecordPage page) {
		this.page = page;
	}

	@Override
	public Set<RecordSource> getRecordSources() {
		return masterRecordService.getAllSources();
	}

	@Override
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
