import kotlin.reflect.KFunction

fun main() {
    // Get sum function reference
    val functionReference: KFunction<Int> = ::sum

    // Print some of the properties that [KFunction] provides.
    println("Name: ${functionReference.name}")
    println("Visibility: ${functionReference.visibility}")
    println("ReturnType: ${functionReference.returnType}")
    println("Annotations: ${functionReference.annotations}")
    println("Parameters: ${functionReference.parameters}")
    println("TypeParameters: ${functionReference.typeParameters}")
    println("Call: Result of sum(10, 20) = ${functionReference.call(10, 20)}")
}

/**
 * Return @param firstNumber + @param secondNumber
 */
internal fun sum(firstNumber: Int, secondNumber: Int): Int = firstNumber + secondNumber
