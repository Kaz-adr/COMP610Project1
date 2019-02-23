import java.util.ArrayList;

public class Human {
    protected int _numId;
    protected int[] _preferred;
    private boolean taken = false;
    //private int partnerID = -1;
    private Human partner;
    public ArrayList<Human> historyOfAttempts = new ArrayList<Human>();

    Human (int numId, int[] preferred){
        _numId = numId;
        _preferred = preferred;
    }

    public void hookUp (Human newPartner){
        taken = true;
        partner = newPartner;
    }

    public void addToHistory(Human suitee){
        historyOfAttempts.add(suitee);
    }


    public void breakUp (){
        taken = false;
        partner = null;
    }

    public boolean isTaken() {
        return taken;
    }

    public Human getPartner() {
        return partner;
    }

    public int[] get_preferred() {
        return _preferred;
    }

    public int get_numId() {
        return _numId;
    }
}
