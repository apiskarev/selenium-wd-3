package tests.pages.data;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Product extends MainData {

    public Product(){
        setEnabled();
        generateName();
        generateCode();
        generateGender();
        generateQuantity();
        setProductImagePath();
        generateDates();

        generateKeywords();
        generateShortDescription();
        generateDescription();

        selectCurrency();
        generatePrices();
    }

    //general
    private boolean isEnabled;
    private String name;
    private String code;
    private String gender;
    private double quantity;
    private String productImagePath;
    private String dateFrom;
    private String dateTo;

    // information
    private String keywords;
    private String shortDescription;
    private String description;

    // prices
    private String purchasePriceInDollars;
    private String purchasePriceInEuros;
    private String currency;

    private void setEnabled(){
        isEnabled = getRandomBoolean();
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    private void generateName(){
        String [] material = {"Metallic", "Wooden", "Plastic"};
        String [] productTypes = {"Toy", "Chair", "Hair Brush", "Mirror", "Cup"};
        name = material[getRandomNumber(0, material.length -1)] + " " + productTypes[getRandomNumber(0, productTypes.length - 1)];
    }

    public String getName(){
        return name;
    }

    private void generateCode(){
        code = String.valueOf(generateRandomNumericValue(4));
    }

    public String getCode(){
        return code;
    }

    private void generateGender(){
        String[] genders = {"Female", "Male", "Unisex"};
        gender = genders[getRandomNumber(0, genders.length - 1)];
    }

    public String getGender(){
        return gender;
    }

    private void generateQuantity(){
        quantity = generateRandomDouble(10, 10000);
    }

    public double getQuantity(){
        return quantity;
    }

    private void setProductImagePath(){
        Path image = Paths.get(resourcesImagesFolder.toAbsolutePath().toString(), "baseproduct.png");
        productImagePath = image.toAbsolutePath().toString();
    }

    public String getProductImagePath(){
        return productImagePath;
    }

    private String addZeroIfValueLessThan10(int initValue){
        return initValue < 10 ? "0" + initValue : String.valueOf(initValue);
    }

    private void generateDates(){
        int dayFrom = getRandomNumber(1, 30);
        int monthFrom = getRandomNumber(1, 11);
        int yearFrom = getRandomNumber(2019, 2028);

        dateFrom = addZeroIfValueLessThan10(dayFrom) +
                addZeroIfValueLessThan10(monthFrom) + yearFrom;

        int dayTo = getRandomNumber(dayFrom, 31);
        int monthTo = getRandomNumber(monthFrom, 12);
        int yearTo = getRandomNumber(yearFrom, 2029);

        dateTo = addZeroIfValueLessThan10(dayTo) +
                addZeroIfValueLessThan10(monthTo) + yearTo;
    }

    public String getDateFrom(){
        return dateFrom;
    }

    public String getDateTo(){
        return dateTo;
    }

    private void generateKeywords(){
        String [] keywordsList = name.split(" ");
        StringBuilder s = new StringBuilder();
        for (String aKeywordsList : keywordsList)
            s.append(aKeywordsList).append(" ")
                    .append(aKeywordsList.toLowerCase()).append(" ");
        keywords = String.valueOf(s);
    }

    public String getKeywords(){
        return keywords;
    }

    private void generateShortDescription(){
        shortDescription = generateRandomText(getRandomNumber(3, 10));
    }

    public String getShortDescription(){
        return shortDescription;
    }

    private void generateDescription(){
        description = generateRandomText(getRandomNumber(10, 75));
    }

    public String getDescription(){
        return description;
    }

    private void selectCurrency(){
        if (getRandomBoolean()) currency = "USD";
        else currency = "EUR";
    }

    private void generatePrices(){
        double dollarPrice = generateRandomDouble(100, 5000);
        purchasePriceInDollars = String.format("%.2f", dollarPrice).replace(",", ".");
        double euroPrice = dollarPrice * 1.3;
        purchasePriceInEuros = String.format("%.2f", euroPrice).replace(",", ".");
    }

    public String getPurchasePriceInDollars() {
        return purchasePriceInDollars;
    }

    public String getPurchasePriceInEuros() {
        return purchasePriceInEuros;
    }

    public String getCurrency() {
        return currency;
    }

}
