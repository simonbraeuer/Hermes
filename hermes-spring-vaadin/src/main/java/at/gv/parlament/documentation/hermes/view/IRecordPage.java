package at.gv.parlament.documentation.hermes.view;

import at.gv.parlament.documentation.hermes.controller.IRecordPageController;
import at.gv.parlament.documentation.hermes.domain.RecordSetting;

public interface IRecordPage extends IContentPage {
	public void setRecordSetting(RecordSetting setting, boolean isRecording);
	public void setController(IRecordPageController controller);
}
