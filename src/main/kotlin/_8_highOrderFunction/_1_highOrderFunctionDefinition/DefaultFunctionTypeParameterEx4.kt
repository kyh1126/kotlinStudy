package _8_highOrderFunction._1_highOrderFunctionDefinition

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    // 함수 타입 파라미터를 선언하면서 람다를 디폴트 값으로 지정한다.
    transform: (T) -> String = { it.toString() }
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        // 기본 toString 메소드를 사용해 객체를 문자열로 변환한다.
//        result.append(element)

        result.append(transform(element))
    }
    result.append(postfix)
    return result.toString()
}

// nullable 함수 타입을 사용할 수도 있다. 대신 null 체크 필요
fun foo(callback: (() -> Unit)) {
    if (callback != null) {
        callback()
    }
    // 함수 타입이 invoke 메소드를 구현하는 인터페이스라 아래와 같이도 가능하다.
    callback?.invoke()
}

// Using safe call operator
fun <T> Collection<T>.joinToString2(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        val str = transform?.invoke(element) ?: element.toString()
        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}


fun main(args: Array<String>) {
    val letters = listOf("Alpha", "Beta")
    println(letters.joinToString())
    println(letters.joinToString { it.toLowerCase() })
    println(letters.joinToString(separator = "! ", postfix = "!! ") { it.toUpperCase() })

    println(letters.joinToString2())
    println(letters.joinToString2 { it.toLowerCase() })
    println(letters.joinToString2(separator = "! ", postfix = "!! ") { it.toUpperCase() })
}