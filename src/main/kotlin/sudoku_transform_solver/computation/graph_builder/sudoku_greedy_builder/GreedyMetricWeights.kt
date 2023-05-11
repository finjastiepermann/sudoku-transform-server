package sudoku_transform_solver.computation.graph_builder.sudoku_greedy_builder

class GreedyMetricWeights {
    var hamming : Int = 1
    var hammingShape : Int = 1
    var symbolCount : Int = 1

    fun hamming(w : Int) : GreedyMetricWeights {
        hamming = w;
        return this;
    }

    fun hammingShape(w : Int) : GreedyMetricWeights {
        hammingShape = w;
        return this;
    }

    fun symbolCount(w : Int) : GreedyMetricWeights {
        symbolCount = w;
        return this;
    }
}