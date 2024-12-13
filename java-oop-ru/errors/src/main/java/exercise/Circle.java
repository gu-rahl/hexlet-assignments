package exercise;

public class Circle {
    private final Point center;
    private final int radius;

    // Конструктор
    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    // Метод для получения радиуса
    public int getRadius() {
        return radius;
    }

    // Метод для вычисления площади круга
    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Радиус не может быть отрицательным");
        }
        return Math.PI * radius * radius;
    }
}
