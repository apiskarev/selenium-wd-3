package tests.pages.data;


public class Product extends MainData {

    public Product(){
        generateName();
        generateCode();
        generateName();
    }

    //general
    private String name;
    private String code;
    private String gender;

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



}
