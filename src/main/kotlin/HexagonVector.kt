/*
MIT License

Copyright (c) 2023 MaxBuster

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

GitHub Repository : https://github.com/MaxBuster380/Hexavect
 */

import kotlin.math.*
import kotlin.random.Random

/**
 * Representation of a single hexagon in the hexagonal plane.
 */
class HexagonVector {
    companion object {
        /**
         * Vector coordinate of the plane's origin hexagon.
         */
        val ORIGIN = HexagonVector(0, 0)

        /**
         * Unit hexagon vector. Represents the hexagon to the right of the origin.
         */
        val HOR_RIGHT = HexagonVector(1, 0)

        /**
         * Unit hexagon vector. Represents the hexagon to the left of the origin.
         */
        val HOR_LEFT = HexagonVector(-1, 0)

        /**
         * Unit hexagon vector. Represents the hexagon to the top-right of the origin.
         */
        val ASC_RIGHT = HexagonVector(0, 1)

        /**
         * Unit hexagon vector. Represents the hexagon to the bottom-left of the origin.
         */
        val ASC_LEFT = HexagonVector(0, -1)

        /**
         * Unit hexagon vector. Represents the hexagon to the bottom-right of the origin.
         */
        val DESC_RIGHT = HexagonVector(1, -1)

        /**
         * Unit hexagon vector. Represents the hexagon to the top-left of the origin.
         */
        val DESC_LEFT = HexagonVector(-1, 1)

        /**
         * Gives a random hexagon in the plane.
         * @return a hexagon of arbitrary coordinates.
         */
        fun getRandom() : HexagonVector {
            return HexagonVector(
                Random.nextInt(),
                Random.nextInt()
            )
        }

        /**
         * Gives the hexagon that contains the given point.
         * The input point is in the Cartesian coordinate system, also known as the standard (x, y) coordinate system.
         * @param x X coordinate of the point.
         * @param y Y coordinate of the point.
         * @param radius Distance from the center to an edge of the hexagon. Is also the length of the hexagon's sides.
         * @return The hexagon containing the given point.
         * @see toCartesian
         */
        fun fromCartesian(x : Double, y : Double, radius : Double) : HexagonVector {
            /*
                        | 1 0 |
                (x,y) * | T S | = (a,b)

                s = sin(PI/3)
                t = tan(PI/3)
                S = 1 / sin(PI/3) = 1 / s
                T = - 1 / tan(PI/3) = - 1 / t
            */
            val diameter = radius * 2

            val s = sin(PI / 3.0)
            val t = tan(PI / 3.0)

            val a = round((x + -y / t)/diameter).toInt()
            val b = round(y / (s * diameter)).toInt()

            return HexagonVector(a, b)
        }
    }

    private val a : Int
    private val b : Int

    private constructor(a : Int, b : Int) {
        this.a = a
        this.b = b
    }

    constructor() : this(0, 0)

    // PUBLIC INSTANCE METHODS

    /**
     * Finds the distance with another hexagon.
     * @param other Other hexagon to measure the distance to.
     * @return Gives the number of hexagons on the path from the two hexagons.
     */
    fun distance(other : HexagonVector) : Long {
        val difference = other - this

        val aDifference = difference.a.toLong()
        val bDifference = difference.b.toLong()

        val absAB = abs(aDifference + bDifference)
        val absA = abs(aDifference)
        val absB = abs(bDifference)

        return maxOf(absAB, absA, absB)
    }

    /**
     * Gives the coordinates of the hexagon on the Cartesian coordinate system, also known as the standard (x, y) coordinate system.
     * @param radius Distance from the center to an edge of the hexagon. Is also the length of the hexagon's sides.
     * @return The (X, Y) coordinates of the hexagon's center in an orthonormal basis plane.
     * @see fromCartesian
     */
    fun toCartesian(radius : Double) : Pair<Double, Double> {
        /*
                    | 1 0 |
            (a,b) * | c s | = (x,y)

            c = cos(PI/3)
            s = sin(PI/3)
        */

        val diameter = radius * 2
        val c = cos(PI / 3.0)
        val s = sin(PI / 3.0)

        return Pair(
            diameter*(a + c * b),
            diameter*(s * b)
        )
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

    // PUBLIC INSTANCE METHODS - SUPERCLASS Object

    override fun toString(): String {
        return "($a, $b)"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) { return false }
        if (other !is HexagonVector) { return false }

        return this.a == other.a && this.b == other.b
    }

    override fun hashCode(): Int {
        val long : Long = a.toLong() shl 32 or b.toLong()
        return long.hashCode()
    }
}