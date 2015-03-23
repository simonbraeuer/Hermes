package at.gv.parlament.documentation.hermes.controller.uploadVideo;

import at.gv.parlament.documentation.hermes.controller.IValidationResult;

public enum UploadVideoValidationResult implements IValidationResult{
	OK {
	    @Override
		public String getValidationMessage() {
			return "Alles OK!";
		}
	},
	
	NAME_ALREADY_USED {
	    @Override
		public String getValidationMessage() {
			return "Der Name ist bereits vergeben!";
		}
	},
	 
	NAME_EMPTY {
	    @Override
	    public String getValidationMessage() {
	        return "Der Name darf nicht leer sein!";
	    }
	}
}
