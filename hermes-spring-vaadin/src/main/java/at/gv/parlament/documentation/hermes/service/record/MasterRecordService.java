package at.gv.parlament.documentation.hermes.service.record;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import at.gv.parlament.documentation.hermes.domain.RecordSetting;
import at.gv.parlament.documentation.hermes.domain.RecordSource;

public class MasterRecordService implements IMasterRecordService{
	private Hashtable<RecordSource, IRecordService> services = new Hashtable<>();
	private RecordSource defaultSource;

	@Override
	public void registerService(RecordSource source, IRecordService service, boolean isDefault) {
		services.put(source, service);
		defaultSource = source;
	}

	@Override
	public void startRecord(RecordSource source, RecordSetting setting) {
		RecordSource serviceSource = source;
		if(serviceSource == null) {
			serviceSource = defaultSource;
		}
		services.get(serviceSource).startRecord(setting);
	}

	@Override
	public void stopRecord(RecordSource source) {
		services.get(source).stopRecord();
	}

	@Override
	public List<RecordSource> getAllSources() {
		ArrayList<RecordSource> ret = new ArrayList<RecordSource>();
		for(RecordSource source:services.keySet()) {
			ret.add(source);
		}
		
		return ret;
	}

	@Override
	public RecordSetting isRecording(RecordSource source) {
		if (source == null || services.get(source) == null) {
			return null;
		}
		return services.get(source).isRecording();
	}

	@Override
	public RecordSource getDefaultSource() {
		return defaultSource;
	}
	
}
