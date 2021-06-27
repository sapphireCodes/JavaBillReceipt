
enum category{
    BOOK,CHOCOLATE,PILLS,OTHERS
}
public class Item {
    private String name;
    private double price;
    private boolean isImported;
    private boolean isSalesTaxable;
    private category cat;

    public Item(String name, double price, String itemType){
        this.price=price;
        this.name=name;
        this.isImported=setImported();
        this.cat=setCategory(itemType);
        this.isSalesTaxable=this.SaleTaxable();
    }
    private boolean setImported(){
        return this.name.contains("imported");
    }
    private category setCategory(String itemType){
        for(category x:category.values()){
            if (itemType.contains(x.toString().toLowerCase())){
                return x;
            }  
        }
        return category.OTHERS;
    }
    public boolean SaleTaxable(){
        switch(this.cat){
            case BOOK:
                return false;
            case CHOCOLATE:
                return false;
            case PILLS:
                return false;
            case OTHERS:
                return true;
            default:
                return true;
        }
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public boolean getImported(){
        return this.isImported;
    }
    public double getSalesTax(){
        double totalSaleTax=0;
        totalSaleTax=this.isSalesTaxable?this.price*0.1:0;
        totalSaleTax+=this.isImported?this.price*0.05:0;
        return Math.ceil(totalSaleTax /0.05) * 0.05;
    }
}
