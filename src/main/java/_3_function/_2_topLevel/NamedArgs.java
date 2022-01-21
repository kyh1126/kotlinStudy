package _3_function._2_topLevel;

public class NamedArgs {
    private static int f1;
    private static int f2;
    private static String f3;

    public static void call(int f1, int f2, String f3) {
        System.out.println("result: " + f1 + f2 + f3);
    }

    public static void main(String[] args) {
        call(f1 = 1, f2 = 2, f3 = "3");
        call(/* f1 */1, /* f2 */2, /* f3 */"3");
    }
}
