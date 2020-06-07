package _3_function._6_localFunction

fun saveUser(user: User) {
    // 필드 검증 중복 부분
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
    }
    println("Save done!")
}

// 로컬 함수
// 자신이 속한 바깥 함수의 모든 파라미터와 변수를 사용할 수 있다.
fun saveUserV2(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")

    println("Save done!")
}

fun saveUserV3(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")

    println("Save done!")
}

// 확장 함수
// 한 객체만을 다루면서 객체의 비공개 데이터를 다룰 필요는 없는 함수의 경우 유용하다.
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${id}: empty $fieldName")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}

fun main(args: Array<String>) {
//    saveUser(User(1, "", ""))
    saveUser(User(1, "Jenny", "Dongchun"))

//    saveUserV2(User(2, "", ""))
    saveUserV2(User(2, "Jenny", "Dongchun"))

//    saveUserV3(User(3, "", ""))
    saveUserV3(User(3, "Jenny", "Dongchun"))

    User(4, "Jenny", "").validateBeforeSave()
}