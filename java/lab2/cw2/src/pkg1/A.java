package pkg1;

public class A {
	int number;
	protected String name;
	public static void main(String[] argv){
		System.out.print("Hello");
	}

	public A(int number, String name){
		this.number = number;
		this.name = new String(name);
	}
	
	public void callDecrement(){
		this.decrement();
	}
	
	public void callChangeName(){
		this.changeName();
	}
	
	public void callIncrement(){
		this.increment();
	}
	
	private void increment(){
		number++;
	}
	protected void decrement(){
		number--;
	}
	void changeName(){
		name = "package changeName";
	}
}
