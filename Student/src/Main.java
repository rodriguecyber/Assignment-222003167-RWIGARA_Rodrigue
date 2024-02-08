import java.applet.Applet;
import java.awt.*;


public class Main {

    public static void main(String[] args) {
        // Create an instance of the register class
        Login m2 = new Login();

        // Assuming state is initialized within the register class
        int state = m2.getState();
        System.out.println(state);


        if (state == 1) {
            //new Dashboard();
        } else {
            m2.login();
        }
    }
}
