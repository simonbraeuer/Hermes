package at.gv.parlament.documentation.hermes.service.record;

import java.util.Set;

import at.gv.parlament.documentation.hermes.domain.RecordSetting;
import at.gv.parlament.documentation.hermes.domain.RecordSource;

public interface IMasterRecordService {
	public void startRecord(RecordSource source, RecordSetting setting);
	public void stopRecord(RecordSource source);
	public void registerService(RecordSource source, IRecordService service);
	public Set<RecordSource> getAllSources();
	public RecordSetting isRecording(RecordSource source);
}
