import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class UnstableMatchingInput {
    Scanner scanner;
    String _inputFileName;

    private ArrayList<Male> men = new ArrayList<>();
    private ArrayList<Female> women = new ArrayList<>();

    int numBoysOrGirls;

    UnstableMatchingInput(String inputFileName){
        _inputFileName = inputFileName;
        try{
            scanner = new Scanner(new File(_inputFileName));
            numBoysOrGirls = scanner.nextInt();
            int[] preference;
            //do the men
            for (int i = 0; i < numBoysOrGirls; i++){
                preference = new int[numBoysOrGirls];
                for (int j = 0; j < numBoysOrGirls; j++){
                    preference[j] = scanner.nextInt();
                }
                men.add(new Male(i + 1, preference));
            }
            //do the women
            for (int i = 0; i < numBoysOrGirls; i++){
                preference = new int[numBoysOrGirls];
                for (int j = 0; j < numBoysOrGirls; j++){
                    preference[j] = scanner.nextInt();
                }
                women.add(new Female(i + 1, preference));
            }
            //order Preference List
            orderFemaleList();
            orderMaleList();
        }
        catch ( FileNotFoundException e){ System.out.println(_inputFileName +  "Not found!"); }
    }

    private void orderMaleList(){
        for (Male man: men){
            for (int i: man.get_preferred()){
                //AAAAAAAAAAAAAAAAAAAA
            }
        }
    }

    private  void orderFemaleList(){

    }

    public void breakUpAll (){
        men.forEach((m) -> m.breakUp());
        women.forEach((f) -> f.breakUp());
    }

    //returns single man from top of list, if none exist return null
    public Male nextFreeMan(){
        for (Male man : men){
            if (!man.isTaken()) return man;
        }
        return null;
    }

    public Female nextFreeWoman(){
        for (Female woman : women){
            if (!woman.isTaken()) return woman;
        }
        return null;
    }


    public ArrayList<Male> getMen() {
        return men;
    }

    public void setMen(ArrayList<Male> men) {
        this.men = men;
    }

    public ArrayList<Female> getWomen() {
        return women;
    }

    public void setWomen(ArrayList<Female> women) {
        this.women = women;
    }

    @Override
    public String toString() {
        return men + "\n" + women;
    }
}