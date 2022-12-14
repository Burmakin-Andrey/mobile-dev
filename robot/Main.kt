enum class Direction {
    UP, DOWN, RIGHT, LEFT
}

fun main(){
    val sr = SmartRobot(1,2,Direction.DOWN)
    sr.stepForward()
    sr.moveRobot(2,3)
    print(sr)
}