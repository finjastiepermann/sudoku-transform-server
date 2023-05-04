package sudoku_transform_solver.model.transformation

import sudoku_transform_solver.computation.TURN
import sudoku_transform_solver.model.sudoku.Sudoku

class Turn(private val dir : Direction) : Transformation {

    override fun apply(s : Sudoku) : Sudoku = TURN(s, dir);

    override fun toString(): String {
        return "Turned 90° to the ${if (dir == Direction.LEFT) "left" else "right"}"
    }
}