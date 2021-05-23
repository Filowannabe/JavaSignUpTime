import frontend.navigator.Navigator;

public class App {
    public static void main(String[] args) throws Exception {
        Navigator navigator = new Navigator();
        navigator.goRegisterPage(0, 50, navigator.getBodyWidth(), navigator.getBodyHeight());
        navigator.initComponents();
    }
}
