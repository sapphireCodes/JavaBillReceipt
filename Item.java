
enum category{
    BOOK_MEDICAL_FOOD, OTHERS
}
public class Item {
    private String name;
    private double price;
    private boolean isImported;
    private boolean isSalesTaxable;
    private category cat;
    public Item(String name, double d,boolean imported, category c){
        this.price=d;
        this.name=name;
        this.isImported=imported;
        this.cat=c;
        this.isSalesTaxable=this.SaleTaxable();
    }
    public boolean SaleTaxable(){
        switch(this.cat){
            case BOOK_MEDICAL_FOOD:
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
    public void setPrice(double price){
        this.price=price;
    }
    public double getSalesTax(){
        double totalSaleTax=0;
        totalSaleTax=this.isSalesTaxable?this.price*0.1:0;
        totalSaleTax+=this.isImported?this.price*0.05:0;
        return Math.ceil(totalSaleTax /0.05) * 0.05;
    }
}
