import kotlin.reflect.KClass
import kotlin.reflect.KVisibility
import kotlin.reflect.full.createInstance

fun main() {

    // Create an instance from Person class with reflection
    val person = Person::class.createInstance()
    println("Person name is ${person.name}")


    // Checking Person class is data class or not
    if (Person::class.isData) {
        println("Person is an data class")
    }

    // Checking Person class has internal modifier or not
    if (Person::class.visibility == KVisibility.INTERNAL) {
        println("Person class has internal modifier")
    }

    // Checking Person class is open or final
    if (Person::class.isOpen) {
        println("Person class has open modifier")
    } else {
        println("Person class hasn't open modifier")
    }

    println("----------------")

    printClassConstructors(Person::class)
}

/**
 * Print visibility, annotations, parameters of all constructors of given @param kClass
 */
fun printClassConstructors(kClass: KClass<*>) {
    kClass.constructors.forEachIndexed { index, constructor ->
        println("Constructor #$index")
        println("Visibility: ${constructor.visibility}")
        println("Annotations: ${constructor.annotations}")
        println("Parameters: ${constructor.parameters}")
        println("----------------")
    }
}