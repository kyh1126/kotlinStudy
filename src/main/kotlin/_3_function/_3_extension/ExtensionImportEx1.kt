package _3_function._3_extension

import _3_function.strings.lastChar
import _3_function.strings.lastChar as last

fun main(args: Array<String>) {
    println("Kotlin".lastChar())

    // as 키워드 : 여러 패키지의 같은 이름 함수 충돌 방지 가능
    // 자바에서는 전체 패키지 경로를 사용하여 호출 가능 하지만
    // 코틀린은 반드시 import를 사용, as로 함수 이름을 바꾸는 것이 충돌 방지 유일한 방법
    println("Kotlin".last())
}