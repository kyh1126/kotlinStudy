package _8_highOrderFunction._3_flowControlHighOrderFunction

fun lookFor(names: List<String>) {
    // 람다 안에서 return 을 사용하면 람다로부터만 반환되는 게 아니라 그 람다를 호출하는 함수가 실행을 끝내고 반환된다.
    // 자신을 둘러싸고 있는 블록보다 더 바깥에 있는 다른 블록을 반환하게 만드는 return 문을 넌로컬(non-local) return.
    // return 이 바깥쪽 함수를 반환시킬 수 있는 때는 람다를 인자로 받는 함수가 인라인 함수인 경우뿐이다.
    names.forEach {
        if (it == "Jenny") {
            println("Found!")
            return
        }
    }
    println("Jenny is not found")
}

fun main(args: Array<String>) {
    lookFor(listOf("Alice", "Jenny"))
}