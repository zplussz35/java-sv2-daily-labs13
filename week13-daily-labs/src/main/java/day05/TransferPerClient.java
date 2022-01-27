package day05;

public class TransferPerClient {
    private String clientId;
    private int sum;
    private int numberOfTransactions;

    public TransferPerClient(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public int getSum() {
        return sum;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void increaseSum(int sum) {
        this.sum += sum;
        this.numberOfTransactions++;
    }

    public void decreaseSum(int sum) {
        this.sum -= sum;
        this.numberOfTransactions++;
    }

    @Override
    public String toString() {
        return clientId + " " + sum + " " + numberOfTransactions;
    }
}
