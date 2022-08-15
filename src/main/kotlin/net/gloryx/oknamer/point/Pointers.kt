package net.gloryx.oknamer.point

import net.gloryx.oknamer.builder.Buildable
import net.gloryx.oknamer.impl.point.PointersImpl

interface Pointers : Buildable<Pointers, Pointers.Builder> {
    fun <T> get(pointer: Pointer<T>): T?

    fun <T> getOrDefault(pointer: Pointer<T>, defaultValue: T?): T? = get(pointer) ?: defaultValue

    fun <T> supports(pointer: Pointer<T>): Boolean

    companion object {
        fun empty() = PointersImpl.EMPTY
        fun builder(): Builder = PointersImpl.BuilderImpl()
    }

    interface Builder : Buildable.Builder<Pointers> {
        fun <T> static(pointer: Pointer<T>, value: T?): Builder = dynamic(pointer) { value }
        fun <T> dynamic(pointer: Pointer<T>, supplier: () -> T?): Builder
    }
}