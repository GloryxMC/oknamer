package net.gloryx.oknamer

import net.gloryx.oknamer.key.Namespaced

object Oknamer : Namespaced {
    const val NAMESPACE = "oknamer"
    
    override val namespace: String = NAMESPACE
}