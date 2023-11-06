public class Costumer {
    private String name;
    private String email;
    private double creditLimit;

    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    public double getCreditLimit() {
        return this.creditLimit;
    }
    public Costumer(String name, String email, double creditLimit) {
        this.name = name;
        this.email = email;
        this.creditLimit = creditLimit;
    }
    public Costumer() {
        this("Sem nome", "nenhum@gmail.com");
    }
    public Costumer(String name, String email) {
        this(name, email, 1000);
    }

}
