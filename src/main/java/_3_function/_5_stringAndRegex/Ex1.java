package _3_function._5_stringAndRegex;

import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) {
        // 자바의 split의 구분 문자열은 실제로는 정규식이다. -> 아래의 경우 빈배열 반환
        Arrays.stream("12.345-6.A".split(".")).forEach(System.out::println);
    }
}
