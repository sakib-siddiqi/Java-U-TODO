package todo_manager;

public class Todo_Manager {

    public static void main(String[] args) {
        try {
            Login login = new Login();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
        } catch (RuntimeException error) {
            System.out.println(error.getMessage());
        }
    }
}
