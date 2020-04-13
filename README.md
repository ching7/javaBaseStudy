# javaBaseStudy

[![java](https://img.shields.io/badge/JAVA-1.8+-green.svg)](#java-proxy)

## java-proxy

什么是**代理**：

在Java设计模式中，代理模式是这样定义的：给某个对象提供一个代理对象，并由代理对象控制原对象的引用。

　　可能大家不太明白这句话，在举一个现实生活中的例子：比如我们要买一间二手房，虽然我们可以自己去找房源，但是这太花费时间精力了，而且房屋质量检测以及房屋过户等一系列手续也都得我们去办，再说现在这个社会，等我们找到房源，说不定房子都已经涨价了，那么怎么办呢？最简单快捷的方法就是找二手房中介公司（为什么？别人那里房源多啊），于是我们就委托中介公司来给我找合适的房子，以及后续的质量检测过户等操作，我们只需要选好自己想要的房子，然后交钱就行了。

　　代理简单来说，就是如果我们想做什么，但又不想直接去做，那么这时候就找另外一个人帮我们去做。那么这个例子里面的中介公司就是给我们做代理服务的，我们委托中介公司帮我们找房子。

![java代理模式](document/images/java-proxy.jpg)

- java常用的代理模式
  - ***JDK***提供的动态代理
  - ***cglib***动态代理

## java-reflect

什么是**反射**：

正常情况下我们新建一个类就是：

~~~java
Student st = new Student()
~~~

通过new方式，调用默认构造方法新建一个类，加载到jvm虚拟机中，这种类的加载方法存在一种问题，就是运行时不灵活，如果我们把student类换成teacher类，就需要重新修改代码。

而java的反射机制提供了一种方法，在程序运行时动态加载所需要的类

~~~java
Class c1 = Class.forName("com.cyh.test.Teacher");
//创建此Class对象所表示类的一个新实例,
 //newInstance方法调用的是Teacher的空参数构造方法
Object o = c1.newInstance();
~~~

类路径可以从配置文件加载，从而实现不需要修改代码，实现类的替换

除此之外，还可以根据反射特性，对于任意一个类。都能都知道这个类的所有属性和方法，对于任意一个对象，都能够调用它的任意一个方法和属

- java基础知识 - 反射原理
- 反射获取注解的基础demo

## java-validCode

- 纯java代码实现图像验证码
- 添加干扰线等

## java-serializbzle

Java 序列化是 JDK 1.1 时引入的一组开创性的特性，用于将 Java 对象转换为字节数组，便于存储或传输。此后，仍然可以将字节数组转换回 Java 对象原有的状态。

序列化的思想是“冻结”对象状态，然后写到磁盘或者在网络中传输；反序列化的思想是“解冻”对象状态，重新获得可用的 Java 对象。

但是点开序列化 `Serializbale` 接口的定义，会发现这个是一个空接口

> [参考文章](https://mp.weixin.qq.com/s/qV9Ius76bo7GIKu0S-XZQA)

* 实例

  * 创建一个`People`类（只有两个字段，和对应的 `getter/setter`），用于序列化和反序列化

  * 创建一个测试类，通过 `ObjectOutputStream` 将“18 岁的王二”写入到文件当中，实际上就是一种序列化的过程；再通过 `ObjectInputStream` 将“18 岁的王二”从文件中读出来，实际上就是一种反序列化的过程。

  ~~~java
  public static void main(String[] args) {
          // 初始化
          People wanger = new People();
          wanger.setName("王二");
          wanger.setAge(18);
          System.out.println(wanger);
  
          // 把对象写到文件中
          try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("chenmo"));){
              oos.writeObject(wanger);
          } catch (IOException e) {
              e.printStackTrace();
          }
  
          // 从文件中读出对象
          try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("chenmo")));){
              People wanger1 = (People) ois.readObject();
              System.out.println(wanger1);
          } catch (IOException | ClassNotFoundException e) {
              e.printStackTrace();
          }
      }
  ~~~

  

  * 由于没有实现`Serializbale` 接口，运行过程中会报错

  ~~~properties
  com.cyn.bean.People@28d93b30
  java.io.NotSerializableException: com.cyn.bean.People
  	at java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1184)
  	at java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:348)
  	at com.cyn.bean.TestMain.main(TestMain.java:25)
  java.io.WriteAbortedException: writing aborted; java.io.NotSerializableException: com.cyn.bean.People
  	at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1355)
  	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:371)
  	at com.cyn.bean.TestMain.main(TestMain.java:32)
  Caused by: java.io.NotSerializableException: com.cyn.bean.People
  	at java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1184)
  	at java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:348)
  	at com.cyn.bean.TestMain.main(TestMain.java:25)
  
  ~~~

  * 添加接口实现后，正常序列化和反序列化

  * 序列化和反序列的实现过程

    * ObjectOutputStream 序列化

      跟进ObjectOutputStream源码会发现，序列化时会判断被序列化的对象是哪一种类型

      ~~~java
      if (obj instanceof String) {
          writeString((String) obj, unshared);
      } else if (cl.isArray()) {
          writeArray(obj, desc, unshared);
      } else if (obj instanceof Enum) {
          writeEnum((Enum<?>) obj, desc, unshared);
      } else if (obj instanceof Serializable) {
          writeOrdinaryObject(obj, desc, unshared);
      } else {
          if (extendedDebugInfo) {
              throw new NotSerializableException(
                  cl.getName() + "\n" + debugInfoStack.toString());
          } else {
              throw new NotSerializableException(cl.getName());
          }
      }
      ~~~

    * 被序列化的类实现`Serializable` 接口

      实现序列化，依次调用`writeObject()`→`writeObject0()`→`writeOrdinaryObject()`→`writeSerialData()`→`invokeWriteObject()`→`defaultWriteFields()`。

    * 反序列化反向执行上述过程

