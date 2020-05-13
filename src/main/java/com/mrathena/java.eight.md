# Java-Eight



# 第一部分 基础知识



## 第1章 为什么要关心Java 8 



### 1.1 Java怎么还在变 



#### 1.1.2 流处理 

#### 1.1.3 用行为参数化把代码传递给方法 

#### 1.1.4 并行与共享的可变数据 

#### 1.1.5 Java需要演变 



### 1.2 Java中的函数 



#### 1.2.1 方法和 Lambda作为一等公民 

#### 1.2.2 传递代码：一个例子 

#### 1.2.3 从传递方法到 Lambda 



### 1.3 流



### 1.4 默认方法



### 1.5 来自函数式编程的其他好思想 



### 1.6 小结



以下是你应从本章中学到的关键概念。 

1.  请记住语言生态系统的思想，以及语言面临的“要么改变，要么衰亡”的压力。虽然Java 可能现在非常有活力，但你可以回忆一下其他曾经也有活力但未能及时改进的语言的命 运，如COBOL。 
2.  Java 8中新增的核心内容提供了令人激动的新概念和功能，方便我们编写既有效又简洁的 程序。 
3. 现有的Java编程实践并不能很好地利用多核处理器。 
4.  函数是一等值；记得方法如何作为函数式值来传递，还有Lambda是怎样写的。 
5.  Java 8中Streams的概念使得Collections的许多方面得以推广，让代码更为易读，并允 许并行处理流元素。 
6. 你可以在接口中使用默认方法，在实现类没有实现方法时提供方法内容。 
7. 其他来自函数式编程的有趣思想，包括处理null和使用模式匹配。 



## 第2章 通过行为参数化传递代码 



### 2.1 应对不断变化的需求



#### 2.1.1 初试牛刀：筛选绿苹果 

#### 2.1.2 再展身手：把颜色作为参数 

#### 2.1.3 第三次尝试：对你能想到的每个属性做筛选 



### 2.2 行为参数化 



### 2.3 对付啰嗦



#### 2.3.1 匿名类 

#### 2.3.2 第五次尝试：使用匿名类 

#### 2.3.3 第六次尝试：使用 Lambda表达式 

#### 2.3.4 第七次尝试：将 List 类型抽象化 



### 2.4 真实的例子 



#### 2.4.1 用Comparator 来排序 

#### 2.4.2 用Runnable 执行代码块 

#### 2.4.3 GUI事件处理 



### 2.5 小结



以下是你应从本章中学到的关键概念。 

1. 行为参数化，就是一个方法接受多个不同的行为作为参数，并在内部使用它们，完成不 同行为的能力。 
2. 行为参数化可让代码更好地适应不断变化的要求，减轻未来的工作量。 
3. 传递代码，就是将新行为作为参数传递给方法。但在Java 8之前这实现起来很啰嗦。为接 口声明许多只用一次的实体类而造成的啰嗦代码，在Java 8之前可以用匿名类来减少。 
4. Java API包含很多可以用不同行为进行参数化的方法，包括排序、线程和GUI处理。 



## 第3章 Lambda 表达式



### 3.1 Lambda 管中窥豹



Lambda表达式包含3个部分

1. 参数列表
2. 箭头
3. Lambda主体

以下都是Lambda表达式的例子

```java
(Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
(String s) -> s.length();
(String s) -> s.length() > 100;
() -> 42;
(int x, int y) -> {
    System.out.print("Result:");
    System.out.println(x + y);
};
() -> "Raoul";
() -> {return "Mario";}
(List<String> list) -> list.isEmpty()
() -> new Apple(10)
(Apple a) -> {
    System.out.println(a.getWeight());
}
(int a, int b) -> a * b
```



### 3.2 在哪里以及如何使用 Lambda



#### 3.2.1 函数式接口

函数式接口就是只定义一个抽象方法的接口

