
class SweetManager {

    private static volatile SweetManager instance;

    private SweetManager() {
        System.out.println("SweetManager instance created.");
    }

    public static SweetManager getInstance() {
        if (instance == null) {
            synchronized (SweetManager.class) {
                if (instance == null) {
                    instance = new SweetManager();
                }
            }
        }
        return instance;
    }

    public void manageSweet(String sweetName) {
        System.out.println("Managing sweet: " + sweetName);
    }
}

public class SingletonPatternExample {

    public static void main(String[] args) {

        SweetManager manager1 = SweetManager.getInstance();
        SweetManager manager2 = SweetManager.getInstance();

        manager1.manageSweet("Kaju Katli");
        manager2.manageSweet("Methi Pak");

        System.out.println("Are both instances same? " + (manager1 == manager2));
    }
}
