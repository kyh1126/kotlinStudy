package _7_operatorOverloading._5_delegatedProperty

class PersonMap {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    // 위임 프로퍼티로 맵을 사용한다.
    // 표준 라이브러리가 Map, MutableMap 인터페이스에 대해 getValue, setValue 확장 함수를 제공.
    val name: String by _attributes
}

fun main(args: Array<String>) {
    val p = PersonMap()
    val data = mapOf("name" to "Jenny", "company" to "Kakao commerce")
    for ((attrName, value) in data) {
        p.setAttribute(attrName, value)
    }

    println(p.name)
}