* 序列化注意点

  * 不会被序列化的字段`static` 和 `transient`

    * `static` 修饰的字段，序列化前为变化，序列化后，如果字段发生变化。反序列后，该字段不会保留序列化前的状态，因为`static` 修饰的字段属于类的状态，反序列化时，会根据当前类状态变化。

    * `transient`修饰的字段，属于临时字段，`meizi` 的值为“王三”，反序列化后，`meizi` 的值为 `null。`

      `transient` 的中文字义为“临时的”（论英语的重要性），它可以阻止字段被序列化到文件中，在被反序列化后，`transient` 字段的值被设为初始值，比如 `int` 型的初始值为 0，对象型的初始值为 `null`。

* 其他序列化接口`Externalizable`

  * 需要实现2个方法`readExternal`、`writeExternal`，将需要序列化的字段手动读写。如果没有的化，反序列化后的值会是默认值，没有保留类的原有值

    ~~~java
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }
    
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
    }
    ~~~

* 序列化ID

  我们在进行序列化时，常常会看到

  `private static final long serialVersionUID = 3282215350418518214L;` 

  这段代码

  `serialVersionUID` 被称为序列化 ID，它是决定 Java 对象能否反序列化成功的重要因子。在反序列化时，Java 虚拟机会把字节流中的 `serialVersionUID` 与被序列化类中的 `serialVersionUID` 进行比较，如果相同则可以进行反序列化，否则就会抛出序列化版本不一致的异常。

## java-design-pattern

Java常用设计模式介绍以及demo

* **strategy**（策略模式）

  一个类的行为或其算法可以在运行时更改。

  **意图：**定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。

  **主要解决：**在有多种算法相似的情况下，使用 if...else 所带来的复杂和难以维护。

  **何时使用：**一个系统有许多许多类，而区分它们的只是他们直接的行为。

  **如何解决：**将这些算法封装成一个一个的类，任意地替换。

  **关键代码：**实现同一个接口。

  **应用实例：**

  1、诸葛亮的锦囊妙计，每一个锦囊就是一个策略。 

  2、旅行的出游方式，选择骑自行车、坐汽车，每一种旅行方式都是一个策略。 

  3、JAVA AWT 中的 LayoutManager。

  4、spring中多个类实现的加载

  **优点：**

  1、同一个算法接口实现可以自由切换。 

  2、避免使用多重条件判断。

  3、扩展性良好。

  **缺点：**

   1、策略类会增多。

   2、所有策略类都需要对外暴露。

  **使用场景：**

   1、如果在一个系统里面有许多类，它们之间的区别仅在于它们的行为，那么使用策略模式可以动态地让一个对象在许多行为中选择一种行为。 

  2、一个系统需要动态地在几种算法中选择一种。 

  3、如果一个对象有很多的行为，如果不用恰当的模式，这些行为就只好使用多重的条件选择语句来实现。

  **注意事项：**如果一个系统的策略多于四个，就需要考虑使用混合模式，解决策略类膨胀的问题。