你将会在第9章中看到，接口现在还可以拥有默认方法（即在类没有对方法进行实现时， 其主体为方法提供默认实现的方法）。哪怕有很多默认方法，只要接口只定义了一个抽象 方法，它就仍然是一个函数式接口。 

Lambda表达式允许你直接以内联的形式为函数式接口的抽象方法提供实现，并把整个表达式作为函数式接口的实例（具体说来，是函数式接口一个具体实现的实例）。



#### 3.2.2 函数描述符

函数式接口的抽象方法的签名基本上就是Lambda表达式的签名。我们将这种抽象方法叫作 函数描述符。例如，Runnable接口可以看作一个什么也不接受什么也不返回（void）的函数的 签名，因为它只有一个叫作run的抽象方法，这个方法什么也不接受，什么也不返回（void）。

我们在本章中使用了一个特殊表示法来描述Lambda和函数式接口的签名。() -> void代表 了参数列表为空，且返回void的函数。这正是Runnable接口所代表的。 举另一个例子，(Apple, Apple) -> int代表接受两个Apple作为参数且返回int的函数



### 3.3 把Lambda付诸实践：环绕执行模式 



#### 3.3.1 第1步：记得行为参数化 

#### 3.3.2 第2步：使用函数式接口来传递行为 

#### 3.3.3 第3步：执行一个行为 

#### 3.3.4 第4步：传递 Lambda 



### 3.4 使用函数式接口 



Java 8 常用函数式接口

| 函数式接口        | 函数描述符     | 原始类型(基本数据类型)特化的函数式接口                       |
| :---------------- | :------------- | ------------------------------------------------------------ |
| Predicate<T>      | T->boolean     | IntPredicate, LongPredicate, DoublePredicate                 |
| Consumer<T>       | T->void        | IntConsumer, LongConsumer, DoubleConsumer                    |
| Function<T,R>     | T->R           | IntFunction<R>, IntToDoubleFunction, IntToLongFunction, LongFunction<R>, LongToIntFunction, LongToDoubleFunction, DoubleFunction<R>, ToIntFunction<T>, ToLongFucntion<T>, ToDoubleFunction<T> |
| Supplier<T>       | ()->T          | BooleanSupplier, IntSupplier, LongSubblier, DoubleSupplier   |
| UnaryOperator<T>  | T->T           | IntUnaryOperator, LongUnartOperator, DoubleUnartOperator     |
| BinaryOperator<T> | (T,T)->T       | IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator  |
| BiPredicate<L,R>  | (L,R)->boolean |                                                              |
| BiConsumer<T,U>   | (T,U)->void    | ObjIntConsumer<T>, ObjLongConsumer<T>, ObjDoubleConsumer<T>-即使加了Obj也是int |
| BiFunction<T,U,R> | (T,U)->R       | ToIntBiFunction<T,U>, ToLongBiFunction<T,U>, ToDoubleBiFunction<T,U> |

Predicate 叫做 副词

Lambdas及函数式接口的例子 

| 使用案例              | Lambda的例子                                                 | 对应的函数式接口                                             |
| --------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 布尔表达式            | (List<String> list) -> list.isEmpty()                        | Predicate<List<String>>                                      |
| 创建对象              | () -> new Apple(10)                                          | Supplier<Apple>                                              |
| 消费一个对象          | (Apple a) ->  System.out.println(a.getWeight())              | Consumer<Apple>                                              |
| 从一个对象中选择/提取 | (String s) -> s.length()                                     | Function<String, Integer>或 ToIntFunction<String>            |
| 合并两个值            | (int a, int b) -> a * b                                      | IntBinaryOperator                                            |
| 比较两个对象          | (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()) | Comparator<Apple>或 BiFunction<Apple, Apple, Integer>或 ToIntBiFunction<Apple, Apple> |



#### 3.4.1 Predicate 

#### 3.4.2 Consumer 

#### 3.4.3 Function 



### 3.5 类型检查、类型推断以及限制 



#### 3.5.1 类型检查 

