package kirkensgaard.examples.icecreamstore.domain;

import kirkensgaard.examples.icecreamstore.strategies.PaymentStrategy;

public class BuyIceCreamRequest {
    public PaymentStrategy paymentStrategy;
    IceCreamType iceCreamType;

    public BuyIceCreamRequest(IceCreamType iceCreamType, PaymentStrategy paymentStrategy){
        this.iceCreamType = iceCreamType;
        this.paymentStrategy = paymentStrategy;
    }


    public IceCreamType getIceCreamType() {
        return iceCreamType;
    }
}
