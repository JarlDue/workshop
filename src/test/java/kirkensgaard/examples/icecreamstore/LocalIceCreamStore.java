package kirkensgaard.examples.icecreamstore;

import kirkensgaard.examples.icecreamstore.domain.BuyIceCreamRequest;
import kirkensgaard.examples.icecreamstore.domain.IceCream;

public class LocalIceCreamStore implements IceCreamStore{
    @Override
    public IceCream buyIceCream(BuyIceCreamRequest buyIceCreamRequest) {
        int priceOfIceCream = priceOfIceCreamByType(buyIceCreamRequest.getIceCreamType().getFlavor());
        if(buyIceCreamRequest.paymentStrategy.payAmount(priceOfIceCream)) {
            switch (buyIceCreamRequest.getIceCreamType().getFlavor()) {
                case "vanilla" -> {return new IceCream("vanilla");}
                case "chocolate" -> {return new IceCream("chocolate");}
            }
        }

        return null;
    }

    @Override
    public int getPriceOfIceCream(String flavor) {
        switch (flavor) {
            case "vanilla" -> {
                return 20;
            }
            case "chocolate" -> {
                return 25;
            }
        }
        return 0;
    }

    private int priceOfIceCreamByType(String flavor) {
       return getPriceOfIceCream(flavor);
    }
}
