package ch12.share;

public class Calculator implements Cloneable {
	private int memory;
	
	
	public int getMemory(){
		return this.memory;
	}
	
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : "+this.memory);
	}
	
	public Calculator clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Calculator) obj;
	}
}
