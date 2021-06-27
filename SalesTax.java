public class SalesTax extends TaxGenerator{
    public boolean isApplicable(Item item){
        return item.SaleTaxable();
    }
    public double Rate(){
        return 10.00;
    }
    
}
