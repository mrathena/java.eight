package com.mrathena.part1.chapter3.section6;

import java.util.function.UnaryOperator;

public class Test {

	public static void main(String[] args) {
		UnaryOperator<String> unaryOperator = (String s) -> s.toUpperCase();
		unaryOperator = String::toUpperCase;
	}

}
