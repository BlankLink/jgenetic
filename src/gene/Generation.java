package gene;

import java.util.ArrayList;

public class Generation {
    public ArrayList<Individual> individuals = new ArrayList<Individual>();
    public double bestfit;
    public double avgfit;
    public Individual bestIndividual;

    public Generation nextGen(){
	return new Generation();
    }

    public Generation(){
	bestfit = avgfit = 0;
	for(int i=0; i< Constants.maxpop;i++) {
	    individuals.add( new Individual() );
	    double cFitness = individuals.get(i).getFitness();
	    if( cFitness > bestfit) {
		bestfit = cFitness;
		bestIndividual = individuals.get(i);
	    }
	    avgfit+=cFitness;
	}
    }
}
