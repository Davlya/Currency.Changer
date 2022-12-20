import java.util.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main
{
   public class MyWindowApp extends JFrame { //Наследуя от JFrame мы получаем всю функциональность окна

      public MyWindowApp(){
        super("Обмен Валют");
        setBounds(100, 100, 200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
    
      public static void main(String[] args) {
        MyWindowApp app = new MyWindowApp();
        app.setVisible(true);
      }
    }
    
   // public class VoronCalc extends JFrame {
   //    private int voron = 0;
   //    private JLabel countLabel;
   //    private JButton addCrow;
   //    private JButton removeCrow;
    
      // public VoronCalc(){
      //   super("Crow calculator");
      //   //Подготавливаем компоненты объекта
      //   countLabel = new JLabel("Crows:" + voron);
      //   addCrow = new JButton("Add Crow");
      //   removeCrow = new JButton("Remove Crow");
    
      //   JPanel buttonsPanel = new JPanel(new FlowLayout()); 
      //   buttonsPanel.add(countLabel, BorderLayout.NORTH);
    
      //   buttonsPanel.add(addCrow);
      //   buttonsPanel.add(removeCrow);
    
      //   add(buttonsPanel, BorderLayout.SOUTH);
      //   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // }

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

   public static void directorActions() {
      Scanner sc = new Scanner(System.in);

      System.out.println("Меню:");
      System.out.println("(1)Показать список всей бытовой техники");
      System.out.println("(2)Показать количество бытовой техники");
      System.out.println("(3)Максимальное количество бытовой техники");
      System.out.println("(4)Минимальное количество бытовой техники");
      System.out.println("(5)Отчет по закупкам бытовой техники");
      System.out.println("(0)Выход");
      do {
          System.out.print("Ваш выбор: ");
          String chooseAction = sc.nextLine();
          switch (chooseAction) {
              case "action1":
              case "Action1":
              case "1":
                  System.out.println("Действие 1");
                  action1();
                  directorActions();
                  break;
              case "action2":
              case "Action2":
              case "2":
                  System.out.println("Действие 2");
                  action2();
                  directorActions();
                  break;
              case "action3":
              case "Action3":
              case "3":
                  System.out.println("Действие 3");
                  action3();
                  directorActions();
                  break;
              case "action4":
              case "Action4":
              case "4":
                  System.out.println("Действие 4");
                  action4();
                  directorActions();
                  break;
              case "action5":
              case "Action5":
              case "5":
                  System.out.println("Действие 5");
                  action5();
                  directorActions();
                  break;
              default:
                  System.out.println("Такого действия нет в программе!");
                  directorActions();
                  break;
              case "n":
                  try {
                      chooseUsers();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              case "action0":
              case "Action0":
              case "0":
                  System.out.println("Выход");
                  break;
          }
          break;
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
      // **********************************************************************
      // public static void Menu() throws IOException{
      //       System.out.println("1. Показать весь список бытовой техники в магазине");
      //       System.out.println("2. Искать бытовую технику");
      //       System.out.println("3. Показать отчет по бытовой технике");
      //       System.out.println("4. Выполнить заказ бытовой техники");
      //       System.out.println("5. Посмотреть список заказаной бытовой тенхники");
      //       System.out.println("6. Показать отсутствующие на складе бытовые техники");
      //       System.out.println("7. Показать все бытовые техники, на которых действует скидка");
      //       System.out.println("8. Удалить заказ");
      //       System.out.println("9. Выход");
      //       ShowMenu();
      //   }
      //   public static void ShowMenu() throws IOException{
      //       Scanner input = new Scanner(System.in);
      //       while (true){
      //           System.out.print("(Чтобы увидеть меню снова, нажмите [0]) Введите-->");
      //           var action = input.nextLine();
      //           switch(action){
      //               case "0": Menu(); break;
      //               case "1": ShowFullList(); break;
      //               case "2": Search(); break;
      //               case "3": ShowReport(); break;
      //               case "4": Order(); break;
      //               case "5": OrderList(); break;
      //               case "6": Lack(); break;
      //               case "7": Discount(); break;
      //               case "8": Delete(); break;
      //               case "n":
      //                   try {
      //                       chooseUsers();
      //                   } catch (IOException e) {
      //                       e.printStackTrace();
      //                   }
      //               case "9": exit(); break;
      //               default: System.out.print("Пожалуйста, введите номера из меню.");
      //           }
      //       }
      //   }
      //   private static void ShowFullList() throws FileNotFoundException, IOException{
      //       try {
      //           FileInputStream file= new FileInputStream(new File("C:\\Users\\ainura_inai\\IdeaProjects\\Sample\\src\\БытоваяТехника.xlsx"));
      //           XSSFWorkbook workbook = new XSSFWorkbook(file);
      //           XSSFSheet sheet = workbook.getSheetAt(0);
      //           Iterator<Row> rowIterator = sheet.iterator();

      //           while (rowIterator.hasNext()){
      //               Row row = rowIterator.next();
      //               for(var colIndex = 0; colIndex < 3; colIndex += 2)
      //               {
      //                   Cell cell = row.getCell(colIndex);
      //                   switch (cell.getCellType()){
      //                       case Cell.CELL_TYPE_NUMERIC:
      //                           System.out.printf("%.0f", cell.getNumericCellValue());
      //                           break;
      //                       case Cell.CELL_TYPE_STRING:
      //                           System.out.print(cell.getStringCellValue()+ "\t\t");
      //                           break;
      //                   }
      //               }
      //               System.out.println();
      //           }
      //           file.close();
      //       }
      //       catch(Exception e){
      //           System.out.println("Smth is wrong!");
      //       }
      //   }
   }
}
