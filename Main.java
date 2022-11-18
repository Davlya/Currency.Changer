import java.util.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main
{
   public static boolean authorization(int n, String loginUser, String passwordUser) {
      try{
         String line = Files.readAllLines(Paths.get("passwords.txt")).get(n);
         String [] log_pas = line.split(" ");
         String login = log_pas[0];
         String password = log_pas[1];
         if (loginUser.equals(login) && passwordUser.equals(password)){
            return true;
         }else {
            return false;
         }
      }
      catch(IOException e){
         System.out.println(e);
      }
      return true;
   }

   public static String chooseUsers() throws IOException {
      Scanner sc = new Scanner(System.in);

      System.out.println("Choose your profession:");
      System.out.println("(1) Director");
      System.out.println("(2) Worker");
      System.out.println("(3) User");
      do {
         System.out.print("Your choice: ");
         String choose = sc.nextLine();
         switch (choose) {
               case "director":
               case "Director":
               case "1":
                  System.out.println("Welcome dear Director");
                  System.out.println("Enter your login and password");
                  directorInputLgPw();
                  break;
               case "worker":
               case "Worker":
               case "2":
                  System.out.println("Welcome dear Worker");
                  System.out.println("Enter your login and password");
                  workerInputLgPw();
                  break;
               case "deliveryman":
               case "Deliveryman":
               case "3":
                  System.out.println("Welcome dear User");
                  System.out.println("Enter your login and password");
                  deliverymanInputLgPw();
                  break;
               default:
                  System.out.println("Who are Warrior?");
                  System.out.print("Желаете выйти[1] или повторить[0]?");
                  int ex = sc.nextInt();
                  if (ex == 0){
                     chooseUsers();
                  }
                  else if(ex == 1){
                     System.exit(0);
                  }
         }
         break;
      } while (true);
      return "";
   }

   public static void deliverymanInputLgPw() throws IOException {
      Scanner sc = new Scanner(System.in);

      do {
         System.out.print("Your password: ");
         String input_lg = sc.next();
         sc.nextLine();
         System.out.print("Your password: ");
         String input_pw = sc.next();
         sc.nextLine();

            boolean haveInArray = authorization(2, input_lg, input_pw);

            if (haveInArray) {
               System.out.println("Welcome dear User!");
               current_changer();
               break;
            } else {
               System.out.println("Попытайтесь снова.");
            }
      } while (true);
   }

   public static void directorInputLgPw() {
      Scanner sc = new Scanner(System.in);

      do {
         System.out.print("Your password: ");
         String input_lg = sc.next();
         sc.nextLine();
         System.out.print("Your password: ");
         String input_pw = sc.next();
         sc.nextLine();

         boolean haveInArray = authorization(0, input_lg, input_pw);

         if (haveInArray) {
               System.out.println("Директор, вы успешно вошли!");
               current_changer();
               break;
         } else {
               System.out.println("Попытайтесь снова");
         }
      } while (true);
   }

   public static void workerInputLgPw() throws IOException {
      Scanner sc = new Scanner(System.in);

      do {
            System.out.print("Введите логин: ");
            String input_lg = sc.next();
            sc.nextLine();
            System.out.print("Введите пароль: ");
            String input_pw = sc.next();
            sc.nextLine();

            boolean haveInArray = authorization(1, input_lg, input_pw);

            if (haveInArray) {
               System.out.println("Работник, вы успешно вошли!");
               current_changer();
               break;
            } else {
               System.out.println("Попытайтесь снова");
            }
      } while (true);
   }

   public static void current_changer()
   {
      int choice;
      double amount;
      double dollar, yuan, euro;

      Scanner sc = new Scanner(System.in);

      System.out.println("Options:");
      System.out.println("Enter 1: Dollar");
      System.out.println("Enter 2: Yuan");
      System.out.println("Enter 3: Euro");

      System.out.println("\nChoose your option: ");
      choice = sc.nextInt();
      System.out.println("Your number is: " + choice);

      System.out.println("Enter the amount you want to convert?");
      amount = sc.nextFloat();
      System.out.println("Your amount is: " + amount);

      switch (choice)
         {
         case 1:
            yuan = amount * 7.12;
            System.out.println(amount + " Dollar = " + yuan + " Yuan");
            euro = amount * 1.02;
            System.out.println(amount + " Dollar = " + euro + " Euro");
            break;

         case 2:
            dollar = amount * 0.14;
            System.out.println(amount + " Yuan = " + dollar + " Dollar");
            euro = amount * 0.14;
            System.out.println(amount + " Yuan = " + euro + " Euro");
            break;

         case 3:
            dollar = amount * 0.98;
            System.out.println(amount + " Euro = " + dollar + " Dollar");
            yuan = amount * 6.98;
            System.out.println(amount + " Euro = " + yuan + " Yuan");
            break;

         default:
            System.out.println("Invalid input");
         }
   }
   public static void main(String[] args) throws IOException {
      chooseUsers();

   }
}
