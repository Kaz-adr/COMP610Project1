import java.util.Arrays;

public class Female extends Human {
    Female (int numId, int[] preferred){
        super(numId, preferred);
    }

    @Override
    public String toString() {
        return "Female #" + _numId + " preferences: " + Arrays.toString(_preferred);
    }
}
