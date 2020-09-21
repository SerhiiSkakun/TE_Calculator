package tasks;

import java.util.concurrent.Callable;
import java.util.function.DoubleUnaryOperator;

public class ThreadCalculator implements Calculator, Callable<Double> {

    private IntegralCalculator calculator;

    public ThreadCalculator(double start, double finish, int n, DoubleUnaryOperator f) {
        calculator = new IntegralCalculator(start,finish,n,f);
    }

    @Override
    public double calculate() {
        return calculator.calculate();
    }

    @Override
    public Double call() {
        return calculate();
    }
}
