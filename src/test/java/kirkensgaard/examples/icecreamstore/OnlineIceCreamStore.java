package kirkensgaard.examples.icecreamstore;

import kirkensgaard.examples.icecreamstore.domain.BuyIceCreamRequest;
import kirkensgaard.examples.icecreamstore.domain.IceCream;
import kirkensgaard.examples.icecreamstore.paymenttypes.CashPayment;

public class OnlineIceCreamStore implements IceCreamStore {
    @Override
    public IceCream buyIceCream(BuyIceCreamRequest buyIceCreamRequest) {
        if(buyIceCreamRequest.paymentStrategy.getClass().equals(CashPayment.class)){
            throw new IllegalArgumentException("We are sorry, but we do not accept cash payment");
        }
        return null;
    }

    @Override
    public int getPriceOfIceCream(String flavor) {
        return 0;
    }
}
