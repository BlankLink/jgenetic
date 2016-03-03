
package gene;

import java.util.Comparator;
import java.text.DecimalFormat;

public class Constants {
    public static final int nCity = 22;
    public static int maxpop = 1000;

    // % individuals to take
    public static double elitism = .25;

    //sum to 1.0
    public static double mutation = .7;
    public static double crossover = .2;
    //end sum to 1.0

    public static Comparator<Individual> indComparator = new Comparator<Individual>() {
	@Override
	public int compare(Individual one, Individual two) {
	    return (int) (two.getFitness() - one.getFitness() );
	}
    };

    public static final DecimalFormat df = new DecimalFormat("#.##");
}
