package at.gv.parlament.documentation.hermes.controller;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinUIScope;

import at.gv.parlament.documentation.hermes.domain.RecordSetting;
import at.gv.parlament.documentation.hermes.domain.RecordSource;
import at.gv.parlament.documentation.hermes.service.record.IMasterRecordService;
import at.gv.parlament.documentation.hermes.view.IRecordPage;

@SpringComponent
@VaadinUIScope
public class RecordPageController implements IRecordPageController, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2581971322827527679L;
	private IRecordPage page;
	private RecordSource selectedSource;
	
	@Autowired
	transient private IMasterRecordService masterRecordService;
	
	@Override
	public void selectRecordSource(RecordSource source) {
		selectedSource = source;
		if(source == null) {
			selectedSource = masterRecordService.getDefaultSource();
		}
		refreshRecordPage();
	}

	@Override
	public void recordAction(boolean record, RecordSetting setting) {
		if(record && !isRecording()) {
			masterRecordService.startRecord(selectedSource, setting);
		}
		if(!record && isRecording()) {
			masterRecordService.stopRecord(selectedSource);
		}
		refreshRecordPage();
	}

	@Override
	public void setRecordPage(IRecordPage page) {
		this.page = page;
		page.setRecordSources(masterRecordService.getAllSources());
		page.setDefaultSource(masterRecordService.getDefaultSource());
	}

	
	// --------- private --------
	
	private void refreshRecordPage() {
		RecordSetting currentSetting = masterRecordService.isRecording(selectedSource);
		page.setRecordSetting(currentSetting, currentSetting != null);
	}
	
	private boolean isRecording() {
		return masterRecordService.isRecording(selectedSource)!=null;
	}


}
