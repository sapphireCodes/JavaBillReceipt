import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class MainClass{

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String iname,imported,icat;
        double iprice,fst=0,famt=0;
        boolean isImp;
        category c;
        while(true){
            System.out.println("Add item in cart? (Y/N)");
            String order=sc.nextLine();
            if (order.equals("Y") || order.equals("y")){
                System.out.println("Enter item name :");
                iname=sc.nextLine();
                
                System.out.println("Is it imported? (Y/N)");
                imported=sc.nextLine();
                isImp=imported.equals("Y")||imported.equals("y");
                
                System.out.println("Does it belong to food/medical/books category? (Y/N)");
                icat=sc.nextLine();
                c=(icat.equals("Y")||icat.equals("y"))?category.BOOK_MEDICAL_FOOD:category.OTHERS;
                
                System.out.println("Enter item price :");
                iprice=Double.parseDouble(sc.nextLine());
                
                Item b1=new Item(iname,iprice,isImp,c);
                double st=b1.getSalesTax();
                fst+=st;
                double totalprice=st+b1.price;
                famt+=totalprice;
            }
            else{
                break;
            }        
        }
        BigDecimal f1=new BigDecimal(fst);
        BigDecimal f2=new BigDecimal(famt);
        MathContext m = new MathContext(4);
        BigDecimal p1 = f1.round(m);
        BigDecimal p2 = f2.round(m);
        System.out.println("Total Sales Tax :"+p1);
        System.out.println("Total Amount :"+p2);
        sc.close();
    }
}