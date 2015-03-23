package at.gv.parlament.documentation.hermes.service.videofile;

import at.gv.parlament.documentation.hermes.service.IServiceExceptionContent;

public enum VideoFileServiceExceptionState implements IServiceExceptionContent{
	FAIL_UPLOAD {
	    @Override
		public String getMessage() {
			return "Das hochgeladene Video konnte nicht gespeichert werden.";
		}
	}
}
