package gene;

import java.util.ArrayList;

public class Generation {
    ArrayList<Individual> individuals = new ArrayList<Individual>();
    public Generation nextGen(){
	return new Generation();
    }
}
