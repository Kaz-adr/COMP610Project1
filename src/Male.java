import java.util.Arrays;

public class Male extends Human{
    Male (int numId, int[] preferred){
        super(numId, preferred);
    }

    @Override
    public String toString() {
        return "Male #" + _numId + " preferences: " + Arrays.toString(_preferred);
    }
}
