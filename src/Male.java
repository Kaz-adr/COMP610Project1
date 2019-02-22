import java.util.ArrayList;
import java.util.Arrays;

public class Male extends Human{
    private ArrayList<Female> orderedFemaleList = new ArrayList<Female>(); //assigned in UnstableMatchingInput

    Male (int numId, int[] preferred){
        super(numId, preferred);
    }

    public ArrayList<Female> getOrderedFemaleList() {
        return orderedFemaleList;
    }

    @Override
    public String toString() {
        return "Male #" + _numId + " preferences: " + Arrays.toString(_preferred);
    }
}
