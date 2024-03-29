package sudoku_transform_solver.model.transformation

import sudoku_transform_solver.computation.SWITCH_ROW
import sudoku_transform_solver.model.sudoku.Sudoku

class SwitchRow(private var row1: Int, private var row2: Int) : Transformation {

    override fun apply(s : Sudoku) : Sudoku {
        return SWITCH_ROW(s, row1, row2);
    }

    override fun toString(): String {
        return "Switched rows $row1 and $row2."
    }
}