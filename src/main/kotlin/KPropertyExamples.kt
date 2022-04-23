import kotlin.reflect.KProperty

// person property
private val person = Person("RMS", 68)

fun main() {
    // Get person property reference
    val personPropertyReference: KProperty<Person> = ::person

    // Print some of the properties that [KProperty] provides.
    println("Name: ${personPropertyReference.name}")
    println("IsConst: ${personPropertyReference.isConst}")
    println("IsLateinit: ${personPropertyReference.isLateinit}")
    println("Visibility: ${personPropertyReference.visibility}")
    println("ReturnType: ${personPropertyReference.returnType}")
    println("Annotations: ${personPropertyReference.annotations}")
    println("Parameters: ${personPropertyReference.parameters}")
    println("TypeParameters: ${personPropertyReference.typeParameters}")
    println("Getter: Result:${personPropertyReference.getter.call()}")
}