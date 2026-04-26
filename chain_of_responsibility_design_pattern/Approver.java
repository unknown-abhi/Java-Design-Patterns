public abstract class Approver {
    protected Approver nextApprover;

    /**
     * Sets the next approver in the chain of responsibility.
     *
     * @param nextApprover the next approver to handle the request if this one
     *                     cannot
     */
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    /**
     * Processes the purchase request. Subclasses must implement this method
     * to handle the request or pass it to the next approver.
     *
     * @param request the purchase request to process
     */
    public abstract void processRequest(PurchaseRequest request);
}