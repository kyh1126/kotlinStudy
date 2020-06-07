package _6_typeSystem._2_primitiveType

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println("We're ${percent}% done!")
}

fun main(args: Array<String>) {
    // Kotlin doesn't distinguish the primitive, reference type.
    showProgress(146)

    // 코틀린의 Int 타입은 자바 int 타입으로 컴파일된다.
    // 이런 컴파일이 불가능한 경우는 컬렉션과 같은 제네릭 클래스를 사용하는 경우뿐이다.
    // Int 타입을 컬렉션의 타입 파라미터로 넘기면 그 컬렉션에는 Int 의 래퍼 타입에 해당하는 java.lang.Integer 객체가 들어간다.

//  Primitive types in Kotlin
//  Type	Bits	Min value	            Max value
//  Long	64	    -9223372036854775808	9223372036854775807
//  Int	    32	    -2147483648	            2147483647
//  Short	16	    -32768	                32767
//  Byte	8	    -128	                127

//  Type	Bits	Notes
//  Double	64	    16-17 significant digits (same as float in Python)
//  Float	32	    6-7 significant digits
//  Char	16	    UTF-16 code unit (see the section on strings - in most cases, this is one Unicode character, but it might be just one half of a Unicode character)
//  Boolean	8	    true or false
}