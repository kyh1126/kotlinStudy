package _8_highOrderFunction._3_flowControlHighOrderFunction

fun lookForLabel(names: List<String>) {
    // 람다 식에서도 local return 을 사용할 수 있다. for 루프의 break 같은 역할.
    // 레이블(label) : return 으로 실행을 끝내고 싶은 람다식 앞에 레이블을 붙이고, return 뒤에 그 레이블을 추가
    names.forEach label@{
        if (it == "Jenny") {
            println("Found!")
            return@label
        }
    }
    // 람다를 인자로 받는 인라인 함수 이름을 return 뒤에 레이블로 사용 가능.
    names.forEach {
        if (it == "Jenny") {
            return@forEach
        }
    }
    println("Jenny is not found")
}

fun main(args: Array<String>) {

    println(StringBuilder().apply sb@{
        listOf(1, 2, 3).apply {
            this@sb.append(this.toString() + "!")
            append(this + 1)
        }
    })
}