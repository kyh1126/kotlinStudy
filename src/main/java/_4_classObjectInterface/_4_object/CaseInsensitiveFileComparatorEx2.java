package _4_classObjectInterface._4_object;

import java.io.File;

public class CaseInsensitiveFileComparatorEx2 {
    public static void main(String[] args) {
        File f1 = new File("/User");
        File f2 = new File("/user");

        System.out.println(CaseInsensitiveFileComparator.INSTANCE.compare(f1, f2));
    }
}
