package _4_classObjectInterface._1_interface

fun main(args: Array<String>) {
    // 추상클래스 구현하기
    val obj = AnimatedImplementation()
    obj.animate()
    obj.animateTwice()
    obj.stopAnimating()
}