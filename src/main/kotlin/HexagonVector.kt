import kotlin.math.abs

/**
 * Representation of a single hexagon in the hexagonal plane.
 */
class HexagonVector {
    companion object {
        /**
         * Unit hexagon vector. Represents the hexagon to the right of the origin.
         */
        val HORIZONTAL_RIGHT = HexagonVector(1, 0)

        /**
         * Unit hexagon vector. Represents the hexagon to the left of the origin.
         */
        val HORIZONTAL_LEFT = HexagonVector(-1, 0)

        /**
         * Unit hexagon vector. Represents the hexagon to the top-right of the origin.
         */
        val ASCENDING_RIGHT = HexagonVector(0, 1)

        /**
         * Unit hexagon vector. Represents the hexagon to the bottom-left of the origin.
         */
        val ASCENDING_LEFT = HexagonVector(0, -1)

        /**
         * Unit hexagon vector. Represents the hexagon to the bottom-right of the origin.
         */
        val DESCENDING_RIGHT = HexagonVector(1, -1)

        /**
         * Unit hexagon vector. Represents the hexagon to the top-left of the origin.
         */
        val DESCENDING_LEFT = HexagonVector(-1, 1)
    }

    private var a : Int
    private var b : Int
    private constructor(a : Int, b : Int) {
        this.a = a
        this.b = b
    }

    constructor() : this(0, 0)

    init {
        a = 0
        b = 0
    }

    // PUBLIC INSTANCE METHODS

    /**
     * Finds the distance with another hexagon.
     * @param other Other hexagon to measure the distance to.
     * @return Gives the number of hexagons on the path from the two hexagons.
     */
    fun distance(other : HexagonVector) : Int {
        val difference = other - this

        val absAB = abs(difference.a + difference.b)
        val absA = abs(difference.a)
        val absB = abs(difference.b)

        return maxOf(absAB, absA, absB)
    }

    // PUBLIC INSTANCE METHODS - OPERATORS
    operator fun plus(other : HexagonVector) : HexagonVector {
        return HexagonVector(this.a + other.a, this.b + other.b)
    }

    operator fun minus(other : HexagonVector) : HexagonVector {
        return HexagonVector(this.a - other.a, this.b - other.b)
    }

    operator fun times(factor : Int) : HexagonVector {
        return HexagonVector(this.a * factor, this.b * factor)
    }

    operator fun div(divisor : Int) : HexagonVector {
        return HexagonVector(this.a / divisor, this.b / divisor)
    }
}