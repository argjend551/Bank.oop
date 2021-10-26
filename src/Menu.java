import java.util.Scanner;

public class Menu {


    public void menu(){
        Swedbank bank = new Swedbank();
        Scanner scan = new Scanner(System.in);
        System.out.println("----------------------------------------------------------");
        System.out.println("Welcome to Swedbank! , Choose between 1-5 in the menu");
        System.out.println("1. Create new bank account");
        System.out.println("2. Account info");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Transfer money");
        System.out.println("6. Change pin");
        System.out.println("7. Exit");
        System.out.println("----------------------------------------------------------");

        int val = scan.nextInt();

        while(val < 8)
        {


            switch (val){
                case 1:
                bank.createAccount();
                break;
                case 2:

                    System.out.println("Login in");
                    System.out.println("Firstname");
                    String name = scan.next();
                    System.out.println("Pin");
                    int pin = scan.nextInt();


                    bank.getAccount(name,pin);
                    break;
                case 3:
                    System.out.println("Login in");
                    System.out.println("Firstname");
                    String name1 = scan.next();
                    System.out.println("Pin");
                    int pin1 = scan.nextInt();
                    bank.dePosit(name1,pin1);
                    break;

                case 4:
                    System.out.println("Login in");
                    System.out.println("Firstname");
                    String name2 = scan.next();
                    System.out.println("Pin");
                    int pin2 = scan.nextInt();
                    bank.withDraw(name2,pin2);
                    break;
                case 5:
                    System.out.println("Enter account you want to transfer from (Firstname)");
                    String name3 = scan.next();
                    System.out.println("Enter the account you want to transfer to (Firstname)");
                    String name4 = scan.next();
                    bank.transferMoney(name3,name4);
                    break;

                case 6:
                    System.out.println("Enter account Firstname");
                    String a = scan.next();
                    System.out.println("Enter pin");
                    int pin3 = scan.nextInt();
                    bank.changePin(a,pin3);
                    break;

                case 7:
                    System.out.println("Exiting..");
                    System.exit(0);

            }


            System.out.println("----------------------------------------------------------");
            System.out.println("1. Create new bank account");
            System.out.println("2. Account info");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer money");
            System.out.println("6. Change pin");
            System.out.println("7. Exit");
            System.out.println("-------------------------------------------------------");
            val = scan.nextInt();

        }


    }

}