* **factory**（工厂模式）

  属于创建型模式，它提供了一种创建对象的最佳方式。在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。

  **意图：**定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
  
  **主要解决：**主要解决接口选择的问题。
  
  **何时使用：**我们明确地计划不同条件下创建不同实例，实现不同功能
  
  **如何解决：**让其子类实现工厂接口，返回的也是一个抽象的产品。
  
  **关键代码：**创建过程在其子类执行。
  
  **应用实例：** 
  
  1、您需要一辆汽车，可以直接从工厂里面提货，而不用去管这辆汽车是怎么做出来的，以及这个汽车里面的具体实现。
  
  2、Hibernate 换数据库只需换方言和驱动就可以。
  
  **优点：**
  
  1、一个调用者想创建一个对象，只要知道其名称就可以了。 
  
  2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。
  
  3、屏蔽产品的具体实现，调用者只关心产品的接口。
  
  **缺点：**每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数成倍增加，在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖。这并不是什么好事。
  
  **使用场景：**
  
  1、日志记录器：记录可能记录到本地硬盘、系统事件、远程服务器等，用户可以选择记录日志到什么地方。 
  
  2、数据库访问，当用户不知道最后系统采用哪一类数据库，以及数据库可能有变化时。
  
  3、设计一个连接服务器的框架，需要三个协议，"POP3"、"IMAP"、"HTTP"，可以把这三个作为产品类，共同实现一个接口。
  
  **注意事项：**作为一种创建类模式，在任何需要生成复杂对象的地方，都可以使用工厂方法模式。有一点需要注意的地方就是复杂对象适合使用工厂模式，而简单对象，特别是只需要通过 new 就可以完成创建的对象，无需使用工厂模式。如果使用工厂模式，就需要引入一个工厂类，会增加系统的复杂度

* 抽象工厂模式（abstractFactory）

  围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

  在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。

  **意图：**提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。

  **主要解决：**主要解决接口选择的问题。

  **何时使用：**系统的产品有多于一个的产品族，而系统只消费其中某一族的产品。

  **如何解决：**在一个产品族里面，定义多个产品。

  **关键代码：**在一个工厂里聚合多个同类产品。

  **应用实例：**工作了，为了参加一些聚会，肯定有两套或多套衣服吧，比如说有商务装（成套，一系列具体产品）、时尚装（成套，一系列具体产品），甚至对于一个家庭来说，可能有商务女装、商务男装、时尚女装、时尚男装，这些也都是成套的，即一系列具体产品。假设一种情况（现实中是不存在的，要不然，没法进入共产主义了，但有利于说明抽象工厂模式），在您的家中，某一个衣柜（具体工厂）只能存放某一种这样的衣服（成套，一系列具体产品），每次拿这种成套的衣服时也自然要从这个衣柜中取出了。用 OOP 的思想去理解，所有的衣柜（具体工厂）都是衣柜类的（抽象工厂）某一个，而每一件成套的衣服又包括具体的上衣（某一具体产品），裤子（某一具体产品），这些具体的上衣其实也都是上衣（抽象产品），具体的裤子也都是裤子（另一个抽象产品）。

  **优点：**当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象。

  **缺点：**产品族扩展非常困难，要增加一个系列的某一产品，既要在抽象的 Creator 里加代码，又要在具体的里面加代码。

  **使用场景：** 1、QQ 换皮肤，一整套一起换。 2、生成不同操作系统的程序。

  **注意事项：**产品族难扩展，产品等级易扩展。