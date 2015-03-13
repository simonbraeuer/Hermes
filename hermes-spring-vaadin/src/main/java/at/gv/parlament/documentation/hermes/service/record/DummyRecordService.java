package at.gv.parlament.documentation.hermes.service.record;

import org.springframework.stereotype.Service;

import at.gv.parlament.documentation.hermes.domain.RecordSetting;
import at.gv.parlament.documentation.hermes.domain.RecordSource;

@Service
public class DummyRecordService implements IRecordService {
	public static final RecordSource SOURCE = new RecordSource("DUMMY"); 
	
	private RecordSetting currentRecordSetting;

	@Override
	public void startRecord(RecordSetting setting) {
		currentRecordSetting = setting;
	}

	@Override
	public void stopRecord() {
		currentRecordSetting = null;
	}

	@Override
	public RecordSetting isRecording() {
		return currentRecordSetting;
	}

}
