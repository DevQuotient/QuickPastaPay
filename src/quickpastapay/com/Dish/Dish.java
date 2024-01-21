// Dish class
package quickpastapay.com.Dish;

import java.math.BigDecimal;

/**
 * This is the Dish class, which contains the most relevant attributes and methods.
 */
public class Dish {
    private TypeOfPasta typeOfPasta;
    private TypeOfSauce typeOfSauce;
    private TypeOfCheese typeOfCheese;

    private BigDecimal priceofTheDish;

    public Dish() {
    }

    public TypeOfPasta getTypeOfPasta() {
        return typeOfPasta;
    }

    public void setTypeOfPasta(TypeOfPasta typeOfPasta) {
        this.typeOfPasta = typeOfPasta;
    }

    public TypeOfSauce getTypeOfSauce() {
        return typeOfSauce;
    }

    public void setTypeOfSauce(TypeOfSauce typeOfSauce) {
        this.typeOfSauce = typeOfSauce;
    }

    public TypeOfCheese getTypeOfCheese() {
        return typeOfCheese;
    }

    public void setTypeOfCheese(TypeOfCheese typeOfCheese) {
        this.typeOfCheese = typeOfCheese;
    }

    public BigDecimal getPriceofTheDish() {
        return priceofTheDish;
    }

    public void setPriceofTheDish(BigDecimal priceofTheDish) {
        this.priceofTheDish = priceofTheDish;
    }

    @Override
    public String toString() {
        return "Type of Pasta: " + this.getTypeOfPasta() +
                "\nType of Sauce: " + this.getTypeOfSauce() +
                "\nType of Cheese: " + this.getTypeOfCheese();
    }
}