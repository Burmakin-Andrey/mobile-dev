fun main() {
        var arr = readln().split(" ").map(String::toFloat)

        println(arr)
        val newArr = arrayListOf<Float>()


        for (i in 1.. arr.size-2){
                newArr.add((arr[i-1] + arr[i] + arr[i+1])/3)

        }
        newArr.add(0, arr[0])
        newArr.add(arr[arr.size-1])

        newArr.forEach { el ->
                print(el!!.toString() + " ")
        }

}