public class Account {
    private String firstname;
    private String lastname;
    private int PIN;
    private double balance;

    public Account(String firstname,String lastname, int PIN) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.PIN = PIN;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}