package net.gloryx.oknamer.point

import org.jetbrains.annotations.Contract


interface Pointered {
    /**
     * Gets the value of the [pointer].
     *
     * @param pointer the pointer
     * @param <T> the type
     * @return the value
     * @since 4.8.0
    </T> */
    operator fun <T> get(pointer: Pointer<T>): T? = pointers().get(pointer)

    /**
     * Gets the value of [pointer].
     *
     *
     * If this [Audience] is unable to provide a value for [pointer], [defaultValue] will be returned.
     *
     * @param pointer the pointer
     * @param defaultValue the default value
     * @param <T> the type
     * @return the value
     * @since 4.8.0
    </T> */
    @Contract("_, null -> _; _, !null -> !null")
    fun <T> getOrDefault(pointer: Pointer<T>, defaultValue: T): T? =
        pointers().getOrDefault(pointer, defaultValue)

    /**
     * Gets the pointers for this object.
     *
     * @return the pointers
     * @since 4.8.0
     */
    fun pointers(): Pointers {
        return Pointers.empty()
    }
}