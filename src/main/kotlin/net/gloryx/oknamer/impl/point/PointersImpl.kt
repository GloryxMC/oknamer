@file:Internal
package net.gloryx.oknamer.impl.point

import net.gloryx.oknamer.point.Pointer
import net.gloryx.oknamer.point.Pointers
import org.jetbrains.annotations.ApiStatus.Internal
import java.util.function.Supplier

internal class PointersImpl(builder: BuilderImpl) : Pointers {
    val pointers = builder.pointers

    @Suppress("unchecked_cast")
    override fun <T> get(pointer: Pointer<T>): T? = pointers[pointer]?.get() as T?

    override fun <T> supports(pointer: Pointer<T>): Boolean = pointers.containsKey(pointer)

    override fun toBuilder(): Pointers.Builder = BuilderImpl(pointers)

    class BuilderImpl(internal val pointers: MutableMap<Pointer<*>, Supplier<*>> = mutableMapOf()) : Pointers.Builder {
        override fun <T> dynamic(pointer: Pointer<T>, supplier: () -> T?) = apply {
            pointers[pointer] = Supplier(supplier)
        }

        override fun build(): Pointers =
            PointersImpl(this)
    }

    companion object {
        val EMPTY = object : Pointers {
            override fun <T> get(pointer: Pointer<T>): T? = null
            override fun <T> supports(pointer: Pointer<T>): Boolean = false
            override fun toBuilder(): Pointers.Builder = BuilderImpl()
        }
    }
}