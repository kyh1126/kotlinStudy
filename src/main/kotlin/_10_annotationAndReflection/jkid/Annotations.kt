package _10_annotationAndReflection.jkid

import java.text.SimpleDateFormat
import java.util.*
import kotlin.reflect.KClass

@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude

@Target(AnnotationTarget.PROPERTY)
annotation class JsonName(val name: String)

// 제네릭 클래스라서 참조하려면 항상 타입 인자를 제공해야 한다.
interface ValueSerializer<T> {
    fun toJsonValue(value: T): Any?
    fun fromJsonValue(jsonValue: Any?): T
}

object DateSerializer : ValueSerializer<Date> {
    private val dateFormat = SimpleDateFormat("dd-mm-yyyy")

    override fun toJsonValue(value: Date): Any? =
        dateFormat.format(value)
    override fun fromJsonValue(jsonValue: Any?): Date =
        dateFormat.parse(jsonValue as String)
}

// 클래스를 인자로 받아야 하면 애노테이션 파라미터 타입에 KClass<out 허용할 클래스이름>을 쓴다.
// 제네릭 클래스를 인자로 받아야 하면 KClass<out 허용할 클래스이름<*>> 처럼 스타 프로젝션을 덧붙인다.
@Target(AnnotationTarget.PROPERTY)
// KClass : 이 KClass 의 인스턴스가 가리키는 코틀린 타입을 지정.
annotation class DeserializeInterface(val targetClass: KClass<out Any>)

@Target(AnnotationTarget.PROPERTY)
// CustomSerializer 애노테이션이 어떤 타입에 대해 쓰일지 알 수 없으므로 ValueSerializer 에 스타 프로젝션을 썼다.
annotation class CustomSerializer(val serializerClass: KClass<out ValueSerializer<*>>)