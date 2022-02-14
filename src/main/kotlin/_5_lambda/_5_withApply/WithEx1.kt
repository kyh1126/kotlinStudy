package _5_lambda._5_withApply

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

// with version
fun alphabetWith(): String {
    val stringBuilder = StringBuilder()
    // 실제로는 파라미터가 2개 있는 함수다.
    // return with(StringBuilder()) 로 해도 된다.
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        append("\nNow I know the alphabet!")
        // 바깥쪽 클래스의 toString 을 호출하고 싶으면 this@OuterClass.toString() 하면 된다.
        this.toString() // 그냥 toString() 과 동일하다.
    }
}

// 수신 객체 지정 람다 : lambda with receiver
// 수신 객체를 명시하지 않고 람다의 본문 안에서 다른 객체의 메소드를 호출할 수 있게 하는 것
fun main() {
    // with 는 수신 객체 지정 람다를 활용한다.
//    println(alphabet())

    println(alphabetWith())
}
