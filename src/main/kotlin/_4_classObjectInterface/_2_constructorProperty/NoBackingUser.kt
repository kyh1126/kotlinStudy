package _4_classObjectInterface._2_constructorProperty

interface NoBackingUser {
    // should override in subclass
    val email: String

//    var b:String
    // it can be inheritance without override
    // 프로퍼티에 뒷받침하는 필드가 없다. 대신 매번 결과를 계산해 돌려준다.
    val nickname: String
        get() = email.substringBefore('@')
}