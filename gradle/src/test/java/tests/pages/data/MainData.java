package tests.pages.data;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainData {

    Path resourcesImagesFolder = Paths.get("src", "main", "resources", "images");

    boolean getRandomBoolean(){
        Random r = new Random();
        return r.nextBoolean();
    }

    public int getRandomNumber(int from, int to){
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    int generateRandomNumericValue(int length){
        StringBuilder s = new StringBuilder();
        for (int b = 0; b < length; b++)
            s.append(getRandomNumber(0, 9));
        return Integer.parseInt(String.valueOf(s));
    }

    String generateRandomWord(int length, boolean isAlphaNumeric){
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

    String generateRandomWord(int length){
        return generateRandomWord(length, false);
    }

    double generateRandomDouble(int from, int to){
        Random r = new Random();
        return from + r.nextDouble() * (to - from);
    }

    String generateRandomText(int wordsLength){
        StringBuilder s = new StringBuilder();
        for (int i =0; i < wordsLength; i++){
            s.append(generateRandomWord(getRandomNumber(3, 12))).append(" ");
        }
         return String.valueOf(s);
    }
}
