package sudoku_transform_solver_test.computation

import org.junit.jupiter.api.Test
import sudoku_transform_solver.computation.HAMMING
import sudoku_transform_solver.model.sudoku.Sudoku
import kotlin.test.assertEquals

class DistanceTest  {

    @Test
    fun hammingTest() {
        val s1 = Sudoku(arrayOf(
            arrayOf(0, 1, 0, 2, 0, 2, 0, 3, 3),
            arrayOf(0, 1, 0, 2, 0, 2, 0, 3, 3),
            arrayOf(0, 1, 0, 2, 0, 2, 0, 3, 3),
            arrayOf(0, 1, 0, 2, 0, 2, 0, 3, 3),
            arrayOf(0, 1, 0, 2, 0, 2, 0, 3, 3),
            arrayOf(0, 1, 0, 2, 0, 2, 0, 3, 3),
            arrayOf(0, 1, 0, 2, 0, 2, 0, 3, 3),
            arrayOf(0, 1, 0, 2, 0, 2, 0, 3, 3),
            arrayOf(0, 1, 0, 2, 0, 2, 0, 3, 3)
        ));

        val s2 = Sudoku(arrayOf(
            arrayOf(0, 1, 0, 2, 0, 0, 0, 3, 3),
            arrayOf(1, 0, 0, 2, 0, 2, 0, 3, 3),
            arrayOf(0, 1, 0, 0, 0, 2, 0, 3, 3),
            arrayOf(0, 0, 1, 2, 0, 0, 0, 0, 3),
            arrayOf(0, 1, 0, 2, 0, 2, 0, 3, 3),
            arrayOf(0, 0, 0, 0, 0, 2, 0, 3, 3),
            arrayOf(0, 1, 0, 2, 0, 0, 0, 3, 3),
            arrayOf(0, 0, 0, 2, 0, 2, 0, 0, 3),
            arrayOf(0, 1, 0, 0, 0, 2, 0, 3, 3)
        ));

        assertEquals(14.0, HAMMING(s1,s2, { a, b -> a == 0 && b == 0 || a != 0 && b != 0}) );
    }
}