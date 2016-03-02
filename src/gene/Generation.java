package gene;

import java.util.ArrayList;

public class Generation<E> extends ArrayList<E> {
    public Generation<E> nextGen(){
	return new Generation<E>();
    }
}
