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
                (aShift + bShift).toLong()
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
                (aShift + bShift).toLong()
            )
        }
    }

    /**
     * Check for HOR_LEFT * a + ASC_LEFT * b
     */
    @Test
    fun distanceCheck3() {
        for(i in 1..RANDOM_CHECK_COUNT) {
            val aShift = (abs(Random.nextInt()) % 1E6).toInt()
            val bShift = (abs(Random.nextInt()) % 1E6).toInt()

            val hexagon = HexagonVector.HOR_LEFT * aShift + HexagonVector.ASC_LEFT * bShift

            assertEquals(
                hexagon.distance(HexagonVector.ORIGIN),
                (aShift + bShift).toLong()
            )
        }
    }

    /**
     * Check for HOR_LEFT * a + DESC_LEFT * b
     */
    @Test
    fun distanceCheck4() {
        for(i in 1..RANDOM_CHECK_COUNT) {
            val aShift = (abs(Random.nextInt()) % 1E6).toInt()
            val bShift = (abs(Random.nextInt()) % 1E6).toInt()

            val hexagon = HexagonVector.HOR_LEFT * aShift + HexagonVector.DESC_LEFT * bShift

            assertEquals(
                hexagon.distance(HexagonVector.ORIGIN),
                (aShift + bShift).toLong()
            )
        }
    }

    /**
     * Checks that the empty constructor gives the origin hexagon.
     */
    @Test
    fun emptyConstructor() {
        assertEquals(HexagonVector.ORIGIN, HexagonVector())
    }

    /**
     * Ensures that toGrid and fromGrid are inverse functions of one another.
     */
    @Test
    fun fromToGrid() {
        val radius = 64.0

        for(i in 1..RANDOM_CHECK_COUNT) {
            val firstHexagon = HexagonVector.getRandom()
            val center = firstHexagon.toGrid(radius)
            val secondHexagon = HexagonVector.fromGrid(center.first, center.second, radius)

            assertEquals(
                firstHexagon,
                secondHexagon
            )
        }
    }
}