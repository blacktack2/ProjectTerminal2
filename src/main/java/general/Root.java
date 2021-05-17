package general;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Root extends JFrame implements MouseListener, MouseMotionListener {

    private final int PREF_WIDTH = 800, PREF_HEIGHT = 600;

    private Menu currentMenu;

    public static void main(String[] args) {
        new Root();
    }

    private Root() {
        super("Project Terminal 2");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        getContentPane().addMouseListener(this);
        getContentPane().addMouseMotionListener(this);
        getContentPane().setFocusable(true);

        getContentPane().setBackground(new Color(150, 200, 255));

        initializeMenus();

        getContentPane().setPreferredSize(new Dimension(PREF_WIDTH, PREF_HEIGHT));
        pack();
        repaint();
        setVisible(true);
    }

    private void initializeMenus() {
        NavMenu mainMenu = new NavMenu(this);
        NavMenu simulationMenu = new NavMenu(this, mainMenu, "Simulations");
        NavMenu gameMenu = new NavMenu(this, mainMenu, "Games");
        NavMenu puzzleMenu = new NavMenu(this, mainMenu, "Puzzles");

        mainMenu.construct();
        simulationMenu.construct();
        gameMenu.construct();
        puzzleMenu.construct();

        setCurrentMenu(mainMenu);
    }

    public void exit() {
        System.exit(0);
    }

    public void setCurrentMenu(Menu newMenu) {
        if (currentMenu != null) {
            currentMenu.unInitialize();
            remove(currentMenu);
        }
        currentMenu = newMenu;
        newMenu.initialize();
        add(newMenu, newMenu.getConstraints());
        pack();
        repaint();
    }

    public void mouseClicked(MouseEvent mouseEvent) {

    }

    public void mousePressed(MouseEvent mouseEvent) {

    }

    public void mouseReleased(MouseEvent mouseEvent) {

    }

    public void mouseEntered(MouseEvent mouseEvent) {

    }

    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void mouseDragged(MouseEvent mouseEvent) {

    }

    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
