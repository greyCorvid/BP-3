package fractals;

public class MandelbrotFractal implements Fractal {
    @Override
    public double getColorIndex(double x, double y) {
        int N = 1000;
        long R = 1000000000;
        //c = x + yi
        //z = a + bi
        double a = 0;
        double b = 0;
        int ii = N;
        for (int i = 0; i <= N; i++) {
            double tempa = a*a-b*b;
            double tempb = a*b+a*b;
            a = tempa + x;
            b = tempb + y;
            if (Math.sqrt(a*a + b*b) > R) {
                ii = i;
                break;
            }
        }
        return (double)ii/N;
    }
}
