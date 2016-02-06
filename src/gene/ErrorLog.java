package gene;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.io.IOException;

public class ErrorLog {

    private static Logger l = Logger.getLogger(ErrorLog.class.getName());

    public static void write(String message) {
	//TODO: clean this up, add the handler elsewhere.
	try { 
	    l.addHandler( new FileHandler("/Users/Farilight-Excalibur/Projects/java/jgenetic/dat/error.log")); 
	}
	catch ( IOException e ) {
	    System.err.println("error finding log file");
	}
	l.log(Level.INFO, message);
    }
}
