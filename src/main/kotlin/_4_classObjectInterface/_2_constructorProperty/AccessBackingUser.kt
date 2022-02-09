package _4_classObjectInterface._2_constructorProperty

class AccessBackingUser(val name: String) {
    var address: String = "unspecified"
        // access backing field using setter
        // 뒷받침하는 필드 값 읽기
        set(value: String) {
            println(
                """
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent()
            )
            // field 라는 특별한 식별자를 통해 뒷받침하는 필드에 접근할 수 있다.
            field = value
        }
}
