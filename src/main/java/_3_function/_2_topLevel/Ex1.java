package _3_function._2_topLevel;

import java.util.List;

import static _3_function._2_topLevel.JoinToStringEx1Kt.joinToString;


public class Ex1 {
    public static void main(String[] args) {
        var list = List.of(1, 2, 3, 4);

        System.out.println(joinToString(list, "/ ", "(", ")"));
        System.out.println(joinToString(list));
    }
}
