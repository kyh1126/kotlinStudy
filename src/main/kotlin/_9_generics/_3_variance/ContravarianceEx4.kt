package _9_generics._3_variance

// 반공변성(Contravariance) : 반공변 클래스의 하위 타입 관계는 공변 클래스의 경우와 반대다.
// 타입 B가 타입 A의 하위 타입인 경우 Consumer<A>가 Consumer<B>의 하위 타입인 관계가 성립하면 제네릭 클래스 Consumer<T>는 타입 인자 T에 대해 반공변이다.
// Producer 클래스는 타입 인자의 하위 타입 관계를 그대로 따르지만 Consumer 클래스에서는 타입 인자의 하위 타입 관계와는 반대다.

// in : 그 키워드가 붙은 타입이 이 클래스의 메소드 안으로 전달돼 메소드에 의해 소비된다. 그 타입 인자를 오직 인 위치에서만 사용할 수 있다.

// 공변성(Covariance)                반공변성(contravariance)         무공변성(invariance)
// Producer<out T>                 Consumer<in T>                 MutableList<T>
// 타입 인자의 하위 타입 관계가           타입 인자의 하위 타입 관계가          하위 타입 관계가 성립하지 않는다.
// 제네릭 타입에서도 유지된다.            제네릭 타입에서 뒤집힌다.
// Producer<Cat>은                  Consumer<Animal>은
// Producer<Animal>의 하위 타입이다.   Consumer<Cat>의 하위 타입이다.
// T를 아웃 위치에서만 사용할 수 있다.     T를 인 위치에서만 사용할 수 있다.      T를 아무 위치에서나 사용할 수 있다.

open class Mammal(val name: String) {
    fun eat() {}
    fun sleep() {}
}

data class Sloths(val slothName: String, val isTwoFingered: Boolean): Mammal(slothName)
data class Pandas(val pandaName: String) : Mammal(pandaName)

// String 은 Any 의 하위 타입이고 Consumer<Any>가 Consumer<String>의 하위 타입이다.
interface Comparator<in T> {
    // 이 인터페이스의 메소드는 T 타입의 값을 소비하기만 한다. T가 in 위치에서만 쓰인다.
    fun compare(e1: T, e2: T): Int {
        return 1
    }
}

fun main(args: Array<String>) {
    val strings: List<String> = listOf("a")
    val anyComparator = Comparator<Any> { e1, e2 ->
        e1.hashCode() - e2.hashCode()
    }

    // 문자열과 같은 구체적인 타입의 객체를 비교하기 위해 모든 객체를 비교하는 Comparator 를 사용할 수 있다.
    strings.sortedWith(anyComparator)

    val crewCrewCrew = listOf(
        Sloths("Jerry", false),
        Sloths("Bae", true),
        Sloths("Alex", false),
        Pandas("Tegan"),
        Pandas("Peggy")
    )

    val compareByNames = Comparator { a: Mammal, b: Mammal ->
        a.name.first().toInt() - b.name.first().toInt()
    }

    println(crewCrewCrew.sortedWith(compareByNames))
}