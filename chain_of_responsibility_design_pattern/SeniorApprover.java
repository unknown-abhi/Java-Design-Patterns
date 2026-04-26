public class SeniorApprover extends Approver {
    /**
     * Processes the purchase request. Approves if amount is <= 10000,
     * otherwise passes to the next approver in the chain.
     *
     * @param request the purchase request to process
     */
    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= 10000) {
            System.out.println("Senior Approver approved the purchase of $" + request.getAmount() + " for "
                    + request.getPurpose());
        } else if (nextApprover != null) {
            nextApprover.processRequest(request);
        } else {
            System.out.println("Purchase request for $" + request.getAmount() + " could not be approved.");
        }
    }
}