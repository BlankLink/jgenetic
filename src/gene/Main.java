package gene;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {

    public static void setup() {
	//setup log
	Logger.getLogger(Logger.class.getName()).log(Level.INFO, "log initialized");
	//setup singleton
       	CityMap.getCityMap().print("dat/citymap.txt");
    }

    public static void main(String args[]){
	setup();
	Individual i = new Individual();
	System.out.print( i + "\n\n");
	Individual j = new Individual( i );
	System.out.print( j  + "\n\n");
	Individual k = new Individual();
	System.out.print( k  + "\n\n");
	Individual l = new Individual( j, k );
	System.out.print( l  + "\n\n");
    }
}
