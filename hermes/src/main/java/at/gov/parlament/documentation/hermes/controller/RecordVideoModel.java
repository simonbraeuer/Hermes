package at.gov.parlament.documentation.hermes.controller;

public final class RecordVideoModel {
	private String recordButtonLabel;
	private String recordButtonAction;
	private String currentVideo;
	
	public String getCurrentVideo() {
		return currentVideo;
	}
	public void setCurrentVideo(String currentVideo) {
		this.currentVideo = currentVideo;
	}
	public String getRecordButtonLabel() {
		return recordButtonLabel;
	}
	public void setRecordButtonLabel(String recordButtonLabel) {
		this.recordButtonLabel = recordButtonLabel;
	}
	public String getRecordButtonAction() {
		return recordButtonAction;
	}
	public void setRecordButtonAction(String recordButtonAction) {
		this.recordButtonAction = recordButtonAction;
	}
	
	
}
