package sudoku_transform_solver.computation

import sudoku_transform_solver.model.sudoku.Sudoku
import kotlin.math.abs

fun HAMMING(
    s1 : Sudoku,
    s2 : Sudoku,
    same : (a : Int, b : Int) -> Boolean,
    norm : Number? = null
) : Double {
    var sum : Int = 0;
    for (i in (0 until s1.size())) {
        for (j in (0 until s1.size())) {
            if(!same(s1.get(i,j), s2.get(i,j))) sum++;
        }
    }

    return if (norm != null) sum / (s1.size() * s1.size()) * norm.toDouble();
    else sum.toDouble();
}

fun SYMBOL_COUNT_DISTANCE(
    s1 : Sudoku,
    s2 : Sudoku,
    norm: Number? = null
) : Double {
    val nSymbols = Array(s1.size()) {0}; //Index in Array represents Symbol (usually Symbols 1-9). Value of 0 means a Symbol appears the same number of times in both Sudokus
    for(i in (0 until s1.size())) {
        for(j in (0 until s1.size())) {
            if(s1.get(i,j) != 0) nSymbols[s1.get(i,j) - 1]++;
            if(s2.get(i,j) != 0) nSymbols[s2.get(i,j) - 1]--;
        }
    }

    val out = nSymbols.reduce { acc, i ->  acc+ abs(i) };
    return if (norm != null) out / (s1.size() * s1.size()) * norm.toDouble();
    else out.toDouble();
}