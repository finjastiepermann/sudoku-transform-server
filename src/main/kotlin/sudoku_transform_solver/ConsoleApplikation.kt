package sudoku_transform_solver

import sudoku_transform_solver.model.Sudoku
import java.util.stream.Collectors
import kotlin.streams.asStream
import kotlin.system.measureTimeMillis
import java.lang.Runnable


fun main(args: Array<String>) {
    benchGenerate();
}

fun parseInput(input: String) {
    if(input == "turn l") { return; }
    if(input == "turn r") { return; }


}

fun SudokuToOne() : Sudoku {
    return Sudoku(Sudoku().getField().asSequence().map { ln ->
       ln.asSequence().map { _ -> 1 }.asStream().toArray() {size -> arrayOfNulls<Int>(size)}
    }.asStream().toArray {size -> arrayOfNulls<Array<Int>>(size)});
}

fun genLoopSeq(n : Int) {
    repeat(n) {
        SudokuToOne();
        SudokuToOne();
    }
}

fun genLoopPar(n : Int) {
    repeatPar(n) {
        SudokuToOne();
        SudokuToOne();
    }
}

fun repeatPar(n : Int, r : Runnable) {
    val actions : MutableList<Runnable> = ArrayList();
    repeat(n) {
        actions.add(r);
    }

    actions.parallelStream()
        .map { r : Runnable  -> r.run(); }
        .collect(Collectors.toList());
}

fun benchGenerate() {
    val OUTER_REP = 20;
    val INNER_REP = 120;

    val timeSeq : Long;
    val timePar : Long;

    val timeSeqSeq : Long;
    val timeSeqPar : Long;
    val timeParSeq : Long;
    val timeParPar : Long;

    timeSeq = measureTimeMillis {
        genLoopSeq(INNER_REP);
    }

    timePar = measureTimeMillis {
        genLoopPar(INNER_REP);
    }

    timeSeqSeq = measureTimeMillis {
        repeat(OUTER_REP) {
            genLoopSeq(INNER_REP);
        }
    }

    timeSeqPar = measureTimeMillis {
        repeat(OUTER_REP) {
            genLoopPar(INNER_REP);
        }
    }

    timeParSeq = measureTimeMillis {
        repeatPar(OUTER_REP) {
            genLoopSeq(INNER_REP);
        }
    }

    timeParPar = measureTimeMillis {
        repeatPar(OUTER_REP) {
            genLoopPar(INNER_REP);
        }
    }

    println("Time Sequential: ${timeSeq}");
    println("Time Parallel: ${timePar}");
    println("---------------------------")
    println("Time Seq-Seq: ${timeSeqSeq}");
    println("Time Seq-Par: ${timeSeqPar}");
    println("Time Par-Seq: ${timeParSeq}");
    println("Time Par-Par: ${timeParPar}");
}