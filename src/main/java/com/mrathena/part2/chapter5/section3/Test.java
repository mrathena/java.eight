package com.mrathena.part2.chapter5.section3;

import com.mrathena.common.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {

	public static void main(String[] args) {

		List<Dish> menu = Dish.demo();
		System.out.println(menu);

		// 检查谓词是否至少匹配一个元素
		System.out.println();
		System.out.println(menu.stream()
				.anyMatch(Dish::isVegetarian));

		// 检查谓词是否匹配所有元素
		System.out.println();
		System.out.println(menu.stream()
				.allMatch(Dish::isVegetarian));

		System.out.println();
		System.out.println(menu.stream()
				.noneMatch(Dish::isVegetarian));

		// 查找元素
		System.out.println();
		Optional<Dish> dish =
				menu.stream()
						.filter(Dish::isVegetarian)
						.findAny();
		System.out.println(dish.orElse(null));

		// 存在就打印名字,不存在则不操作
		System.out.println();
		menu.stream()
				.filter(Dish::isVegetarian)
				.findAny()
				.ifPresent(d -> System.out.println(d.getName()));

		// 查找第一个元素
		System.out.println();
		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> firstSquareDivisibleByThree =
				someNumbers.stream()
						.map(x -> x * x)
						.filter(x -> x % 3 == 0)
						.findFirst();
		System.out.println(firstSquareDivisibleByThree.orElse(null));






	}

}
