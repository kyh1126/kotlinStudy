package _4_classObjectInterface._2_constructorProperty

// primary constructor 1
// val 은 이 파라미터에 상응하는 프로퍼티가 생성된다는 뜻이다.
class User(
    val nickname: String = "default name",
    val isSubscribed: Boolean = true // 생성자 파라미터에도 디폴트 값을 정의할 수 있다.
)

// primary constructor 2
class User2 constructor(_nickname: String) {
    val nickname: String

    // 초기화 블록
    init {
        nickname = _nickname
    }
}

// primary constructor 3
class User3(_nickname: String) {
    // 프로퍼티를 주 생성자의 파라미터로 초기화한다.
    val nickname = _nickname
}

fun main() {
    val jenny = User("김제니", isSubscribed = false) // 생성자 인자 중 일부에 대해 이름을 지정할 수도 있다.
    println(jenny.isSubscribed) // false
}
