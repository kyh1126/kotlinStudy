package _9_generics._3_variance

import kotlin.random.Random
import kotlin.reflect.KClass

// 스타 프로젝션(star projection) : 제네릭 타입 인자 정보가 없음을 표현.
// https://kotlinlang.org/docs/reference/generics.html#star-projections
// MutableList<*>는 MutableList<Any?>와 같지 않다.
// Every concrete instantiation of that generic type would be a subtype of that projection.

// T에 대해 반공변인 인터페이스 선언
interface FieldValidator<in T> {
    fun validate(input: T): Boolean
}

object DefaultStringValidator : FieldValidator<String> {
    override fun validate(input: String): Boolean = input.isNotEmpty()
}

object DefaultIntValidator : FieldValidator<Int> {
    override fun validate(input: Int): Boolean = input >= 0
}

// 검증기 컬렉션에 대한 접근 캡슐화하기
object Validators {
    // 안전하지 못한 부분을 감춤으로써 외부에서 잘못 사용하지 않음을 보장할 수 있다.
    private val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()

    fun <T : Any> registerValidator(kClass: KClass<T>, fieldValidator: FieldValidator<T>) {
        validators[kClass] = fieldValidator
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <T : Any> get(kClass: KClass<T>): FieldValidator<T> = validators[kClass] as? FieldValidator<T>
        ?: throw IllegalArgumentException("No validator for ${kClass.simpleName}")
}

fun main(args: Array<String>) {
    val list: MutableList<Any?> = mutableListOf('a', 1, "qwe")
    val chars = mutableListOf('a', 'b', 'c')

    val unknownElements: MutableList<*> = if (Random.Default.nextBoolean()) list else chars
    // MutableList<*>를 아웃 프로젝션 타입으로 인식한다. MutableList<out Any?> 로 인식.
    // 원소 타입을 모르더라도 그 리스트에서 안전하게 Any? 타입의 원소를 꺼내올 수는 있지만, 원소를 마음대로 넣을수는 없다.
//    unknownElements.add(42)

    // Consumer<in T> 와 같은 반공변 타입 파라미터에 대한 스타 프로젝션 = <in Nothing>
    // For Foo<in T>, where T is a contravariant type parameter, Foo<*> is equivalent to Foo<in Nothing>
    // It means there is nothing you can write to Foo<*> in a safe way when T is unknown.

    val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()
    // 이렇게 저장해도 맵에 저장된 값의 타입은 FieldValidator<*> 이다.
    validators[String::class] = DefaultStringValidator
    validators[Int::class] = DefaultIntValidator

    // 이렇게 정의를 하고 나도 쓸 때 검증기로 검증할 수 없다. 어떤 타입을 검증하는 검증기인지 모르기 때문이다.
    // 또 Out-projected type 'FieldValidator<*>' 뜬다.
//    validators[String::class]!!.validate("")

    // 이렇게 하면 실행은 되는데 unchecked cast 안전하지 않은 캐스팅 이 뜬다.
    // 이 원소가 FieldValidator 임을 알 수 있지만 그 원소 타입은 알 수 없다는 뜻.
    val stringValidator = validators[String::class] as FieldValidator<String>
    println(stringValidator.validate(""))
    // 바로 이렇게....
    val intValidator = validators[Int::class] as FieldValidator<String>

    // 타입 안전성을 보장한다.
    Validators.registerValidator(String::class, DefaultStringValidator)
    Validators.registerValidator(Int::class, DefaultIntValidator)
    println(Validators[String::class].validate("Kotlin"))
    println(Validators[Int::class].validate(52))
}