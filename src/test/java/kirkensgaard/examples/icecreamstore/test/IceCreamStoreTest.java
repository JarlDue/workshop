package kirkensgaard.examples.icecreamstore.test;

import kirkensgaard.examples.icecreamstore.*;
import kirkensgaard.examples.icecreamstore.domain.BuyIceCreamRequest;
import kirkensgaard.examples.icecreamstore.domain.IceCream;
import kirkensgaard.examples.icecreamstore.domain.IceCreamType;
import kirkensgaard.examples.icecreamstore.paymenttypes.CashPayment;
import kirkensgaard.examples.icecreamstore.paymenttypes.CreditCard;
import kirkensgaard.examples.icecreamstore.strategies.PaymentStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IceCreamStoreTest {

    IceCreamStore iceCreamStore;


    /**
     * As a Customer, I want to be able to buy an IceCream with money
     * As a Customer, I want to be able to buy an IceCream with creditcard
     * As a Customer, I want to be able to buy an IceCream with PayPal
     */
    @Test
    public void canBuyIceWithCreditCardCream() {
        iceCreamStore = new LocalIceCreamStore();
        PaymentStrategy creditCard = new CreditCard();
        creditCard.addMoney(100);
        IceCreamType chocolateIceCreamType = new IceCreamType("chocolate");
        BuyIceCreamRequest buyIceCreamRequest = new BuyIceCreamRequest(chocolateIceCreamType, creditCard);
        IceCream chocolateIceCream = iceCreamStore.buyIceCream(buyIceCreamRequest);
        Assertions.assertEquals(IceCream.class, chocolateIceCream.getClass());
        Assertions.assertEquals(buyIceCreamRequest.getIceCreamType().getFlavor(), chocolateIceCream.getFlavor());

        IceCreamType vanillaIceCreamType = new IceCreamType("vanilla");
        BuyIceCreamRequest buyVanillaIceCreamRequest = new BuyIceCreamRequest(vanillaIceCreamType, creditCard);
        IceCream vanillaIceCream = iceCreamStore.buyIceCream(buyVanillaIceCreamRequest);

        Assertions.assertEquals(IceCream.class, vanillaIceCream.getClass());
        Assertions.assertEquals(buyVanillaIceCreamRequest.getIceCreamType().getFlavor(), vanillaIceCream.getFlavor());
    }

    @Test
    public void moneyIsCorrectlySubtractedWhenPayingWithCreditCard() {
        iceCreamStore = new LocalIceCreamStore();

        PaymentStrategy creditCard = new CreditCard();
        int amountOfMoneyAddedToCard = 100;
        creditCard.addMoney(amountOfMoneyAddedToCard);


        Assertions.assertEquals(creditCard.getAmountAvailable(), amountOfMoneyAddedToCard);
        int priceForVanilla = iceCreamStore.getPriceOfIceCream("vanilla");
        IceCreamType vanillaIceCreamType = new IceCreamType("vanilla");
        BuyIceCreamRequest buyVanillaIceCreamRequest = new BuyIceCreamRequest(vanillaIceCreamType, creditCard);
        IceCream vanillaIceCream = iceCreamStore.buyIceCream(buyVanillaIceCreamRequest);

        Assertions.assertEquals(amountOfMoneyAddedToCard - priceForVanilla, creditCard.getAmountAvailable());
    }

    @Test
    public void notEnoughMoneyOnCard() {
        iceCreamStore = new LocalIceCreamStore();
        PaymentStrategy creditCard = new CreditCard();
        IceCreamType chocolateIceCreamType = new IceCreamType("chocolate");
        BuyIceCreamRequest buyIceCreamRequest = new BuyIceCreamRequest(chocolateIceCreamType, creditCard);
        IceCream chocolateIceCream = iceCreamStore.buyIceCream(buyIceCreamRequest);
        Assertions.assertEquals(null, chocolateIceCream);
    }

    @Test
    public void ensureOnlineStoresDoNotAcceptCash() {
        iceCreamStore = new OnlineIceCreamStore();

        PaymentStrategy cash = new CashPayment();
        IceCreamType chocolateIceCreamType = new IceCreamType("chocolate");
        BuyIceCreamRequest buyIceCreamRequest = new BuyIceCreamRequest(chocolateIceCreamType, cash);
        Assertions.assertThrows(IllegalArgumentException.class, () -> iceCreamStore.buyIceCream(buyIceCreamRequest));
    }
}
