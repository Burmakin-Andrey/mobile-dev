class SmartRobot(x: Int,y: Int, direction: Direction ): Robot(x,y,direction) {
    fun moveRobot(toX: Int, toY: Int){
        if (toX > x){
            while (direction != Direction.RIGHT)
                turnRight()
            while (toX>x)
                stepForward()
        }
        if (toX < x){
            while (direction != Direction.LEFT)
                turnRight()
            while (toX < x)
                stepForward()
        }
        if (toY < y){
            while (direction != Direction.DOWN)
                turnRight()
            while (toY < y)
                stepForward()
        }
        if (toY > y){
            while (direction != Direction.UP)
                turnRight()
            while (toY > y)
                stepForward()
        }
    }
}