package kirkensgaard.examples;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;


@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testCodingStandards() {
        //Method with guardclause
        System.out.println(guardClause("Hello World"));
        System.out.println(guardClause(null));
        System.out.println(cognitiveComplexity("Hello World"));
        System.out.println(rewrittenCognitiveComplexity("Hello World"));
        //Method with low cognitive complexity
        //Method with high cognitive complexity

        //Moving from abstract to concrete
        //Strategy Pattern
        PaymentMethod creditCard = new CreditCard();
        creditCard.addMoney(150);

        PaymentMethod cash = new Cash();
        cash.addMoney(5);

        System.out.println(purchaseIceCream("chocolate", cash));
        System.out.println(purchaseIceCream("chocolate", creditCard));

    }

    private String guardClause(String input) {
        if (input == null) {
            return "Why did you give me a null?";
        }
        return input.toLowerCase();
    }

    private String cognitiveComplexity(String input) {
        if (input != null) {
            if(input.length() > 10) {
                if(input.length() < 50){
                    return input.toLowerCase();
                }
                return input;
            }
            return input;
        }

        return "Why did you give me a null?";
    }

    private String rewrittenCognitiveComplexity(String input) {
        if (input == null) {
            return "Why did you give me a null?";
        }
        if(input.length() <= 10) {
            return input;
        }
        if(input.length() >= 50) {
            return input.toLowerCase();
        }
        return input;
    }
    private String purchaseIceCream(String flavor, PaymentMethod paymentMethod) {
        if (flavor == null) {
            return "Why did you give me a null?";
        }
        if(!isIceCreamFlavorAvailable(flavor)) {
            return "We don't have that flavor";
        }

        int costOfIcecream = getIceCreamCostByFlavor(flavor);

        if(paymentMethod == null) {
            return "Why did you give me a null?";
        }

        if(paymentMethod.pay(costOfIcecream)) {
            return "Here is your ice cream";
        }

        return "Sorry, but you don't have enough money";
    }

    private boolean isIceCreamFlavorAvailable(String flavor) {
        if (flavor == null) {
            return false;
        }
        if(flavor.equals("chocolate")) {
            return true;
        }
        if(flavor.equals("vanilla")) {
            return true;
        }
        if(flavor.equals("strawberry")) {
            return false;
        }
        return false;
    }

    private int getIceCreamCostByFlavor(String flavor) {
        if (flavor == null) {
            return 111111110;
        }
        if(flavor.equals("chocolate")) {
            return 10;
        }
        if(flavor.equals("vanilla")) {
            return 12;
        }
        if(flavor.equals("strawberry")) {
            return 11;
        }
        return 1111111110;
    }
}

interface PaymentMethod {
    boolean pay(int amount);
    void addMoney(int costOfIcecream);

}

class Cash implements PaymentMethod {
    int amount;
    @Override
    public boolean pay(int costOfIcecream) {
        if(amount - costOfIcecream >= 0) {
            amount -= costOfIcecream;
            return true;
        }
        return false;
    }

    @Override
    public void addMoney(int amount) {
        this.amount += amount;
    }
}

class CreditCard implements PaymentMethod {

    int creditCardValue = 0;

    @Override
    public boolean pay(int costOfIcecream) {
        if(creditCardValue - costOfIcecream >= 0) {
            creditCardValue -= costOfIcecream;
            return true;
        }
        return false;
    }

    @Override
    public void addMoney(int amount) {
        creditCardValue += amount;
    }
}
