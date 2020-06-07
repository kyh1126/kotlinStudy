package _6_typeSystem._2_primitiveType

fun foo(l: Long) = println("@@ " + l)

fun main(args: Array<String>) {
    // Whenever you use an arithmetic operator on two integers of the same type
    // (or when you use a unary operator like negation),
    // there is no automatic "upgrading" if the result doesn't fit in the type of the operands!
    val i = 1
//    val l: Long = i

    // 직접 변환 메소드를 호출해야 한다.
    // Boolean 제외 모든 원시 타입에 대한 변환 함수를 제공한다.
    val l: Long = i.toLong()
    // 숫자 리터럴을 타입이 알려진 변수에 대입하거나 함수에게 인자로 넘기면 컴파일러가 필요한 변환을 자동으로 넣어준다.
    val b: Byte = 1
    val ll = b + 1L
    println("## " + ll)
    foo(42)

    // 두 박스 타입 간 equals 비교시 박스 타입 객체를 비교한다.
    val x = 1
    val list = listOf(1L, 2L, 3L)
    // Type inference failed.
//    println(x in list)
    println(x.toLong() in list)
}