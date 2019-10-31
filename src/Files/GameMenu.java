package Files;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {

    public GameMenu(){
        JFrame frame = new JFrame();                //создаем новую форму
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);          //при нажатии на крестик форма закрывается
        frame.setSize(1920,1080);               //размеры формы (не укажешь размеры - не увидишь элемент)
        frame.setLocation(-10,0);               //в каком месте будет располагаться (в данном случае лев верх угол будет прям в самом углу)
        frame.setResizable(false);              //нельзя изменять размеры формы

        frame.setLayout(new FlowLayout());      //новыцй слой, где будет фоновой рисунок
        frame.setTitle("Game of Power");        //заголовок окна

        ImageIcon icon = new ImageIcon("C:\\MyProgramm\\Java\\Game\\src\\Images\\Fon.jpg");    //это типо эмблемы у приложения
        frame.setIconImage(icon.getImage());        //установится тоже рядом с заголовком

        JLabel label = new JLabel(icon);        //создаем метку , куда собственно и помещаем фоновой рисунок
        frame.getContentPane().add(label);      //слой это что-то ыроде типа панели, кода мы добавляем лэйбл
        frame.setVisible(true);                 // ну и отображаеи форму

        JButton button_start = new JButton();           //создание кнопки
        button_start.setContentAreaFilled(false);       //делаем фон кнопки прозрачным
        button_start.setIcon(new ImageIcon("C:\\MyProgramm\\Java\\Game\\src\\Images\\NewGame.png"));        //картинка на кнопке
        button_start.setLocation(700,300);          //где находится
        label.add(button_start).setSize(160,40);    //добавляем на фоновой рисунок, указыая размеры
        button_start.addActionListener(new ActionListener() {       //слушатель событий, что то типо как Event в питоне, только для кнопки
            @Override
            public void actionPerformed(ActionEvent e) {
                PreviewGame previewGame = new PreviewGame();        //следующая форма, т.к. она как класс, то и создаем экзэмпляр
                frame.dispose();                                    //закрываем старую форму
            }
        });

        JButton button_exit = new JButton();
        button_exit.setContentAreaFilled(false);
        button_exit.setIcon(new ImageIcon("C:\\MyProgramm\\Java\\Game\\src\\Images\\Exit.png"));
        button_exit.setLocation(700, 400);
        label.add(button_exit).setSize(160,40);
        button_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        GameMenu gameMenu = new GameMenu();
    }
}
