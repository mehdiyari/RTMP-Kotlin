import kotlin.reflect.KClass

fun main() {
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