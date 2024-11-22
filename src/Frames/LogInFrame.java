package Frames;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Buttons.*;

public class LogInFrame extends JFrame implements ActionListener {

    Account user;

    TypeIButton confirm = new TypeIButton();
    TypeIButton toSignUp = new TypeIButton();
    SignUpFrame signUp;
    /*
     * 2 input box, 2 botton OK & SignUp...
     * No, let left the button listener in main.
     * so user can cycle log and sign as much they wanted.
     * I ran into a problem to make that possible when I try to
     * let one of the frames access the other frame visibility().
     * ok that wouldnt work either. i will actively bond these
     * two frames together on start up. bond() is created.
     * Update in Class diagram please.
     */

    public LogInFrame() {

        this.setTitle("control: Loging in");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(100, 200, 350, 200);
        // add stuffs to frame here & stuffs's configuration
        // should be make in "Button - Types folder" or etc.
        this.setVisible(false);
    }

    public void bond(SignUpFrame signUp, Account user) {
        this.user = user;
        this.signUp = signUp;
    }
    /*
     * tried to do polymorphsm here, seem like JFrame dont
     * like our frame which inherited from JFrame. need a check
     * on that, or just hard coded it as taking Login Frame
     * instead of Jframe, waever.
     */
    /*
     * oh wait, a container of JFrame can store its
     * inheritanced class's instance like LogInFrame.
     * but dosnt mean I can literrally asign them into
     * JFrame typed variable. :p silly ass. (ok fixed)
     * this is trash
     * public void bond(JFrame logIn) {
     * this.logIn = logIn;}
     */

    // button listeners for sign up option
    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == confirm && user.isValid()) {
            // (user.is_admin()) ? new UserMenu().setVisible(true) : new
            // UserMenu(user).setVisible(true);
            // this.setVisible(false);(too hard to read, but legit)
            UserMenu menu = (user.isAdmin()) ? new UserMenu() : new UserMenu(user);
            menu.setVisible(true);
            this.dispose();
        }
        if (e.getSource() == toSignUp) {
            this.setVisible(false);
            signUp.setVisible(true);
            // reset this textfield too!!
        }
    }
}