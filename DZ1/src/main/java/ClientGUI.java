import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final JTextArea log = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField("John Smith");
    private final JPasswordField tfPassword = new JPasswordField("123456");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private final JList<String> clientList = new JList<>();

    ClientGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        tfMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.append(tfMessage.getText() + "\n");
                try (BufferedWriter bw = Files.newBufferedWriter(Path.of("History.txt"),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
                     PrintWriter pw = new PrintWriter(bw, true)) {
                    pw.println(tfMessage.getText());
                } catch (IOException exc) {
                    System.out.println(exc.getMessage());
                }
                tfMessage.setText("");
            }
        });
        panelBottom.add(tfMessage, BorderLayout.CENTER);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.append(tfMessage.getText() + "\n");
                try (BufferedWriter bw = Files.newBufferedWriter(Path.of("History.txt"),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
                     PrintWriter pw = new PrintWriter(bw, true)) {
                    pw.println(tfMessage.getText());
                } catch (IOException exc) {
                    System.out.println(exc.getMessage());
                }
                tfMessage.setText("");
            }
        });

        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);


        log.setEditable(false);
        if (Files.exists(Path.of("History.txt"))) {
            try (BufferedReader br = Files.newBufferedReader(Path.of("History.txt"))){
                String line;
                while ((line = br.readLine()) != null){
                    log.append(line+"\n");
                }
            }catch (IOException exc){
                System.out.println(exc.getMessage());
            }
        }
        JScrollPane scrolLog = new JScrollPane(log);
        add(scrolLog);

        add(clientList, BorderLayout.EAST);
        String[] clientNames = {"Paul McCartney", "John Lennon", "George Harisson", "Ringo Starr"};
        clientList.setListData(clientNames);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ClientGUI();
    }
}
