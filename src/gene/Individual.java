package gene;

import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class Individual {
    public City[] cities;
    private double fitness;
    public double tdistance;
    public int tcities;

    //random cconstructor
    public Individual( ) {
	this.cities = new City[Constants.nCity];
	for( int i = 0; i < Constants.nCity; i++ )
	    cities[i] = CityMap.getCityMap().getRandomCity();
	genFitness();
    }
    
    //a sexual mutation constructor
    public Individual( Individual a ) {
	cities = new City[Constants.nCity];
	Random rand = new Random();
	for( int i = 0; i < Constants.nCity; i++ )
	    cities[i] = a.cities[i];
	int cityA = rand.nextInt(Constants.nCity);
	int cityB = rand.nextInt(Constants.nCity);
	while( cityA == cityB )
	    cityB = rand.nextInt(Constants.nCity);
	City temp = cities[cityA];
	cities[cityA] = cities[cityB];
	cities[cityB] = temp;
	genFitness();
    }

    //bi sexual constructor
    public Individual( Individual a, Individual b ) {
	Random rand = new Random();
	this.cities = new City[Constants.nCity];
	int pointA = rand.nextInt(Constants.nCity);
	int pointB = pointA + rand.nextInt(Constants.nCity-pointA);

	for( int i = 0; i < pointA; i++)
	    cities[i] = a.cities[i];
	for( int i = pointA; i < pointB; i++)
	    cities[i] = b.cities[i];
	for( int i = pointB; i < Constants.nCity; i++)
	    cities[i] = a.cities[i];
	genFitness();
    }
    
    //copy constructor
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
	tcities = unique;

	//sum distances of voyage
	int tdistance = 0;
	for(int i = 1; i < Constants.nCity; i++)
	    tdistance += distance( cities[i], cities[i-1] );

	//add in distance from last city to first
	tdistance += distance( cities[Constants.nCity-1], cities[0] );
	this.tdistance = tdistance;

	//generate fitness score

	//TODO:its possible to divide by zero here.
	fitness = unique*unique / (300 - tdistance);
    }

    private double distance( City a, City b ) {
	return Math.sqrt( Math.pow( a.x - b.x , 2)
			  + Math.pow( a.y - b.y , 2 ) );
    }

    public double getFitness(){ return fitness;  }

    @Override
    public String toString() {
	StringBuilder result = new StringBuilder();
	for( int i = 0; i < Constants.nCity; i++ ) {
	    result.append( cities[i].name + ( (i+1) % Constants.nCity != 0 ? " => " : "" ) );
	    if( (i+1) % 5 == 0 ) result.append( "\n");
	}
	return result.toString();
    }
}
