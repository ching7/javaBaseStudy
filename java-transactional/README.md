# 事务管理

事物管理对于企业应用来说是至关重要的，好使出现异常情况，它也可以保证数据的一致性。

spring支持编程式事务管理和声明式事务管理两种方式。

**编程式事务管理**：@Transactional注解等实现

使用TransactionTemplate或者直接使用底层的PlatformTransactionManager。对于编程式事务管理，spring推荐使用TransactionTemplate。

~~~java
    @Transactional (propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    public AuditOutput postAudit(AuditInnerput innerInput) {
        ...
    }
~~~



**声明式事务管理**：TransactionTemplate实现

建立在AOP之上的。其本质是对方法前后进行拦截，然后在目标方法开始之前创建或者加入一个事务，在执行完目标方法之后根据执行情况提交或者回滚事务。声明式事务最大的优点就是不需要通过编程的方式管理事务，这样就不需要在业务逻辑代码中掺杂事务管理的代码，只需在配置文件中做相关的事务规则声明(或通过基于@Transactional注解的方式)，便可以将事务规则应用到业务逻辑中。

~~~java
public void batchInsert(Integer id, String kind) {
        transactionExtTemplate.execute(() -> {
            archscanconfigDAO.deleteArchscanconfig(id);
            archscanconfigDAO.batchInsertArchscanconfig(kind);
        });
    }
~~~



**二者区别**

* 显然声明式事务管理要优于编程式事务管理，这正是spring倡导的非侵入式的开发方式。声明式事务管理使业务代码不受污染，一个普通的POJO对象，只要加上注解就可以获得完全的事务支持。
* 和编程式事务相比，声明式事务唯一不足地方是最细粒度只能作用到方法级别，无法做到像编程式事务那样可以作用到代码块级别。但是即便有这样的需求，也存在很多变通的方法，比如，可以将需要进行事务管理的代码块独立为方法等等。