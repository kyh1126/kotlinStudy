package _5_lambda._1_lambdaExpressionMemberReference

import java.awt.Button

fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    // 함수의 파라미터 뿐 아니라 람다 밖의 final 아닌 변수까지 람다에서 사용 가능
    messages.forEach { println("$prefix $it") }
}

fun tryToCountButtonClicks(button: Button): Int {
    var clicks = 0
    button.onClick { clicks++ }
    return clicks
}

private fun Button.onClick(function: () -> Int) {
    println("클릭됨")
//    clicks++
}


private fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0

    // 람다 밖 변수 변경도 가능
    responses.forEach {
        if (it.startsWith("4")) {
            // clientErrors, serverErrors are the variables captured in the closure
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

fun main(args: Array<String>) {
    val errors = listOf("403 Forbidden", "404 Not Found", "500 Internal Server error")
    printMessageWithPrefix(errors, "Error:")

    printProblemCounts(errors)


    // 변경 가능한 변수 포획하기
    // 변경 가능한 변수를 필드로 하는 클래스를 선언하여 값을 변경시킨다.
    val counter = Ref(0)
    val inc = { ++counter.value }

    var counter2 = 0
    val inc2 = { ++counter2 }
    println("1st:${run(inc)} , 2nd:${run(inc2)}")

    // 람다를 이벤트 핸들러나 다른 비동기적으로 실행되는 코드로 활용하는 경우 함수 호출이 끝난 다음에 로컬 변수가 변경될 수도 있다.
    // onClick 핸들러는 clicks 를 반환한 다음에 호출된다.
    // 카운터 변수를 클래스의 프로퍼티나 전역 프로퍼티 위치로 빼서 나중에 변수의 변화를 볼 수 있게 해야한다.
    val btn = Button()
    println("총 ${tryToCountButtonClicks(btn)}번 클릭됨")
    tryToCountButtonClicks(btn)
    tryToCountButtonClicks(btn)
}