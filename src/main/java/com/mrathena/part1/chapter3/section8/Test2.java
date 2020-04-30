package com.mrathena.part1.chapter3.section8;

import com.mrathena.common.Apple;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test2 {

	public static void main(String[] args) {

		// 谓词复合

		List<Apple> appleList = Apple.demo();
		System.out.println(appleList);

		Predicate<Apple> redApple = a -> "red".equals(a.getColor());
		Predicate<Apple> redAndHeavyOrGreen = redApple.and((apple -> apple.getWeight() > 400)).or(apple -> "green".equals(apple.getColor()));

		List<Apple> collect = appleList.stream().filter(redAndHeavyOrGreen).collect(Collectors.toList());
		System.out.println(collect);

	}

}
