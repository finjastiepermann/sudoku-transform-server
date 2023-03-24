package sudoku_transform_solver.model.transformation

import sudoku_transform_solver.computation.RENAME
import sudoku_transform_solver.model.Sudoku

class Rename : Transformation {
    private var symbol1: Int;
    private var symbol2: Int;

    constructor(symbol1: Int, symbol2: Int) {
        this.symbol1 = symbol1;
        this.symbol2 = symbol2;
    }
    override fun apply(s: Sudoku): Sudoku {
        return RENAME(s, symbol1, symbol2);
    }

    override fun toString(): String {
        TODO("Not yet implemented")
    }
}