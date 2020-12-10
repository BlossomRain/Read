package part3.chapter8.template;

public class Database {
    public static Customer getCustomerWithId(int id) {
        return new Customer("customer" + id, id);
    }
}
