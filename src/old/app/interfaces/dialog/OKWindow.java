package app.interfaces.dialog;

import app.telemetry.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
/**
 * @author Jack Meng
 */
public class OKWindow implements ActionListener {
  private final JButton okButton;
  private final JFrame frame;

  public OKWindow(String message) {
    
    JPanel panel = new JPanel();
    JLabel label = new JLabel("<html><center><p>" + message + "</p></center></html>");
    okButton = new JButton("Yay!");
    okButton.addActionListener(this);
    okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    label.setFont(label.getFont().deriveFont(label.getFont().getSize() * 1.5f));

    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    panel.add(label);
    panel.add(okButton);
    URL url = getClass().getResource("/icons/others/ok_icon.png");
    assert url != null;
    frame = new JFrame(message);
    frame.setIconImage(new ImageIcon(getClass().getResource("/icons/others/frame-warning.png")).getImage());
    frame.add(panel);
    frame.setSize(300, 100);
    frame.setResizable(false);
    frame.setUndecorated(true);
    frame.addComponentListener(new app.interfaces.event.FrameOrganizer(frame));
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    frame.setVisible(true);
  }

  
  /** 
   * @param e
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(okButton)) {
      frame.dispose();
      Logger.log(e.getSource() + "\n" + frame.getClass());
    }
  }

}