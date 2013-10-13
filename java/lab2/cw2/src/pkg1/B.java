package pkg1;

public class B extends A {
	protected void decrement(){
		number--;
	}
	void changeName(){
		name = "B package changeName";
	}
	private void increment(){
		number += 2;
	}
	public B(){
		super(10,"Konstrkuktor A");
	}
}
