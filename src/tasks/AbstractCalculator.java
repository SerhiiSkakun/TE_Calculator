package tasks;

import java.util.function.DoubleUnaryOperator;

public abstract class AbstractCalculator implements Calculator {
    protected final double start;
    protected final double finish;
    protected final int n;
    protected final DoubleUnaryOperator f;

    public AbstractCalculator(double start, double finish, int n, DoubleUnaryOperator f) {
        this.start = start;
        this.finish = finish;
        this.n = n;
        this.f = f;
    }
}
