package sudoku_transform_solver.model.transformation

import sudoku_transform_solver.model.Sudoku

/**
 * Wraps sudoku transformation into objects to organize transformation sequenzes into data structures
 */
interface Transformation {
    fun apply(s : Sudoku) : Sudoku;
    override fun toString(): String;
}