#### 3.5.2 同样的 Lambda，不同的函数式接口 

#### 3.5.3 类型推断 

#### 3.5.4 使用局部变量

我们迄今为止所介绍的所有Lambda表达式都只用到了其主体里面的参数。但Lambda表达式
也允许使用自由变量（不是参数，而是在外层作用域中定义的变量），就像匿名类一样。 它们被
称作捕获Lambda。例如，下面的Lambda捕获了portNumber变量：

```java
int portNumber = 1337;
Runnable r = () -> System.out.println(portNumber);
```

尽管如此，还有一点点小麻烦：关于能对这些变量做什么有一些限制。Lambda可以没有限制地捕获（也就是在其主体中引用）实例变量和静态变量。**但局部变量必须显式声明为final， 或事实上是final。**换句话说，Lambda表达式只能捕获指派给它们的局部变量一次。（注：捕获实例变量可以被看作捕获终局部变量this。） 例如，下面的代码无法编译，因为portNumber 变量被赋值两次： 

```java
int portNumber = 1337;
Runnable r = () -> System.out.println(portNumber);
portNumber = 31337;
```
你可能会问自己，为什么局部变量有这些限制。
- 第一，实例变量和局部变量背后的实现有一个关键不同。**实例变量都存储在堆中，而局部变量则保存在栈上。**如果Lambda可以直接访问局部变量，而且Lambda是在一个线程中使用的，则使用Lambda的线程，可能会在分配该变量的线程将这个变量收回之后，去访问该变量。因此，Java在访问自由局部变量时，实际上是在访问它的副本，而不是访问原始变量。如果局部变量仅仅赋值一次那就没有什么区别了——因此就有了这个限制。
- 第二，这一限制不鼓励你使用改变外部变量的典型命令式编程模式（我们会在以后的各章中解释，这种模式会阻碍很容易做到的并行处理）。



### 3.6  方法引用



方法引用主要有三类

1. 指向静态方法的方法引用（例如Integer的parseInt方法，写作Integer::parseInt）
2. 指向任意类型实例方法的方法引用（例如String的length方法，写作String::length）
3. 指向现有对象的实例方法的方法引用（假设你有一个局部变量apple用于存放Apple类型的对象，它支持实例方法getValue，那么你就可以写apple::getValue）



#### 3.6.1 管中窥豹 

#### 3.6.2 构造函数引用 

对于一个现有构造函数，你可以利用它的名称和关键字new来创建它的一个引用：ClassName::new。

```java
Supplier<Apple> c1 = Apple::new;
Apple a1 = c1.get(); 
-
Supplier<Apple> c1 = () -> new Apple();
Apple a1 = c1.get(); 
```

如果你的构造函数的签名是Apple(Integer weight)，那么它就适合Function接口的签 名，于是你可以这样写：

```java
Function<Integer, Apple> c2 = Apple::new;
Apple a2 = c2.apply(110);
-
Function<Integer, Apple> c2 = (weight) -> new Apple(weight);
Apple a2 = c2.apply(110);
```

在下面的代码中，一个由Integer构成的List中的每个元素都通过我们前面定义的类似的 map方法传递给了Apple的构造函数，得到了一个具有不同重量苹果的List： 

```java
List<Integer> weights = Arrays.asList(7, 3, 4, 10);
List<Apple> apples = map(weights, Apple::new); 
public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f){     
	List<Apple> result = new ArrayList<>();
	for(Integer e: list){
		result.add(f.apply(e));
	}
	return result;
}
```

如果你有一个具有两个参数的构造函数Apple(String color, Integer weight)，那么 它就适合BiFunction接口的签名，于是你可以这样写： 

```java
BiFunction<String, Integer, Apple> c3 = Apple::new;
Apple c3 = c3.apply("green", 110);
-
BiFunction<String, Integer, Apple> c3 = (color, weight) -> new Apple(color, weight);
Apple c3 = c3.apply("green", 110); 
```

