package org.wikipedia.works.lesson06
/*
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher

data class Shape(val sideLength: Float, val sideCount: Int, val color: ColorHw)

enum class ColorHw {
    RED,
    BLUE,
    GREEN,
    YELLOW,
    BLACK,
    WHITE
}

class SideLengthInRangeMatcher(
    private val min: Float,
    private val max: Float
) : TypeSafeMatcher<Shape>() {

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideLength in min..max
    }

    override fun describeTo(description: Description) {
        description.appendText("length in range $min and $max")
    }
}

class NegativeSideLength() : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Length must be greater zero")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideLength > 0
    }
}

class NegativeSide : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Quantity of sides must be greater zero")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideCount > 0
    }
}

class ColorOfShape(private val expectedColor: ColorHw) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Shape with must be $expectedColor color")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.color == expectedColor
    }
}

class EvenQuantityOfSides : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Shape is Even quantity of side")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideCount % 2 == 0
    }

}

class AngleCountMatchesSides(
    private val angleCount: Int
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Shape must have same numb of angles as sides if it has or more " +
                "and 0 angles it it has 1 or 2 sides")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return when {
            item.sideCount in 1..2 -> true
            item.sideCount > 2 -> true
            else -> throw IllegalArgumentException("Wrong shape")
        }
    }

}

fun hasLengthInRange(min: Float, max: Float) = SideLengthInRangeMatcher(min, max)
fun hasEvenSideCount(): Matcher<Shape> = EvenQuantityOfSides()
fun hasColor(expectedColor: ColorHw): Matcher<Shape> = ColorOfShape(expectedColor)
fun hasValidSideCount(): Matcher<Shape> = NegativeSide()
fun hasValidSideLength(): Matcher<Shape> = NegativeSideLength()
fun hasAngleCount(): Matcher<Shape> = AngleCountMatchesSides()

class ShapeTest {
    val shapes = listOf(
        Shape(10f, 3, ColorHw.RED), Shape(5f, 4, ColorHw.BLUE), Shape(7f, 2, ColorHw.GREEN),
        Shape(0.5f, 1, ColorHw.YELLOW), Shape(-3f, 5, ColorHw.BLACK), Shape(8f, -2, ColorHw.WHITE),
        Shape(12f, 6, ColorHw.RED), Shape(15f, 8, ColorHw.BLUE), Shape(20f, 4, ColorHw.GREEN),
        Shape(9f, 5, ColorHw.YELLOW), Shape(2f, 3, ColorHw.BLACK), Shape(11f, 7, ColorHw.WHITE),
        Shape(6f, 10, ColorHw.RED), Shape(3f, 2, ColorHw.BLUE), Shape(4f, 1, ColorHw.GREEN),
        Shape(25f, 12, ColorHw.YELLOW), Shape(30f, 14, ColorHw.BLACK), Shape(35f, 16, ColorHw.WHITE),
        Shape(40f, 18, ColorHw.RED), Shape(50f, -20, ColorHw.BLUE)
    )


    @Test
    fun `should pass for valid side length`() {
        assertThat(shapes[0], hasLengthInRange(01f, 100.0f))
    }

    @Test
    fun `should pass for valid expected color`() {
        assertThat(shapes[1], hasColor(ColorHw.BLUE))
    }

    @Test
    fun `should pass for valid expected anyOf`() {
        val matcher = anyOf(
            hasColor(ColorHw.YELLOW),
            hasValidSideLength()
        )

        shapes.forEachIndexed { index, shape ->
            try {
                assertThat("Shape at index $index failed", shape, matcher)
            } catch (e: AssertionError) {
                println("🙈 Shape failed: index = $index, shape = $shape = ${e.message} ")
            }
        }
    }

    @Test
    fun `validate all shapes`() {
        shapes.filter { shape ->
            allOf(
                hasValidSideCount(),
                hasEvenSideCount(),
                hasLengthInRange(0.1f, 100f),
                hasAngleCount(),
                hasValidSideLength(),
                hasColor(ColorHw.BLUE)
            ).matches(shape)
        }
    }
}
*/



