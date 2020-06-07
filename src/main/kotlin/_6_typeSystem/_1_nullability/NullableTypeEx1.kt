package _6_typeSystem._1_nullability

// null 이 될 수 있는 타입인 변수에 대해 변수.메소드() 직접 호출할 수 없다.
//fun strLenSafe(s: String?) = s.length()

// null 검사를 추가하면 코드가 컴파일된다.
fun strLenSafe(s: String?): Int =
    if (s != null) s.length else 0

fun main(args: Array<String>) {
    // 타입 이름 뒤에 물음표를 붙이면 그 타입의 변수나 프로퍼티에 null 참조를 저장할 수 있다.
    val x: String? = null
    // null 이 될 수 있는 값을 널이 될 수 없는 타입의 변수에 대입할 수 없다.
//    var y: String = x

    // nullable 타입의 값으로는 null 과 비교하는 일을 할 수 있다.
    // 일단 null 과 비교하면 컴파일러는 그 사실을 기억하고
    // null 이 아님이 확실한 영역에서는 해당 값을 널이 될 수 없는 타입의 값처럼 사용할 수 있다.
}