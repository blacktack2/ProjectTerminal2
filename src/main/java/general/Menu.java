package general;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public abstract class Menu extends JPanel {

    protected Root root;
    protected Menu parent = null;
    protected HashMap<String, Menu> children = new HashMap<>();

    public Menu(Root root) {
        this.root = root;
        setLayout(new GridBagLayout());
        setBackground(new Color(150, 150, 150));
    }

    public Menu(Root root, Menu parent, String name) {
        this(root);
        this.parent = parent;
        parent.addChild(this, name);
    }

    abstract void construct();

    public GridBagConstraints getConstraints() {
        return new GridBagConstraints(
                0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
                0, 0
        );
    }

    public void initialize() {

    }

    public void unInitialize() {

    }

    public void addChild(Menu child, String name) {
        children.put(name, child);
    }
}
