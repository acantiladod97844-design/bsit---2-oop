public class InsufficientResourcesException extends Exception {

    private final double shortfall;

    public InsufficientResourcesException(double shortfall) {
        super("Insufficient funds. You are short by PHP "
                + String.format("%.2f", shortfall));

        this.shortfall = shortfall;
    }

    public double getShortfall() {
        return shortfall;
    }
}