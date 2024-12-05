package puskesmas.pkg;

import java.awt.Container;
import java.util.Stack;
import puskesmas.pkg.frame.LoginFrame;

/**
 * @author Achmad Raihan
 */
public class App {

  private static App app;
  private final LoginFrame appFrame;
  private final Stack<Container> panels;

  private App() {
    panels = new Stack<>();
    appFrame = new LoginFrame();
  }

  private void run() {
    panels.push(appFrame.getContentPane());
    appFrame.setResizable(false);
    appFrame.setVisible(true);
    appFrame.pack();
    appFrame.setLocationRelativeTo(null);
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    App.getInstance();
  }

  public static App getInstance() {
    if (app == null) {
      app = new App();
      app.run();
    }
    return app;
  }

  public void switchPanelTo(Container panel) {
    panels.push(panel);
    appFrame.setContentPane(panel);
    appFrame.pack();
    appFrame.setLocationRelativeTo(null);
  }

  public void back() {
    panels.pop();
    appFrame.setContentPane(panels.lastElement());
    appFrame.pack();
    appFrame.setLocationRelativeTo(null);
  }
}
