public class PurchaseRequest {
    private double amount;
    private String purpose;

    /**
     * Constructs a new PurchaseRequest with the specified amount and purpose.
     *
     * @param amount  the amount of the purchase
     * @param purpose the purpose of the purchase
     */
    public PurchaseRequest(double amount, String purpose) {
        this.amount = amount;
        this.purpose = purpose;
    }

    /**
     * Gets the amount of the purchase.
     *
     * @return the purchase amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the purpose of the purchase.
     *
     * @return the purchase purpose
     */
    public String getPurpose() {
        return purpose;
    }
}