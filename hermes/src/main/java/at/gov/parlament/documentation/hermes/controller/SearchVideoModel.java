package at.gov.parlament.documentation.hermes.controller;

import java.util.ArrayList;
import java.util.List;

import at.gov.parlament.documentation.hermes.domain.Video;

public final class SearchVideoModel {
	private String fileNameStartsWith;
	private List<SearchVideoResultModel> results;
	
	private SearchVideoModel() {
		super();
		fileNameStartsWith ="";
		results = new ArrayList<SearchVideoResultModel>();
	}
	
	public static SearchVideoModel createBySearchAndVideoList(String fileNameStartsWith, List<Video> videos) {
		SearchVideoModel ret = new SearchVideoModel();
		ret.fileNameStartsWith = fileNameStartsWith;
		for (Video video: videos) {
			ret.addResultByVideo(video);
		}
		return ret;
	}
	
	private void addResultByVideo(Video video) {
		SearchVideoResultModel newResult = new SearchVideoResultModel();
		newResult.setFileLink(video.getLink());
		newResult.setFileName(video.getFileName());
		results.add(newResult);
	}
	
	public String getFileNameStartsWith() {
		return fileNameStartsWith;
	}

	public void setFileNameStartsWith(String fileNameStartsWith) {
		this.fileNameStartsWith = fileNameStartsWith;
	}

	public List<SearchVideoResultModel> getResults() {
		return results;
	}

	public void setResults(List<SearchVideoResultModel> results) {
		this.results = results;
	}

	
	
	public class SearchVideoResultModel {
		private String fileName;
		private String fileLink;
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getFileLink() {
			return fileLink;
		}
		public void setFileLink(String fileLink) {
			this.fileLink = fileLink;
		}
		
		
		
	}
}
