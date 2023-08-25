package calculator;
import java.util.logging.Logger;
public class LogCalculator implements Calculable{
    private Calculable decoratedCalculater;
    private Loggable logger;
    public LogCalculator(Calculator calculator, Loggable logger){
        decoratedCalculater= calculator;
        this.logger=logger;
    }
    @Override
    public Calculable sum(int arg) {
        int fArg=decoratedCalculater.getResult();
        logger.log(Integer.toString(fArg));
        Calculable sum= decoratedCalculater.sum(arg);
        logger.log(sum.toString());
        return sum;
    }

    @Override
    public Calculable multi(int arg) {
        int fArg=decoratedCalculater.getResult();
        logger.log(Integer.toString(fArg));
        Calculable mult= decoratedCalculater.multi(arg);
        logger.log(mult.toString());
        return mult;
    }

    @Override
    public int getResult() {
        int res = decoratedCalculater.getResult();
        logger.log(Integer.toString(res));
        return 0;
    }
}
