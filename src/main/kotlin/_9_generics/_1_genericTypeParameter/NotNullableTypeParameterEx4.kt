package _9_generics._1_genericTypeParameter

// 널이 될 수 없는 타입만 타입 인자로 받게 만들려면 Any? 대신 Any 를 상한으로 사용.
class Processor<T : Any> {
    fun process(value: T) {
        value.hashCode()
    }
}

fun main(args: Array<String>) {
    // String?이 Any 의 자손 타입이 아니므로 에러
//    val nullableStringProcessor = Processor<String?>()
}