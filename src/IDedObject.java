public interface IDedObject {
    int getID();
    void printID();

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

        /** Override Functions **/
        @Override
        public int getID() {
            return productID;
        }

        @Override
        public void printID(){
            System.out.println("Product ID: "+productID);
            System.out.println("Product Name: " +productName);
            System.out.println("Supplier Name: " + supplierName);

        }
    }
}
