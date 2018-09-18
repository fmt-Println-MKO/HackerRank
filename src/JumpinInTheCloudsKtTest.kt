import org.junit.jupiter.api.Assertions.*

internal class JumpinInTheCloudsKtTest {

    @org.junit.jupiter.api.Test
    fun jumpingOnClouds() {

        assertEquals(3, jumpingOnClouds(arrayOf(0, 0, 0, 1, 0, 0)))
        assertEquals(4, jumpingOnClouds(arrayOf(0, 0, 1, 0, 0, 1, 0)))
        assertEquals(3, jumpingOnClouds(arrayOf(0, 0, 0, 0, 1, 0)))
    }
}