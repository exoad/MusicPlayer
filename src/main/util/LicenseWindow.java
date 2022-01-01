package main.util;

import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JScrollPane;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkContrastIJTheme;
public class LicenseWindow implements Runnable {
  private JFrame frame;
  private JLabel label;
  private JTextPane textArea;
  private JScrollPane scrollPane;

  public LicenseWindow() throws IOException {
    FlatAtomOneDarkContrastIJTheme.setup();
    URL url = getClass().getResource("/license_icon.png");
    ImageIcon icon = new ImageIcon(url);
    frame = new JFrame("Music Player | License");
    frame.setIconImage(icon.getImage());
    frame.setSize(500, 600);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    
    Icon license_title = icon;
    label = new JLabel("Music Player - License");
    label.setIcon(license_title);
    label.setAlignmentX(Component.CENTER_ALIGNMENT);

    textArea = new JTextPane();
    textArea.setEditable(false);

    BufferedReader br = new BufferedReader(
        new InputStreamReader(getClass().getResource("/license.txt").openStream()));
    String license = "";
    try {
      String line = br.readLine();
      while (line != null) {
        license += line + "\n";
        line = br.readLine();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    textArea.setText(license);
    StyledDocument doc = textArea.getStyledDocument();
    SimpleAttributeSet center = new SimpleAttributeSet();
    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
    doc.setParagraphAttributes(0, doc.getLength(), center, false);
    // make the first line of the license bold
    SimpleAttributeSet bold = new SimpleAttributeSet();
    StyleConstants.setBold(bold, true);
    doc.setCharacterAttributes(0, doc.getLength(), bold, false);
    textArea.setSize(new Dimension(400, 400));
    textArea.setFont(textArea.getFont().deriveFont(textArea.getFont().getSize() * 1f));
    textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
    scrollPane = new JScrollPane(textArea);
    scrollPane.setBounds(0, 0, 150, 500);
    scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
    scrollPane.setPreferredSize(new Dimension(450, 500));
    
    frame.add(label);
    frame.add(Box.createVerticalStrut(7));
    frame.add(scrollPane);

  }

  @Override
  public void run() {
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) throws IOException {
    new LicenseWindow().run();
  }
}
