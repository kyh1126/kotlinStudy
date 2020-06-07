package _6_typeSystem._1_nullability;

import java.util.Objects;

import static _6_typeSystem._1_nullability.PlatformTypeEx11Kt.yellAtSafe;
import static _6_typeSystem._1_nullability.WithoutNullChkEx10Kt.yellAt;

public class JavaMainEx10 {
    public static void main(String[] args) {
        yellAt(new JavaPerson("Jenny"));
        System.out.println("###");

        yellAtSafe(new JavaPerson(null));

//         Objects.requireNonNull(a, "상품이름 잘못들어옴")
    }
}
