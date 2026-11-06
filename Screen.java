import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.net.URI;

public class Screen extends JPanel implements ActionListener {

    // instance variables
    private JButton viewInfo;
    private JButton deleteState;
    private JButton viewAll;
    private JButton addState;
    private JButton addPicture;
    private JButton submit;
    private JButton back;

    private DLList<JTextField> inputs;
    private String mode = "";

    private DLList<State> list;
    private MyHashMap<State, StateInfo> states;

    // constructor
    public Screen() {

        states = new MyHashMap<>();
        try {
            State ca = new State("CA", "California");
            StateInfo caInfo = new StateInfo("Sacramento", 38900000);
            caInfo.addPicture("https://images.unsplash.com/photo-1501594907352-04cda38ebc29?q=80&w=1632");
            caInfo.addPicture("https://plus.unsplash.com/premium_photo-1725408106567-a77bd9beff7c?q=80&w=1740");
            states.put(ca, caInfo);

            State ny = new State("NY", "New York");
            StateInfo nyInfo = new StateInfo("Albany", 19600000);
            nyInfo.addPicture("https://images.unsplash.com/photo-1496442226666-8d4d0e62e6e9?q=80&w=1740");
            nyInfo.addPicture("https://images.unsplash.com/photo-1496588152823-86ff7695e68f?q=80&w=1740");
            states.put(ny, nyInfo);

            State tx = new State("TX", "Texas");
            StateInfo txInfo = new StateInfo("Austin", 29500000);
            txInfo.addPicture("https://plus.unsplash.com/premium_photo-1690522331003-a5d7cff78f3a?q=80&w=1740");
            txInfo.addPicture("https://images.unsplash.com/photo-1530089711124-9ca31fb9e863?q=80&w=1738");
            states.put(tx, txInfo);

            setLayout(new BorderLayout());
            showMainMenu();
        }
        catch(Exception e) {
            System.out.println("Error loading states: " + e.getMessage());
        }
    }

    // show main menu method
    public void showMainMenu() {

        removeAll();
        setLayout(new GridLayout(5, 1, 10, 10));

        viewAll = new JButton("View All States");
        viewInfo = new JButton("View State Information");
        deleteState = new JButton("Delete State");
        addState = new JButton("Add State");
        addPicture = new JButton("Add Picture");

        viewAll.setActionCommand("VIEW_ALL");
        viewInfo.setActionCommand("VIEW_INFO");
        deleteState.setActionCommand("DELETE");
        addState.setActionCommand("ADD_STATE");
        addPicture.setActionCommand("ADD_PICTURE");

        viewAll.addActionListener(this);
        viewInfo.addActionListener(this);
        deleteState.addActionListener(this);
        addState.addActionListener(this);
        addPicture.addActionListener(this);

        add(viewAll);
        add(viewInfo);
        add(deleteState);
        add(addState);
        add(addPicture);

        revalidate();
        repaint();
    }

