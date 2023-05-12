import java.util.Scanner;
import java.util.ArrayList;


public class Main {
        public static ArrayList<BankAccount> account = new ArrayList <>();
        public static void main (String[] args) {
            Scanner scan = new Scanner(System.in);
            account.add(new BankAccount("Ong",3000, 001 ));
            account.add(new BankAccount("Nick",250, 002 ));
            account.add(new BankAccount("Jack",4000, 003 ));
            account.add(new BankAccount("Ally",3000, 004 ));
            account.add(new BankAccount("Sheena",2580, 005 ));
            account.add(new BankAccount("Tony",4060, 006 ));


            System.out.println("Hello world! Welcome to the Bank of Ong!");
            System.out.println("Are you an existing customer? (-1 to exit)");
            System.out.println("1. Yes");
            System.out.println("2. No");
            Integer start = Integer.valueOf(scan.nextLine());

            if (start == 1) {
                System.out.println("Please enter Account Number");
                Integer requestAccount = Integer.valueOf(scan.nextLine());
                boolean targetAccount = false;
                int index = -1;

                for (int a = 0; a < account.size(); a++) {
                    if (account.get(a).getAccountId() == requestAccount) {
                        targetAccount = true;
                        index = a;
                    }
                }
                if (!targetAccount) {
                    System.out.println("Account not found");
                } else if (targetAccount && index >= 0) {
                    mainMenu(account.get(index));
                }
            } else if (start == 2) {
                System.out.println("Let's make a new account!");
                System.out.println("What is the name of the account?");
                String name = scan.nextLine();
                System.out.println("What is the beginning balance for the account?");
                Double accountBalance = Double.parseDouble(scan.nextLine());
                Integer accountId = (int) (Math.random());
                account.add(new BankAccount(name, accountBalance, accountId));
                mainMenu(account.get((account.size() - 1)));
            } else {
                System.out.println("Have a good day!");

            }
        }
        public static void mainMenu(BankAccount account){
            System.out.println("Hello " + account.getAccountName());
            System.out.println("Welcome to the Main Menu, What would you like to do today?");

            while(true){
                System.out.println("1. To check account blanace");
                System.out.println("2. To make a withdrawl");
                System.out.println("3. To make a deposit");
                System.out.println("4. To make a transfer to an another account");
                System.out.println("5. To exit.");
                Scanner scan= new Scanner(System.in);

                Integer response = Integer.valueOf(scan.nextLine());

                if (response == 1){
                    System.out.println("Your account balance is: $" + account.getAccountBalance());
                } else if( response == 2){
                    System.out.println("Enter amount to withdrawl");
                    double withdrawalAmount = scan.nextDouble();
                    account.withdrawal(withdrawalAmount);
                    System.out.println( account.getAccountBalance());
                }else if ( response == 3){
                    System.out.println("Enter amount to deposit");
                    double depositAmount = scan.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println(account.getAccountBalance());
                }else if(response == 4){
                    System.out.println("Enter account number");
                    int accountRequest = Integer.valueOf(scan.nextLine());
                    boolean targetAccount = false;
                    int index =-1;


                    for(int i =0; i < account.size(); i ++){
                        if (account.get(i).getAccountId()== accountRequest){
                            targetAccount = true;
                            index= i;
                        }
                    }
                    if (targetAccount && index >= 0){
                        System.out.println("Enter transfer amount");
                        double transferAmount = Double.valueOf(scan.nextLine());
                        account.transfer(account.get(index), transferAmount);
                        System.out.println(" Transfer $" + transferAmount + " from " +account.get(index));

                    }else{
                        System.out.println("Sorry, unable to find Account Number. Try again.");
                    }
                }else if (response == 5){
                    System.out.println("Have a nice day!");
                    break;
                }

            }
        }
    }
