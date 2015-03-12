package at.gv.parlament.documentation.hermes.service.record;

import java.io.IOException;

import org.springframework.stereotype.Service;

import at.gv.parlament.documentation.hermes.domain.RecordSource;

@Service
public final class RecordWebCamRecordService extends AbstractPropertyRecordService {
	public static final RecordSource SOURCE = new RecordSource("RECORDWEBCAM"); 
	
	@Override
	protected String getName() {
		return "recordWebCam";
	}

	@Override
	protected String getDefaultStartCommand() {
		return "D:\\DEV\\privat\\binaries\\ffmpeg-static\\ffmpeg-20150216-git-03adafb-win64-static\\bin\\ffmpeg.exe -f dshow -s 640x480 -r 30 -vcodec mjpeg -i video=\"HP HD Webcam [Fixed]\" \"${outputFile}\"";
	}

	@Override
	protected String getDefaultStopCommand() {
		
		return "NOT USED HERE!";
	}
	
	@Override
	public void stopRecord() {
		if(startProcess.isAlive()) {
			try {
				startProcess.getOutputStream().write('q');
			} catch (IOException e) {
				startProcess.destroyForcibly();
			}
		}
		currentRecordSetting = null;
	}

}
