package at.gov.parlament.documentation.hermes.domain;

import java.util.ArrayList;
import java.util.List;

public class Video {
	private String fileName;
	private List<PositionMarker> positionMarkers;
	
	public Video() {
		super();
		positionMarkers = new ArrayList<PositionMarker>();
		fileName = "";
		
	}

	public String getFileName() {
		return fileName;
	}
	
	public String getLink() {
		return "/files/" + fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public List<PositionMarker> getPositionMarkers() {
		return positionMarkers;
	}

	public void setPositionMarkers(List<PositionMarker> positionMarkers) {
		this.positionMarkers = positionMarkers;
	}
	
	
	
}