不将构造函数实例化却能够引用它，这个功能有一些有趣的应用。例如，你可以使用Map来 将构造函数映射到字符串值。你可以创建一个giveMeFruit方法，给它一个String和一个 Integer，它就可以创建出不同重量的各种水果： 

```java
static Map<String, Function<Integer, Fruit>> map = new HashMap<>();
static {
	map.put("apple", Apple::new);
	map.put("orange", Orange::new);
	// etc...
}
public static Fruit giveMeFruit(String fruit, Integer weight) {
	return map.get(fruit.toLowerCase()).apply(weight);
}
```



### 3.7 Lambda和方法引用实战 



为了给这一章还有我们讨论的所有关于Lambda的内容收个尾，我们需要继续研究开始的那 个问题——用不同的排序策略给一个Apple列表排序，并需要展示如何把一个原始粗暴的解决方案转变得更为简明。这会用到书中迄今讲到的所有概念和功能：行为参数化、匿名类、Lambda 表达式和方法引用。我们想要实现的终解决方案是这样的

```java
inventory.sort(comparing(Apple::getWeight)); 
```

#### 3.7.1 第1步：传递代码 

你很幸运，Java 8的API已经为你提供了一个List可用的sort方法，你不用自己去实现它。 那么困难的部分已经搞定了！但是，如何把排序策略传递给sort方法呢？你看，sort方法的 签名是这样的： 

```java
void sort(Comparator<? super E> c) 
```

它需要一个Comparator对象来比较两个Apple！这就是在Java中传递策略的方式：它们必 须包裹在一个对象里。我们说sort的行为被参数化了：传递给它的排序策略不同，其行为也会 不同。 

你的第一个解决方案看上去是这样的： 

```java
public class AppleComparator implements Comparator<Apple> {
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
    }
} 
inventory.sort(new AppleComparator()); 
```

#### 3.7.2 第2步：使用匿名类 

你在前面看到了，你可以使用匿名类来改进解决方案，而不是实现一个Comparator却只实 例化一次： 

```java
inventory.sort(new Comparator<Apple>() {
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
    }
}); 
```

#### 3.7.3 第3步：使用 Lambda表达式 

但你的解决方案仍然挺啰嗦的。Java 8引入了Lambda表达式，它提供了一种轻量级语法来实 现相同的目标：传递代码。你看到了，在需要函数式接口的地方可以使用Lambda表达式。我们 回顾一下：函数式接口就是仅仅定义一个抽象方法的接口。抽象方法的签名（称为函数描述符） 描述了Lambda表达式的签名。在这个例子里，Comparator代表了函数描述符(T, T) -> int。 因为你用的是苹果，所以它具体代表的就是(Apple, Apple) -> int。改进后的新解决方案看上去就是这样的了： 

```java
inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
```

我们前面解释过了，Java编译器可以根据Lambda出现的上下文来推断Lambda表达式参数的 类型。那么你的解决方案就可以重写成这样： 

```java
inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
```

你的代码还能变得更易读一点吗？**Comparator**具有一个叫作**comparing**的静态辅助方法， 它可以接受一个Function来提取Comparable键值，并生成一个Comparator对象（我们会在第 9章解释为什么接口可以有静态方法）。它可以像下面这样用（注意你现在传递的Lambda只有一 个参数：Lambda说明了如何从苹果中提取需要比较的键值）： 

```java
Comparator<Apple> c = Comparator.comparing((Apple a) -> a.getWeight()); 
```

现在你可以把代码再改得紧凑一点了： 

```java
import static java.util.Comparator.comparing;
inventory.sort(comparing((a) -> a.getWeight())); 
```

#### 3.7.4 第4步：使用方法引用 

前面解释过，方法引用就是替代那些转发参数的Lambda表达式的语法糖。你可以用方法引 用让你的代码更简洁（假设你静态导入了java.util.Comparator.comparing）： 

