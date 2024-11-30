import javax.swing.*;

public class HelloWorldGUI extends JFrame {

    public HelloWorldGUI() {
        setTitle("Hello World GUI");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello, World!", SwingConstants.CENTER);
        add(label);

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new HelloWorldGUI());
        
    }
}