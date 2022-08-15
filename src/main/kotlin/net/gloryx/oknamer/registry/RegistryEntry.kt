package net.gloryx.oknamer.registry

import net.gloryx.oknamer.Oknamer
import net.gloryx.oknamer.key.Key
import net.gloryx.oknamer.key.Keyed
import net.gloryx.oknamer.key.dot

@Suppress("UNUSED")
abstract class RegistryEntry<T : RegistryEntry<T>> : Keyed {
    
    var registryName: Key? = null
        set(value) {
            if (registryName == null)
                field = value
            else throw IllegalAccessException("Cannot reassign registry name.")
        }

    override val key: Key
        get() = registryName ?: Oknamer dot "nothing"
}