package com.mrathena.part2.chapter5.section4;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {



		// 元素求和
		System.out.println();
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(numbers.stream().reduce(0, (i, j) -> i + j));
		System.out.println(numbers.stream().reduce(0, Integer::sum));
		System.out.println(numbers.stream().reduce(Integer::sum));

		// 元素求积
		System.out.println();
		System.out.println(numbers.stream().reduce(1, (i, j) -> i * j));
		System.out.println(numbers.stream().reduce((i, j) -> i * j));

		// 最大值和最小值
		System.out.println();
		System.out.println(numbers.stream().reduce((i, j) -> i > j ? i : j));
		System.out.println(numbers.stream().reduce(Integer::max));
		System.out.println(numbers.stream().reduce(Integer::min));







	}

}
