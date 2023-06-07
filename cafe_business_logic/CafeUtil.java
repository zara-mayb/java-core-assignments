import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil {
    public int getStreakGoal(int numWeeks){
        int drinks = 0;
        for(int i = 0; i <= numWeeks; i++){
            drinks += i;
        }
        return drinks;
    }
    public double getOrderTotal(double[] prices){
        double total = 0.0;
        for (double price : prices){
            total += price;
        }
        return total;
    }
    public void displayMenu(ArrayList<String> menuItems){
        for (int i = 0; i < menuItems.size(); i++){
            String item = menuItems.get(i);
            System.out.println(i + item);
        }
    }
    public void addCustomer(ArrayList<String> customerList){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello," + userName);
        System.out.println("There are" + customerList.size() + "people in front of you");
        customerList.add(userName);
        System.out.println(customerList);
    }
}
