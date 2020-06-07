package _10_annotationAndReflection._1_annotation

import _10_annotationAndReflection.jkid.DeserializeInterface

interface Company {
    val name: String
}

data class CompanyImpl(override val name: String) : Company

// 어떤 클래스를 선언 메타데이터로 참조할 수 있는 기능이 필요할 때 클래스 참조를 파라미터로 하는 애노테이션 클래스를 선언
// @DeserializeInterface 가보자. CompanyImpl 은 out Any 의 하위 타입이다.
data class Person2(val name: String, @DeserializeInterface(CompanyImpl::class) val company: Company)
