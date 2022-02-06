package _4_classObjectInterface._1_interface

fun main() {
    Button().click()

    // 인터페이스 구현하기
    val btn = Button2()
    btn.setFocus(false)
    btn.showOff()
}
