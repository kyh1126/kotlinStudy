package _5_lambda._3_lazyEvaluation

import _5_lambda._1_lambdaExpressionMemberReference.Person

fun main(args: Array<String>) {
    val people = listOf(Person("Kevin", 22), Person("Alice", 32), Person("Jenny", 31))

    // intermediate operations
    // returns another sequence, which is produced lazily
    people.asSequence()
        .map { println("map($it)"); it.age * 2 }
        .filter { println("filter($it)"); it % 8 == 0 }

    println("===== ===== ===== =====")

    // terminal operation
    // the operation
    people.asSequence()
        .map { println("map($it)"); it.age * 2 }
        .filter { println("filter($it)"); it % 8 == 0 }
        .toList()

    // 각 원소 하나마다 실행해 find 가 2를 채택하고 3, 4는 계산하지 않는다.
    println("## " + listOf(1, 2, 3, 4).asSequence().map { it * it }.find { it > 3 })
}