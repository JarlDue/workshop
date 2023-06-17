package kirkensgaard.examples.icecreamstore.domain;

public class IceCreamType {

    String flavor;

    public IceCreamType(String flavor){
        if(flavor == null){
            throw new NullPointerException("You are passing a null value to a non-null field");
        }
        this.flavor = flavor;
    }
    public String getFlavor() {
        return flavor;
    }
}
