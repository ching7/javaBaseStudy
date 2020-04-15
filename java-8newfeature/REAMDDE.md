# JAVA8 新特性

[![java](https://img.shields.io/badge/JAVA-1.8+-green.svg)](##Lambda)

## Lambda

* 什么是`Lambda`

  Lambda 表达式（lambda expression）是一个匿名函数，Lambda表达式基于数学中的λ演算得名，直接对应于其中的lambda抽象（lambda abstraction），是一个**匿名函数**，即没有函数名的函数。Lambda表达式可以表示闭包。

* 什么是`闭包`

  闭包就是能够读取其他函数内部变量的函数。例如在javascript中，只有函数内部的子函数才能读取局部变量，所以闭包可以理解成**“定义在一个函数内部的函数“**。

Lambda 表达式主要用来定义行内执行的方法类型接口，例如，一个简单方法接口。在示例代码中，我们使用各种类型的Lambda表达式来定义MathOperation接口的方法。然后我们定义了sayMessage的执行。

Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。