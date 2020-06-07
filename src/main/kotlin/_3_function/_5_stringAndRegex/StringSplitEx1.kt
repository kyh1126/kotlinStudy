package _3_function._5_stringAndRegex

fun main(args: Array<String>) {
    // 자바의 split 구분 문자열은 실제로는 정규식이다. -> 아래의 경우 빈배열 반환
    println("12.345-6.A".split("."))

    // 자바같이 정규식으로 나눠보기
    println("12.345-6.A".split("\\.|-".toRegex()))

    // split 구분 문자열을 여러개 받을 수도 있다.
    println("12.345-6.A".split(".", "-"))
}
