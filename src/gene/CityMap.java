package gene;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.logging.Logger;
import java.util.logging.Level;

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
	    Logger.getLogger(Logger.class.getName()).log(Level.WARNING,
							 "there was a problem: " + e.getMessage());
	}
    }

    public void print(String filename) {
	try {
	    BufferedWriter fout = new BufferedWriter( new FileWriter( filename ) );
	    for(int i = 0; i < Constants.nCity; i++ )
		fout.write( cities[i].name + "\n" + cities[i].x + " " + cities[i].y + "\n" );
	    fout.close();
	}
	catch ( Exception e ) {
	    Logger.getLogger(Logger.class.getName()).log(Level.WARNING,
							 "there was a problem: " + e.getMessage());
	}
    }
}
