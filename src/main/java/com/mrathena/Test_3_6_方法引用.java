package com.mrathena;

import java.util.function.UnaryOperator;

public class Test_3_6_方法引用 {

	public static void main(String[] args) {
		UnaryOperator<String> unaryOperator = (String s) -> s.toUpperCase();
		unaryOperator = String::toUpperCase;
	}

}
