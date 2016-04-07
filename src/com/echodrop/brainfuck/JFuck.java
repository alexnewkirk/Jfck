package com.echodrop.brainfuck;

import java.util.Scanner;
import java.util.Stack;

/**
 * An interpreter for the BrainFuck programming language
 * 
 * @author echo_drop
 *
 */
public class JFuck {

	private char[] mem;
	private int dataPointer;
	private Scanner input;
	private Stack<Integer> stack;
	private int memorySize;

	public JFuck(int memorySize) {
		this.memorySize = memorySize;
		init();
	}

	private void init() {
		this.mem = new char[memorySize];
		this.dataPointer = 0;
		this.input = new Scanner(System.in);
		this.stack = new Stack<Integer>();
	}

	public void executeBf(String source) {

		init();

		for (int i = 0; i < source.length(); i++) {

			switch (source.charAt(i)) {

			case '>':
				dataPointer++;
				break;
			case '<':
				dataPointer--;
				break;
			case '+':
				mem[dataPointer]++;
				break;
			case '-':
				mem[dataPointer]--;
				break;
			case '.':
				System.out.println((char) mem[dataPointer]);
				break;
			case ',':
				String typed = "";
				while (typed.length() > 1 || typed.isEmpty()) {
					System.out.print(">");
					typed = input.nextLine();
				}
				mem[dataPointer] = typed.charAt(0);
				System.out.println();
				break;
			case '[':
				stack.push(i);
				break;
			case ']':
				if (mem[dataPointer] != 0) {
					i = stack.peek();
				} else {
					stack.pop();
				}
				break;
			default:
				// ignore any character that is not a valid BF command
				break;
			}
		}

	}

}