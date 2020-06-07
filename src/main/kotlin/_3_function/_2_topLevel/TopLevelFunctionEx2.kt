// 여기와 Ex1 import 차이
// @JvmName : 코틀린 최상위 함수가 포함되는 클래스의 이름을 바꾸고 싶을 때 사용. 파일의 맨 앞, 패키지 이름 선언 이전에 위치해야 한다.
// @file:JvmName("StringFunctions")
package _3_function._3_extension

import _3_function.strings.joinToString

fun main(args: Array<String>) {
    val set = ('a'..'e').toSet()
    println(joinToString(set, "; ", "(", ")"))
}