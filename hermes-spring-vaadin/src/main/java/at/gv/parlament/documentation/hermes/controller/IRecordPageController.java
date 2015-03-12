package at.gv.parlament.documentation.hermes.controller;

import java.util.Set;

import at.gv.parlament.documentation.hermes.domain.RecordSource;
import at.gv.parlament.documentation.hermes.view.IRecordPage;

public interface IRecordPageController {
	public void selectRecordSource(RecordSource source);
	public Set<RecordSource> getRecordSources();
	public void recordAction(boolean record);
	//public boolean isRecording();
	public void setRecordPage(IRecordPage page);
	public void setFileName(String fileName);
}
