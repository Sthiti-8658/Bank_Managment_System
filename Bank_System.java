package java_projects;
import java.util.HashMap;
import java.util.Scanner;


public class Bank_System {
    private HashMap<String,User>users =new HashMap<>();

    public Bank_System(){
        //sample users
        users.put("1002345",new User("1002345","Alex","8658",5000));
        users.put("1006789",new User("1006789","litton","1234",3000));
    }
    public void start(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Welcome to Simple Bank System");

        System.out.println("Enter Account Number: ");
        String accNo =sc.nextLine();
        System.out.println("Enter PIN: ");
        String pin=sc.nextLine();

        User user =users.get(accNo);

        if(user !=null && user.getPin().equals(pin)) {
            System.out.println("Login successful.Welcome " + user.getName());

            int choice;
            do {
                System.out.println("\n1.Deposit\n2.Withdraw\n3.Balance\n4.Mini Statement\n5.Exit");
                System.out.print("Choose option: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter amount to deposit: ");
                        double amount = sc.nextDouble();
                        user.deposit(amount);
                        System.out.println("Amount deposited successfully.");
                    }
                    case 2 -> {
                        System.out.print("Enter amount to Withdraw: ");
                        double amount = sc.nextDouble();
                        if (user.withdraw(amount)) {
                            System.out.println("Withdraw successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    }
                    case 3 -> user.showBalance();
                    case 4 -> user.printMinistatement();
                    case 5 -> System.out.println("Thank you for using the bank System. ");
                    default -> System.out.println("Invalid option.");
                }
            } while (choice != 5);

        }else{
            System.out.println("Invalid account or PIN.");

        }
        sc.close();
    }

}