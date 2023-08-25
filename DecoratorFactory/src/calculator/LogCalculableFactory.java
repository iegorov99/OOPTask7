package calculator;

public class LogCalculableFactory implements ICalculableFactory {
    private Loggable logger;

    @Override
    public Calculable create(int primaryArg) {
        return new LogCalculator(new Calculator(primaryArg), logger);
    }

    public LogCalculableFactory(Loggable logger) {
        this.logger = logger;
    }
}