package gene;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class Generation {
    public ArrayList<Individual> individuals = new ArrayList<Individual>();
    public double bestfit;
    public double avgfit;
    public Individual bestIndividual;

    public Generation nextGen(){
	return new Generation(this);
    }

    private void getFittest( Generation g ){
	PriorityQueue<Individual> q = new PriorityQueue<>(Constants.indComparator);
	for( Individual n : g.individuals )
	    q.add(n);
	for( int i = 0; i < Constants.maxpop * Constants.elitism; i++) {
	    individuals.add( q.poll() );
	}
    }

    private void genStats() {
	//get average fitness, best fitness and ref to best fit individual
	bestfit = avgfit = 0;
	for( Individual c : individuals ) {
	    double cFitness = c.getFitness();
	    if( cFitness > bestfit) {
		bestfit = cFitness;
		bestIndividual = c;
	    }
	    avgfit+=cFitness;
	}
	avgfit/= individuals.size();
    }

    private Individual roulette() {
	//Roulette selection method
	//ALGORITHM: 1. sum the fitnesses
	//           2. multiply sum by num between 0 - 1
	//           3. loop through individuals, deducting fitness from product
	//           4.     until <= 0
	//           5. select that individual

	double totfit = 0;
	Individual theone = null;
	for( Individual n : individuals )
	    totfit+=n.getFitness();
	Random r = new Random();
	totfit *= r.nextDouble();
	for( Individual n : individuals ) {
	    totfit -= n.getFitness();
	    if( totfit <= 0) {
		theone = n;
		break;
	    }
	    
	}
	return theone;
    }

    public Generation(){
	for(int i=0; i< Constants.maxpop;i++)
	    individuals.add( new Individual() );
	genStats();
    }
    public Generation( Generation g ) {
	//TODO:build new generation based on the one sent in
	//ALGORITHM: 1.pick the elite from the previous generation
	//           2.until full, chose random method
	//           3.    use roulette selection for crossover, mutation
	getFittest( g );
	Random r = new Random();
	for(int i = individuals.size(); i < Constants.maxpop; i++) {
	    double selection = r.nextDouble();
	    if ( selection < Constants.mutation )
		individuals.add( new Individual( roulette() ) );
	    else if ( selection < Constants.crossover )
		individuals.add( new Individual( roulette(), roulette() ) );
	    else
		individuals.add( new Individual() );
	}
	genStats();
    }

    @Override
    public String toString() {
	return "best gene:\n" + bestIndividual + 
	    "\nfitness: " + Constants.df.format(bestfit) +
	    "\ntotal distance: " + Constants.df.format(bestIndividual.tdistance) +
	    "\ntotal cities: " + bestIndividual.tcities +
	    "\navg fitness: " + Constants.df.format(avgfit);
    }
}
