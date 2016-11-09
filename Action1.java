import java.util.*;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
public class Action1 implements ActionListener {        
 String name;
 public Action1()throws Exception {}
public  Action1(String name){
this.name=name;
}
  public void actionPerformed (ActionEvent e){ 
    try{ 
        
    FileInputStream input = new FileInputStream(this.name);
    BufferedImage image = ImageIO.read(input);     
    JFrame frame2 = new JFrame("Image");
    frame2.setVisible(true);
    frame2.setSize(670,510);
    JLabel label = new JLabel(new ImageIcon(image));
    JPanel panel = new JPanel();
    frame2.add(panel);
    panel.add(label);   
    frame2.getContentPane().add(label);
    }catch(Exception d){}    
  }
  public static boolean ret(){ 
  return true;
}
}