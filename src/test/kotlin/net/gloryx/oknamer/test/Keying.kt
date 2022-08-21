package net.gloryx.oknamer.test

import net.gloryx.oknamer.key.Key
import org.junit.Test
import kotlin.test.assertEquals

class Keying {
    @Test
    fun `creating keys`() {
        val myKey = Key.of(TestNamespace, "my_key")
        assertEquals(myKey.namespace, "test")
        assertEquals(myKey.value, "my_key")
    }
}