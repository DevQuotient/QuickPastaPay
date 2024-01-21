// DishManagement class
package quickpastapay.com.Dish;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DishManagement {
    private final BigDecimal priceOfPastaForStudent = BigDecimal.valueOf(0.60);
    private final BigDecimal priceOfPastaForWorker = BigDecimal.valueOf(0.80);
    private final BigDecimal priceOfPastaForVisitor = BigDecimal.valueOf(1.0);
    private BigDecimal totalAmount;
    private String customerCategory;
    private ArrayList<Dish> listOfDishes;

    public DishManagement() {
        listOfDishes = new ArrayList<>();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(String customerCategory) {
        this.customerCategory = customerCategory;
    }

    public BigDecimal calculateTotalAmountOfTheOrder(String customerCategory) {
        if (customerCategory.equalsIgnoreCase("Student")) {
            this.setTotalAmount(priceOfPastaForStudent);
            System.out.println("Total amount for a " + this.getCustomerCategory() + " is: " + priceOfPastaForStudent + "$");
        } else if (customerCategory.equalsIgnoreCase("Worker")) {
            this.setTotalAmount(priceOfPastaForWorker);
            System.out.println("Total amount for a " + this.getCustomerCategory() + " is: " + priceOfPastaForWorker + "$");
        } else if (customerCategory.equalsIgnoreCase("Visitor")) {
            this.setTotalAmount(priceOfPastaForVisitor);
            System.out.println("Total amount for a " + this.getCustomerCategory() + " is: " + priceOfPastaForVisitor + "$");
        } else {
            System.out.println(LocalDateTime.now() + " Unknown category!" + "\n" + "Please contact the service provider");
        }

        return getTotalAmount();
    }

    public void showDetailsOfTheOrder(Dish dish) {
        System.out.println(LocalTime.now());
        System.out.println(dish.toString());
        System.out.println("Total Amount: " + this.getTotalAmount() + "$");
    }

    public boolean printReceipt(Dish dish, boolean answer, String customerCategory) {
        boolean positiveResponse = answer;
        if (positiveResponse) {
            System.out.println("---Receipt---");
            System.out.println(LocalDateTime.now());
            showDetailsOfTheOrder(dish);
        } else {
            System.out.println("Proceeding to Payment Process");
        }
        return true;
    }

    public String addADishtoTheList(Dish dish) {
        listOfDishes.add(dish);
        System.out.println("List of Orders:" + "\n" + listOfDishes.toString());
        return listOfDishes.toString();
    }

    public void showMenu() {


        try {
            Scanner input = new Scanner(System.in);

            mainLoop:
            while (true) {
                System.out.println("\uD83C\uDF5D Welcome to QuickPastaPay \uD83C\uDF5D");
                System.out.println("For a delightful experience, pasta orders must include both cheese and sauce. Orders without selecting sauce and cheese will not be processed.");
                System.out.println("\uD83D\uDC49 Remember: Your satisfaction is our priority! Follow the given instructions for a perfect pasta meal.");
                System.out.println("🚀 To proceed with your order, type 'yes'. If you want to cancel, type 'no'.");

                String response = input.next();
                if (response.equalsIgnoreCase("yes")) {
                    Dish dish = new Dish();

                    // Type of Pasta
                    System.out.println("Please select the number of your desired type of Pasta \uD83C\uDF5D: " + "\n" + "1.FUSILLI" + "\n" + "2.FARFALLE" + "\n" + "3.PENNE");
                    System.out.println("Notice: If you choose a number less than 1 or larger than 3, the program will restart automatically.");
                    int choosenNumber = input.nextInt();
                    if (choosenNumber < 1 || choosenNumber > 3) {
                        System.out.println("Only numbers between 1 and 3 are allowed!");
                        continue mainLoop;  // Restart the program from the beginning
                    }
                    switch (choosenNumber) {
                        case 1:
                            dish.setTypeOfPasta(TypeOfPasta.FUSILLI);
                            break;
                        case 2:
                            dish.setTypeOfPasta(TypeOfPasta.FARFALLE);
                            break;
                        case 3:
                            dish.setTypeOfPasta(TypeOfPasta.PENNE);
                            break;
                    }

                    // Type of Sauce
                    System.out.println("Please select the number of your desired type of Sauce \uD83C\uDF72: " + "\n" + "1.BOLOGNESE" + "\n" + "2.BÉCHAMEL" + "\n" + "3.ALFREDO");
                    System.out.println("Notice : If you choose a number less than 1 or larger than 3, the program will restart automatically.");
                    int sauceChoice = input.nextInt();
                    if (sauceChoice < 1 || sauceChoice > 3) {
                        System.out.println("Only numbers between 1 and 3 are allowed!");
                        continue mainLoop;  // Restart the program from the beginning
                    }
                    switch (sauceChoice) {
                        case 1:
                            dish.setTypeOfSauce(TypeOfSauce.BOLOGNESE);
                            break;
                        case 2:
                            dish.setTypeOfSauce(TypeOfSauce.BÉCHAMEL);
                            break;
                        case 3:
                            dish.setTypeOfSauce(TypeOfSauce.ALFREDO);
                            break;
                    }

                    // Type of Cheese
                    System.out.println("Please select the number of your desired type of Cheese \uD83E\uDDC0: " + "\n" + "1. EMMENTAL" + "\n" + "2. GOUDA" + "\n" + "3. MOZZARELLA");
                    System.out.println("Notice : If you choose a number less than 1 or larger than 3, the program will restart automatically.");
                    int cheeseChoice = input.nextInt();
                    if (cheeseChoice < 1 || cheeseChoice > 3) {
                        System.out.println("Only numbers between 1 and 3 are allowed!");
                        continue mainLoop;  // Restart the program from the beginning
                    }
                    switch (cheeseChoice) {
                        case 1:
                            dish.setTypeOfCheese(TypeOfCheese.EMMENTAl);
                            break;
                        case 2:
                            dish.setTypeOfCheese(TypeOfCheese.GOUDA);
                            break;
                        case 3:
                            dish.setTypeOfCheese(TypeOfCheese.MOZZARELLA);
                            break;
                    }

                    // Category
                    System.out.println("Please select the number of your Category: " + "\n" + "1.STUDENT" + "\n" + "2.WORKER" + "\n" + "3.VISITOR");
                    System.out.println("Notice : If you choose a number less than 1 or larger than 3, the program will restart automatically.");
                    int numberOfCategory = input.nextInt();
                    if (numberOfCategory < 1 || numberOfCategory > 3) {
                        System.out.println("Only numbers between 1 and 3 are allowed!");
                        continue mainLoop;  // Restart the program from the beginning
                    }
                    switch (numberOfCategory) {
                        case 1:
                            setCustomerCategory("Student");
                            calculateTotalAmountOfTheOrder(this.getCustomerCategory());
                            addADishtoTheList(dish);
                            break;
                        case 2:
                            setCustomerCategory("Worker");
                            addADishtoTheList(dish);
                            calculateTotalAmountOfTheOrder(this.getCustomerCategory());
                            break;
                        case 3:
                            setCustomerCategory("Visitor");
                            addADishtoTheList(dish);
                            calculateTotalAmountOfTheOrder(this.getCustomerCategory());
                            break;
                    }
                } else if (response.equalsIgnoreCase("no")) {
                    System.out.println("Order canceled. Exiting...");
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Only numbers are allowed :)");
        } catch (Exception e) {
            System.out.println("Unspecified error!");
        }


    }
}


