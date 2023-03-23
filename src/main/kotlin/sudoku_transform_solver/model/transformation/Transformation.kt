package sudoku_transform_solver.model.transformation

interface Transformation {
    fun apply();
    override fun toString(): String;
}