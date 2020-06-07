package _6_typeSystem._1_nullability

// as : 지정한 타입으로 바꿀 수 없으면 ClassCastException 발생 Thus, we call it unsafe.
// as? : 대상 타입으로 변환할 수 없으면 null 반환 Safe cast operator that returns null on failure. 아니면 값 반환
// is :  true/false
fun main(args: Array<String>) {
    val p1 = PersonName("Dmitry", "Jemerov")
    val p2 = PersonName("Dmitry", "Jemerov")

    // == 연산자는 equals 메소드를 호출한다.
    println(p1 == p2)
    println(p1.equals(42))
}