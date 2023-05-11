package sudoku_transform_solver.computation.graph_builder.sudoku_greedy_builder

import sudoku_transform_solver.computation.HAMMING
import sudoku_transform_solver.computation.SYMBOL_COUNT_DISTANCE
import sudoku_transform_solver.computation.graph_builder.BuildStrategy
import sudoku_transform_solver.model.graph.Graph
import sudoku_transform_solver.model.sudoku.Sudoku
import sudoku_transform_solver.model.transformation.Transformation

class SudokuGreedyStrategy : BuildStrategy<Sudoku, Transformation> {

    private val weightsPhase1 : GreedyMetricWeights = GreedyMetricWeights()
        .hamming(1)
        .hamming(1)
        .symbolCount(0)

    private val weightsPhase2 : GreedyMetricWeights = GreedyMetricWeights()
        .hamming(1)
        .hammingShape(1)
        .symbolCount(5)

    private var weights : GreedyMetricWeights = weightsPhase1;
    override fun next(
        start: Sudoku,
        goal: Sudoku,
        graph: Graph<Sudoku, Transformation>?,
        previous: Sudoku?,
        depth: Int?
    ): Array<Pair<Sudoku, Transformation>> {
        val possible : List<Transformation> = ArrayList();


    }

    private fun evaluate(from : Sudoku, transformation: Transformation, target : Sudoku) : Triple<Sudoku, Transformation, Double> {
        val to : Sudoku = transformation.apply(from);
        val score : Double = totalDistance(from, target) - totalDistance(to, target);

        return Triple(to, transformation, score);
    }

    private fun totalDistance(sudoku1: Sudoku, sudoku2: Sudoku) : Double {
        return (    HAMMING(sudoku1, sudoku2, {a, b -> a == b}, weights.hamming)
                +   HAMMING(sudoku1, sudoku2, {a, b -> (a == 0 && b == 0) || (a != 0 && b != 0)}, weights.hammingShape)
                +   SYMBOL_COUNT_DISTANCE(sudoku1, sudoku2, weights.symbolCount));
    }
}