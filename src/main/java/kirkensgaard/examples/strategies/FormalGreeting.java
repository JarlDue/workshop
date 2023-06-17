package kirkensgaard.examples.strategies;

public class FormalGreeting implements GreetingStrategy{

        @Override
        public String getGreeting(String name) {
            return "Hello " + name + ", how are you?";
        }
}
