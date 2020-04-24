# JAVA8 新特性

[![java](https://img.shields.io/badge/JAVA-1.8+-green.svg)](##Lambda)

## Lambda

* 什么是`Lambda`

  Lambda 表达式（lambda expression）是一个匿名函数，Lambda表达式基于数学中的λ演算得名，直接对应于其中的lambda抽象（lambda abstraction），是一个**匿名函数**，即没有函数名的函数。Lambda表达式可以表示闭包。

* 什么是`闭包`

  闭包就是能够读取其他函数内部变量的函数。例如在javascript中，只有函数内部的子函数才能读取局部变量，所以闭包可以理解成**“定义在一个函数内部的函数“**。

Lambda 表达式主要用来定义行内执行的方法类型接口，例如，一个简单方法接口。在示例代码中，我们使用各种类型的Lambda表达式来定义MathOperation接口的方法。然后我们定义了sayMessage的执行。

Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。

## StreamAPI

Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。

Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象。

Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。

这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等。

元素流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作(terminal operation)得到前面处理的结果。

```
+--------------------+       +------+   +------+   +---+   +-------+
| stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
+--------------------+       +------+   +------+   +---+   +-------+
```

以上的流程转换为 Java 代码为：

```
List<Integer> transactionsIds = 
widgets.stream()
             .filter(b -> b.getColor() == RED)
             .sorted((x,y) -> x.getWeight() - y.getWeight())
             .mapToInt(Widget::getWeight)
             .sum();
```

### 什么是 Stream？

Stream（流）是一个来自数据源的元素队列并支持聚合操作

- 元素是特定类型的对象，形成一个队列。 Java中的Stream并不会存储元素，而是按需计算。
- **数据源** 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。
- **聚合操作** 类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等。

和以前的Collection操作不同， Stream操作还有两个基础的特征：

- **Pipelining**: 中间操作都会返回流对象本身。 这样多个操作可以串联成一个管道， 如同流式风格（fluent style）。 这样做可以对操作进行优化， 比如延迟执行(laziness)和短路( short-circuiting)。
- **内部迭代**： 以前对集合遍历都是通过Iterator或者For-Each的方式, 显式的在集合外部进行迭代， 这叫做外部迭代。 Stream提供了内部迭代的方式， 通过访问者模式(Visitor)实现。

### 常用Stream

* stream 生成流     

* forEach 应用于stream新的方法 'forEach' 来迭代流中的每个数据      

* map 用于映射每个元素到对应的结果（对流中的每个元素做操作后返回流       

* filter 用于通过设置的条件过滤出元素        

* limit 于获取指定数量的流       

* 并行（parallel）程序      

* Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。

  - toList
  - toSet
  - toCollection

* 数值流

  `int sum = list.stream().map(Person::getAge).reduce(0, Integer::sum);` 计算元素总和的方法其中暗含了装箱成本，`map(Person::getAge)` 方法过后流变成了 Stream 类型，而每个 Integer 都要拆箱成一个原始类型再进行 sum 方法求和，这样大大影响了效率。

  针对这个问题 Java 8 有良心地引入了数值流 IntStream, DoubleStream, LongStream，这种流中的元素都是原始数据类型，分别是 int，double，long

  IntStream 与 LongStream 拥有 range 和 rangeClosed 方法用于数值范围处理

  - IntStream ： rangeClosed(int, int) / range(int, int)
  - LongStream ： rangeClosed(long, long) / range(long, long)

  这两个方法的区别在于一个是闭区间，一个是半开半闭区间：

  - rangeClosed(1, 100) ：[1, 100]
  - range(1, 100) ：[1, 100)

  数值流中的 max 方法返回的类型是Optional

  * NullPointerException 可以说是每一个 Java 程序员都非常讨厌看到的一个词，针对这个问题， Java 8 引入了一个新的容器类 Optional，可以代表一个值存在或不存在，这样就不用返回容易出问题的 null。之前文章的代码中就经常出现这个类，也是针对这个问题进行的改进。

  Optional 类比较常用的几个方法有：

  - isPresent() ：值存在时返回 true，反之 flase
  - get() ：返回当前值，若值不存在会抛出异常
  - orElse(T) ：值存在时返回该值，否则返回 T 的值

  Optional 类还有三个特化版本 OptionalInt，OptionalLong，OptionalDouble

  Optional 类其中其实还有很多学问，讲解它说不定也要开一篇文章，这里先讲那么多，先知道基本怎么用就可以。