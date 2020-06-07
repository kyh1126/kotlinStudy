package _3_function._2_topLevel;

import java.util.Set;

import static _3_function.strings.StringFunctions.joinToString;

//import static _3_function.strings.StringFunctions.joinToString;

public class Ex2 {
    public static void main(String[] args) {
        var set = Set.of('a', 'b', 'c', 'd', 'e');
        System.out.println(joinToString(set, "; ", "(", ")"));
    }
}
