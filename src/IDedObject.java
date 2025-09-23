public interface IDedObject {
    int getID();
    void printID();

    /**
    Design a java class Product that implements IDedObject interface and has the following class variables:
    int productID
    String productName
    String supplierName
    Implement suitable constructors, a printID function that prints all the variable values in separate lines and getID() function that returns the productID.  Add any access and other functions necessary.
    {Note all your data should be private and methods public inside the class)
    */

    class Product implements IDedObject{
        private int productID;
        private String productName;
        private String supplierName;

        /** Constructor **/
        public Product(int id, String p, String s){
            productID = id;
            productName = p;
            supplierName = s;
        }

        /** Getters **/
        @Override
        public int getID() {
            return productID;
        }
        public String getProductName() {
            return productName;
        }
        public String getSupplierName(){
            return supplierName;
        }

        /** Setters **/
        public void setID(int id){
            productID = id;
        }
        public void setProductName(String s){
            productName = s;
        }
        public void setSupplierName(String s){
            supplierName = s;
        }

        @Override
        public void printID(){
            System.out.println("Product ID: "+productID);
            System.out.println("Product Name: " +productName);
            System.out.println("Supplier Name: " + supplierName);

        }
    }
}
