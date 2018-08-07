package walls

class Wall(
        private var row: Int,
        private var column: Int
){
    fun getRow(): Int{
        return this.row
    }
    fun getColumn(): Int{
        return this.column
    }
}