```java
inventory.sort(comparing(Apple::getWeight)); 
```

恭喜你，这就是你的终解决方案！这比Java 8之前的代码好在哪儿呢？它比较短；它的意 思也很明显，并且代码读起来和问题描述差不多：“对库存进行排序，比较苹果的重量。” 



### 3.8 复合Lambda表达式的有用方法 



Java 8的好几个函数式接口都有为方便而设计的方法。具体而言，许多函数式接口，比如用 于传递Lambda表达式的Comparator、Function和Predicate都提供了允许你进行复合的方法。 这是什么意思呢？在实践中，这意味着你可以把多个简单的Lambda复合成复杂的表达式。比如， 你可以让两个谓词之间做一个or操作，组合成一个更大的谓词。而且，你还可以让一个函数的结 果成为另一个函数的输入。你可能会想，函数式接口中怎么可能有更多的方法呢？（毕竟，这违 背了函数式接口的定义啊！）窍门在于，我们即将介绍的方法都是默认方法，也就是说它们不是 抽象方法。



#### 3.8.1 比较器复合 

```java
Comparator<Apple> c = Comparator.comparing(Apple::getWeight); 
```

逆序

```java
inventory.sort(comparing(Apple::getWeight).reversed());
```

比较器链

```java
inventory.sort(comparing(Apple::getWeight)
               .reversed()
               .thenComparing(Apple::getCountry)); 
```



#### 3.8.2 谓词复合

谓词接口包括三个方法：negate(非)、and和or，让你可以重用已有的Predicate来创建更复 杂的谓词。

```java
Predicate<Apple> notRedApple = redApple.negate(); 
Predicate<Apple> redAndHeavyApple = redApple.and(a -> a.getWeight() > 150);
Predicate<Apple> redAndHeavyAppleOrGreen = 
    redApple.and(a -> a.getWeight() > 150).or(a -> "green".equals(a.getColor())); 
```



#### 3.8.3 函数复合

你还可以把Function接口所代表的Lambda表达式复合起来。Function接口为此配 了andThen和compose两个默认方法，它们都会返回Function的一个实例。  

```java
Function<Integer, Integer> f = x -> x + 1; 
Function<Integer, Integer> g = x -> x * 2; 
Function<Integer, Integer> h = f.andThen(g); // 意味着 g(f(x))
int result = h.apply(1); 
-
Function<Integer, Integer> h = f.compose(g); // 意味着 f(g(x))
int result = h.apply(1); 
```



### 3.9 数学中的类似思想 



#### 3.9.1 积分

#### 3.9.2 与Java 8的 Lambda联系起来 



### 3.10 小结



以下是你应从本章中学到的关键概念。 

1. Lambda表达式可以理解为一种匿名函数：它没有名称，但有参数列表、函数主体、返回 类型，可能还有一个可以抛出的异常的列表。
2. Lambda表达式让你可以简洁地传递代码。 
3. 函数式接口就是仅仅声明了一个抽象方法的接口。 
4. 只有在接受函数式接口的地方才可以使用Lambda表达式。 
5. Lambda表达式允许你直接内联，为函数式接口的抽象方法提供实现，并且将整个表达式 作为函数式接口的一个实例。 
6. Java 8自带一些常用的函数式接口，放在java.util.function包里，包括Predicate <T>、Function<T,R>、Supplier<T>、Consumer<T>和BinaryOperator<T>等
7. 为了避免装箱操作，对Predicate<T>和Function<T, R>等通用函数式接口的原始类型 特化：IntPredicate、IntToLongFunction等。 
8. 环绕执行模式（即在方法所必需的代码中间，你需要执行点儿什么操作，比如资源分配 和清理）可以配合Lambda提高灵活性和可重用性。 
9. Lambda表达式所需要代表的类型称为目标类型。 
10. 方法引用让你重复使用现有的方法实现并直接传递它们。 
11. Comparator、Predicate和Function等函数式接口都有几个可以用来结合Lambda表达 式的默认方法。 



