package sudoku_transform_solver.computation

import sudoku_transform_solver.model.sudoku.Sudoku
import sudoku_transform_solver.model.transformation.Direction

class Transform

fun RENAME(s : Sudoku, symbol1 : Int, symbol2 : Int) : Sudoku {
    return transform { i, j, out ->
        out.set(
            if (s.get(i, j) == symbol1) symbol2
            else if  (s.get(i, j) == symbol2) symbol1
            else s.get(i, j),
            i, j
        );
    }

}

fun TURN(s : Sudoku, dir : Direction) : Sudoku {
    return transform { i, j, out ->
        if(dir == Direction.LEFT) out.set(s.get(i,j), s.size() - 1 - j, i);
        else out.set(s.get(i,j), j, s.size() - 1 - i);
    }
}

fun SWITCH_ROW(s: Sudoku, row1 : Int, row2 : Int) : Sudoku {
    return transform { i, j, out ->
        out.set(
            if(i == row1) s.get(row2, j)
            else if(i == row2) s.get(row1, j)
            else s.get(i, j),
            i, j
        );
    }
}

fun SWITCH_COLUMN(s : Sudoku, col1 : Int, col2 : Int) : Sudoku {
    return transform { i, j, out ->
        out.set(
            if(j == col1) s.get(i, col2)
            else if(j == col2) s.get(i, col1)
            else s.get(i, j),
            i, j
        );
    }
}

fun SWITCH_BLOCK_ROW(s: Sudoku, row1 : Int, row2 : Int) : Sudoku {
    return transform { i, j, out ->
        out.set(
            if (i >= row1*s.blockSize() && i < (row1+1)*s.blockSize()) s.get((row2*s.blockSize()) + (i%s.blockSize()), j)
            else if (i >= row2*s.blockSize() && i < (row2+1)*s.blockSize()) s.get((row1*s.blockSize()) + (i%s.blockSize()), j)
            else s.get(i,j),
            i, j
        );
    }
}

fun SWITCH_BLOCK_COLUMN(s : Sudoku, col1 : Int, col2 : Int) : Sudoku {
    return transform { i, j, out ->
        out.set(
            if (j >= col1*s.blockSize() && j < (col1+1)*s.blockSize()) s.get(i,(col2*s.blockSize()) + (j%s.blockSize()) )
            else if (j >= col2*s.blockSize() && j < (col2+1)*s.blockSize()) s.get(i,(col1*s.blockSize()) + (j%s.blockSize()) )
            else s.get(i,j),
            i, j
        );
    }
}

private fun transform(func : (i : Int, j : Int, out : Sudoku) -> Unit) : Sudoku {
    val out = Sudoku();
    for(i in (0 until out.size())) {
        for (j in (0 until out.size())) {
            func(i,j, out);
        }
    }
    return out;
}

