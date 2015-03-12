package at.gv.parlament.documentation.hermes.service.record;

import java.util.Hashtable;
import java.util.Set;

import com.vaadin.spring.annotation.SpringComponent;

import at.gv.parlament.documentation.hermes.domain.RecordSetting;
import at.gv.parlament.documentation.hermes.domain.RecordSource;

public class MasterRecordService implements IMasterRecordService{
	private Hashtable<RecordSource, IRecordService> services = new Hashtable<>();

	@Override
	public void registerService(RecordSource source, IRecordService service) {
		services.put(source, service);
	}

	@Override
	public void startRecord(RecordSource source, RecordSetting setting) {
		services.get(source).startRecord(setting);
	}

	@Override
	public void stopRecord(RecordSource source) {
		services.get(source).stopRecord();
	}

	@Override
	public Set<RecordSource> getAllSources() {
		return services.keySet();
	}

	@Override
	public RecordSetting isRecording(RecordSource source) {
		return services.get(source).isRecording();
	}
	
}
