package ch14.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class VectorExam {
	public static void main(String[] args) {
		//벡터는 멀티스레드 환경에서 동기화된 메서드로 구현
		//동시에 여러명이 수정할 수 없다.
		Scanner in = new Scanner(System.in);
		
		List<Board> list = new LinkedList<Board>();
		
		for (int i = 1 ; i < 7 ; i ++) {
			list.add(new Board(String.format("제목%d",i),String.format("내용%d",i),String.format("작성자%d",i)));
		}
		
		System.out.println("게시물 전체 보기");
		Board tmp = null;
		for(int i = 0;  i<list.size();i++) {
			tmp = list.get(i);
			System.out.printf("%s \t| %s \t\t| %s\n",tmp.title,tmp.text,tmp.name);
		}
		
		System.out.println("-------------------------------");
		System.out.println("2번 게시물 보기");
		tmp = list.get(1);
		System.out.printf("%s | %s | %s\n",tmp.title,tmp.text,tmp.name);
		
		System.out.println("-------------------------------");
		System.out.println("3번 게시물 수정");
		tmp = list.get(2);
		tmp.title = "수정제목1";
		tmp.text = "수정내용1";
		tmp.name = "수정작성자1";
		list.set(2, tmp);
		
		System.out.println("-------------------------------");
		System.out.println("게시물 전체 보기");
		for(int i = 0;  i<list.size();i++) {
			tmp = list.get(i);
			System.out.printf("%s \t| %s \t\t| %s\n",tmp.title,tmp.text,tmp.name);
		}
		
		System.out.println("-------------------------------");
		System.out.println("4번 게시물 삭제");
		list.remove(3);
		
		System.out.println("-------------------------------");
		System.out.println("게시물 전체 보기");
		for(int i = 0;  i<list.size();i++) {
			tmp = list.get(i);
			System.out.printf("%s \t| %s \t\t| %s\n",tmp.title,tmp.text,tmp.name);
		}
	}
}
