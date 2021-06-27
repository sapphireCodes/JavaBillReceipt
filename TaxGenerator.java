
public abstract class TaxGenerator {
    abstract public boolean isApplicable(Item item);
    abstract public double Rate();

    
    public double generateTax(Item item){
        if(isApplicable(item)){
            double tax= (item.getPrice()*Rate())/100;
            tax=Math.ceil(tax/0.05)*0.05;
            return tax;
        }
        return 0;
    } 
}
