package tasks;

public class Task1 {
    double total;
    int finished;

    public static void main(String[] args) {
        new Task1().run();
    }

    private void run() {

        long startTime = System.currentTimeMillis();

        int nTreads = 4;

        startThreads(nTreads);

        synchronized (this) {
            while (finished < nTreads){
                try {
                    wait();
                } catch (InterruptedException ignored) { }
            }
        }
        long finishTime = System.currentTimeMillis();

        System.out.println("total = " + total);
        System.out.println(finishTime - startTime);
//        IntegralCalculator integralCalculator = new IntegralCalculator(a,b,n,Math::sin);
//        double v = integralCalculator.calculate();
//        System.out.println("v = " + v);
    }

    public void startThreads(int nTreads) {
        double a = 0;
        double b = Math.PI;
        int n = 100_000_000;

        total = 0;
        finished = 0;
        double delta = (b - a) / nTreads;
        for (int i = 0; i < nTreads; i++) {
            new Thread(new ThreadCalculator(a + i * delta, a + (i + 1) * delta, n/ nTreads, Math::sin, this)).start();
        }
    }

    synchronized void sentResult(double result){
        total += result;
        finished++;
        notify();
    }
}
