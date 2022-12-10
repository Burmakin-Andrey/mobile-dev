import java.io.FileInputStream
import java.util.*

//Что-то я наколхозил, думаю можно было сделать проще через регулярные, но об этом я только потом подумал)

fun check(arrI: String, arrText: String, index: String): Boolean {
    if ( arrText.indexOf(":") > 0 &&
        arrI.indexOf(index) > 0 &&
        arrText.substring(3,arrText.indexOf(":")+1).startsWith(arrI.substring(0,arrI.indexOf(index))))
                return true
    else return false
}

fun main() {
    val sc = Scanner(FileInputStream("roles.txt"))

    val roles = arrayListOf<String>()
    val textLines = arrayListOf<String>()
    var line  = ""
    var c  = 0

    while (sc.hasNextLine()) {
        line = sc.nextLine()
        if (line == "textLines:" || c > 0) {
            c++
            textLines.add((c-1).toString() + ") " + line)
        }
        else
            roles.add(line +":")
    }
    roles.removeAt(0)
    textLines.removeAt(0)

    var arr =  Array(roles.size, { Array(textLines.size+1, {"0"}) })

    arr.forEachIndexed{i, el ->
        arr[i][0] = roles[i]

    }
    for (i in 0..roles.size-1 ){
        for (j in 0..textLines.size-1 ){
            if (check(arr[i][0],textLines[j], " " ) || check(arr[i][0],textLines[j], ":" ))
                arr[i][j + 1] = textLines[j]

        }

    }

    for (array in arr) {
        for (value in array) {
            if (value != "0")
                println(value)
        }
        println()
    }

}
