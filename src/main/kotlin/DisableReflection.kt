import kotlin.reflect.full.createInstance

/**
 * Reflection
 * Simply security manager that check the packages and if equal
 * to "java.lang.reflect" or "kotlin.reflect" throws [SecurityException]
 */
class AppSecurityManager : SecurityManager() {

    override fun checkPackageAccess(pkg: String?) {
        if (pkg == "java.lang.reflect" || pkg == "kotlin.reflect") {
            throw SecurityException("Reflection is not allowed in this program")
        }

        super.checkPackageAccess(pkg)
    }
}

fun main() {
    System.setSecurityManager(AppSecurityManager())

    // Using reflection cause [SecurityException]
    Person::class.createInstance().name.also(::println)
}