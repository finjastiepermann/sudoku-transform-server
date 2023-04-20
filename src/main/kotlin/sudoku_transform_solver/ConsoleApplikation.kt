package sudoku_transform_solver

import sudoku_transform_solver.model.Sudoku
import java.util.Arrays
import java.util.stream.Collectors
import kotlin.streams.asStream
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.*
import java.lang.Runnable
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


fun main(args: Array<String>) {
    benchGenerate();
}

fun parseInput(input: String) {
    if(input == "turn l") { return; }
    if(input == "turn r") { return; }


}

fun SudokuToOnePar() : Sudoku {
    return Sudoku(Sudoku().getField().asSequence().asStream().parallel().map { ln ->
        ln.asSequence().asStream().parallel().map {_ -> 1}.toArray {size -> arrayOfNulls<Int>(size)}
    }.toArray {size -> arrayOfNulls<Array<Int>>(size)});
}

fun SudokuToOneSeq() : Sudoku {
    return Sudoku(Sudoku().getField().asSequence().map { ln ->
       ln.asSequence().map { _ -> 1 }.asStream().toArray() {size -> arrayOfNulls<Int>(size)}
    }.asStream().toArray {size -> arrayOfNulls<Array<Int>>(size)});
}

fun benchmark() {
    val timeSeq : Long;
    val timePar : Long;

    timeSeq = measureTimeMillis {
        for(i in 1..100) {
            SudokuToOneSeq();
        }
    }

    timePar = measureTimeMillis {
        for (i in 1..100) {
            SudokuToOnePar();
        }
    }

    println("Time Sequential: ${timeSeq}")
    println("Time Parallel: ${timePar}")

}

fun benchGenerate() {
    val timeSeq : Long;
    val timePar : Long;

    timeSeq = measureTimeMillis {
        repeat(120) {
            SudokuToOneSeq();
            SudokuToOneSeq();
        }
    }

    timePar = measureTimeMillis {
        val actions : MutableList<Runnable> = ArrayList();
        repeat(120) {
            actions.add() {
                SudokuToOneSeq();
                SudokuToOneSeq();
            }
        }

        actions.parallelStream()
            .map { r : Runnable  -> r.run(); }
            .collect(Collectors.toList());
    }

    println("Time Sequential: ${timeSeq}")
    println("Time Parallel: ${timePar}")
}