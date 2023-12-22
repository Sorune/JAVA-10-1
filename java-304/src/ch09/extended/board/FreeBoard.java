package ch09.extended.board;

public class FreeBoard extends Board {
	//필드
	private String comment;
	private int visitCount;
	
	
	//생성자
	
	
	//메서드
	public String getComment() {
		return comment;
	}
	public int getVisitCount() {
		return visitCount;
	}
	public void setComment(String comment) {
		//욕설 비방 체크
		this.comment = comment;
	}
	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}
}
