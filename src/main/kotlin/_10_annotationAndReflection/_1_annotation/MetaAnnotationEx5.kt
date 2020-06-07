package _10_annotationAndReflection._1_annotation

// 메타애노테이션(meta-annotation) : 애노테이션 클래스에 적용할 수 있는 애노테이션
// 표준 라이브러리에 있는 메타애노테이션 중 가장 흔히 쓰이는
// @Target : 적용할 수 있는 요소의 유형을 지정. 안하면 모든 선언에 적용할 수 있는 애노테이션이 된다.
// AnnotationTarget : 클래스, 파일, 프로퍼티, 프로퍼티 접근자, 타입, 식 등의 이넘 정의
@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class BindingAnnotation

@BindingAnnotation
annotation class MyBinding

// 대상을 PROPERTY 로 지정한 애노테이션을 자바 코드에서 사용할 수는 없다.
// 자바에서 그런 애노테이션을 사용하려면 AnnotationTarget.FIELD 를 두 번째 대상으로 추가해야 한다.
// @Retention : 정의 중인 애노테이션 클래스를 소스 수준에서만 유지할지, .class 파일에 저장할지, 실행 시점에 리플렉션을 사용해 접근할 수 있게 할지 지정하는 메타애노테이션.
// 자바 컴파일러는 기본적으로 애노테이션을 .class 파일에는 저장하지만 런타임에는 사용할 수 없게 한다.
// 대부분의 애노테이션은 런타임에도 사용할 수 있어야 하므로 코틀린에서는 기본적으로 애노테이션의 @Retention 을 RUNTIME 으로 지정한다.