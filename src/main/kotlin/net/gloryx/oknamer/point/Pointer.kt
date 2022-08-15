package net.gloryx.oknamer.point

import net.gloryx.oknamer.key.Key

data class Pointer<T>(val type: Class<T>, val key: Key)