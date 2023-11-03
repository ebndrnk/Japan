package Japan.example;

import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class OpenPagae extends JFrame {
    JTextField hours;
    JTextField minutes;
    public OpenPagae(){
        super("Clocker");
        super.setBounds(550, 150, 600, 600);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(3, 3, 50, 0));
        JButton button_start = new JButton("Listen");
        JButton button_stop = new JButton("Stop listen");
        JButton button_send = new JButton("Start alarm");

        hours = new JTextField("");
        minutes = new JTextField("");


        container.add(new JLabel("Введите время \n (ЧЧ/ММ): "));
        container.add(hours);
        container.add(minutes);

        container.add(button_send);
        container.add(new JLabel(""));  // ааааааааа
        container.add(new JLabel(""));  // ааааааааа
        container.add(new JLabel(""));  // ааааааааа
        container.add(button_stop);



        button_send.addActionListener(e -> {

//            Thread threadForWhile = new Thread(() -> {
                Date date;
                while(true){
                    date = new Date();
                    if(Integer.toString(date.getHours()).equals(hours.getText()) && Integer.toString(date.getMinutes()).equals(minutes.getText())){
                        Sound.start();
                        break;
                    }
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
//            });
//            threadForWhile.start();

        });

        button_stop.addActionListener(e -> {
            Sound.stop();
        });


    }
}
