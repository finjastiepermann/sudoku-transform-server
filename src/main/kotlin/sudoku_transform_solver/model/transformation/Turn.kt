package sudoku_transform_solver.model.transformation

import sudoku_transform_solver.computation.TURN
import sudoku_transform_solver.model.Sudoku

class Turn(val dir : Direction) : Transformation {

    override fun apply(s : Sudoku) : Sudoku = TURN(s, dir);

    override fun toString(): String {
        TODO("Not yet implemented")
    }
}