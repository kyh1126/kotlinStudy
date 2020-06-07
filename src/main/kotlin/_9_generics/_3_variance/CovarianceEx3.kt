package _9_generics._3_variance

// Variance annotation, "out"
// 1. 공변성 : 하위 타입 관계가 유지된다.
// 2. 사용 제한 : T를 아웃 위치에서만 사용할 수 있다.

open class Animal {
    fun feed() = println("냠냠")
}

// 코틀린에서 제네릭 클래스가 타입 파라미터에 대해 공변적임을 표시하려면 out 을 넣어야 한다.
// out 변성을 지정하기 전엔 고양이 무리는 동물 무리 하위 클래스가 아니다(invariant, 무공변성). 지정 후에만, 클래스가 T에 대해 공변적이다.

// 클래스 타입 파라미터 T 앞에 out 을 붙이면 클래스 안에서 T를 사용하는 메소드가 아웃 위치에서만 T를 사용하게 허용하고 인 위치에서는 T를 사용하지 못하게 막는다.
// private 메소드 파라미터, 생성자 파라미터는 인, 아웃 어느쪽도 아니다. 타입 파라미터가 out 이어도 생성자 파라미터 선언에 사용할 수 있다.
// 변성 규칙(variance)은 클래스 외부의 사용자가 클래스를 잘못 사용하는 일을 막기 위한 것이므로 클래스 내부 구현 및 안전한 상황에서는 적용되지 않는다.
// 이러한 위치 규칙은 외부에서 볼 수 있는(public, protected, internal) 클래스 API 에만 적용할 수 있다.
// 하지만 생성자 파라미터에 val 이나 var 키워드를 적으면 게터나 (변경 가능한 프로퍼티의 경우)세터를 정의하는 것과 같다.
// 읽기 전용 프로퍼티는 아웃 위치, 변경 가능 프로퍼티는 아웃과 인 위치 모두에 해당한다.
// var leadAnimal:T 같은 생성자 파라미터는 쓸 수 없다. 인 위치에 있기 때문에.. private 나 val 로 표기하면 쓸 수 있다.
class Herd<out T : Animal>(vararg animals: T) {
    val size: Int get() = 1
    operator fun get(i: Int): T = Animal() as T

    // 아웃 위치는 되지만 인 위치가 안됨. private 메소드로 지정시 사용가능.
    private fun test(t: T): T {
        println("인 위치 테스트")
        return t
    }
}

fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals[i].feed()
    }
}

class Cat : Animal() {
    fun cleanLitter() = println("cleanLitter")
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()
        // Herd 에 out 이 없을 땐 Animal 클래스 아니라서 안된다고 함
        // out 후엔 캐스팅할 필요가 없다.
        feedAll(cats)
    }
}

// 아웃 위치, 인 위치?
// 아웃 위치 : T가 함수의 반환 타입에 쓰이면 그 함수는 T 타입의 값을 생산(produce)한다.
// 인 위치 : T가 함수의 파라미터 타입에 쓰인다면 그 함수는 T 타입의 값을 소비(consume)한다.

fun main(args: Array<String>) {
    // List<T>는 T 타입의 값을 추가, 변경하는 메소드가 없어 T에 대해 공변적이다.
    // MutableList 는 add 메소드 같이 인 위치에 쓰이기 때문에 T에 대해 공변적일 수 없다.
    // 컴파일러는 타입 파라미터가 쓰이는 위치를 제한한다.
    val a = mutableListOf(1, 2, 3)
}