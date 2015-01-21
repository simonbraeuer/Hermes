
import java.io.IOException;

public class HermesDummyApp {
	private static String FFMPEG_EXE = "/Users/sbr/Hermes/decoder/ffmpeg";
	
	private static String VID_IN ="/Users/sbr/Hermes/content/testvideo.mpg";
	private static String VID_OUT = "/Users/sbr/Hermes/content/outvideo.mpeg";
	private static String STARTTIME ="01:02:45";
	private static String DURATION ="00:23:00";
	
	public static void main(String[] args) {
		 try {
			cutVideo(VID_IN, VID_OUT, STARTTIME, DURATION);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static int cutVideo (String inVideo, String outVideo, String fromTime, String durationTime) throws IOException, InterruptedException {
		String command = FFMPEG_EXE+" -ss " + fromTime + " -i " + inVideo + " -t " + durationTime + " -c copy " + outVideo;
		
		Process process = Runtime.getRuntime().exec(command);
		process.waitFor();
		
		System.out.println( process.exitValue() );
		
		return process.exitValue();
	}
	
}
