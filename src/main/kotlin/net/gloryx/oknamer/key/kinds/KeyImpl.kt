package net.gloryx.oknamer.key.kinds

import net.gloryx.oknamer.key.Key

@Suppress("MemberVisibilityCanBePrivate")
sealed class KeyImpl : Key {
    protected val comparator: Comparator<Key> = Comparator.comparing(Key::value).thenComparing(Key::namespace)

    override fun compareTo(other: Key): Int = comparator.compare(this, other)
}
