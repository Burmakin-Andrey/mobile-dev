class TicTacToe(_size: Int){
    private val size : Int
    init{
        size = _size
    }
    var arr =  Array(size) { Array(size) { 0 } }


    fun checkWin(v: Int) : Boolean {
        var count1 = 0
        var count2 = 0
        var count3 = 0
        var count4 = 0
        for (i in 0 until size){
            for (j in 0 until size){
                if (arr[i][j] == v)
                    count1+=1
                if (arr[j][i] == v)
                    count2+=1
                if (arr[j][j] == v)
                    count3+=1
                if (arr[(size-1) - j][j] == v)
                    count4+=1
            }
            if (count1 == size || count2 == size || count3 == size || count4 == size) return true
            else {
                count1 = 0
                count2 = 0
                count3 = 0
                count4 = 0
            }

        }
        return false
    }

    fun printTTT(){
        for ( i in arr){
            for (j in i){
                print("$j ")
            }
            println()
        }
    }
}




fun main(args: Array<String>) {
    println("Write N")
    var n = readLine()!!.toInt()
    var arrT : Array<TicTacToe> = Array(n*n, {TicTacToe(n)})
    var c = 1
    println("Write coords")
    var coord = readln().split(" ").map(String::toInt)
    arrT[0].arr[coord[0]][coord[1]] = 1
    arrT[0].printTTT()

    while (true) {
        var j = c % 2 + 1
        println("Write coords")
        var nextField = coord[0]*n+coord[1]
        coord = readln().split(" ").map(String::toInt)
        while (true) {
            if ( arrT[nextField].arr[coord[0]][coord[1]] == 1 || arrT[nextField].arr[coord[0]][coord[1]] == 2){
            println("The coordinate was already there, enter another one")
            coord = readln().split(" ").map(String::toInt)
            } else break
        }

        arrT[nextField].arr[coord[0]][coord[1]] = j
        arrT[nextField].printTTT()
        if (arrT[nextField].checkWin(j)) {
            println("Win"); break

        }
        c+=1

        for(i in 0 until n){
            for(j in 0 until n){
                for(k in 0 until n) {
                    print(arrT[i * n + k].arr[j].contentToString())
                }
                println()
            }
            println()
        }
    }
}