package com.echodrop.brainfuck;

public class Example {

	public static void main(String[] args) {

		// Create a new bf interpreter with a memory size of 30k cells
		JFuck in = new JFuck(30000);

		// Hello, world!
		String helloWorld = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
		in.executeBf(helloWorld);
	}

}
