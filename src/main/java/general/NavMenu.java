package general;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class NavMenu extends  Menu {

    private JButton[] buttons;

    public NavMenu(Root root) {
        super(root);
    }

    public NavMenu(Root root, Menu parent, String name) {
        super(root, parent, name);
    }

    @Override
    public void construct() {
        buttons = new JButton[children.size() + 1];
        int i = 0;
        for (HashMap.Entry<String, Menu> child : children.entrySet()) {
            buttons[i] = new JButton(child.getKey());
            buttons[i].addActionListener(e -> root.setCurrentMenu(child.getValue()));
            GridBagConstraints btnCon = new GridBagConstraints(
                    0, i, 1, 1, 1, 1,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
                    0, 0
            );
            add(buttons[i], btnCon);
            i++;
        }
        if (parent == null) {
            buttons[i] = new JButton("Exit");
            buttons[i].addActionListener(e -> root.exit());
        } else {
            buttons[i] = new JButton("Back");
            buttons[i].addActionListener(e -> root.setCurrentMenu(parent));
        }
        GridBagConstraints btnCon = new GridBagConstraints(
                0, i, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
                0, 0
        );
        add(buttons[i], btnCon);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void unInitialize() {

    }
}
