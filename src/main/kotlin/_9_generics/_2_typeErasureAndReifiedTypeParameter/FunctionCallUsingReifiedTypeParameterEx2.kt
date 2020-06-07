package _9_generics._2_typeErasureAndReifiedTypeParameter

// Cannot check for instance of erased type: T
//fun <T> isACommon(value: Any) = value is T

// inline 함수의 타입 파라미터는 실체화되므로 실행 시점에 인라인 함수의 타입 인자를 알 수 있다. 인라인의 성능 향상이 아닌 실체화한 타입 파라미터 사용하기 위한 사용 방법.
// 컴파일러는 타입 인자로 쓰인 구체적인 클래스를 참조하는 바이트코드를 생성해 삽입하므로 실행 시점에 타입 소거의 영향을 받지 않는다.
// 자바 코드에서는 reified 타입 파라미터를 사용하는 inline 함수를 호출할 수 없다. (자바에서는 인라인 함수를 다른 보통 함수처럼 호출해서 인라이닝이 되지 않는다.)
inline fun <reified T> isA(value: Any) = value is T

// reified 키워드는 이 타입 파라미터가 실행 시점에 지워지지 않음을 표시.
inline fun <reified T> Iterable<*>.filterIsInstance(): List<T> {
    val destination = mutableListOf<T>()
    for (element in this) {
        // 각 원소가 타입 인자로 지정한 클래스의 인스턴스인지 검사할 수 있다.
        if (element is T) {
            destination.add(element)
        }
    }
    return destination
}

// is :
// checks and explicit casts for immutable values and inserts (safe) casts automatically when needed (smart casting).
// as :
// is not recommended because it does not guarantee run-time safety.
// Safe cast as?. If it cannot be casted, it will return null instead.
// (You may pass a wrong object which cannot be detected at compiled time.)

// is X         =  instanceof X :   type checking + smart cast
// foo as X     =  ((X) foo)    :   type casting
fun main(args: Array<String>) {
    println(isA<String>("abc"))
    println(isA<String>(123))

    val items = listOf("one", 2, "three")
    // 타입 인자로 지정한 클래스의 인스턴스만 모아서 만든 리스트를 반환한다.
    println(items.filterIsInstance<String>())
}