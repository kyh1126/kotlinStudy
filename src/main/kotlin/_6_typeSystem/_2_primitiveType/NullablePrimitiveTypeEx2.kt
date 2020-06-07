package _6_typeSystem._2_primitiveType

// The mapping only matters at compile time, the runtime representation remains unchanged.

// Java's primitive types are mapped to corresponding Kotlin types (keeping platform types in mind):
//  Java type	Kotlin type
//  byte	    kotlin.Byte
//  short	    kotlin.Short
//  int	        kotlin.Int
//  long	    kotlin.Long
//  char	    kotlin.Char
//  float	    kotlin.Float
//  double	    kotlin.Double
//  boolean	    kotlin.Boolean

// Some non-primitive built-in classes are also mapped:
//  Java type	            Kotlin type
//  java.lang.Object	    kotlin.Any!
//  java.lang.Cloneable	    kotlin.Cloneable!
//  java.lang.Comparable	kotlin.Comparable!
//  java.lang.Enum	        kotlin.Enum!
//  java.lang.Annotation	kotlin.Annotation!
//  java.lang.CharSequence	kotlin.CharSequence!
//  java.lang.String	    kotlin.String!
//  java.lang.Number	    kotlin.Number!
//  java.lang.Throwable	    kotlin.Throwable!

// Java's boxed primitive types are mapped to nullable Kotlin types:
//  Java type	        Kotlin type
//  java.lang.Byte	    kotlin.Byte?
//  java.lang.Short	    kotlin.Short?
//  java.lang.Integer	kotlin.Int?
//  java.lang.Long	    kotlin.Long?
//  java.lang.Character	kotlin.Char?
//  java.lang.Float	    kotlin.Float?
//  java.lang.Double	kotlin.Double?
//  java.lang.Boolean	kotlin.Boolean?

// Note that a boxed primitive type used as a type parameter is mapped to a platform type:
// for example, List<java.lang.Integer> becomes a List<Int!> in Kotlin.

// Collection types may be read-only or mutable in Kotlin, so Java's collections are mapped as follows
// (all Kotlin types in this table reside in the package kotlin.collections):
//  Java type	    Kotlin read-only type	Kotlin mutable type	            Loaded platform type
//  Iterator<T>	    Iterator<T>	            MutableIterator<T>	            (Mutable)Iterator<T>!
//  Iterable<T>	    Iterable<T>	            MutableIterable<T>	            (Mutable)Iterable<T>!
//  Collection<T>	Collection<T>	        MutableCollection<T>	        (Mutable)Collection<T>!
//  Set<T>	        Set<T>	                MutableSet<T>	                (Mutable)Set<T>!
//  List<T>	        List<T>	                MutableList<T>	                (Mutable)List<T>!
//  ListIterator<T>	ListIterator<T>	        MutableListIterator<T>	        (Mutable)ListIterator<T>!
//  Map<K, V>	    Map<K, V>	            MutableMap<K, V>	            (Mutable)Map<K, V>!
//  Map.Entry<K, V>	Map.Entry<K, V>	        MutableMap.MutableEntry<K,V>	(Mutable)Map.(Mutable)Entry<K, V>!

// Java's arrays are mapped as mentioned below:
//  Java type	Kotlin type
//  int[]	    kotlin.IntArray!
//  String[]	kotlin.Array<(out) String>!

fun main(args: Array<String>) {
    println(Person("Sam", 35).isOlderThan(Person("Jenny", 31)))
    println(Person("Sam", 35).isOlderThan(Person("Jenny")))
}