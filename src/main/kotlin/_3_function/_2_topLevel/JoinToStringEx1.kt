package _3_function._2_topLevel

// joinToString() 함수
// @JvmOverloads : 코틀린 컴파일러가 자동으로 맨 마지막 파라미터로부터 파라미ㅣ터를 하나씩 생략한 오버로딩한 자바 메소드를 추가해준다.
@JvmOverloads
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "<",
    postfix: String = ">"
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    val list = (1..5).toList()
    println(joinToString(list, "; ", "(", ")"))
    println()

    val set = ('a'..'e').toSet()
    // 3-2-1. 이름 붙인 인자
    println(joinToString(prefix = "(", separator = "/ ", postfix = ")", collection = set))
    println()

    // 3-2-2 디폴트 파라미터 값
    // 자바 호출시 모든 인자를 명시해야 한다.
    println(joinToString(set))
    println(joinToString(list, prefix = "(", postfix = ")"))
}