import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    private boolean isServerWorking;

    private ServerWindow(){
        isServerWorking = false;
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) log.setText("Server is already stopped...");
                else {
                    isServerWorking = false;
                    log.setText("Server stopped: " + !isServerWorking);
                }
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) log.setText("Server has already started...");
                else{
                    isServerWorking = true;
                    log.setText("Server started "+ isServerWorking);
                }
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X,POS_Y,WIDTH,HEIGHT);
        setResizable(false);
        setTitle("ChatServer");
        setAlwaysOnTop(true);
        setLayout(new GridLayout(3,1));
        add(btnStart);
        add(btnStop);
        add(log );

        setVisible(true);
    }

    public static void main(String[] args) {
        new ServerWindow();
    }
}
