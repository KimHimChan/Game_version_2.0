package Files;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PreviewGame extends JFrame {

    private boolean flag_transition = false;    //transition - переход
    private int array[] = new int[2];
    //private int hod[] = new int[2];
    private String[] array_char = new String[2];


    public PreviewGame(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLocation(-10,0);
        frame.setResizable(false);

        frame.setLayout(new FlowLayout());
        frame.setTitle("Game of Power");

        ImageIcon icon = new ImageIcon("C:\\MyProgramm\\Java\\Game\\src\\Images\\Fon.jpg");
        frame.setIconImage(icon.getImage());

        JLabel label = new JLabel(icon);
        frame.getContentPane().add(label);
        frame.setVisible(true);

        JLabel label1 = new JLabel(new ImageIcon("C:\\MyProgramm\\Java\\Game\\src\\Images\\luk0.jpg"));
        label1.setLocation(40, 165);
        label.add(label1).setSize(250,400);

        JLabel label2 = new JLabel(new ImageIcon("C:\\MyProgramm\\Java\\Game\\src\\Images\\tank0.jpg"));
        label2.setLocation(1325,165);
        label.add(label2).setSize(250,400);

        JButton button_next = new JButton();
        button_next.setContentAreaFilled(false);
        button_next.setIcon(new ImageIcon("C:\\MyProgramm\\Java\\Game\\src\\Images\\Next.png"));
        button_next.setLocation(1295, 650);
        label.add(button_next).setSize(250,50);
        button_next.setEnabled(false);

        JButton button_luk = new JButton();
        button_luk.setContentAreaFilled(false);
        button_luk.setIcon(new ImageIcon("C:\\MyProgramm\\Java\\Game\\src\\Images\\Archer.png"));
        button_luk.setLocation(70,90);
        label.add(button_luk).setSize(250,50);

        JButton button_tank = new JButton();
        button_tank.setContentAreaFilled(false);
        button_tank.setIcon(new ImageIcon("C:\\MyProgramm\\Java\\Game\\src\\Images\\Warrior.png"));
        button_tank.setLocation(1295, 90);
        label.add(button_tank).setSize(250,50);

        button_luk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flag_transition) array[0] = 0;
                else array[1] = 0;
                button_luk.setEnabled(false);
                button_tank.setEnabled(true);
                button_next.setEnabled(true);
            }
        });
        button_tank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flag_transition) array[0] = 1;
                else array[1] = 1;
                button_tank.setEnabled(false);
                button_luk.setEnabled(true);
                button_next.setEnabled(true);
            }
        });
        button_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button_luk.setEnabled(true);               //снятие блокировки
                button_tank.setEnabled(true);
                button_next.setEnabled(false);             //кнопка блокируется

                flag_transition = true;
                //Random random = new Random();         //
                //int order = random.nextInt(2);      //order - порядок
                //hod[0] = order;                       //
                array_char[0] = "Player_1";// + (hod[0] + 1);
                button_next.setIcon(new ImageIcon("C:\\MyProgramm\\Java\\Game\\src\\Images\\Complete.png"));
                button_next.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //if (order == 0) hod[1] = order + 1;                   //
                        //else hod[1] = 0;                                      //
                        array_char[1] = "Player_2"; //+ (hod[1] + 1);
                        //System.out.print(array_char[0] + " " + array[0] + " " + hod[0] + " " +
                        //        array_char[1] + " " + array[1] + " " + hod[1]);
                        frame.dispose();
                        Game game = new Game();
                        game.StartForm(array_char, array);//, hod); //, hod);
                    }
                });
            }
        });
    }
}
