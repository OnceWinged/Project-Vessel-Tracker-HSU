package Utils.Buttons;

import java.awt.Font;

import javax.swing.JButton;//added bunch of event.folder, over engineer the stuff, now I use lamda func to get me to that point, be happy you dont need to read 300words comments in these section. I removed them all.

public class TypeIButton extends JButton {
    /*
     * call this type I. mean buttom for option window such as "OK".
     * Type II is more bigger button working on user menu and direct
     * to difference features frame.
     */
    public TypeIButton(int x, int y, String name) {
        // button with prefixed size, but optional offset
        setBounds(x, y, 200, 50);
        setText(name);
        setFocusable(false);
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
        setFont(new Font("Congenial Black", Font.ITALIC, 16));
    }
}