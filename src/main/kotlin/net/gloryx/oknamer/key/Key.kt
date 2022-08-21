package net.gloryx.oknamer.key

import net.gloryx.oknamer.key.kinds.LangKey
import net.gloryx.oknamer.key.kinds.NormalKey

interface Key : Comparable<Key>, Keyed, Namespaced {

    val value: String

    override val key: Key get() = this

    operator fun component1() = namespace
    operator fun component2() = value

    fun asString(): String

    override fun compareTo(other: Key): Int

    companion object {
        fun of(namespace: Namespaced, value: String) = new<NormalKey>(namespace, value)
        fun lang(namespace: Namespaced, value: String) = new<LangKey>(namespace, value)

        private inline fun <reified T : Key> new(namespace: Namespaced, value: String) = T::class.constructors.toList()[0].call(namespace, value)
    }
}