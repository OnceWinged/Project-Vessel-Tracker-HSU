import Components.Account;
import Components.LogInFrame;
import Components.SignUpFrame;

/**
 * Milan TODO:
 * this one for the login screen frame
 * will start the Log in frame on default
 * 
 * Luồng chính, khi chạy app, việc
 * đầu tiên được thực hiện là
 * init/ khởi tạo logScreen & object Account.
 * Khi có account tồn tại. khởi chạy
 * Menu để đọc choice của user.
 * + menuStart(boolean) : boolean
 **/
public class StartUpMain {
    public static void main(String[] args) {

        // Account user = new Account();
        LogInFrame logIn = new LogInFrame();
        SignUpFrame signUp = new SignUpFrame();

        logIn.bond(signUp);
        signUp.bond(logIn);

        logIn.setVisible(true);

        /**
         * do {
         * Reload the components.
         * } while (!user.is_valid());
         * 
         * no this will make it impossible to type in account. cause the text
         * keep getting reset every frame. we only reset it on confirm button
         * press located in the frame's body themself, not main stream.
         */
    }
}
