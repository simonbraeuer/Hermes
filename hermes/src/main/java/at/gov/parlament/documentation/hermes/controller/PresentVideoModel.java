package at.gov.parlament.documentation.hermes.controller;

import java.util.ArrayList;
import java.util.List;

import at.gov.parlament.documentation.hermes.domain.PositionMarker;
import at.gov.parlament.documentation.hermes.domain.Video;

public final class PresentVideoModel {
	private String videoLink;
	private List<PresentVideoPositionMarkerModel> positionMarkers;
	
	private PresentVideoModel (String videoLink) {
		this.videoLink = videoLink;
		positionMarkers = new ArrayList<PresentVideoModel.PresentVideoPositionMarkerModel>();
	}

	public static PresentVideoModel createByVideo (Video video) {
		PresentVideoModel ret = new PresentVideoModel(video.getLink());
		for(PositionMarker pm:video.getPositionMarkers()) {
			PresentVideoPositionMarkerModel newPm = ret.new PresentVideoPositionMarkerModel();
			newPm.setName(pm.getName());
			newPm.setTimeOffset(pm.getOffsetSeconds());
			ret.positionMarkers.add(newPm);
		}
		return ret;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public List<PresentVideoPositionMarkerModel> getPositionMarkers() {
		return positionMarkers;
	}

	public void setPositionMarkers(
			List<PresentVideoPositionMarkerModel> positionMarkers) {
		this.positionMarkers = positionMarkers;
	}

	public class PresentVideoPositionMarkerModel {
		private String name;
		private double timeOffset;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getTimeOffset() {
			return timeOffset;
		}
		public void setTimeOffset(double timeOffset) {
			this.timeOffset = timeOffset;
		}
		
	}
}
