import java.util.ArrayList;
import java.util.Arrays;

public class Male extends Human{
    public ArrayList<Female> orderedFemaleList = new ArrayList<Female>(); //assigned in UnstableMatchingInput

    Male (int numId, int[] preferred){
        super(numId, preferred);
        for (int i = 0; i < preferred.length; i++){
            orderedFemaleList.add(null);
        }
    }

    public boolean prefferToCurrentPartner(Female suitor){
        int ratingOfCurrentPartner = orderedFemaleList.indexOf(getPartner());
        int ratingOfSuitor = orderedFemaleList.indexOf(suitor);
        if (ratingOfSuitor < ratingOfCurrentPartner) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Male #" + _numId + " preferences: " + Arrays.toString(_preferred);
    }
}
