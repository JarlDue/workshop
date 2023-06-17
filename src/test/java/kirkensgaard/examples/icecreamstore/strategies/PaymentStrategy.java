package kirkensgaard.examples.icecreamstore.strategies;

public interface PaymentStrategy {

    boolean payAmount(int amountToPay);
    void addMoney(int amountToAdd);

    int getAmountAvailable();
}
