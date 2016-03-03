package gene;

import java.util.ArrayList;
import java.util.PriorityQueue;

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
	for(int i = individuals.size(); i < Constants.maxpop; i++) {
	    
	}

	genStats();
    }
    @Override
    public String toString() {
	return "best gene:\n" + bestIndividual + 
	    "\nfitness: " + Constants.df.format(bestfit) +
	    "\ntotal distance: " + Constants.df.format(bestIndividual.tdistance) +
	    "\ntotal cities: " + bestIndividual.tcities +
	    "\navg fitness: " + avgfit;
    }
}
