package _8_highOrderFunction._1_highOrderFunctionDefinition

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

fun main(args: Array<String>) {
    // 인자로 받은 함수 호출
    twoAndThree { a, b -> a + b }

    // 술어 함수를 파라미터로 받는 filter 함수
    (0..9).filter { it > 3 }.forEach { println(it) }
}