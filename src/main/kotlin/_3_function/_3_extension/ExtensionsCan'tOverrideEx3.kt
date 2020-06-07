package _3_function._3_extension

import _3_function.extensions.showOff

// 확장 함수는 클래스의 일부가 아닌 클래스 밖에 선언되어 오버라이드 불가하다.
fun View.showOff() = println("I'm a view!")

fun Button.showOff() = println("I'm a button!")

fun main(args: Array<String>) {
    val view: View = Button()
    view.click()

    view.showOff()

    showOff(view)
}