package kirkensgaard.examples.icecreamstore.paymenttypes;

import kirkensgaard.examples.icecreamstore.strategies.PaymentStrategy;

public class CashPayment implements PaymentStrategy {
    int amountOfMoneyAvailable;

    @Override
    public boolean payAmount(int amountToPay) {
        if(amountOfMoneyAvailable >= amountToPay){
            amountOfMoneyAvailable = amountOfMoneyAvailable - amountToPay;
            return true;
        }
        return false;
    }

    @Override
    public void addMoney(int amountToAdd) {
        amountOfMoneyAvailable = amountOfMoneyAvailable + amountToAdd;
    }

    @Override
    public int getAmountAvailable() {
        return amountOfMoneyAvailable;
    }
}
