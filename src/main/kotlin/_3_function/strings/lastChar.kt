package _3_function.strings

//fun String.lastChar(): Char = this.get(this.length - 1)
fun String.lastChar(): Char = get(length - 1)

// 확장 프로퍼티
// 수신 객체(receiver type) 클래스가 추가되었다.
// 뒷받침하는 필드(backing field)가 없어서 최소 게터는 꼭 정의해야 함
val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) = this.setCharAt(length - 1, value)
