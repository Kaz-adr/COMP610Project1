import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
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

    //not tested on fringe cases
    private void orderMaleList(){
        for (Male man: men){
            for (int i = 0; i < women.size(); i++){
                man.orderedFemaleList.add(man.get_preferred()[i] - 1, women.get(i));
            }
            man.orderedFemaleList.removeAll(Collections.singleton(null));
        }
    }

    private  void orderFemaleList(){
        for (Female woman: women){
            for (int i = 0; i < men.size(); i++){
                woman.orderedMaleList.add(woman.get_preferred()[i] - 1, men.get(i));
            }
            woman.orderedMaleList.removeAll(Collections.singleton(null));
        }
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

    public int menWithFirstChoice(){
        int luckyMen = 0;
        for (Male man: men){
            if (man.getPartner() == man.orderedFemaleList.get(0)) luckyMen++;
        }
        return luckyMen;
    }

    public int womenWithFirstChoice(){
        int luckyWomen = 0;
        for (Female woman: women){
            if (woman.getPartner() == woman.orderedMaleList.get(0)) luckyWomen++;
        }
        return luckyWomen;
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

    public String printCouples(){
        String outputString = "";
        for (Male man: men){
            outputString += "couple(Man#" + man.get_numId() + ", Woman#" + man.getPartner().get_numId() + ")\n";
        }
        return outputString;
    }

    @Override
    public String toString() {
        return men + "\n" + women;
    }
}