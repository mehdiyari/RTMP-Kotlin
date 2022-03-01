import kotlin.reflect.KVisibility
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.jvm.isAccessible

/**
 * Simple singleton class with double-check pattern
 */
class Singleton private constructor() {

    private val data: String = "data"

    @Volatile
    private var singleton: Singleton? = null

    fun getInstance(): Singleton {
        if (singleton == null) {
            synchronized(this) {
                if (singleton == null) {
                    singleton = Singleton()
                }
            }
        }

        return singleton!!
    }
}

fun main() {
    val singletonKClass = Singleton::class
    singletonKClass.constructors.firstOrNull { it.visibility == KVisibility.PRIVATE }?.also { privateConstructor ->
        /**
         * We give access to private constructor and we can create instance
         * from [Singleton] class [privateConstructor.call] method
         */
        privateConstructor.isAccessible = true
        val singletonNewObject = privateConstructor.call()

        singletonKClass.declaredMemberProperties.firstOrNull { it.visibility == KVisibility.PRIVATE }
            ?.also { dataProperty ->
                /**
                 * We give access to private property and we can get value with [dataProperty.get] method.
                 */
                dataProperty.isAccessible = true
                dataProperty.get(singletonNewObject).toString().also(::println)
            }
    }
}