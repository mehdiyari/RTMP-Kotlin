import kotlin.reflect.KCallable

private val person = Person("RMS", 68)
private fun sayHello(name: String): String = "Hello $name"

fun main() {
    val propertyKCallable: KCallable<Person> = ::person
    val functionKCallable: KCallable<String> = ::sayHello
    val constructorKCallable: KCallable<Person> = Person::class.constructors.firstOrNull()!!

    printSomePropertiesOfKCallable(propertyKCallable)
    printSomePropertiesOfKCallable(functionKCallable)
    printSomePropertiesOfKCallable(constructorKCallable)

}

fun printSomePropertiesOfKCallable(kCallable: KCallable<Any>) {
    println("Name: ${kCallable.name}")
    println("Visibility: ${kCallable.visibility}")
    println("ReturnType: ${kCallable.returnType}")
    println("Annotations: ${kCallable.annotations}")
    println("Parameters: ${kCallable.parameters}")
    println("TypeParameters: ${kCallable.typeParameters} \n")
}
