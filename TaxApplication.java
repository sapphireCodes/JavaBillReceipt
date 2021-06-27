public class TaxApplication {
    private SalesTax Tst = new SalesTax();
    private ImportTax It= new ImportTax();

    public void Calculate(Cart cart)
    {
        for(ItemDetail iDetail:cart.CartItems)
        {   double sales_tax=0;
            if (Tst.isApplicable(iDetail.item)){
                Tst.Rate();
                sales_tax+=Tst.generateTax(iDetail.item);   
            }
            if (It.isApplicable(iDetail.item)){
                It.Rate();
                sales_tax+=It.generateTax(iDetail.item);
            }
            iDetail.setSalesTax(sales_tax);
            iDetail.setCost();
        }
        cart.setTotalTax();
        cart.setTotalCost();
    }
}
