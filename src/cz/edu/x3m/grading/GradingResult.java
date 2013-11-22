package cz.edu.x3m.grading;

/**
 *
 * @author Jan Hybs
 */
abstract public class GradingResult {

    protected final double result;



    public GradingResult (double result) {
        this.result = result;
    }



    public double getResult () {
        return result;
    }
}
