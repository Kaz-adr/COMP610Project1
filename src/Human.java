public class Human {
    protected int _numId;
    protected int[] _preferred;
    private boolean taken = false;
    private int partnerID = -1;

    Human (int numId, int[] preferred){
        _numId = numId;
        _preferred = preferred;
    }

    public void hookUp (int partner){
        taken = true;
        partnerID = partner;
    }

    public void breakUp (){
        taken = false;
        partnerID = -1;
    }

    public boolean isTaken() {
        return taken;
    }

    public int getPartnerID() {
        return partnerID;
    }

    public int[] get_preferred() {
        return _preferred;
    }

    public int get_numId() {
        return _numId;
    }
}
