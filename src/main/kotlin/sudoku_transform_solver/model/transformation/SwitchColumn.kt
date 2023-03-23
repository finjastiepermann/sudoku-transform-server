package sudoku_transform_solver.model.transformation

import sudoku_transform_solver.computation.SWITCH_COLUMN
import sudoku_transform_solver.model.Sudoku

class SwitchColumn : Transformation{
    private var col1 : Int;
    private var col2 : Int;

    constructor(column1 : Int, column2: Int)  {
        col1 = column1;
        col2 = column2;
    }

    override fun apply(s : Sudoku) : Sudoku {
        return SWITCH_COLUMN(s, col1, col2);
    }

    override fun toString(): String {
        TODO("Not yet implemented")
    }
}