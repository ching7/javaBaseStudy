package com.cyn.demo;

import org.junit.Test;

import java.util.HashSet;

/**
 * @ClassName HashCodeConflict
 * @Description
 * @Author ynchen
 * @Date 2024/7/11 16:25
 * @Version V1.0.0
 */
public class HashCodeConflict {
    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<>();
        for (int i = 0; i < 110001; i++) {
            int code = new Book().hashCode();
            if (!set.contains(code)) {
                set.add(code);
            } else {
                // hashCode冲突 11w左右
                // 重写hashcode不会出现冲突，每次实例化传不同参数不会出现
                System.out.println("冲突:+" + i + "hashcode:" + code);
            }
        }
        System.out.println(set.size());
    }

    static class Book {
        private int id;

//        public Book(int id) {
//            this.id = id;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Book book = (Book) o;
//            return id == book.id;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hashCode(id);
//        }
    }

    @Test
    public void v1() {
        System.out.println("Hello World!".hashCode());
        System.out.println("Hello WorlD!".hashCode());
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
        System.out.println("CC".hashCode());
    }

    @Test
    public void v2() {
        Integer a = Integer.valueOf(600);
        Integer b = 600;
        int c = 600;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a == c);
        System.out.println(b == c);

        System.out.println("===");
        Integer a1 = 99;
        Integer b1 = 99;
        int c1 = 99;
        System.out.println(a1 == b1);
        System.out.println(a1.equals(b1));
        System.out.println(a1 == c1);
        System.out.println(b1 == c1);
    }
}
