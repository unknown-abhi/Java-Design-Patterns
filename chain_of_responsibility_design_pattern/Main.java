public class Main {
    /**
     * Main method to demonstrate the Chain of Responsibility design pattern.
     * Sets up a chain of approvers and processes sample purchase requests.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Approver junior = new JuniorApprover();
        Approver senior = new SeniorApprover();
        Approver manager = new ManagerApprover();

        junior.setNextApprover(senior);
        senior.setNextApprover(manager);

        PurchaseRequest req1 = new PurchaseRequest(500, "Office supplies");
        PurchaseRequest req2 = new PurchaseRequest(5000, "Software license");
        PurchaseRequest req3 = new PurchaseRequest(25000, "New server");
        PurchaseRequest req4 = new PurchaseRequest(100000, "Company car");

        junior.processRequest(req1);
        junior.processRequest(req2);
        junior.processRequest(req3);
        junior.processRequest(req4);
    }
}