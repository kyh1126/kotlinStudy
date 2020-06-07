package _8_highOrderFunction._1_highOrderFunctionDefinition

// 고차 함수 :
// 람다나 함수 참조를 인자로 넘길 수 있거나 반환하는 함수

// 파라미터 이름을 지정할 수도 있다.
fun performRequest(url: String, e: (code: Int, content: String) -> Unit) {
}

fun main(args: Array<String>) {
    val sum = { x: Int, y: Int -> x + y }
    val action = { println(42) }

    //                      파라미터 타입     반환 타입
    val sumWithTypeDeclare: (Int, Int) -> Int = { x, y -> x + y }
    val actionWithTypeDeclare: () -> Unit = { println(42) }

    // 반환 타입을 nullable 로 지정 가능
    var canReturnNull: (Int, Int) -> Int? = { x, y -> null }
    // 함수 타입 전체가 nullable
    var funOrNull: ((Int, Int) -> Int)? = null

    val url = "http://kotl.in"
    // API에서 제공하는 이름을 람다에 사용할 수 있다. 원하는 다른 이름을 붙여도 된다.
    performRequest(url) { code, content -> /*...*/ }
}