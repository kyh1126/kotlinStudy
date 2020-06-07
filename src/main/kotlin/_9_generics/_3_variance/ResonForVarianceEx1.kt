package _9_generics._3_variance

// 변성(variance) : List<Any> List<String> 과 같이 기저 타입이 같고 타입 인자가 다른 여러 타입이 서로 어떤 관계가 있는지 설명하는 개념

fun printContents(list: List<Any>) {
    println(list.joinToString())
}

fun addAnswer(list: MutableList<Any>) {
    list.add(42)
}

fun main(args: Array<String>) {
    printContents(listOf("abc", "bac"))

    val strings = mutableListOf("abc", "bac")
    // MutableList<Any> 가 필요한 곳에 MutableList<String> 을 넘기면 안 된다.
//    addAnswer(strings)

    // 어떤 함수가 리스트의 원소를 추가, 변경하면 타입 불일치가 생길 수 있어서 List<Any> 대신 List<String> 을 넘길 수 없다.
    // 하지만 원소 추가나 변경이 없는 경우에는 List<String> 을 List<Any> 대신 넘겨도 안전하다.
}