    // show form method
    public void displayInputPanel(String title, DLList<String> labels) {

        removeAll();
        setLayout(new BorderLayout());

        JPanel form = new JPanel(
            new GridLayout(labels.size() + 1, 2, 5, 5)
        );

        inputs = new DLList<JTextField>();

        for (int i = 0; i < labels.size(); i++) {

            form.add(new JLabel(labels.get(i)));

            JTextField field = new JTextField();
            inputs.add(field);
            form.add(field);
        }

        submit = new JButton("Submit");
        submit.addActionListener(this);
        form.add(submit);

        back = new JButton("Back");
        back.addActionListener(this);
        form.add(back);

        add(new JLabel(title, SwingConstants.CENTER), BorderLayout.NORTH);
        add(form, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    // show result method
    public void showResult(String text) {

        removeAll();
        setLayout(new BorderLayout());

        JTextArea output = new JTextArea(text);
        output.setEditable(false);

        add(new JScrollPane(output), BorderLayout.CENTER);

        back = new JButton("Back");
        back.addActionListener(this);
        add(back, BorderLayout.SOUTH);

        revalidate();
        repaint();
    }

    // show state info method
    public void showStateInfo(StateInfo info) {

        removeAll();
        setLayout(new BorderLayout());

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        content.add(new JLabel(info.toString()));

        DLList<String> pics = info.getPictures();

        for (int i = 0; i < pics.size(); i++) {

            try {
                URL url = URI.create(pics.get(i)).toURL();
                ImageIcon image = new ImageIcon(url);

                Image scaled = image.getImage().getScaledInstance(
                    300, 180, Image.SCALE_SMOOTH
                );

                content.add(new JLabel(new ImageIcon(scaled)));

            } catch (Exception ex) {
                content.add(new JLabel("Picture could not load."));
            }
        }

        add(new JScrollPane(content), BorderLayout.CENTER);

        back = new JButton("Back");
        back.addActionListener(this);
        add(back, BorderLayout.SOUTH);

        revalidate();
        repaint();
    }

    // action performed
    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        // view all
        if (command.equals("VIEW_ALL")) {

            list = states.keySet().toDLList();

            String text = "";

            for (int i = 0; i < list.size(); i++) {
                text += list.get(i) + "\n";
            }

            showResult(text);
        }

        // view info
        else if (command.equals("VIEW_INFO")) {

            mode = "VIEW";

            DLList<String> labels = new DLList<String>();
            labels.add("Abbreviation:");

            displayInputPanel("View State Information", labels);
        }

        // delete
        else if (command.equals("DELETE")) {

            mode = "DELETE";

            DLList<String> labels = new DLList<String>();
            labels.add("Abbreviation:");

            displayInputPanel("Delete State", labels);
        }

        // add state
        else if (command.equals("ADD_STATE")) {

            mode = "ADD";

            DLList<String> labels = new DLList<String>();
            labels.add("Name:");
            labels.add("Abbreviation:");
            labels.add("Capital:");
            labels.add("Population:");

            displayInputPanel("Add State", labels);
        }

        // add picture
        else if (command.equals("ADD_PICTURE")) {

            mode = "PICTURE";

            DLList<String> labels = new DLList<String>();
            labels.add("Abbreviation:");
            labels.add("Picture URL:");

            displayInputPanel("Add Picture", labels);
        }

        // if the user clicks the back button
        else if (e.getSource() == back) {
            showMainMenu();
        }

        // after the user submits the info
        else if (e.getSource() == submit) {

            // view mode
            if (mode.equals("VIEW")) {

                State state = new State(inputs.get(0).getText().trim().toUpperCase(), "");

                StateInfo info = states.get(state);

                if (info == null) {
                    showResult("State not found.");
                } else {
                    showStateInfo(info);
                }
            }

            // delete mode
            else if (mode.equals("DELETE")) {

                State state = new State(
                    inputs.get(0).getText().trim().toUpperCase(), ""
                );

                StateInfo removed = states.remove(state);

                if (removed == null) {
                    showResult("State not found.");
                } else {
                    showResult("State deleted.");
                }
            }

            // add mode
            else if (mode.equals("ADD")) {

                try {
                    State state = new State(
                        inputs.get(1).getText().trim().toUpperCase(),
                        inputs.get(0).getText().trim()
                    );

                    StateInfo info = new StateInfo(
                        inputs.get(2).getText().trim(),
                        Integer.parseInt(inputs.get(3).getText().trim())
                    );

                    states.put(state, info);

                    showResult("State added.");

                } catch (NumberFormatException ex) {
                    showResult("Population must be a whole number.");
                }
            }

            // picture mode
            else if (mode.equals("PICTURE")) {

                State state = new State(
                    inputs.get(0).getText().trim().toUpperCase(), ""
                );

                StateInfo info = states.get(state);

                if (info == null) {
                    showResult("State not found.");
                } else {
                    info.addPicture(inputs.get(1).getText().trim());
                    showResult("Picture added.");
                }
            }
        }
    }
}
