package Files;

import javax.swing.*;
import java.awt.*;

public class Finish extends JFrame {

    private String way = "C:\\MyProgramm\\Java\\Game\\src\\Images\\";

    public void End(String nick_name) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLocation(-10, 0);
        frame.setResizable(false);
        frame.setTitle("Game of Power");
        frame.setLayout(new FlowLayout());
        ImageIcon icon = new ImageIcon(way + "Fon.jpg");
        frame.setIconImage(icon.getImage());
        JLabel label = new JLabel(icon);
        frame.getContentPane().add(label);
        frame.setVisible(true);

        JLabel label_op = new JLabel("Winner is " + nick_name);
        label_op.setLocation(600,100);
        label_op.setFont(new Font("Serif", Font.BOLD,45));
        label_op.setForeground(Color.WHITE);
        label.add(label_op).setSize(400,100);
    }
}
