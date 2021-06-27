import java.util.Scanner;
import java.math.*;

public class Receipt {

	private Cart cart;
	private double fst=0;
	private double famt=0;
	private BigDecimal totalSalesTax,totalPrice;
    private TaxApplication taxes;
	
	public Receipt(){
        cart=new Cart();
		getCustomerOrder();
        taxes=new TaxApplication();
        taxes.Calculate(cart);
        fst=cart.getTotalTax();
        famt=cart.getTotalCost();
        roundDigit();
        
	}
    public void getCustomerOrder(){
        try {
            Scanner sc= new Scanner(System.in);
            System.out.println("Place an order :");
            String[] itemsWithNoSalesTax=new String[]{"book","pills","chocolate"};
            
            while(sc.hasNextLine()){
                String inpLine=sc.nextLine();
                if (inpLine.isEmpty()){
                    break;
                }
                else{
                String []words=inpLine.split(" ");
    
                int qty=Integer.parseInt(words[0]);
                String itemType = inpLineContainsItemsFromArray(inpLine, itemsWithNoSalesTax);
                int indexOfAt=inpLine.indexOf(" at");
                String iname=inpLine.substring(0, indexOfAt);
                double iprice=Double.parseDouble(inpLine.substring(indexOfAt+4));

                Item b1=new Item(iname,iprice,itemType);
                cart.CartItems.add(new ItemDetail(b1,qty));
                }
            }
            sc.close();           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	public static String inpLineContainsItemsFromArray(String inpLine, String[] items)
    {
        for(int i =0; i < items.length; i++)
        {
            if(inpLine.contains(items[i]))
            {
               return items[i];
            }
        }
        return "others";
    }
    
	public void roundDigit(){
        BigDecimal f1=new BigDecimal(fst);
        BigDecimal f2=new BigDecimal(famt);
        MathContext m = new MathContext(4);
        totalSalesTax = f1.round(m);
        totalPrice = f2.round(m);
    } 
	
	public void printReceipt(){
		int numCount = cart.CartItems.size();
		for(int i = 0;i<numCount;i++){
			System.out.printf("%s: %.2f \n",cart.CartItems.get(i).item.getName(),cart.CartItems.get(i).getCost());
		}
		System.out.printf("\nSales Tax: %.2f \n",totalSalesTax);
		System.out.println("Total: " + totalPrice);
	}
	
}