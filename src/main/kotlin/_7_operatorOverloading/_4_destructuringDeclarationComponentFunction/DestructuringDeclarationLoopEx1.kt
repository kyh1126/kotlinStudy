package _7_operatorOverloading._4_destructuringDeclarationComponentFunction

// data 클래스의 주 생성자에 들어있는 프로퍼티에 대해서는 컴파일러가 자동으로 componentN 함수를 만들어준다.
// 코틀린 표준 라이브러리에서는 맨 앞의 다섯 원소에 대한 componentN 을 제공한다.
fun printEntries(map: Map<String, String>) {
    // 구조 분해 선언
    for ((key, value) in map) {
        println("$key -> $value")
    }
}

fun main(args: Array<String>) {
    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)

    // 코틀린 라이브러리는 Map.Entry 에 대한 확장 함수로 component1, component2 를 제공한다.
    for (entry in map.entries) {
        println("${entry.component1()} -> ${entry.component2()}")
    }
}