# 第二部分 函数式数据处理



## 第4章 引入流



### 4.1 流是什么



流是Java API的新成员，它允许你以声明性方式处理数据集合（通过查询语句来表达，而不 是临时编写一个实现）。就现在来说，你可以把它们看成遍历数据集的高级迭代器。

Java 8中的Stream API可以让你写出这样的代码： 

1. 声明性——更简洁，更易读 
2. 可复合——更灵活 
3. 可并行——性能更好 



### 4.2 流简介



### 4.3 流与集合



### 4.4 流操作



#### 4.4.1 中间操作 

#### 4.4.2 终端操作 

#### 4.4.3 使用流

流的使用一般包括三件事： 

1. 一个数据源（如集合）来执行一个查询
2.  一个中间操作链，形成一条流的流水线
3.  一个终端操作，执行流水线，并能生成结果

中间操作和终端操作

| 操作      | 类型              | 返回类型    | 操作参数              | 函数描述符   |
| --------- | ----------------- | ----------- | --------------------- | ------------ |
| filter    | 中间              | Stream<T>   | Predicate<T>          | T->boolean   |
| distinct  | 中间(有状态/无界) | Stream<T>   |                       |              |
| skip      | 中间(有状态/有界) | Stream<T>   | long                  |              |
| limit     | 中间(有状态/有界) | Stream<T>   | long                  |              |
| map       | 中间              | Stream<R>   | Function<T,R>         | T->R         |
| flatMap   | 中间              | Stream<R>   | Function<T,Stream<R>> | T->Stream<R> |
| sorted    | 中间(有状态/无界) | Stream<T>   | Comparator<T>         | (T,T)->int   |
| anyMatch  | 终端              | boolean     | Predicate<T>          | T->boolean   |
| noneMatch | 终端              | boolean     | Predicate<T>          | T->boolean   |
| allMatch  | 终端              | boolean     | Predicate<T>          | T->boolean   |
| findAny   | 终端              | Optional<T> |                       |              |
| findFirst | 终端              | Optional<T> |                       |              |
| forEach   | 终端              | void        | Consumer<T>           | T->void      |
| collect   | 终端              | R           | Collector<T,A,R>      |              |
| reduce    | 终端(有状态-有界) | Optional<T> | BinaryOperator<T>     | (T,T)->T     |
| count     | 终端              | long        |                       |              |

终端操作

| 操作    | 类型 | 目的                                                   |
| ------- | ---- | ------------------------------------------------------ |
| forEach | 终端 | 消费流中的每个元素并对其应用 Lambda。这一操作返回 void |
| count   | 终端 | 返回流中元素的个数。这一操作返回 long                  |
| collect | 终端 | 把流归约成一个集合，比如 List、 Map 甚至是 Integer     |



### 4.5 小结



以下是你应从本章中学到的一些关键概念。 

1. 流是“从支持数据处理操作的源生成的一系列元素”。 
2. 流利用内部迭代：迭代通过filter、map、sorted等操作被抽象掉了。 
3. 流操作有两类：中间操作和终端操作。 
4. filter和map等中间操作会返回一个流，并可以链接在一起。可以用它们来设置一条流 水线，但并不会生成任何结果。 
5.  forEach和count等终端操作会返回一个非流的值，并处理流水线以返回结果。 
6. 流中的元素是按需计算的。 



## 第五章 使用流



### 5.1 筛选和切片 



#### 5.1.1 用谓词筛选 

filter



#### 5.1.2 筛选各异的元素 

distinct



#### 5.1.3 截短流 

limit



#### 5.1.4 跳过元素 

skip



### 5.2 映射



一个非常常见的数据处理套路就是从某些对象中选择信息。比如在SQL里，你可以从表中选 择一列。Stream API也通过map和flatMap方法提供了类似的工具。 



#### 5.2.1 对流中每一个元素应用函数 

