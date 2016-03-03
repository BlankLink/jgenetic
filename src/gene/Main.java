package gene;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.text.DecimalFormat;

public class Main {

    public static void setup() {
	//setup log
	Logger.getLogger(Logger.class.getName()).log(Level.INFO, "log initialized");
	//setup singleton
       	CityMap.getCityMap().print("dat/citymap.txt");
    }

    public static void main(String args[]){
	setup();

	//individual tests
	// Individual i = new Individual();
	// System.out.print( i + "\n\n");
	// Individual j = new Individual( i );
	// System.out.print( j  + "\n\n");
	// Individual k = new Individual();
	// System.out.print( k  + "\n\n");
	// Individual l = new Individual( j, k );
	// System.out.print( l  + "\n\n");

	//generation tests
	Generation g = new Generation();
	DecimalFormat df = new DecimalFormat("#.##");
	System.out.println("best gene:\n" + g.bestIndividual + 
			   "\nfitness: " + df.format(g.bestfit) +
			   "\ntotal distance: " + df.format(g.bestIndividual.tdistance) +
			   "\ntotal cities: " + g.bestIndividual.tcities);

    }
}
