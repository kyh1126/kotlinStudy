package _10_annotationAndReflection._1_annotation

import _10_annotationAndReflection.jkid.CustomSerializer
import _10_annotationAndReflection.jkid.DateSerializer
import java.util.*

// 기본적으로 제이키드는 원시 타입이 아닌 프로퍼티를 중첩된 객체로 직렬화한다.
// 직렬화하는 로직 직접 제공. Annotations 의 interface ValueSerializer 가보자.
data class Person3(
    val name: String,
    @CustomSerializer(DateSerializer::class) val birthDate: Date
)