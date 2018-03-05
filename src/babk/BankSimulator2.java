package babk;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This program demonstrates random access. You can access existing accounts and
 * deposit money, or create new accounts. The accounts are saved in a random
 * access file.
 */
public class BankSimulator2 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BankData data = new BankData();
        Map<Integer, Integer> accountMap = loadHashMap(data);

        try {
            data.open("bank.dat");

            boolean done = false;
            while (!done) {
                System.out.print("Account number: ");
                int accountNumber = in.nextInt();
                System.out.print("Amount to deposit: ");
                double amount = in.nextDouble();

//                int recNum = accountMap.get(accountNumber);
System.out.println("rec num: " + accountMap.get(accountNumber));
                    int recNum = 1;
//                int position = data.find(accountNumber);
                int position = data.size();
                BankAccount account;
                if (recNum >= 0) {
                    account = data.read(recNum);
                    account.deposit(amount);
                    System.out.println("New balance: " + account.getBalance());
                } else // Add account
                {
                    account = new BankAccount(accountNumber, amount);

                    System.out.println("Adding new account.");
                }
                data.write(position, account);

                System.out.print("Done? (Y/N) ");
                String input = in.next();
                if (input.equalsIgnoreCase("Y")) {
                    done = true;
                }
            }
        } finally {
            data.close();
        }
    }

    public static Map<Integer, Integer> loadHashMap(BankData data) throws IOException {
        Scanner in = new Scanner(System.in);
        Map<Integer, Integer> accountMap = new HashMap<>();

        int position = 0;
        int count = 0;

        try {
            data.open("bank.dat");

            while (count < data.size()) {

//            int position = data.find(accountNumber);
                BankAccount account = data.read(position);
                accountMap.put(account.getAccountNumber(), position);
                count++;

            }
        } finally {
            data.close();
        }

        return accountMap;
    }

}
