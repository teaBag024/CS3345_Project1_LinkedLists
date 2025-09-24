import java.awt.desktop.SystemEventListener;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        boolean flag = true;
        Scanner in = new Scanner(System.in);
        while(flag) {
            System.out.println(
                    "1. Make Empty\n" +
                            "2. Find ID\n" +
                            "3. Insert at Front\n" +
                            "4. Delete at Front\n" +
                            "5. Delete ID\n" +
                            "6. Print all Records\n" +
                            "7. Done");
            String userInput = in.nextLine();
            int userChoice = intParse(userInput);

            IDedObject.Product p;
            int id;
            switch (userChoice){
                case 1:
                    //make Empty
                    list.makeEmpty();
                    break;
                case 2:
                    //FindID
                    System.out.print("ID No: ");
                    userInput = in.nextLine();
                    id = intParse(userInput);

                    p = (IDedObject.Product) list.findID(id);
                    if(p == null) System.out.println("Not in our System :(");
                    else p.printID();

                    break;
                case 3:
                    //Insert At Front
                    System.out.print("Enter Product ID: ");
                    userInput = in.nextLine();
                    int new_id = intParse(userInput);

                    System.out.print("Enter Product Name: ");
                    userInput = in.nextLine();
                    String new_name = userInput;

                    System.out.print("Enter Product Supplier: ");
                    userInput = in.nextLine();
                    String new_supp = userInput;

                    p = new IDedObject.Product(new_id, new_name, new_supp);
                    if(list.insertAtFront(p)) {
                        System.out.println("Sucess!");
                    }else System.out.println("Somethings not right, theres a repeat?");

                    break;
                case 4:
                    //Delete at front
                    p = (IDedObject.Product) list.deleteFromFront();
                    if(p == null) System.out.println("List is empty");
                    else p.printID();

                    break;
                case 5:
                    //Delete ID
                    System.out.print("ID No: ");
                    userInput = in.nextLine();
                    id = intParse(userInput);

                    p = (IDedObject.Product) list.delete(id);
                    if(p == null) System.out.println("Not in our System :(");
                    else p.printID();

                    break;
                case 6:
                    //Print all records
                    list.printAllRecords();
                    break;
                case 7:
                    flag = false;
                    break;
            }



        }
        in.close();
    }

    /**
     *  Takes String and checks if it is number
     *  if is, return String as Int
     *  else, return -1
     * */
    private static int intParse(String s){
        try{
            int i = Integer.parseInt(s);
            return i;
        }catch (NumberFormatException e){
            System.out.println("Invalid Input!");
            return -1;
        }
    }
}