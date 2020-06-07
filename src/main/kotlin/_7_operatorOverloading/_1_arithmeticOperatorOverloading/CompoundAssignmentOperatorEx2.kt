package _7_operatorOverloading._1_arithmeticOperatorOverloading

//  Augmented assignments
//  Expression	Translated to
//  a += b	    a.plusAssign(b)
//  a -= b	    a.minusAssign(b)
//  a *= b	    a.timesAssign(b)
//  a /= b	    a.divAssign(b)
//  a %= b	    a.remAssign(b), a.modAssign(b) (deprecated)

// If the corresponding binary function (i.e. plus() for plusAssign()) is available too, report error (ambiguity),
// Make sure its return type is Unit, and report an error otherwise.
// Generate code for a.plusAssign(b);
// Otherwise, try to generate code for a = a + b (this includes a type check: the type of a + b must be a subtype of a).
//operator fun <T> MutableCollection<T>.plusAssign(element: T) {
//    this.add(element)
//}

fun main(args: Array<String>) {
    var list = listOf(1, 2)
    // kotlin.collections plus() 와 충돌하여 컴파일러 오류
    // val list 로 plusAssign 적용이 불가능하게 할 수도 있다.?? -> plus 적용이 불가능하게 할 수 있다.
    // However, for read-only collections, they actually use the plus or minus operators and try to assign the result to the same variable.
    // Thus, they are available only on "var read-only" collections.(+= 가 plus 로 작동한다.) 아니면 Val cannot be reassigned 뜬다.
    // For mutable collections, they modify the collection if it's a val.
    // a += b -> a = a.plus(b) / a.plusAssign(b)
    list += 3
//    list = list.plus(3)
    println(list)

    // +와 -는 항상 새로운 컬렉션을 반환한다.
    // 변경 가능한 컬렉션에서 +=와 -=는 메모리에 있는 객체 상태를 변화시킨다.
    // 읽기 전용 컬렉션에서 +=와 -=는 변경을 적용한 복사본을 반환한다.
    // (var 로 선언한 변수가 가리키는 읽기 전용 컬렉션에만 +=와 -=를 적용할 수 있다.)
    val newList = list + listOf(4, 5)
    println(newList)
}