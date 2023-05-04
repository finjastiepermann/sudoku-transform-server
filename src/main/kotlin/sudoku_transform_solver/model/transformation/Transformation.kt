package sudoku_transform_solver.model.transformation

import sudoku_transform_solver.model.sudoku.Sudoku

/**
 * Wraps sudoku transformation into objects to organize transformation sequences into data structures
 */
interface Transformation {
    fun apply(s : Sudoku) : Sudoku;
    override fun toString(): String;
}