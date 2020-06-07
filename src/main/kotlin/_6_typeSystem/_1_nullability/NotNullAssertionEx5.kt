package _6_typeSystem._1_nullability

fun ignoreNulls(s: String?) {
    // 예외는 이 지점을 가리킨다.
    // !! : 어떤 값이든 널이 될 수 없는 타입으로 바꿀 수 있다. NPE 발생.
    // 어떤 값이 널이었는지 확실히 하기 위해 여러 !! 단언문을 한 줄에 함께 쓰는 일을 피하라.
    val sNotNull: String = s!!
    println(sNotNull.length)
}

fun main(args: Array<String>) {
    ignoreNulls(null)
}