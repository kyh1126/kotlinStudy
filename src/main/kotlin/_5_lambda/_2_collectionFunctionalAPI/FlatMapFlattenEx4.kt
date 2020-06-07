package _5_lambda._2_collectionFunctionalAPI

fun main(args: Array<String>) {
    var books = listOf(
        Book("Harry", listOf("조앤 K")),
        Book("Harry2", listOf("조앤", "K")),
        Book("Harry3", listOf("조", "앤", "K"))
    )
    // flatMap : 인자로 주어진 람다를 컬렉션의 모든 객체에 적용하고 람다를 적용한 결과 얻어지는 여러 리스트를 한 리스트로 모은다.
    println(books.flatMap { it.authors }.toSet())

    val strings = listOf("abc","cde")
    println(strings.flatMap { it.toList() })

    // flatten : 특별히 변환해야 할 내용이 없다면 리스트의 리스트를 평평하게 펼치기만 하면 된다.
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets)
    println(numberSets.flatten())
}