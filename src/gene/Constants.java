
package gene;

import java.util.Comparator;
import java.text.DecimalFormat;

public class Constants {
    public static final int nCity = 22;
    public static int maxpop = 1000;

    // % individuals to take
    public static double elitism = .25;

    // probabilities of selecting method
    public static double mutation = .7;
    public static double crossover = mutation + .2;
    //end

    public static Comparator<Individual> indComparator = new Comparator<Individual>() {
	@Override
	public int compare(Individual one, Individual two) {
	    return (int) (two.getFitness() - one.getFitness() );
	}
    };

    public static final DecimalFormat df = new DecimalFormat("#.##");
}
