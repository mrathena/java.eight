package com.mrathena;

import com.mrathena.common.Apple;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test_3_8_复合Lambda表达式的有用方法 {

	public static void main(String[] args) {

		// 比较器复合

		List<Apple> appleList = Apple.demo();
		System.out.println(appleList);

		System.out.println();
		appleList.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
		System.out.println(appleList);

		System.out.println();
		appleList = Apple.demo();
		appleList.sort(Comparator.comparing(Apple::getWeight));
		System.out.println(appleList);

		System.out.println();
		appleList = Apple.demo();
		appleList.sort(Comparator.comparing(Apple::getWeight).reversed());
		System.out.println(appleList);

		System.out.println();
		appleList = Apple.demo();
		appleList.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getCountry));
		System.out.println(appleList);


		// 谓词复合

		Predicate<Apple> redApple = a -> "red".equals(a.getColor());
		Predicate<Apple> redAndHeavyOrGreen = redApple.and((apple -> apple.getWeight() > 400)).or(apple -> "green".equals(apple.getColor()));

		List<Apple> collect = appleList.stream().filter(redAndHeavyOrGreen).collect(Collectors.toList());
		System.out.println(collect);


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
