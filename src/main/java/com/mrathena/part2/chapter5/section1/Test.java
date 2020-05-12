package com.mrathena.part2.chapter5.section1;

import com.mrathena.common.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Test {

	public static void main(String[] args) {

		List<Dish> menu = Dish.demo();
		System.out.println(menu);

		// 用谓词筛选
		System.out.println();
		System.out.println(menu.stream()
				.filter(Dish::isVegetarian)
				.collect(toList()));

		// 筛选各异的元素
		System.out.println();
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream()
				.filter(i -> i % 2 == 0).distinct()
				.forEach(System.out::println);

		// 截断流
		System.out.println();
		System.out.println(menu.stream()
				.filter(d -> d.getCalories() > 300)
				.limit(3)
				.collect(toList()));

		// 跳过元素
		System.out.println();
		System.out.println(menu.stream()
				.filter(d -> d.getCalories() > 300)
				.skip(2)
				.collect(toList()));











	}

}
