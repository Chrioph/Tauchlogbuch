package view;


import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorController {



    public static void generateErrorFrame(String text){
        JFrame frame = new JFrame("Error");
        frame.setSize(1200  , 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        JPanel content = new JPanel();
        frame.add(content);

        JLabel message = new JLabel(text);
        message.setBounds(0,120,500,80);
        content.add(message);

        JButton ok = new JButton("OK!");
        ok.setBounds(250,160,100,80);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        content.add(ok);
        frame.setAlwaysOnTop(true);
        frame.setContentPane(content);

    }

}
