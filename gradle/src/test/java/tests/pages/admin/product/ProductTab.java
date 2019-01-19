package tests.pages.admin.product;

public enum ProductTab {

    GENERAL("General"), INFORMATION("Information"), PRICES("Prices");

    private String name;

    ProductTab(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


}
