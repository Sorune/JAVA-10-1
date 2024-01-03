package ch12.generic.multi;

public class Product<T,M> {//멀티타입
	private T kind; //객체용
	private M model; //String용
	
	
	
	public T getKind() {return kind;}
	public M getModel() {return model;}
	
	
	public void setKind(T kind) {this.kind = kind;}
	public void setModel(M model) {this.model = model;}
	
}
