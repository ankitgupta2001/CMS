package com.cms.tester;

import com.cms.customer.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static com.cms.utils.CMSValidations.*;
import static com.cms.utils.CustomerValidations.*;

public class CustomerManagementSystem {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = false;
            List<Customer> accounts = new ArrayList<>();
            while (!exit) {
                try {
                    System.out.println("1.Enter User Details\n 2.Display AllUsers\n 3. To Login\n 4.To Unsubscribe 0.Exit");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println(
                                    "Enter Customer Details\n Firstname Lastname Email Password RegistrationAmount DOB plan");
                            Customer c = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),
                                    sc.next(), sc.next(), accounts);
                            accounts.add(c);
                            break;
                        case 2:
                            // Display All Users
                            for (Customer customerAccount : accounts) {
                                System.out.println(customerAccount);
                            }
                            break;
                        case 3:
                            // log in
                            System.out.println("Enter  Email and Password");
                            Customer newUser = verifyUser(sc.next(), sc.next(), accounts);
                            System.out.println("To reset Password press 1 and any other key to goto menu");
                            int n = sc.nextInt();
                            if(n == 1){
                                System.out.println("Enter New Password");
                                resetPassword(sc.next(),newUser);
                                System.out.println("New Details");
                                System.out.println(newUser);
                            }
                            break;
                        case 4:
                            //UnSubscribe
                            System.out.println("Enter  Email and Password");
                            Customer loggedUser = verifyUser(sc.next(), sc.next(), accounts);
                            unsubscribe(loggedUser, accounts);
                            System.out.println("User unSubscribe");
                            break;
                        case 0:
                            exit = true;
                            System.exit(0);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
            }
        }
    }
}
