package sudoku_transform_solver.computation.graph_builder

import sudoku_transform_solver.model.graph.Graph

class GraphBuilder<T, U>(
    private val strategy : BuildStrategy<T, U>,
    private val hashFunction: (c : T) -> Int,
    private val options : BuildStrategyOptions = BuildStrategyOptions()
    ) {

    fun build(start : T, target : T) : Graph<T, U>? {
        if  (start == null || target == null) return null;
        val graph = Graph<T, U>(this.hashFunction);

        graph.add(start);
        buildInternal(start, target, graph, options.maxDepth, null);
        return graph;
    }

    private fun buildInternal(current: T, target: T, graph: Graph<T, U>, depth: Int, previous : T?) {
        if (current == null || target == null) return;
        if (depth <= 0) return;
        if (graph.getAdj(current)!!.size > 0) return;
        if (current.equals(target))  return;

        val adj = this.strategy.next(current, target, graph, previous, depth);

        adj.forEach { e ->
            graph.add(e.first);
            graph.connect(current, e.first, e.second, false);

            this.buildInternal(e.first, target, graph, depth - 1, current);
        }
    }
}