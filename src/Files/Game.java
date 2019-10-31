package Files;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class Game extends JFrame {

    private String way = "C:\\MyProgramm\\Java\\Game\\src\\Images\\";
    private String pers1 = ""; private String pers2 = "";
    private int[] type = {0, 1};
    private int[] mana = {6, 6};
    private int[] hp = {20, 20};
    //private int[] card = new int[2];
    private int[] card = {0, 0};
    private boolean flag_transition = false;    //transition - переход


    public void StartForm(String[] array_char, int[] array){        //, int[] hod) {
        //array_char - ник перса
        //array - перс
        //hod - очередь - на случ. проверки

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

        if (array[0] == 0) pers1 = "luk";
        else pers1 = "tank";
        JLabel label1 = new JLabel(new ImageIcon(way + pers1 + type[0] + ".jpg"));
        label1.setLocation(40, 165);
        //if (hod[0] == 0) label1.setLocation(40, 165);             //
        //else label1.setLocation(1325,165);                        //
        label.add(label1).setSize(250,400);

        if (array[1] == 0) pers2 = "luk";
        else pers2 = "tank";
        JLabel label2 = new JLabel(new ImageIcon(way + pers2 + type[1] + ".jpg"));
        label2.setLocation(1325,165);
        //if (hod[1] == 0) label2.setLocation(40, 165);       //
        //else label2.setLocation(1325,165);                  //
        label.add(label2).setSize(250,400);

        JLabel label_name0 = new JLabel(array_char[0]);
        label_name0.setLocation(150,90);
        label_name0.setFont(new Font("Serif", Font.BOLD, 40));
        label_name0.setForeground(Color.WHITE);
        label.add(label_name0).setSize(150,50);

        JLabel label_name1 = new JLabel(array_char[1]);
        label_name1.setLocation(1330,90);
        label_name1.setFont(new Font("Serif", Font.BOLD,40));
        label_name1.setForeground(Color.WHITE);
        label.add(label_name1).setSize(150,50);

        JLabel hp0 = new JLabel(String.valueOf(hp[0]));                //hp[0]));     //[hod[0]]));
        hp0.setLocation(100,600);
        hp0.setFont(new Font("Serif", Font.BOLD,45));
        hp0.setForeground(Color.RED);
        label.add(hp0).setSize(50,50);

        JLabel mana0 = new JLabel(String.valueOf(mana[0]));           //[hod[0]]));
        mana0.setLocation(200,600);
        mana0.setFont(new Font("Serif", Font.BOLD,45));
        mana0.setForeground(Color.BLUE);
        label.add(mana0).setSize(50,50);

        JLabel hp1 = new JLabel(String.valueOf(hp[1]));       //[hod[1]]));
        hp1.setLocation(1400,600);
        hp1.setFont(new Font("Serif", Font.BOLD,45));
        hp1.setForeground(Color.RED);
        label.add(hp1).setSize(50,50);

        JLabel mana1 = new JLabel(String.valueOf(mana[1]));         //mana[hod[1]]));
        mana1.setLocation(1500,600);
        mana1.setFont(new Font("Serif", Font.BOLD,45));
        mana1.setForeground(Color.BLUE);
        label.add(mana1).setSize(50,50);

        JButton button_menu = new JButton();
        button_menu.setContentAreaFilled(false);
        button_menu.setBorder(new EmptyBorder(0,0,0,0));
        button_menu.setIcon(new ImageIcon(way + "Menu.png"));
        button_menu.setLocation(710,-5);
        label.add(button_menu).setSize(170,100);

        JButton button_attack = new JButton();
        button_attack.setIcon(new ImageIcon(way + "Attack.png"));
        button_attack.setLocation(400,450);
        label.add(button_attack).setSize(240,330);

        JButton button_heal = new JButton();
        button_heal.setIcon(new ImageIcon(way + "Heal.png"));
        button_heal.setLocation(680,450);
        label.add(button_heal).setSize(240,330);

        JButton button_spell = new JButton();
        button_spell.setIcon(new ImageIcon(way + "Spell.png"));
        button_spell.setLocation(960,450);
        label.add(button_spell).setSize(240,330);

        JButton button_complete = new JButton();
        button_complete.setContentAreaFilled(false);
        button_complete.setBorder(new EmptyBorder(0,0,0,0));
        button_complete.setIcon(new ImageIcon(way + "End.png"));
        button_complete.setLocation(80,700);
        label.add(button_complete).setSize(170,100);

        button_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(Game.this, "Перейти в главное меню?", "Подтверждение", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION){
                    frame.dispose();
                    GameMenu gameMenu = new GameMenu();
                }
            }
        });

        button_attack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag_transition == false) card[0] = 1;
                else card[1] = 1;
                BlockCards(button_attack, button_heal, button_spell);
            }
        });

        button_heal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag_transition == false) card[0] = 2;
                else card[1] = 2;
                //card = 2;
                BlockCards(button_heal, button_attack, button_spell);
            }
        });

        button_spell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag_transition == false) card[0] = 3;
                else card[1] = 3;
                BlockCards(button_spell, button_attack, button_heal);
            }
        });

        button_complete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button_attack.setEnabled(true);
                button_heal.setEnabled(true);
                button_spell.setEnabled(true);

                int revers = type[0];
                type[0] = type[1];
                type[1] = revers;
                label1.setIcon(new ImageIcon(way + pers1 + type[0] + ".jpg"));
                label2.setIcon(new ImageIcon(way + pers2 + type[1] + ".jpg"));



                //Numerows(type[0], type[1], card,array_char);
                //if (type[0] == 0) UnitsDisplay(hp0, mana0, hp1, mana1,0, 1);                      //type[1]);
                //else UnitsDisplay(hp1, mana1, hp0, mana0, 1, 0);                              //type[1]);

                if (flag_transition == false) {
                    Numerows(0, 1, card[0], array_char);
                    UnitsDisplay(hp0, mana0, hp1, mana1, 0, 1);
                }
                else {
                    Numerows(1, 0, card[1], array_char);
                    UnitsDisplay(hp1, mana1, hp0, mana0, 1, 0);
                }

                //из рандома убрать
                if (flag_transition == false) flag_transition = true;
                else flag_transition = false;
            }
        });
    }

    private void BlockCards(JButton button_block, JButton button_op, JButton button_opp){
        button_block.setEnabled(false);
        button_op.setEnabled(true);
        button_opp.setEnabled(true);
    }

    private void Numerows(int player, int enemy, int cards, String[] nick_name){

        System.out.println("player:"+player+"   "+"card=" + card[player]);

        if (cards == 1 && mana[player] >= 4){
                hp[enemy] -= 3;
                mana[player] -= 6;
                card[player] = 0;
        }
        if (cards == 2 && mana[player] >= 2){
                hp[player] += 2;
                mana[player] -= 4;
                card[player] = 0;
        }
        if (cards == 3 && mana[player] >= 9){
                hp[enemy] -= 7;
                hp[player] -= 2;
                mana[player] -= 9;
                card[player] = 0;
        }

        else mana[player] += 2;

        if (hp[player] > 0 && hp[enemy] > 0){
            return;
        }
        else {
            Finish finish = new Finish();
            if (hp[0] > hp[1]) finish.End(nick_name[0]);
            else finish.End(nick_name[1]);
        }
    }

    private void UnitsDisplay(JLabel hpX, JLabel manaX, JLabel hpY, JLabel manaY, int i, int j){        //единицы отображение
        hpX.setText(String.valueOf(hp[i]));
        manaX.setText(String.valueOf(mana[i]));
        hpY.setText(String.valueOf(hp[j]));
        manaY.setText(String.valueOf(mana[j]));
    }
}
