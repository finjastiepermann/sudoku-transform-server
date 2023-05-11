package sudoku_transform_solver.computation.graph_builder

const val DEFAULT_MAX_DEPTH : Int = 20;
class BuildStrategyOptions {
    var maxDepth : Int = DEFAULT_MAX_DEPTH;

    fun maxDepth(n : Int) : BuildStrategyOptions {
        this.maxDepth = n;
        return this;
    }
}