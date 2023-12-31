package edu.springStudy.vo;

public class BoardVO {
	private String title;
	private int bidx;
	private String wdate;
	private String body;
	private int hit;
	private String id;
	private String filename;
	private String orifilename;
	
	@Override
	public String toString() {
		return "BoardVO [title=" + title + ", bidx=" + bidx + ", wdate=" + wdate + ", body=" + body + ", hit=" + hit
				+ ", id=" + id + ", filename=" + filename + ", orifilename=" + orifilename + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getBidx() {
		return bidx;
	}
	public void setBidx(int bidx) {
		this.bidx = bidx;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getOrifilename() {
		return orifilename;
	}
	public void setOrifilename(String orifilename) {
		this.orifilename = orifilename;
	}
}
