package at.gv.parlament.documentation.hermes.controller;

import java.util.List;

import at.gv.parlament.documentation.hermes.domain.RecordSetting;
import at.gv.parlament.documentation.hermes.domain.RecordSource;
import at.gv.parlament.documentation.hermes.view.IRecordPage;

public interface IRecordPageController {
	public void selectRecordSource(RecordSource source);
	public void recordAction(boolean record, RecordSetting setting);
	public void setRecordPage(IRecordPage page);
	
//	public List<RecordSource> getRecordSources();
//	public RecordSource getDefaultRecordSource();
}
