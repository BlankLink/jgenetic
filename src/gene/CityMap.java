package gene;

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public final class CityMap {
    City []cities;

    public CityMap(String filename){
	cities = new City[Constants.nCity];
	try { 
	    Scanner file = new Scanner( new FileReader(filename));
	    int i = 0;
	    while( file.hasNext() ) {
		cities[i] = new City( file.next(), file.nextInt(), file.nextInt() );
		i++;
	    }
	}
	catch (FileNotFoundException e) {
	    
	}
    }
}
