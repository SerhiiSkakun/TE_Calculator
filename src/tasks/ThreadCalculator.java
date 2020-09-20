package tasks;

import java.util.concurrent.Callable;
import java.util.function.DoubleUnaryOperator;

public class ThreadCalculator implements Calculator, Callable<Double> {

    private IntegralCalculator calculator;
    private final Task1 main;

    public ThreadCalculator(double start, double finish, int n, DoubleUnaryOperator f, Task1 main) {
        calculator = new IntegralCalculator(start,finish,n,f);
        this.main = main;
    }

    @Override
    public double calculate() {
        return calculator.calculate();
    }

//    public void run(){
//        double result = calculate();
//        main.sentResult(result);
//    }

    @Override
    public Double call() throws Exception {
        return calculate();
    }
}
