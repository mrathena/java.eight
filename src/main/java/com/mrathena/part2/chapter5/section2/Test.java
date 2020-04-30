package com.mrathena.part2.chapter5.section2;

import com.mrathena.common.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Test {

	public static void main(String[] args) {

		List<Dish> menu = Dish.demo();
		System.out.println(menu);

		// 对流中每一个元素应用函数
		System.out.println();
		System.out.println(menu.stream()
				.map(Dish::getName)
				.collect(toList()));

		System.out.println();
		List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
		System.out.println(words.stream()
				.map(String::length)
				.collect(toList()));

		System.out.println();
		System.out.println(menu.stream()
				.map(Dish::getName)
				.map(String::length)
				.collect(toList()));

		// 流的扁平化
		System.out.println();
		words = Arrays.asList("Hello", "World");
		System.out.println(words.stream()
				.map(word -> word.split(""))
				.distinct()
				.collect(toList()));
		// 输出的并不是每一个List<String>, 而是List<String[]>

		System.out.println();
		System.out.println(words.stream()
				.map(word -> word.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(toList()));









	}

}
