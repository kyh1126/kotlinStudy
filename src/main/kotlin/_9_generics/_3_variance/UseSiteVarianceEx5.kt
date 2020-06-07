package _9_generics._3_variance

// 선언 지점 변성(Declaration site variance) : 클래스를 선언하면서 변성을 지정하면 그 클래스를 사용하는 모든 장소에 변성 지정자가 영향을 끼치므로 편리하다.
// 사용 지점 변성(Use-site variance) : 자바에서는 타입 파라미터가 있는 타입을 사용할 때마다 해당 타입 파라미터를 하위 타입이나 상위 타입 중 어떤 타입으로 대치할 수 있는지 명시.
// 코틀린의 사용 지점 변성은 자바의 한정 와일드카드(bounded wildcard)와 똑같다.
//  코틀린                     자바
// MutableList<out T> == MutableList<? extends T>
// MutableList<in T>  == MutableList<? super T>

// source, destination 모두 무공변 타입이지만 source 컬렉션에서는 읽기만 하고 destination 컬렉션에서는 쓰기만 한다.
// 여기선 두 컬렉션의 원소 타입이 정확하게 일치할 필요가 없다. (무공변 파라미터 타입 사용중)
fun <T> copyData(source: MutableList<T>, destination: MutableList<T>) {
    for (item in source) {
        destination.add(item)
    }
}

// source 의 원소 타입은 destination 원소 타입의 하위 타입이어야 한다.
fun <T : R, R> copyData2(source: MutableList<T>, destination: MutableList<R>) {
    for (item in source) {
        destination.add(item)
    }
}

// out 키워드를 타입을 사용하는 위치 앞에 붙이면 T 타입을 in 위치에 사용하는 메소드를 호출하지 않는다는 뜻이다.
fun <T> copyData3(source: MutableList<out T>, destination: MutableList<T>) {
    for (item in source) {
        destination.add(item)
    }
}

// in 키워드를 붙여 그 파라미터를 더 상위 타입으로 대치할 수 있다. source 리스트 원소의 상위 타입을 destination 리스트 원소 타입으로 허용한다.
fun <T> copyData4(source: MutableList<T>, destination: MutableList<in T>) {
    for (item in source) {
        destination.add(item)
    }
}

fun main(args: Array<String>) {
    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()
    // Int 가 Any 의 하위 타입이므로 이 함수를 호출할 수 있다.
    copyData2(ints, anyItems)
    println(anyItems)

// 타입 프로젝션(type projection) : in, out 변경자를 붙이는 경우 발생. 일반적인 MutableList 가 아니라 MutableList 를 프로젝션 한(제약을 가한) 타입으로 만든다.
// 타입 파라미터 T를 아웃 위치에서 사용하는 메소드만 호출할 수 있다.
    val list: MutableList<in Number> = mutableListOf("1, 2, 3","a")
    // get 만 되고 add 는 안된다.
    list.add(42)
    println(list[1])

    // out 변성이 지정되어 있다. out 지정시 불필요한 변성이라는 경고가 뜬다.
    var list2: List<out String>
}