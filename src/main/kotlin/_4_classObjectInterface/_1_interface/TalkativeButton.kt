package _4_classObjectInterface._1_interface

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!!")
    protected fun whisper() = println("Let's talk!")
    internal fun internalFun() = println("internal fun internalFun")
}

/*
// 자바에서는 같은 패키지 안에서 protected 멤버에 접근할 수 있지만, 코틀린에서는 오직 어떤 클래스나 그 클래스를 상속한 클래스 안에서만 보인다.
fun TalkativeButton.giveSpeesh() {
    yell()
    whisper() // 오류: "whisper"에 접근할 수 없음: "whisper"는 "TalkativeButton"의 "protected" 멤버임
}
*/
