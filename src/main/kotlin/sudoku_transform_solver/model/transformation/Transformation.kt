package sudoku_transform_solver.model.transformation

/**
 * Wraps sudoku transformation into objects to organize transformation sequenzes into data structures
 */
interface Transformation {
    fun apply();
    override fun toString(): String;
}