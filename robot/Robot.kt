
open class Robot(var x: Int, var y: Int, var direction: Direction ){

    fun turnLeft(){
        if (direction == Direction.UP) direction = Direction.LEFT
        else if (direction == Direction.LEFT) direction = Direction.DOWN
        else if (direction == Direction.DOWN) direction = Direction.RIGHT
        else if (direction == Direction.RIGHT) direction = Direction.UP

    }

    fun turnRight(){
        if (direction == Direction.UP) direction = Direction.RIGHT
        else if (direction == Direction.LEFT) direction = Direction.UP
        else if (direction == Direction.DOWN) direction = Direction.LEFT
        else if (direction == Direction.RIGHT) direction = Direction.DOWN
    }

    fun stepForward(){
        if (direction == Direction.UP) y+=1
        else if (direction == Direction.DOWN) y-=1
        else if (direction == Direction.RIGHT) x+=1
        else if (direction == Direction.LEFT) x-=1
    }

    override fun toString(): String {
        return "x: $x, y: $y, dir: $direction"
    }

}