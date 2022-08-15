package net.gloryx.oknamer.key.kinds

class LangKey(override val namespace: String, override val value: String) : KeyImpl() {
    override fun asString(): String = "$namespace.$value"
}