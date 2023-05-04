package sudoku_transform_solver_test.computation

import org.junit.jupiter.api.Test
import sudoku_transform_solver.computation.*
import sudoku_transform_solver.model.sudoku.Sudoku
import sudoku_transform_solver.model.transformation.Direction

class TransformTest {

    @Test
    fun renameTest() {
        var s = Sudoku(arrayOf(
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        ));

        val expected = Sudoku(arrayOf(
            arrayOf(1, 2, 4, 7, 5, 6, 3, 8, 9),
            arrayOf(1, 2, 4, 7, 5, 6, 3, 8, 9),
            arrayOf(1, 2, 4, 7, 5, 6, 3, 8, 9),
            arrayOf(1, 2, 4, 7, 5, 6, 3, 8, 9),
            arrayOf(1, 2, 4, 7, 5, 6, 3, 8, 9),
            arrayOf(1, 2, 4, 7, 5, 6, 3, 8, 9),
            arrayOf(1, 2, 4, 7, 5, 6, 3, 8, 9),
            arrayOf(1, 2, 4, 7, 5, 6, 3, 8, 9),
            arrayOf(1, 2, 4, 7, 5, 6, 3, 8, 9)
        ));

        s = RENAME(s, 3, 4);
        s = RENAME(s, 3, 7);

        assert(s == expected);
    }

    @Test
    fun turnTest() {
        val s = Sudoku(arrayOf(
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        ));

        var expected = Sudoku(arrayOf(
            Array(9) {1},
            Array(9) {2},
            Array(9) {3},
            Array(9) {4},
            Array(9) {5},
            Array(9) {6},
            Array(9) {7},
            Array(9) {8},
            Array(9) {9}
        ));

        assert(expected == TURN(s, Direction.RIGHT));

        expected = Sudoku(
            arrayOf(
                Array(9) {9},
                Array(9) {8},
                Array(9) {7},
                Array(9) {6},
                Array(9) {5},
                Array(9) {4},
                Array(9) {3},
                Array(9) {2},
                Array(9) {1}
            )
        )

        assert(expected == TURN(s, Direction.LEFT));
    }

    @Test
    fun switchRowTest() {
        var s = Sudoku(
            arrayOf(
                Array(9) {1},
                Array(9) {2},
                Array(9) {3},
                Array(9) {4},
                Array(9) {5},
                Array(9) {6},
                Array(9) {7},
                Array(9) {8},
                Array(9) {9}
            )
        );

        val expected = Sudoku(
            arrayOf(
                Array(9) {1},
                Array(9) {3},
                Array(9) {2},
                Array(9) {6},
                Array(9) {4},
                Array(9) {5},
                Array(9) {9},
                Array(9) {8},
                Array(9) {7}
            )
        );

        s = SWITCH_ROW(s,1, 2);

        s = SWITCH_ROW(s, 4, 5);
        s = SWITCH_ROW(s, 3, 4);

        s = SWITCH_ROW(s, 6, 8);

        assert(s == expected);
    }

    @Test fun switchColumnTest() {
        var s = Sudoku(arrayOf(
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        ));

        val expected = Sudoku(arrayOf(
            arrayOf(1, 3, 2, 6, 4, 5, 9, 8, 7),
            arrayOf(1, 3, 2, 6, 4, 5, 9, 8, 7),
            arrayOf(1, 3, 2, 6, 4, 5, 9, 8, 7),
            arrayOf(1, 3, 2, 6, 4, 5, 9, 8, 7),
            arrayOf(1, 3, 2, 6, 4, 5, 9, 8, 7),
            arrayOf(1, 3, 2, 6, 4, 5, 9, 8, 7),
            arrayOf(1, 3, 2, 6, 4, 5, 9, 8, 7),
            arrayOf(1, 3, 2, 6, 4, 5, 9, 8, 7),
            arrayOf(1, 3, 2, 6, 4, 5, 9, 8, 7)
        ));

        s = SWITCH_COLUMN(s,1, 2);

        s = SWITCH_COLUMN(s, 4, 5);
        s = SWITCH_COLUMN(s, 3, 4);

        s = SWITCH_COLUMN(s, 6, 8);

        assert(s == expected);
    }

    @Test
    fun switchBlockRowTest() {
        var s = Sudoku(
            arrayOf(
                Array(9) {1},
                Array(9) {2},
                Array(9) {3},
                Array(9) {4},
                Array(9) {5},
                Array(9) {6},
                Array(9) {7},
                Array(9) {8},
                Array(9) {9}
            )
        );

        val expected = Sudoku(
            arrayOf(
                Array(9) {7},
                Array(9) {8},
                Array(9) {9},
                Array(9) {1},
                Array(9) {2},
                Array(9) {3},
                Array(9) {4},
                Array(9) {5},
                Array(9) {6}
            )
        );

        s = SWITCH_BLOCK_ROW(s, 1, 2);
        s = SWITCH_BLOCK_ROW(s, 0, 1);

        assert(s == expected);
    }

    @Test fun switchBlockColumnTest() {
        var s = Sudoku(arrayOf(
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        ));

        val expected = Sudoku(arrayOf(
            arrayOf(7, 8, 9, 1, 2, 3, 4, 5, 6),
            arrayOf(7, 8, 9, 1, 2, 3, 4, 5, 6),
            arrayOf(7, 8, 9, 1, 2, 3, 4, 5, 6),
            arrayOf(7, 8, 9, 1, 2, 3, 4, 5, 6),
            arrayOf(7, 8, 9, 1, 2, 3, 4, 5, 6),
            arrayOf(7, 8, 9, 1, 2, 3, 4, 5, 6),
            arrayOf(7, 8, 9, 1, 2, 3, 4, 5, 6),
            arrayOf(7, 8, 9, 1, 2, 3, 4, 5, 6),
            arrayOf(7, 8, 9, 1, 2, 3, 4, 5, 6)
        ));

        s = SWITCH_BLOCK_COLUMN(s, 1, 2);
        s = SWITCH_BLOCK_COLUMN(s, 0, 1);

        assert(s == expected);
    }
}