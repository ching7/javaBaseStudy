package com.cyn.demo;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/23
 */
public class TestDemo {
    public static void main(String[] args) {
//        for (int i = 1; i <= 5; i++) {
//            System.out.println("===" + CountryEnum.forEachCountryEnum(i).getMessage());
//        }
        System.out.println("===" + CountryEnum.ONE);
        System.out.println("===" + CountryEnum.ONE.getCode());
        System.out.println("===" + CountryEnum.ONE.getMessage());

    }
}
