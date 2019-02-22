import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UnstableMatchingInput input = new UnstableMatchingInput("src\\input2.txt");
        System.out.println(input);
        System.out.println(howManyMenGetFirstChoice(input));
        System.out.println(howManyWomenGetFirstChoice(input));

    }

    public static int howManyMenGetFirstChoice(UnstableMatchingInput input){
        int luckyMen = 0;
        for (Male man: input.getMen()){
            for (Female woman: input.getWomen()){
                if (!woman.isTaken() && man.get_preferred()[0] == woman.get_numId()) {
                    woman.hookUp(man.get_numId());
                    man.hookUp(woman.get_numId());
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
                    woman.hookUp(man.get_numId());
                    man.hookUp(woman.get_numId());
                    luckyWomen++;
                }
            }
        }
        input.breakUpAll();
        return luckyWomen;
    }

    public static int howManyPeopleGetFirstChoice(UnstableMatchingInput input){
        int luckyPeople = 0;
        input.breakUpAll();
        return luckyPeople;
    }
}

