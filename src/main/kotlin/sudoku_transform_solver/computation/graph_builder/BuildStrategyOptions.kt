package sudoku_transform_solver.computation.graph_builder

class BuildStrategyOptions {
    var maxDepth : Int? = null;

    fun maxDepth(n : Int?) : BuildStrategyOptions {
        this.maxDepth = n;
        return this;
    }
}