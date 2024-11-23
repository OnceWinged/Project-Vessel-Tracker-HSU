package Frames;

import javax.swing.JFrame;
import Buttons.*;
import TextBoxs.TypeITextBox;

public class SignUpFrame extends JFrame {

    Account user;

    TypeIButton confirm;
    TypeIButton toLogIn;

    TypeITextBox fullName;
    TypeITextBox dateOfBirth;
    TypeITextBox gender;
    TypeITextBox username;
    TypeITextBox password;
    TypeITextBox passwordConfirm;

    LogInFrame logIn;

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

    public SignUpFrame() {
        // note that all "this." is unecessary, we only have one JFrame here
        // I can just call thouse function without need of "this."
        // I did! in Login frame. for study purposed.

        // frame init
        this.setTitle("control: Signing Up? ok, be quick bro.");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setBounds(100, 200, 1000, 800);
        // texbox init

        // button init
        confirm = new TypeIButton(250, 650, "Confirm");
        toLogIn = new TypeIButton(550, 650, "Log In");
        // input field should be 500in width, since KIM AI failed missurably
        // try to visualizing the layout, like a fking amateur.
        confirm.addActionListener(e -> toMenu());
        toLogIn.addActionListener(e -> toLogIn());
        // and then, just like that I got risk off the
        // event.* imports and interfaces.

        // Frame combine
        this.add(confirm);
        this.add(toLogIn);
        this.setVisible(false);
    }

    public void bond(LogInFrame logIn, Account user) {
        this.user = user;
        this.logIn = logIn;
    }

    private void toMenu() {
        if (!user.isValid()) {
            // user isvalid mean exist, on sign in, unexist is the criterion for confirm.
            // criteria is plural of criterion btw. noted that.
            UserMenu menu = (user.isAdmin()) ? new UserMenu() : new UserMenu(user);
            // (user.is_admin()) ? new UserMenu().setVisible(true) : new
            // UserMenu(user).setVisible(true);(too hard to read, but legit)
            menu.setVisible(true);
            this.dispose();
        }
    }

    private void toLogIn() {
        this.setVisible(false);
        logIn.setVisible(true);
        // reset this textfield too!!
    }
}