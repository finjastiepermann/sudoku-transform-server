package sudoku_transform_solver.model.sudoku


const val S_DIM = 9; //Sudoku Dimension
const val S_BLOCK = 3; //Size of the blocks within a sudoku

class Sudoku {
    private val field : Array<Array<Int>>;

    constructor() {
        //Initialize Array filled with zeros
        field = Array(S_DIM) { Array(S_DIM) {0} }
    }

    constructor(field : Array<Array<Int>>) {
        if (field.size != S_DIM || field[0].size != S_DIM) throw DimensionMismatchException();
        this.field = field;
    }

    fun getField() : Array<Array<Int>> {
        return field;
    }

    fun get(x : Int, y : Int) : Int{
        return field[x][y];
    }

    fun set(value: Int, x: Int, y: Int) {
        field[x][y] = value;
    }

    fun size() : Int {
        return S_DIM;
    }

    fun blockSize() : Int {
        return S_BLOCK;
    }

    fun toPrettyString(): String {
        return field.fold("") {
            acc_o : String, ln ->
            acc_o + ln.fold("") { acc_i : String, n -> "$acc_i$n " } + "\n"
        };
    }

    override fun toString(): String {
        return field.joinToString(",") {a -> a.joinToString(",")};
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Sudoku) return false;
        return field.contentDeepEquals(other.getField());
    }
}