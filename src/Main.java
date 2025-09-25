import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<IDedObject.Product> list = new LinkedList<IDedObject.Product>();

        boolean flag = true;    // flag = false if user is "done"
        Scanner in = new Scanner(System.in);
        while(flag) {
            System.out.println(
                    "\n==================================================================\n" +
                    "1. Make Empty\n" +
                            "2. Find ID\n" +
                            "3. Insert at Front\n" +
                            "4. Delete at Front\n" +
                            "5. Delete ID\n" +
                            "6. Print all Records\n" +
                            "7. Done");
            String userInput = in.nextLine();
            int userChoice = intParse(userInput);

            // shared variables.
            IDedObject.Product p;
            int id;
            switch (userChoice) {
                case 1: //make Empty
                    list.makeEmpty();
                    break;
                case 2: // FindID
                    // Get id to find in list
                    System.out.print("ID No: ");
                    userInput = in.nextLine();
                    id = intParse(userInput);

                    // find
                    p = list.findID(id);
                    if (p == null) System.out.println("Not in our System :(");
                    else p.printID();

                    break;
                case 3: //Insert At Front
                    // Get Product information
                    System.out.print("Enter Product ID: ");
                    userInput = in.nextLine();
                    id = intParse(userInput);
                    while(id == -1){            // repeat until valid id
                        userInput = in.nextLine();
                        id = intParse(userInput);
                    }

                    System.out.print("Enter Product Name: ");
                    userInput = in.nextLine();
                    String new_name = userInput;

                    System.out.print("Enter Product Supplier: ");
                    userInput = in.nextLine();
                    String new_supp = userInput;

                    // make new Product object
                    p = new IDedObject.Product(id, new_name, new_supp);
                    // insert and check if successful
                    if (list.insertAtFront(p)) {
                        System.out.println("Product Added!");
                    } else System.out.println("Somethings not right, theres a repeat?");

                    break;
                case 4: //Delete at front
                    p = list.deleteFromFront();
                    if (p == null) System.out.println("List is empty");
                    else {
                        System.out.println("Deleted: ");
                        p.printID();
                    }

                    break;
                case 5: //Delete ID
                    // Get id to delete
                    System.out.print("ID No: ");
                    userInput = in.nextLine();
                    id = intParse(userInput);

                    // delete @ id, and check success
                    p = list.delete(id);
                    if (p == null) System.out.println("Not in our System :(");
                    else p.printID();

                    break;
                case 6: //Print all records
                    list.printAllRecords();
                    break;
                case 7: // done
                    flag = false;
                    break;
            }
            // if none of these cases, will rerun while loop
        }
        in.close(); // close scanner
    }

    /**
     *  Takes String and checks if it is number
     *  if is, return String as Int
     *  else, return -1
     * */
    private static int intParse(String s){
        try{
            return Integer.parseInt(s);
        }catch (NumberFormatException e){
            System.out.println("Invalid Input!");
            return -1;
        }
    }
}