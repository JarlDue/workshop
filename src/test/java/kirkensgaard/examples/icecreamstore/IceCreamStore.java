package kirkensgaard.examples.icecreamstore;

import kirkensgaard.examples.icecreamstore.domain.BuyIceCreamRequest;
import kirkensgaard.examples.icecreamstore.domain.IceCream;

public interface IceCreamStore {
    IceCream buyIceCream(BuyIceCreamRequest buyIceCreamRequest);

    int getPriceOfIceCream(String flavor);
}
