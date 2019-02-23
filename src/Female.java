import java.util.ArrayList;
import java.util.Arrays;

public class Female extends Human {
    public ArrayList<Male> orderedMaleList = new ArrayList<Male>();//assigned in UnstableMatchingInput

    Female (int numId, int[] preferred){
        super(numId, preferred);
        for (int i = 0; i < preferred.length; i++){
            orderedMaleList.add(null);
        }
    }

    public boolean prefferToCurrentPartner(Male suitor){
        int ratingOfCurrentPartner = orderedMaleList.indexOf(getPartner());
        int ratingOfSuitor = orderedMaleList.indexOf(suitor);
        if (ratingOfSuitor < ratingOfCurrentPartner) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Female #" + _numId + " preferences: " + Arrays.toString(_preferred);
    }
}
