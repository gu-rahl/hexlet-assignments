package exercise;

public class Segment {
    private Point beginPoint;
    private Point endPoint;

    // Конструктор
    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    // Метод для получения начальной точки отрезка
    public Point getBeginPoint() {
        return beginPoint;
    }

    // Метод для получения конечной точки отрезка
    public Point getEndPoint() {
        return endPoint;
    }

    // Метод для вычисления средней точки
    public Point getMidPoint() {
        int midX = (beginPoint.getX() + endPoint.getX()) / 2;
        int midY = (beginPoint.getY() + endPoint.getY()) / 2;
        return new Point(midX, midY);
    }
}
