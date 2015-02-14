package at.gov.parlament.documentation.hermes.controller;

import java.util.List;

public final class SearchVideoModel {
	private String fileName;
	
	public String getFileName() {
		return fileName;
	}
	
	private SearchVideoModel (String fileName) {
		this.fileName = fileName;
	}
	
	public static SearchVideoModel createSearchResult (String fileName) {
		return new SearchVideoModel(fileName);
	}
}
