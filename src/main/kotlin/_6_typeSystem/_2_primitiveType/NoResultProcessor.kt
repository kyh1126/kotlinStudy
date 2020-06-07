package _6_typeSystem._2_primitiveType

class NoResultProcessor : Processor<Unit> {
    // Unit 을 반환하지만 타입을 지정할 필요는 없다.
    override fun process() {
        // return 을 명시할 필요가 없다. 컴파일러가 묵시적으로 return Unit 넣어줌.
        println("processing...")
    }
}