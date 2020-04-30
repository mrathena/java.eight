package com.mrathena.part1.chapter3.section8;

import java.util.function.Function;

public class Test3 {

	public static void main(String[] args) {

		// 函数复合

		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> h = f.andThen(g);
		Function<Integer, Integer> c = f.compose(g);
		int result = h.apply(1);

		System.out.println(result);

		System.out.println(h.apply(2));

		System.out.println(c.apply(2));

	}

}
