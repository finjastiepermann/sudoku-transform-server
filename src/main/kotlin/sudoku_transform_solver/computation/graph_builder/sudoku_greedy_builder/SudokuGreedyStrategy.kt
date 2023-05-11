package sudoku_transform_solver.computation.graph_builder.sudoku_greedy_builder

import sudoku_transform_solver.computation.graph_builder.BuildStrategy
import sudoku_transform_solver.model.graph.Graph
import sudoku_transform_solver.model.sudoku.Sudoku
import sudoku_transform_solver.model.transformation.Transformation

class SudokuGreedyStrategy : BuildStrategy<Sudoku, Transformation> {
    override fun next(
        start: Sudoku,
        goal: Sudoku,
        graph: Graph<Sudoku, Transformation>?,
        previous: Sudoku?,
        depth: Int?
    ): Array<Pair<Sudoku, Transformation>> {
        TODO("Not yet implemented")
    }

}