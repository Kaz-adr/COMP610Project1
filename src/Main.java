

public class Main {

    public static void main(String[] args) {
        UnstableMatchingInput input = new UnstableMatchingInput("src\\input2.txt");
        System.out.println(input);

        //unstable solutions
        System.out.println(howManyMenGetFirstChoice(input));
        System.out.println(howManyWomenGetFirstChoice(input));

        //Gale-Shapeley test
        runGaleShapleyOnMen(input);
        System.out.println(input.printCouples());
        System.out.println("# of men with first choice: " + input.menWithFirstChoice());

        runGaleShapleyOnWomen(input);
        System.out.println(input.printCouples());
        System.out.println("# of women with first choice: " + input.womenWithFirstChoice());
    }

    public static int howManyMenGetFirstChoice(UnstableMatchingInput input){
        int luckyMen = 0;
        for (Male man: input.getMen()){
            for (Female woman: input.getWomen()){
                if (!woman.isTaken() && man.get_preferred()[0] == woman.get_numId()) {
                    woman.hookUp(man);
                    man.hookUp(woman);
                    luckyMen++;
                }
            }
        }
        input.breakUpAll();
        return luckyMen;
    }

    public static int howManyWomenGetFirstChoice(UnstableMatchingInput input){
        int luckyWomen = 0;
        for (Female woman: input.getWomen()){
            for (Male man: input.getMen()){
                if (!man.isTaken() && woman.get_preferred()[0] == man.get_numId()) {
                    woman.hookUp(man);
                    man.hookUp(woman);
                    luckyWomen++;
                }
            }
        }
        input.breakUpAll();
        return luckyWomen;
    }

    public static void runGaleShapleyOnMen (UnstableMatchingInput input){
        input.breakUpAll();
        Male manToPropose = input.nextFreeMan();
        while (manToPropose != null){
            for (Female female: manToPropose.orderedFemaleList){
                if(manToPropose.historyOfAttempts.contains(female)) continue;
                manToPropose.addToHistory(female);
                if(!female.isTaken()){
                    manToPropose.hookUp(female);
                    female.hookUp(manToPropose);
                    break;
                }
                else {
                    if (female.prefferToCurrentPartner(manToPropose)){
                        female.getPartner().breakUp();
                        female.breakUp();
                        female.hookUp(manToPropose);
                        manToPropose.hookUp(female);
                        break;
                    }
                }
            }
            manToPropose = input.nextFreeMan();
        }
    }

    public static void runGaleShapleyOnWomen (UnstableMatchingInput input){
        input.breakUpAll();
        Female womanToPropose = input.nextFreeWoman();
        while (womanToPropose != null){
            for (Male male: womanToPropose.orderedMaleList){
                if(womanToPropose.historyOfAttempts.contains(male)) continue;
                womanToPropose.addToHistory(male);
                if(!male.isTaken()){
                    womanToPropose.hookUp(male);
                    male.hookUp(womanToPropose);
                    break;
                }
                else {
                    if (male.prefferToCurrentPartner(womanToPropose)){
                        male.getPartner().breakUp();
                        male.breakUp();
                        male.hookUp(womanToPropose);
                        womanToPropose.hookUp(male);
                        break;
                    }
                }
            }
            womanToPropose = input.nextFreeWoman();
        }
    }

    public static int howManyPeopleGetFirstChoice(UnstableMatchingInput input){
        int luckyPeople = 0;
        input.breakUpAll();
        return luckyPeople;
    }
}

