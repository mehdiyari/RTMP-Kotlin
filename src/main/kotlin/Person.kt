internal data class Person constructor(
    val name: String,
    val age: Int
) {
    @Deprecated("Deprecated Constructor")
    constructor(name: String) : this(name, 1)

    constructor(): this("RMS", 68)
}