package sudoku_transform_solver.computation.graph_builder

import sudoku_transform_solver.model.graph.Graph


interface BuildStrategy<T, U> {

    /**
     * @param start Starting content based on which to append new vertices.
     * @param target target content towards which  to generate new vertices.
     * @param graph Graph containing 'start'.
     * @param previous content indentifying previous vertex in graph.
     *
     * @return List of content for new vertices to be appended to start.
     */
    abstract fun next(start : T, goal : T, graph : Graph<T, U>?, previous : T?, depth : Int?) : Array< Pair<T, U> >;
}