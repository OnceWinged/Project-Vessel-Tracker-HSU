package Frames;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Buttons.*;

public class SignUpFrame extends JFrame implements ActionListener {

    Account user;

    TypeIButton confirm = new TypeIButton();
    TypeIButton toLogIn = new TypeIButton();
    LogInFrame logIn;

    public SignUpFrame() {
        this.setTitle("control: Signing Up? ok, be quick bro.");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(100, 200, 350, 200);
        // add stuffs to frame here & stuffs's configuration
        // should be make in "Button - Types folder" or etc.
        this.setVisible(false);
    }

    public void bond(LogInFrame logIn, Account user) {
        this.user = user;
        this.logIn = logIn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == confirm && !user.isValid()) {
            // user isvalid mean exist, on sign in, unexist is the criterion for confirm.
            // criteria is plural of criterion btw. noted that.
            UserMenu menu = (user.isAdmin()) ? new UserMenu() : new UserMenu(user);
            menu.setVisible(true);
            this.dispose();
        }
        if (e.getSource() == toLogIn) {
            this.setVisible(false);
            logIn.setVisible(true);
            // reset this textfield too!!
        }
    }
}