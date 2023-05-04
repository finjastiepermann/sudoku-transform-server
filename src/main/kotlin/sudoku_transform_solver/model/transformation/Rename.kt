package sudoku_transform_solver.model.transformation

import sudoku_transform_solver.computation.RENAME
import sudoku_transform_solver.model.sudoku.Sudoku

class Rename(private var symbol1: Int, private var symbol2: Int) : Transformation {

    override fun apply(s: Sudoku): Sudoku {
        return RENAME(s, symbol1, symbol2);
    }

    override fun toString(): String {
        return "Renamed $symbol1 to $symbol2 and v.v."
    }
}