package at.gv.parlament.documentation.hermes.view;

import java.util.List;

import at.gv.parlament.documentation.hermes.controller.IRecordPageController;
import at.gv.parlament.documentation.hermes.domain.RecordSetting;
import at.gv.parlament.documentation.hermes.domain.RecordSource;

public interface IRecordPage extends IContentPage {
	public void setRecordSetting(RecordSetting setting, boolean isRecording);
	public void setController(IRecordPageController controller);
	public void setRecordSources(List<RecordSource> sources);
	public void setDefaultSource(RecordSource defaultSource);
}
