

public class ItemDetail {
    public Item item;
    public int qty;
    private double SalesTax;
    private double Cost;
    public ItemDetail(Item item, int qty){
        this.item=item;
        this.qty=qty;
    }
    public void setSalesTax(double amt){
        SalesTax=amt;
    }
    public void setCost(){
        Cost= qty*(SalesTax+item.getPrice());
    }
    public double getSalesTax(){
        return SalesTax;
    }
    public double getCost(){
        return Cost;
    }
}
