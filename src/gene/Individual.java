package gene;

public class Individual {
    private String[] cities;

    public Individual( String[] cities ) {
	this.cities = new String[Constants.nCity];
	for(int i=0; i < Constants.nCity; i++)
	    this.cities[i] = cities[i];
    }
}
