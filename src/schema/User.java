package schema;


public class User {

    public String name;
    public String email;
    public int id;

    public User() {
    }

    public User(int id,String name, String email) {
        this.name = name;
        this.email = email;
        this.id=id;
    }

    public void print() {
        System.out.println("\t👉 ---> USER : " + this.name + ", " + this.email);
    }
}
