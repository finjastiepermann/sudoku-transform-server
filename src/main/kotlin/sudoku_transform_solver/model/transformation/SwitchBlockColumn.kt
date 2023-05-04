package sudoku_transform_solver.model.transformation

import sudoku_transform_solver.computation.SWITCH_BLOCK_COLUMN
import sudoku_transform_solver.model.sudoku.Sudoku

class SwitchBlockColumn(column1: Int, column2: Int) : Transformation {

    private var col1 : Int = column1;
    private var col2 : Int = column2;

    override fun apply(s: Sudoku): Sudoku {
        return SWITCH_BLOCK_COLUMN(s, col1, col2);
    }

    override fun toString(): String {
        TODO("Not yet implemented")
    }
}