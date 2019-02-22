import java.util.ArrayList;
import java.util.Arrays;

public class Female extends Human {
    private ArrayList<Male> orderedMaleList = new ArrayList<Male>();//assigned in UnstableMatchingInput

    Female (int numId, int[] preferred){
        super(numId, preferred);
    }

    public ArrayList<Male> getOrderedMaleList() {
        return orderedMaleList;
    }

    @Override
    public String toString() {
        return "Female #" + _numId + " preferences: " + Arrays.toString(_preferred);
    }
}
