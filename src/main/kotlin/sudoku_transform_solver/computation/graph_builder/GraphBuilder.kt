package sudoku_transform_solver.computation.graph_builder

import sudoku_transform_solver.model.graph.Graph

class GraphBuilder<T, U>(
    private val strategy : BuildStrategy<T, U>,
    private val hashFunction: (c : T) -> Int,
    private val options : BuildStrategyOptions
    ) {

    fun build(start : T, target : T) : Graph<T, U> {
        val graph = Graph<T, U>(this.hashFunction);

        graph.add(start);
        return buildInternal(start, target, graph, 20, null);
    }

    fun buildInternal(current: T, target: T, graph: Graph<T, U>, depth: Int, previous : T?) : Graph<T, U> {
        //TODO
        return graph;
    }
}