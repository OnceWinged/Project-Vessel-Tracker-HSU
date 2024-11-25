// This is similar to SignIn frame, but less notes.
// Why dont I combine all my frame to one and let them inheritance from it?
// Yeah try it. Me? I wont. "Prefer Composition over Inheritance"
// (fact: I fcked up trying)
package Components;

import javax.swing.JFrame;

import Utils.Buttons.*;
import Utils.TextBoxs.*;

public class LogInFrame extends JFrame {

    private Account user;

    private TypeIButton confirm, toSignUp;
    private TypeITextBox username, password;
    // TODO consider make new frame for textfield only, Grid layout and configure it
    // here instead, set number of field and context of each, you can then write
    // thatframe.thattextfield.addActionListener(e -> doingsomeshits);
    private SignUpFrame signUp;

    public LogInFrame() {
        // frame init
        setTitle("control: Loging in");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setBounds(100, 200, 1000, 800);
        // texbox init

        // button init
        confirm = new TypeIButton(250, 450, "Confirm");
        toSignUp = new TypeIButton(550, 450, "Sign Up");
        confirm.addActionListener(e -> toMenu());
        toSignUp.addActionListener(e -> toSignUp());

        // Frame combine
        add(confirm);
        add(toSignUp);
        setVisible(false);
    }

    public void bond(SignUpFrame signUp) {
        this.signUp = signUp;
    }

    // button listeners for sign up option
    private void toMenu() {
        if (user.isValid()) {
            UserMenu menu = (user.isAdmin()) ? new UserMenu() : new UserMenu(user);
            menu.setVisible(true);
            this.dispose();
        }
    }

    private void toSignUp() {
        this.setVisible(false);
        signUp.setVisible(true);
        // reset this textfield too!!
    }
}