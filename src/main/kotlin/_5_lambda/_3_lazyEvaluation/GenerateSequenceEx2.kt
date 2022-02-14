package _5_lambda._3_lazyEvaluation

import java.io.File

// 객체의 조상으로 이뤄진 시퀀스 만들기
fun File.isInsideHiddenDirectory() =
    generateSequence(this) { it.parentFile }.any { it.isHidden }

fun main() {
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())

    val file = File("/Users/.HiddenDir/a.txt")
    println(file.isInsideHiddenDirectory())
}
