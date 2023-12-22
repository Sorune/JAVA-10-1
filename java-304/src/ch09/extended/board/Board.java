package ch09.extended.board;

import java.util.Date;

public class Board { //게시판의 부모 객체
	private int no;
	private String title;
	private String content;
	private Date regDate;
	private Date modDate;
	private String user;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//getter 출력용
	public int getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public String getUser() {
		// 변조 : 이름 중간글자를 *로 표시
		return user;
	}
	
	//setter 입력용
	public void setNo(int no) {
		//자동 번호 증가
		this.no = no;
	}
	public void setTitle(String title) {
		//제목 글자수 제한
		this.title = title;
	}
	public void setContent(String content) {
		//내용 글자수 제한
		this.content = content;
	}
	public void setRegDate(Date regDate) {
		// 작성일 자동
		this.regDate = regDate;
	}
	public void setModDate(Date modDate) {
		// 수정일 자동
		this.modDate = modDate;
	}
	public void setUser(String user) {
		// 회원 인증
		this.user = user;
	}
	
	public boolean findById(String id) {
		boolean result = false;
		
		return result;
	}
}
