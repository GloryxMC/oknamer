package net.gloryx.oknamer.key.kinds

import net.gloryx.oknamer.key.Key
import net.gloryx.oknamer.key.Namespaced

class NormalKey(override val namespace: String, override val value: String) : KeyImpl() {

    constructor(namespace: Namespaced, value: String) : this(namespace.namespace, value)

    override fun asString(): String = "$namespace:$value"

}