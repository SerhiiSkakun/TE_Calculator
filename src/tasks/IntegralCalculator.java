package tasks;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.IntStream;

public class IntegralCalculator extends AbstractCalculator implements Calculator{

    public IntegralCalculator(double start, double finish, int n, DoubleUnaryOperator f) {
        super(start, finish, n, f);
    }

    public double calculate(){
        double h = (finish - start) / n;
        return IntStream.range(0,n)
                .mapToDouble(i->start + i * h)
                .map(f)
                .map(y->y * h)
                .sum();
    }
}
