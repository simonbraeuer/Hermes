package at.gv.parlament.documentation.hermes.service.record;

import at.gv.parlament.documentation.hermes.domain.RecordSetting;

public interface IRecordService {
	public void startRecord(RecordSetting setting);
	public void stopRecord();
	public RecordSetting isRecording();
}
