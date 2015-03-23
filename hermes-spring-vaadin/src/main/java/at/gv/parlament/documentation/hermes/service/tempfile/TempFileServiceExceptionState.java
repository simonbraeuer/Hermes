package at.gv.parlament.documentation.hermes.service.tempfile;

import at.gv.parlament.documentation.hermes.service.IServiceExceptionContent;

public enum TempFileServiceExceptionState implements IServiceExceptionContent{
	NO_WRITE_POSSIBLE {
	    @Override
		public String getMessage() {
			return "Die temporäre Datei kann nicht geschrieben werden!";
		}
	},
	FOLDER_NOT_REACHABLE {
	    @Override
		public String getMessage() {
			return "Das Verzeichnis für temporäre Dateien ist nicht erreichbar!";
		}
	},
	CREATION_FAILED {
	    @Override
		public String getMessage() {
			return "Die temporäre Datei konnte nicht erstellt werden!";
		}
	}
}
