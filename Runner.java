public class Runner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("State Project");
        Screen screen = new Screen();

        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(screen);
        frame.setVisible(true);
    }
}