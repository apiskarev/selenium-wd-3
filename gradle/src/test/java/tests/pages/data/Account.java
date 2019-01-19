package tests.pages.data;

public class Account extends MainData{

    private int taxId;
    private String companyName;
    private String firstName;
    private String lastName;
    private String firstAddress;
    private String secondAddress;
    private int postCode;
    private String city;
    private String email;
    private String phoneNumber;
    private String password;

    Account(){
        generateTaxId();
        generateCompanyName();
        generateFirstName();
        generateLastName();
        generateFirstAddress();
        generateSecondAddress();
        generatePostCode();
        generateCity();
        generateEmail();
        generatePhoneNumber();
        generatePassword();
    }

    private void generateTaxId(){
        taxId = generateRandomNumericValue(9);
    }

    public String getTaxId() {
        return String.valueOf(taxId);
    }

    private void generateCompanyName(){
        companyName = generateRandomText(getRandomNumber(3, 10)) + " limited";
    }

    public String getCompanyName() {
        return companyName;
    }

    private void generateFirstName(){
        String[] names = {"John", "Victor", "Max", "Robert", "Bob", "Bill"};
        firstName = names[getRandomNumber(0, names.length - 1)];
    }

    public String getFirstName() {
        return firstName;
    }

    private void generateLastName(){
        String[] lastNames = {"Smith", "Cage", "Miller", "Schrader", "Pinkman", "White"};
        lastName = lastNames[getRandomNumber(0, lastNames.length - 1)];
    }

    public String getLastName() {
        return lastName;
    }

    private String generateRandomStreet(){
        String [] streets = {"Baltimore", "Wall", "Broadway", "Times square", "Tillary"};
        return streets[getRandomNumber(0, streets.length - 1)] + " street, " + generateRandomNumericValue(getRandomNumber(1, 3));
    }
    private void generateFirstAddress(){
        firstAddress = generateRandomStreet();
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    private void generateSecondAddress(){
        secondAddress = generateRandomStreet();
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    private void generatePostCode(){
        postCode = generateRandomNumericValue(5);
    }

    public String getPostCode() {
        return String.valueOf(postCode);
    }

    private void generateCity(){
        String[] cities = {"New York", "Los Angeles", "Boston", "Trenton", "San Francisco"};
        city = cities[getRandomNumber(0, cities.length - 1)];
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return "United States";
    }

    private void generateEmail(){
        email = (firstName + "." + lastName + generateRandomNumericValue(7) + "@" + companyName.split(" ")[0] + ".com").toLowerCase();
    }

    public String getEmail() {
        return email;
    }

    private void generatePhoneNumber(){
        phoneNumber = "+7 800 " + generateRandomNumericValue(9);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private void generatePassword(){
        password = generateRandomText(10, true);
    }

    public String getPassword() {
        return password;
    }
}
