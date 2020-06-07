package _4_classObjectInterface._4_object

import java.awt.Button
import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

fun countClicks(window: Window) {
    // anonymous object can change non-final variable.
    var clickCount = 0

    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            super.mouseClicked(e)
            clickCount++
        }
    })
}

fun main(args: Array<String>) {
    val btn = Button()
    // object expression 은 그 클래스나 인스턴스에 이름을 붙이지 않는다. 아래와 같이 이름을 붙여도 된다.
    val listener = object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            super.mouseClicked(e)
        }
        override fun mouseEntered(e: MouseEvent?) {
            super.mouseEntered(e)
        }
    }

    btn.addMouseListener(
        listener
    )
    // Anonymous object is not a singleton. It creates new instances.
}