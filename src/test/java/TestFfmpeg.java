

import java.io.IOException;

import at.gov.parlament.documentation.hermes.domain.CutVideoRecordConfig;
import at.gov.parlament.documentation.hermes.exceptions.HashingServiceException;
import at.gov.parlament.documentation.hermes.exceptions.RecordServiceException;
import at.gov.parlament.documentation.hermes.service.RecordService;

public class TestFfmpeg {
	private static String FFMPEG_EXE = "/Users/sbr/bachelordata/bin/decoder/ffmpeg";
	
	private static String MPG_IN ="/Users/sbr/git/hermes/src/test/resources/video/testvideo.mpg";
	private static String MPG_OUT = "/Users/sbr/bachelordata/video/killertomato.mpg";
	private static String MP4_OUT = "/Users/sbr/bachelordata/video/out/out.mp4";
	private static String MP4_IN = "/Users/sbr/bachelordata/video/test.mp4";
	private static String STARTTIME ="00:00:05";
	private static String ENDTIME ="00:00:10";
	
	public static void main(String[] args) {
		RecordService service = new RecordService();
		//CutVideoRecordConfig config = new CutVideoRecordConfig(MPG_IN, MPG_OUT, STARTTIME, ENDTIME);
		CutVideoRecordConfig config = new CutVideoRecordConfig(MPG_IN, MP4_OUT, STARTTIME, ENDTIME);
		
		try {
			service.record(config);
		} catch (RecordServiceException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static int cutVideo (String inVideo, String outVideo, String fromTime, String durationTime) throws IOException, InterruptedException {
		String command = FFMPEG_EXE+" -ss " + fromTime + " -i " + inVideo + " -t " + durationTime + " -c copy " + outVideo;
		
		System.out.println(command);
		
		Process process = Runtime.getRuntime().exec(command);
		process.waitFor();
		
		System.out.println( process.exitValue() );
		
		return process.exitValue();
	}
	
}
