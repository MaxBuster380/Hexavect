import kotlin.math.abs
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class HexagonVectorTest {
    companion object {
        const val RANDOM_CHECK_COUNT = 1e3.toInt()
    }

    /**
     * Check for HOR_RIGHT * a + ASC_RIGHT * b
     */
    @Test
    fun distanceCheck1() {
        for(i in 1..RANDOM_CHECK_COUNT) {
            val aShift = (abs(Random.nextInt()) % 1E6).toInt()
            val bShift = (abs(Random.nextInt()) % 1E6).toInt()

            val hexagon = HexagonVector.HOR_RIGHT * aShift + HexagonVector.ASC_RIGHT * bShift

            assertEquals(
                hexagon.distance(HexagonVector.ORIGIN),
                aShift + bShift
            )
        }
    }

    /**
     * Check for HOR_RIGHT * a + DESC_RIGHT * b
     */
    @Test
    fun distanceCheck2() {
        for(i in 1..RANDOM_CHECK_COUNT) {
            val aShift = (abs(Random.nextInt()) % 1E6).toInt()
            val bShift = (abs(Random.nextInt()) % 1E6).toInt()

            val hexagon = HexagonVector.HOR_RIGHT * aShift + HexagonVector.DESC_RIGHT * bShift

            assertEquals(
                hexagon.distance(HexagonVector.ORIGIN),
                aShift + bShift
            )
        }
    }
}