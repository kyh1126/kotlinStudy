package _8_highOrderFunction._3_flowControlHighOrderFunction

fun lookForAnonymous(names: List<String>) {
    // 람다 식 대신 무명 함수 사용
    // return 은 가장 가까운 함수를 가리키는데 이 위치에서 가장 가까운 함수는 무명 함수다.
    // 일반 함수와 비슷해보이는데 차이는 함수 이름이나 파라미터 타입을 생략할 수 있다.
    names.forEach(fun(name) {
        if (name == "Jenny") {
            println("Found!")
            return
        }
        println("Jenny is not found")
    })
}

fun main(args: Array<String>) {
    val result = (0..9).filter(fun(num): Boolean {
        return num > 3
    })
    // return 은 fun 키워드를 사용해 정의된 가장 안쪽 함수를 반환시킨다.
    // 람다식은 fun 을 사용해 정의되지 않으므로 람다 밖의 함수를 반환시킨다.
    val result2 = (0..9).filter(fun(num) = num > 3)

    println(result == result2)
}