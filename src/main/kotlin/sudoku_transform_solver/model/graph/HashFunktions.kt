package sudoku_transform_solver.model.graph

import kotlin.math.pow

/**
 * Modulo 24 hash function
 */
public fun MOD24_HASH(o : Object) : Int {
    val B = 2.0.pow(24).toInt();
    val M = 16777213 //Last primenumber before B.
    val s = o.toString();

    var h = 0;

    for (i in s.indices) {
        h = (h * B + s.get(i).code) % M;
    }

    return h;
}