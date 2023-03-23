package sudoku_transform_solver.model.transformation

import sudoku_transform_solver.computation.SWITCH_ROW
import sudoku_transform_solver.model.Sudoku

class SwitchRow : Transformation {

    private var row1 : Int;
    private var row2 : Int;

    constructor(s : Sudoku, row1: Int, row2: Int) {
        this.row1 = row1;
        this.row2 = row2;
    }

    override fun apply(s : Sudoku) : Sudoku {
        return SWITCH_ROW(s, row1, row2);
    }

    override fun toString(): String {
        TODO("Not yet implemented")
    }
}