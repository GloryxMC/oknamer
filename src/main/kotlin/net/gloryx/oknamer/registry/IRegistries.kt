package net.gloryx.oknamer.registry

import kotlin.reflect.full.primaryConstructor

/**
 * An interface for libraries that have their own registers, for example KDA with Slash command registers;
 * This interface is like a marker interface.
 */
interface IRegistries

@Suppress("UNUSED")
inline fun <reified R : Registry<T>, T : RegistryEntry<T>> IRegistries.new() = R::class.primaryConstructor!!.call()