package edu.springStudy.vo;

public class SearchVO {
	private String searchType;
	private String searchValue;
	
	@Override
	public String toString() {
		return "SearchVO [searchType=" + searchType + ", searchValue=" + searchValue + "]";
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
}
