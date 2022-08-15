package net.gloryx.oknamer.registry

@Suppress("MemberVisibilityCanBePrivate")
abstract class Registry<T : RegistryEntry<T>> {
    protected val elements: MutableList<Function<out T>> = mutableListOf() // REALLY covariant.

    open fun init() {
        register()
    }

    protected abstract fun register()

    operator fun <R : T> invoke(supplier: () -> R) {
        elements.add(supplier)
    }
}