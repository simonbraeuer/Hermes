package at.gv.parlament.documentation.hermes.service.record;

import org.springframework.stereotype.Service;

import at.gv.parlament.documentation.hermes.domain.RecordSource;

@Service
public final class FfmpegRecordService extends AbstractPropertyRecordService {
	public static final RecordSource SOURCE = new RecordSource("FFMPEG"); 
	
	@Override
	protected String getName() {
		return "ffmpegService";
	}

	@Override
	protected String getDefaultStartCommand() {
		return "FFMPEG START";
	}

	@Override
	protected String getDefaultStopCommand() {
		return "FFMPEG STOP";
	}

}
