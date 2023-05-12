package sudoku_transform_solver.computation.graph_builder.sudoku_greedy_builder

import sudoku_transform_solver.computation.HAMMING
import sudoku_transform_solver.computation.SYMBOL_COUNT_DISTANCE
import sudoku_transform_solver.computation.graph_builder.BuildStrategy
import sudoku_transform_solver.model.graph.Graph
import sudoku_transform_solver.model.sudoku.S_BLOCK
import sudoku_transform_solver.model.sudoku.S_DIM
import sudoku_transform_solver.model.sudoku.Sudoku
import sudoku_transform_solver.model.transformation.*

class SudokuGreedyStrategy : BuildStrategy<Sudoku, Transformation> {
    val MAX_NODE_COMPLEXITY = 5;
    val DISCARD_LOWER_PERCENTILE = 0.5;

    private val weightsPhase1 : GreedyMetricWeights = GreedyMetricWeights()
        .hamming(1)
        .hamming(1)
        .symbolCount(0)

    private val weightsPhase2 : GreedyMetricWeights = GreedyMetricWeights()
        .hamming(1)
        .hammingShape(1)
        .symbolCount(5)

    override fun next(
        start: Sudoku,
        goal: Sudoku,
        graph: Graph<Sudoku, Transformation>?,
        previous: Sudoku?,
        depth: Int?
    ): Array<Pair<Sudoku, Transformation>> {
        var evaluated = generatePossibleTransformations().parallelStream()
            .map { e -> evaluate(start, e.first, goal, e.second)}
            .filter { e -> e.third > 0}
            .sequential()
            .sorted { a, b -> if (a.third > b.third) 1 else if (a.third < b.third) -1 else 0}
            .toList()

        evaluated = evaluated.takeLast(MAX_NODE_COMPLEXITY)
        val maxScore = evaluated.maxOf { e -> e.third }
        return evaluated
            .filter { e -> e.third >= maxScore * DISCARD_LOWER_PERCENTILE }
            .map { e -> Pair(e.first, e.second) }
            .toTypedArray()
    }

    private fun generatePossibleTransformations() : List<Pair<Transformation, GreedyMetricWeights>> {
        //Create and fill List of possible tranformations (helps with parallel evaluation later)
        val possible : MutableList<Pair<Transformation, GreedyMetricWeights>> = ArrayList();

        possible.add(Pair(Turn(Direction.LEFT), weightsPhase1));
        possible.add(Pair(Turn(Direction.RIGHT), weightsPhase1));

        val blocks = S_DIM/ S_BLOCK;
        for (i in (0 until S_BLOCK)) {
            for (j in (0 until i)) {
                possible.add(Pair(SwitchBlockRow(i,j), weightsPhase1))
                possible.add(Pair(SwitchBlockColumn(i,j), weightsPhase1))

                for(k in (0 until blocks)) {
                    val offset = S_BLOCK*k;
                    possible.add(Pair(SwitchRow(offset+i, offset+j),weightsPhase1))
                    possible.add(Pair(SwitchColumn(offset+i, offset+j),weightsPhase1))
                }
            }
        }

        for (i in (1 .. S_DIM)) {
            for (j in (1 .. S_DIM)) {
                possible.add(Pair(Rename(i,j),weightsPhase2))
            }
        }

        return possible;
    }

    private fun evaluate(from : Sudoku, transformation: Transformation, target : Sudoku, weights: GreedyMetricWeights) : Triple<Sudoku, Transformation, Double> {
        val to : Sudoku = transformation.apply(from);
        val score : Double = totalDistance(from, target, weights) - totalDistance(to, target, weights);

        return Triple(to, transformation, score);
    }

    private fun totalDistance(sudoku1: Sudoku, sudoku2: Sudoku, weights: GreedyMetricWeights) : Double {
        return (    HAMMING(sudoku1, sudoku2, {a, b -> a == b}, weights.hamming)
                +   HAMMING(sudoku1, sudoku2, {a, b -> (a == 0 && b == 0) || (a != 0 && b != 0)}, weights.hammingShape)
                +   SYMBOL_COUNT_DISTANCE(sudoku1, sudoku2, weights.symbolCount));
    }
}