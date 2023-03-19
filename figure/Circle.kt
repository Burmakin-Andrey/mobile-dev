// TODO: дополнить определение класса размерами и позицией
class Circle(var x: Int, var y: Int, var radius: Int) : Figure(0), Transforming {
    override fun resize(zoom: Int) {
        radius *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {

        if (centerX == x && centerY == y) return

        if(direction == RotateDirection.Clockwise)
        {
            var tX = x
            x = y - centerY + centerX
            y = -1 * (tX - centerX) + centerY
        }
        else
        {
            var tX = x
            x = -1 * (y - centerY) + centerX
            y = tX - centerX + centerY
        }
    }

    override fun area(): Float {
        return  (3.14 * radius * radius).toFloat() // требуется явное приведение к вещественному числу
    }

    override fun toString(): String {
        return "x - $x, y - $y, radius - $radius"
    }
}