
import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;

public class Receipt {

	private ArrayList<Item> itemList = new ArrayList<Item>();
	private double fst=0;
	private double famt=0;
	private BigDecimal totalSalesTax,totalPrice;
	
	public Receipt(){
		
		try {
            Scanner sc= new Scanner(System.in);
            while(true){
                System.out.println("Add item in cart? (Y/N)");
                String order=sc.nextLine();
                if (order.equals("Y") || order.equals("y")){
                    System.out.println("Enter item name :");
                    String iname=sc.nextLine();
                    
                    System.out.println("Is it imported? (Y/N)");
                    String imported=sc.nextLine();
                    boolean isImp=imported.equals("Y")||imported.equals("y");
                    
                    System.out.println("Does it belong to food/medical/books category? (Y/N)");
                    String icat=sc.nextLine();
                    category c=(icat.equals("Y")||icat.equals("y"))?category.BOOK_MEDICAL_FOOD:category.OTHERS;
                    
                    System.out.println("Enter item price :");
                    double iprice=Double.parseDouble(sc.nextLine());
                    
                    Item b1=new Item(iname,iprice,isImp,c);
                    itemList.add(b1);
                }
                else{
                    break;
                }        
            }
            sc.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
    public void setItemPrice(){
        int itemCount=itemList.size();
        for( int i=0;i<itemCount;i++){
            double st1=itemList.get(i).getSalesTax();
            double p=itemList.get(i).getPrice();
            itemList.get(i).setPrice(st1+p);
        }
    }
    public void getTotalSalesTax(){
        int itemCount=itemList.size();
        for( int i=0;i<itemCount;i++){
            double st=itemList.get(i).getSalesTax();
            fst+=st;
        }
    }
    public void getTotal(){
        int itemCount=itemList.size();
        for( int i=0;i<itemCount;i++){
            double p=itemList.get(i).getPrice();
            famt+=p;
        }
    }
	public void roundDigit(){
        BigDecimal f1=new BigDecimal(fst);
        BigDecimal f2=new BigDecimal(famt);
        MathContext m = new MathContext(4);
        totalSalesTax = f1.round(m);
        totalPrice = f2.round(m);
    } 
	
	public void printReceipt(){
		int numCount = itemList.size();
		for(int i = 0;i<numCount;i++){
			System.out.printf("%s at %.2f \n",itemList.get(i).getName(),itemList.get(i).getPrice());
		}
		System.out.printf("Sales Tax: %.2f \n",totalSalesTax);
		System.out.println("Total: " + totalPrice);
	}
	
}