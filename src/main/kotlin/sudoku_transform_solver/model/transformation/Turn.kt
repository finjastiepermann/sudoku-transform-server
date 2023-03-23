package sudoku_transform_solver.model.transformation

import sudoku_transform_solver.computation.TURN
import sudoku_transform_solver.model.Sudoku

class Turn : Transformation {
    private val dir : Direction;

    constructor(direction: Direction) {
        dir = direction;
    }

    override fun apply(s : Sudoku) : Sudoku{
        return TURN(s, dir);
    }

    override fun toString(): String {
        TODO("Not yet implemented")
    }
}