public class ManagerApprover extends Approver {
    /**
     * Processes the purchase request. Approves if amount is <= 50000,
     * otherwise rejects the request.
     *
     * @param request the purchase request to process
     */
    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= 50000) {
            System.out.println(
                    "Manager approved the purchase of $" + request.getAmount() + " for " + request.getPurpose());
        } else {
            System.out.println("Purchase request for $" + request.getAmount() + " is too high, rejected.");
        }
    }
}