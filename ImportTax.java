public class ImportTax extends TaxGenerator {
    public boolean isApplicable(Item item){
        return item.getImported();
    }
    public double Rate(){
        return 5.00;
    }
    
}
