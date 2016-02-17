package gene;

import java.util.Set;
import java.util.HashSet;

public class Individual {
    private City[] cities;
    private double fitness;

    public Individual( ) {
	this.cities = new City[Constants.nCity];
	for( int i = 0; i < Constants.nCity; i++ )
	    cities[i] = CityMap.getCityMap().getRandomCity();
    }
    
    //constructor
    public Individual( City[] cities ) {
	this.cities = new City[Constants.nCity];
	for(int i=0; i < Constants.nCity; i++)
	    this.cities[i] = cities[i];
	genFitness();
    }

    private void genFitness() {

	//ALGORITHM: 1)Find how many unique cities visited
	//           2)Find the total distance
	//           3)Calculate fitness based on both

	Set<String> uniqueC = new HashSet<String>();
	for(int i = 0; i < Constants.nCity; i++)
	    uniqueC.add(cities[i].name);
	int unique = uniqueC.size();

	//sum distances of voyage
	int tdistance = 0;
	for(int i = 1; i < Constants.nCity; i++)
	    tdistance += distance( cities[i], cities[i-1] );

	//add in distance from last city to first
	tdistance += distance( cities[Constants.nCity], cities[0] );

	fitness = unique*unique / (300 - tdistance);
    }

    private double distance( City a, City b ) {
	return Math.sqrt( Math.pow( a.x - b.x , 2)
			  + Math.pow( a.y - b.y , 2 ) );
    }

    @Override
    public String toString() {
	StringBuilder result = new StringBuilder();
	for( int i = 0; i < Constants.nCity; i++ )
	    result.append( cities[i].name + "\n");
	return result.toString();
    }
	   
}
