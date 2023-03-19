fun main() {


    val newRect = Rect(4, -2, 1,2)
    println("Rectangle: $newRect")
    newRect.rotate(RotateDirection.Clockwise, 0, 0)
    println("Clockwise rotate with center (0,0): $newRect")
    newRect.resize(2)
    println("Zoom x2: $newRect")

    println("-----------------------")

    val newSquare = Square(4, -2, 4)
    println("Square: $newSquare")
    newSquare.rotate(RotateDirection.Clockwise, 2, 2)
    println("Clockwise rotate with center (2,2): $newSquare")
    newSquare.resize(2)
    println("Zoom x2: $newSquare")

    println("-----------------------")

    val newCircle = Circle(2, 2, 3)
    println("Circle: $newCircle")
    newCircle.rotate(RotateDirection.CounterClockwise, 2, 3)
    println("CounterClockwise rotate with center (2,3): $newCircle")
    newCircle.resize(3)
    println("Zoom x2: $newCircle")


}
