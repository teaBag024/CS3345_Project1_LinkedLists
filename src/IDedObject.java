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
