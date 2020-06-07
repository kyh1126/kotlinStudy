package _9_generics._2_typeErasureAndReifiedTypeParameter

// 코틀린 제네릭 타입 인자 정보는 런타임에 지워진다.
// 컴파일러는 List<String> List<Int>를 서로 다른 타입으로 인식하지만
// 실행 시점에 이들은 같은 타입의 List 객체다.
// 제네릭 타입 소거 장점 : 저장해야 하는 타입 정보의 크기가 줄어들어서 메모리 사용량이 줄어든다.

// 스타 프로젝션 :
// 인자를 알 수 없는 제네릭 타입을 표현할 때 (자바의 List<?>와 비슷)
// 타입 파라미터가 2개 이상이면 모든 타입 파라미터에 *를 포함시켜야 한다.

// c가 Collection 임을 알 수 있지만 그 원소 타입은 알 수 없다.
fun printSum(c: Collection<*>) {
    // unchecked cast 경고를 해준다.
    val intList = c as? List<Int> ?: throw IllegalArgumentException("list is expected")
    println(intList.sum())
}

fun printSumKnown(c: Collection<Int>) {
    // 컴파일 시점에 타입 정보가 주어진 경우에는 is 검사를 수행할 수 있게 해준다.
    // 주어지지 않은 경우에는 안전하지 못한 is 검사는 금지하고 위험한 as 캐스팅은 경고를 출력한다.
    if (c is List<Int>) {
        println(c.sum())
    }
}

fun main(args: Array<String>) {
    var value = listOf(1)
    if (value is List<*>) {
    }

    // List 이므로 as? 캐스트가 성공하고 sum 에서 예외가 발생한다.
    printSum(listOf("a", "b"))
}