import java.util.ArrayList;
import java.util.List;

public class Cart {
    public List<ItemDetail> CartItems;
    private double TotalTax;
    private double TotalCost;

    public Cart(){
        CartItems=new ArrayList<ItemDetail>();
    }
    public void setTotalTax(){
        double sum=0;
        for (ItemDetail iDetail : CartItems) {
            sum+=iDetail.getSalesTax();
        }
        TotalTax= sum;
    }
    public void setTotalCost(){
        double sum=0;
        for (ItemDetail iDetail : CartItems) {
            sum+=iDetail.getCost();
        }
        TotalCost= sum;
    }
    public double getTotalTax(){
        return TotalTax;
    }
    public double getTotalCost(){
        return TotalCost;
    }



}
