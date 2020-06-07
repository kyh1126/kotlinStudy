package _4_classObjectInterface._4_object

class NamedCompanionPerson(val name: String) {
//    companion object Loader {
//        fun fromJSON(jsonText: String): NamedCompanionPerson =
//            NamedCompanionPerson(jsonText.substringAfter("name:").replace("}|'".toRegex(), "").trim())
//    }

    // It can implements interface
    companion object : JSONFactory<NamedCompanionPerson> {
    // @JvmStatic 을 최상위 프로퍼티나 객체에서 선언된 프로퍼티 앞에 붙이면 코틀린 클래스의 멤버를 정적인 멤버로 만들어준다.
//        @JvmStatic
//        @NotNull
//        public static NamedCompanionPerson fromJSON(@NotNull String jsonText) {
//            return Companion.fromJSON(jsonText);
//        }

//         @JvmStatic
        override fun fromJSON(jsonText: String): NamedCompanionPerson =
            NamedCompanionPerson(jsonText.substringAfter("name:").replace("}|'".toRegex(), "").trim())
    }
}