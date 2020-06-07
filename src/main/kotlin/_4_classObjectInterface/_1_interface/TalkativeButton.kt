package _4_classObjectInterface._1_interface

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!!")
    protected fun whisper() = println("Let's talk!")
    internal fun internalFun() = println("internal fun internalFun")
}