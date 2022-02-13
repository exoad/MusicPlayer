package app.interfaces.theme.rules;

import app.interfaces.theme.Refresh;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class RegularLight implements Refresh {

  @Override
  public void refresh(java.awt.Window frame) throws UnsupportedLookAndFeelException {
    UIManager.setLookAndFeel(new FlatLightLaf());
    try {
      SwingUtilities.updateComponentTreeUI(frame);
    } catch (NullPointerException e) {
      // do nothing
      e.addSuppressed(e);
    }
    frame.pack();
  }

  public String toString() {
    return "regularlight";
  }
}
