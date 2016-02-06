package gene;

import java.util.Set;
import java.util.HashSet;

public class Individual {
    private City[] cities;
    private Double fitness;

    public Individual( City[] cities ) {
	this.cities = new City[Constants.nCity];
	for(int i=0; i < Constants.nCity; i++)
	    this.cities[i] = cities[i];
    }

    public void generateFitness() {

	//ALGORITHM: 1)Find how many unique cities visited
	//           2)Find the total distance
	//           3)Calculate fitness based on both

	Set<String> uniqueC = new HashSet<String>();
	for(int i = 0; i < Constants.nCity; i++)
	    uniqueC.add(cities[i].name);
    }
}
