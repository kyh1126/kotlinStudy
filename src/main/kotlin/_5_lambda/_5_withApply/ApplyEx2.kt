package _5_lambda._5_withApply

// apply 함수는 with 와 거의 같다.
// apply 는 항상 자신에게 전달된 객체를 반환한다.
fun alphabetApply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}.toString()

fun main(args: Array<String>) {
    println(alphabetApply())
}
