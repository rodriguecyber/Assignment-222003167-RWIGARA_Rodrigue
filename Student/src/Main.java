//import java.applet.Applet;
import java.awt.*;


public class Main {

    public static void main(String[] args) {

        // Assuming state is initialized within the register class
        int state =new   Login().getState();
        if (state == 0) {
            //open login page;
            new Login();
        }
    }
}
