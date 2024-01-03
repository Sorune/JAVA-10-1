package ch12.generic;

public class Box<T> {
	private T t; //필드 / 최상위 객체
	
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
	
}
