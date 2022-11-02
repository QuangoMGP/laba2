public class Point3d extends Point2d {
    private double zCoord;

    // Точность с которой хранятся числа
    private static double precision = 100d;

    public Point3d(double x, double y, double z) {
        super(x, y);
        zCoord = z;
    }

    public Point3d() {
        super();
        zCoord = 0;
    }

    public double getZ() {
        return zCoord;
    }

    // Количество знаков после запятой
    public static void setPrecision(double p) {
        precision = p;
    }

    // Проверяет равенство точек возвращает true если равны иначе false
    public boolean equalsPoint3d(Point3d secondPoint) {
        if (secondPoint.getX() != super.getX())
            return false;
        if (secondPoint.getY() != super.getY())
            return false;
        if (secondPoint.getZ() != this.getZ())
            return false;
        return true;
    }

    // Вычисляет расстояние между двумя точками
    public static double distanceTo(Point3d firstPoint, Point3d secondPoint) {
        double x = Math.round(Math.sqrt(
                Math.pow((secondPoint.getX() - firstPoint.getX()), 2) +
                        Math.pow((secondPoint.getY() - firstPoint.getY()), 2) +
                        Math.pow((secondPoint.getZ() - firstPoint.getZ()), 2))
                * precision) / precision;
        return x;

    }

    // Проверка являются ли три точки различными
    // ture если все точки различны
    public static boolean isTriangle(Point3d firstPoint, Point3d secondPoint, Point3d thirdPoint) {
        return (firstPoint.equalsPoint3d(secondPoint) || firstPoint.equalsPoint3d(thirdPoint)
                || secondPoint.equalsPoint3d(thirdPoint)) ? false : true;
    }

    // Вычисляет площадь для трех заданных точек
    public static double computeArea(Point3d firsPoint, Point3d secondPoint, Point3d thirdPoint) {
        double lineAB = distanceTo(firsPoint, secondPoint);
        double lineBC = distanceTo(thirdPoint, secondPoint);
        double lineAC = distanceTo(firsPoint, thirdPoint);
        double perimeter = (lineAB + lineAC + lineBC) / 2;
        double area = Math.round(
                Math.sqrt(perimeter * (perimeter - lineAB) *
                        (perimeter - lineAC) * (perimeter - lineBC))
                        * precision)
                / precision;

        return isTriangle(firsPoint, secondPoint, thirdPoint) ? area : -1;
    }
}