package sudoku_transform_solver.model


const val S_DIM = 9; //Sudoku Dimension
const val S_BLOCK = 3; //Size of the blocks within a sudoku

class Sudoku {
    private val field : Array<Array<Int>>;

    constructor() {
        //Initialize Array filled with zeros
        field = Array(S_DIM) { _: Int -> Array(S_DIM) {_: Int -> 0} }
    }

    constructor(field : Array<Array<Int>>) {
        this.field = field;
    }

    fun getField() : Array<Array<Int>> {
        return field;
    }

    fun get(x : Int, y : Int) : Int{
        return field[y][x];
    }

    fun set(value: Int, x: Int, y: Int) {
        field[y][x] = value;
    }

    fun toPrettyString(): String {
        return field.fold("") {
            acc_o : String, ln ->
            acc_o + ln.fold("") { acc_i : String, n -> acc_i + n + " "} + "\n"
        };
    }
    override fun toString(): String {
        return field.toString();
    }
}