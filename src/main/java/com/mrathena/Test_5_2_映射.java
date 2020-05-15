package com.mrathena;

import com.mrathena.common.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Test_5_2_映射 {

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

		// 给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？例如，给定[1, 2, 3, 4, 5]，应该返回[1, 4, 9, 16, 25]
		System.out.println();
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(numbers.stream()
				.map(n -> n * n)
				.collect(toList()));

		// 给定两个数字列表，如何返回所有的数对呢？例如，给定列表[1, 2, 3]和列表[3, 4]，应该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。为简单起见，你可以用有两个元素的数组来代表数对
		// 你可以使用两个map来迭代这两个列表，并生成数对。但这样会返回一个Stream-<Stream<Integer[]>>。你需要让生成的流扁平化，以得到一个Stream<Integer[]>。这正是flatMap所做的
		System.out.println();
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		System.out.println(numbers1.stream()
				.map(i ->
						numbers2.stream()
								.map(j -> new int[] {i, j}))
				.map(item -> item)
				.collect(toList()));
		// 相当于map的入参Function传入的是Function<Integer, Stream<Integer[]>>

		System.out.println();
		numbers1.stream()
				.flatMap(i ->
						numbers2.stream()
								.map(j -> new int[] {i, j}))
				.map(item -> "(" + item[0] + "," + item[1] + ")")
				.forEach(System.out::println);

		// 需要注意 Arrays.asList(T ...), 这里的泛型T不能替代int等基本数据类型, 传入int数组会认为是传入了一个int[]类型的单独参数
		System.out.println();
		int[] intArray = {1,2,3,4};
		Integer[] integerArray = {1,2,3,4};
		System.out.println(Arrays.asList(intArray));
		System.out.println(Arrays.asList(integerArray));

		// 如何扩展前一个例子，只返回总和能被3整除的数对呢？例如(2, 4)和(3, 3)是可以的。答案：你在前面看到了， filter可以配合谓词使用来筛选流中的元素。因为在flatMap 操作后，你有了一个代表数对的int[]流，所以你只需要一个谓词来检查总和是否能被3整除 就可以了
		System.out.println();
		numbers1.stream()
				.flatMap(i ->
						numbers2.stream()
								.map(j -> new int[] {i, j}))
				.filter(item -> (item[0] + item[1]) % 3 == 0)
				.map(item -> "(" + item[0] + "," + item[1] + ")")
				.forEach(System.out::println);

	}

}
