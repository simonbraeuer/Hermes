package at.gv.parlament.documentation.hermes.service.record;

import org.springframework.stereotype.Service;

import at.gv.parlament.documentation.hermes.domain.RecordSource;

@Service
public final class DebutRecordService extends AbstractPropertyRecordService {
	public static final RecordSource SOURCE = new RecordSource("DEBUT"); 
	
	@Override
	protected String getName() {
		return "debutService";
	}

	@Override
	protected String getDefaultStartCommand() {
		return "/Applications/Debut.app/Contents/MacOS/Debut -record -format mp4 -file ${outputFile} -videodir ${outputDirectory}";
	}

	@Override
	protected String getDefaultStopCommand() {
		return "/Applications/Debut.app/Contents/MacOS/Debut -stop";
	}

}
