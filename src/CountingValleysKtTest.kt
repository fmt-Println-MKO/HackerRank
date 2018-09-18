import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CountingValleysKtTest {

    @Test
    fun countingValleys() {
        assertEquals(1, countingValleys(8, "UDDDUDUU"))
    }
}