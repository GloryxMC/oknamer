package net.gloryx.oknamer.key

interface Namespaced {
    val namespace: String
}

infix fun Namespaced.dot(value: String) = Key.lang(this, value)
infix fun Namespaced.at(value: String) = Key.of(this, value)