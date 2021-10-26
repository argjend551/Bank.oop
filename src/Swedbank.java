import java.util.ArrayList;
import java.util.Scanner;

public class Swedbank {

        public ArrayList<Account> Gothenburg = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();


    public void createAccount() {
        Scanner scan = new Scanner(System.in);

            System.out.println("Firstname: ");
            String firstname = scan.next();

        for (int i = 3; i > firstname.length();) {

            System.out.println("Invalid name! your name has to be at least 3 characters");
            System.out.println("Firstname: ");
            firstname = scan.next();

        }

            System.out.println("Lastname: ");
            String lastname = scan.next();

        for (int i = 3; i > lastname.length();) {

            System.out.println("Invalid lastname! your name has to be at least 3 characters");
            System.out.println("Lastname: ");
            lastname = scan.next();

        }

        for (Account account : Gothenburg) {
            if(firstname.equals(account.getFirstname()) && lastname.equals(account.getLastname()))
            {
                System.out.println("There already exit an account under that name.");
                menu.menu();
                break;
            }
        }
        firstname = firstname.substring(0,1).toUpperCase() + firstname.substring(1);
        lastname = lastname.substring(0,1).toUpperCase()+ lastname.substring(1);
        int pin;
        pin = PIN(1188,9231);
        System.out.println("Firstname: " + firstname);
        System.out.println("Lastname: " + lastname);
        System.out.println("Pin: " + pin);


            for (int i = 0; i < 1; i++) {
                Gothenburg.add(new Account(firstname, lastname, pin));
            }



    }
    public int PIN(int min,int max){
        return (int) (Math.random()*(max-min))+min;
    }


    public Account getAccount(String name,int pin) {

        for (Account account : Gothenburg) {
            if(name.equalsIgnoreCase(account.getFirstname()) && pin == account.getPIN())
           {
                System.out.println("Name: " + account.getFirstname() + " "+account.getLastname()+ " | Pin:" + account.getPIN() + " | Balance:"+ account.getBalance());
               break;
        }else if (name.equalsIgnoreCase(account.getFirstname()) && pin != account.getPIN()){
                for (int i = 2; i > 0; i--) {

                    System.out.println("Wrong pin.");
                    System.out.println("Tries left: " + i);
                    pin = scan.nextInt();
                    if (pin==account.getPIN()){
                        getAccount(name,pin);
                        break;
                    }
                }

            }else if(!name.equalsIgnoreCase(account.getFirstname())){
                System.out.println("Account not found.");
            }



        }

            return null;
    }






    public Account dePosit(String name,int pin) {

        for (Account account : Gothenburg) {
            if(name.equalsIgnoreCase(account.getFirstname()) && pin == account.getPIN()) {
                System.out.println("how much do you want to deposit?");
                double amount = scan.nextDouble();
                account.setBalance(account.getBalance() + amount);
                System.out.println("Deposit successful");
                System.out.println("New Balance: " + account.getBalance()+ " kr\n");
                break;
            }else if (name.equalsIgnoreCase(account.getFirstname()) && pin != account.getPIN()){
                for (int i = 2; i > 0; i--) {

                    System.out.println("Wrong pin.");
                    System.out.println("Tries left: " + i);
                    pin = scan.nextInt();
                    if (pin==account.getPIN()){
                        dePosit(name,pin);
                        break;
                    }
                }

            }else if(!name.equalsIgnoreCase(account.getFirstname())){
                System.out.println("Account not found.");
            }

            }

        return null;
    }

    public Account withDraw(String name,int pin) {

        for (Account account : Gothenburg) {
            if(name.equalsIgnoreCase(account.getFirstname()) && pin == account.getPIN()) {
                System.out.println("How much do you want to withdraw?");
                double amount = scan.nextDouble();
                if (account.getBalance()>amount){
                    account.setBalance(account.getBalance() - amount);
                    System.out.println("Withdraw successful");
                    System.out.println("New Balance: " + account.getBalance()+ " kr\n");
                    break;
                }
                System.out.println("Not enough money in your bank account.");
                break;

            } else if (name.equalsIgnoreCase(account.getFirstname()) && pin != account.getPIN()){
                for (int i = 2; i > 0; i--) {

                    System.out.println("Wrong pin.");
                    System.out.println("Tries left: " + i);
                    pin = scan.nextInt();
                    if (pin==account.getPIN()){
                        withDraw(name,pin);
                    }
                }

            }else if(!name.equalsIgnoreCase(account.getFirstname())){
                System.out.println("Account not found.");
            }

        }





        return null;
    }


    public Account transferMoney(String name,String name2) {

        System.out.println("Enter pin for " + name);
        int pin = scan.nextInt();

        for (Account account : Gothenburg) {
            if (name.equalsIgnoreCase(account.getFirstname()) && pin == account.getPIN()) {

                for (Account account2 : Gothenburg) {

                    if (name2.equalsIgnoreCase(account2.getFirstname())) {
                        System.out.println("How much do you want to transfer to " + name2);
                        int amount = scan.nextInt();
                        if (account.getBalance() > amount){
                            account.setBalance(account.getBalance() - amount);
                            account2.setBalance(account2.getBalance() + amount);
                            System.out.println("Transferring " + amount+":-");
                            System.out.println("Transfer successful.");
                            return account2;

                        }
                        System.out.println("Not enough money in your bank account.");
                        return null;

                    }


                }


            } else{
                System.out.println("Wrong pin");
            }



        }




        System.out.println("Account not found.");
        return null;
    }


    public Account changePin(String name,int pin){
        for (Account account : Gothenburg) {
            if (name.equalsIgnoreCase(account.getFirstname()) && pin == account.getPIN()) {

                    System.out.println("New pin: ");
                    String newPin = scan.next();
                    for (int i = 4; i > newPin.length();) {

                        System.out.println("Invalid enter a 4-digit number");
                        System.out.println("New pin: ");
                        newPin = scan.next();
                    }
                    account.setPIN(Integer.parseInt(newPin));
                System.out.println("Your new pin is: " + account.getPIN());
                    return account;

                }else{
                System.out.println("Wrong pin");

            }
            System.out.println("Account not found.");


            }
        return null;


        }


}
