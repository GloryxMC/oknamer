package net.gloryx.oknamer.builder

import org.jetbrains.annotations.Contract

interface Buildable<T, B : Buildable.Builder<T>> {
    @Contract("-> new", pure = true)
    fun toBuilder(): B

    interface Builder<T> {
        @Contract("-> new", pure = true)
        fun build(): T
    }
}