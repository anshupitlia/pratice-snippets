package aoc5;

enum TypeOfLine
{
   HORIZONTAL, VERTICAL, NO_LINE, DIAGONAL_1, DIAGONAL_2
}

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Coordinates() {

    }

    public TypeOfLine isLine(Coordinates other) {
        if (this.x == other.x)
            return TypeOfLine.VERTICAL;
        if (this.y == other.y)
            return TypeOfLine.HORIZONTAL;
        if (Math.abs(this.x - other.x) == Math.abs(this.y - other.y))
            return TypeOfLine.DIAGONAL_1;
        return TypeOfLine.NO_LINE;

    }

}
