package sudoku_transform_solver.model.graph

class Graph<T, U>(private val hashFunction : (c : T) -> Int) {

    private val verts : MutableMap<Int, Vertex<T, U>> = HashMap();

    /**
     * Add vertex from content (if not exists).
     */
    fun add(c : T) : T {
        val present = verts[hashFunction(c)];
        return if(present != null) present.content;
        else {
            val v = Vertex<T, U>(c, hashFunction);
            verts[v.hash] = v;
            c;
        }
    }

    /**
     * Remove vertex by content.
     */
    fun remove(c : T) : T? {
        return verts.remove(hashFunction(c))?.content;
    }

    /**
     * Get contents of all vertices
     */
    fun getVerts() : List<T> {
        return verts.map { e -> e.value.content };
    }

    /**
     * Find vertex by content and return contents of its adjacent vertices (paired with connected edge properties)
     */
    fun getAdj(c : T) : List<Pair<T, U?>>? {
        return verts[hashFunction(c)]?.adj?.map { e -> Pair(e.first.content, e.second) };
    }

    /**
     * Connect to vertices by content.
     * Return false if one or both vertices don't exist within the graph.
     */
    fun connect(c1 : T, c2 : T, egdeProperty : U?, directional : Boolean = false) : Boolean {
        val v1 = verts[hashFunction(c1)];
        val v2 = verts[hashFunction(c2)];

        if(v1 == null || v2 == null) return false;

        v1.adj.add(Pair(v2, egdeProperty));
        if(!directional) v2.adj.add(Pair(v1, egdeProperty));
        return true;
    }

    private class Vertex<T, U>(val content: T, hashFunction: (c: T) -> Int) {

        /**
         * List of adjacent  vertices  paired with an optional property for the connecting edge
         */
        val adj : MutableList< Pair< Vertex<T, U>, U? > > = ArrayList();

        val hash : Int = hashFunction(content);
    }
}