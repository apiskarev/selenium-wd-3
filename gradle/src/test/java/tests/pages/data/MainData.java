package tests.pages.data;

import java.util.concurrent.ThreadLocalRandom;

public class MainData {

    int getRandomNumber(int from, int to){
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    int generateRandomNumericValue(int length){
        StringBuilder s = new StringBuilder();
        for (int b = 0; b < length; b++)
            s.append(getRandomNumber(0, 9));
        return Integer.parseInt(String.valueOf(s));
    }

    String generateRandomText(int length, boolean isAlphaNumeric){
        String alphaUpper = "ABCDEFGHIJKLMNOPRSTQUXWVZ";
        String alphaLower = alphaUpper.toLowerCase();
        String numeric = "0123456789";
        char [] charContainer;
        if (isAlphaNumeric){
            charContainer = (alphaUpper + alphaLower + numeric).toCharArray();
        } else {charContainer = (alphaUpper + alphaLower).toCharArray();}
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < length; i++){
            s.append(charContainer[getRandomNumber(1, charContainer.length - 1)]);
        }
        return String.valueOf(s);
    }

    String generateRandomText(int length){
        return generateRandomText(length, false);
    }
}
