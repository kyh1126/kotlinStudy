package _5_lambda._4_functionalInterface

import java.awt.Button

// SAM 생성자의 이름은 사용할려는 함수형 인터페이스 이름과 같다.
// 여러 버튼에 같은 리스너를 적용하고 싶다면 SAM 생성자를 통해 람다를 함수형 인터페이스 인스턴스롤 만들어서 변수로 저장해 활용할 수 있다.
fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All done!") }
}

//val listener = OnClickListener { view ->
//    val text = when (view.id) {
//        R.id.button1 -> "First button"
//        R.id.button2 -> "Second button"
//        else -> "Unknown button"
//    }
//    toast(text)
//}

fun main(args: Array<String>) {
    createAllDoneRunnable().run()

    val button1 = Button()
    val button2 = Button()

//    button1.setOnClickListener(listener)
//    button2.setOnClickListener(listener)

    // 람다에는 무명 객체와 달리 인스턴스 자신을 가리키는 this 가 없다.
    // 람다 안에서 this 는 그 람다를 둘러싼 클래스의 인스턴스를 가리킨다.
    // 이벤트 리스너가 이벤트를 철리하다가 자기 자신의 리스너 등록을 해제해야 한다면 람다를 사용할 수 없다.
    // 그런 경우 람다 대신 무명 객체를 사용해 리스너를 구현하라.
    // 무명 객체 안에서는 this 가 그 무명 객체 인스턴스 자신을 가리킨다. 따라서 리스너를 해제하는 API 함수에게 this 를 넘길 수 있다.
}