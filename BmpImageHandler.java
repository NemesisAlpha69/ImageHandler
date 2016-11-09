import java.util.*;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
public class BmpImageHandler {


            public static void main(String args[]) throws Exception {
        for (int i = 0; i < args.length; i++) {        
                switch(args[i]) {
          case "-basics":{
                BMPBasic colors = new BMPBasic();
                BMPBasic colors1 = new BMPBasic();
                BMPBasic colors2 = new BMPBasic();
                colors.BlueImage();
                colors1.GreenImage();
                Colors colors3 = new Colors();
                colors3.RedImage();
                Colors colors4 = new Colors();
                colors4.RImage();
                Colors colors5 = new Colors();
                colors5.RImage_1();
                JFrame frame = new JFrame("BMPBasic");
                frame.setVisible(true);
                frame.setSize(670,510);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel = new JPanel();
                frame.add(panel);
                JButton button = new JButton("Next");
                panel.add(button); 
                button.addActionListener(new Action1("Image-Blue.bmp"));
                button.addActionListener (new Action1("Figura1.bmp"));
                button.addActionListener(new Action1("Image-Green.bmp"));
                button.addActionListener(new Action1("Image-Mixed.bmp"));
                button.addActionListener(new Action1("Image-Sepia.bmp"));
                button.addActionListener(new Action1("Image-Red.bmp"));
                Action1 a1= new Action1("Image-Blue.bmp");
                Action1 a2= new Action1("Image-Green.bmp");
                Action1 a= new Action1("Image.bmp");
                Action1 a3= new Action1("Image-Sepia.bmp");
                
                //System.out.println("copiado");
                break;
            }//end of case 1
            case "-rotate":{
                BMPRotations rotates = new BMPRotations();
                BMPRotations rotates1 = new BMPRotations();
                BMPRotations rotates2 = new BMPRotations();
                rotates1.HRotate();
                rotates.Efecto();
                rotates2.Hr();
                JFrame frame = new JFrame("BMPRotations");
                frame.setVisible(true);
                frame.setSize(670,510);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel = new JPanel();
                frame.add(panel);
                JButton button = new JButton("Next");
                panel.add(button);
                button.addActionListener(new Action1("Image-HR.bmp"));
                button.addActionListener(new Action1("Image-VR.bmp"));
                button.addActionListener(new Action1("Image-Efecto.bmp"));
                Action1 a1= new Action1("Image-HR.bmp");
                Action1 a22= new Action1("Image-Efecto");
                System.out.println("rotates");
                break;
                }//end of case 2
            case "-resize":{
                    System.out.println("resize");
                break;
            }
            case "-bd":{
                BMPBrightness b= new BMPBrightness();
                b.BR();
                BMPBrightness b1= new BMPBrightness();
                b1.DR();
                JFrame frame = new JFrame("BMPBrightness");
                frame.setVisible(true);
                frame.setSize(670,510);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel = new JPanel();
                frame.add(panel);
                JButton button = new JButton("Next");
                panel.add(button);
                button.addActionListener(new Action1("Image-Bright.bmp"));
                button.addActionListener(new Action1("Image-Dark.bmp"));
                Action1 a1= new Action1("Image-Bright.bmp");
                Action1 aa22=new Action1("Image-Dark.bmp"); 
                
                System.out.println("bd");
                break;
             }//end of case 3            
            case "-grayscale":{
                System.out.println("grayscale.InfoHeader");
                BMPGrayscale grayscale2 = new BMPGrayscale();
                grayscale2.Grayscale();
                BMPGrayscale grayscale4 = new BMPGrayscale();
                grayscale4.PaletColors();
                BMPGrayscale grayscale = new BMPGrayscale();
                
                JFrame frame = new JFrame("BMPGrayscale");
                frame.setVisible(true);
                frame.setSize(670,510);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel = new JPanel();
                frame.add(panel);
                JButton button = new JButton("Next");
                panel.add(button); 
                button.addActionListener(new Action1("Image-Grayscale.bmp"));
                Action1 a1= new Action1("Image-Grayscale.bmp");
                break;
            }//end of case 4
            case "-rle":{
                BMPRunLengthEncoding runlengthencoding1 = new BMPRunLengthEncoding();
                runlengthencoding1.RunLengthEncoding();
                BMPRunLengthEncoding runlengthencoding2 = new BMPRunLengthEncoding();
                runlengthencoding2.Rle();
                BMPRunLengthEncoding runlengthencoding = new BMPRunLengthEncoding();
                JFrame frame = new JFrame("Test");
                frame.setVisible(true);
                frame.setSize(670,510);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel = new JPanel();
                frame.add(panel);
                JButton button = new JButton("Next");
                panel.add(button); 
                button.addActionListener(new Action1("Image-RLE.bmp"));
                Action1 a1= new Action1("Image-RLE.bmp");
                System.out.println("rle");
                
                break;
                }//end of case 5
            case "-all":{
                
                 BMPBasic colors = new BMPBasic();
                BMPBasic colors1 = new BMPBasic();
                BMPBasic colors2 = new BMPBasic();
                colors.BlueImage();
                colors1.GreenImage();
                Colors colors3 = new Colors();
                colors3.RedImage();
                Colors colors4 = new Colors();
                colors4.RImage();
                Colors colors5 = new Colors();
                colors5.RImage_1();
                JFrame frame = new JFrame("BMPBasic");
                frame.setVisible(true);
                frame.setSize(670,510);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel = new JPanel();
                frame.add(panel);
                JButton button = new JButton("Next");
                panel.add(button); 
                button.addActionListener(new Action1("Image-Blue.bmp"));
                button.addActionListener (new Action1("Figura1.bmp"));
                button.addActionListener(new Action1("Image-Green.bmp"));
                button.addActionListener(new Action1("Image-Mixed.bmp"));
                button.addActionListener(new Action1("Image-Sepia.bmp"));
                button.addActionListener(new Action1("Image-Red.bmp"));
                Action1 a1= new Action1("Image-Blue.bmp");
                Action1 a2= new Action1("Image-Green.bmp");
                Action1 a= new Action1("Image.bmp");
                Action1 a3= new Action1("Image-Sepia.bmp");
                Action1 aa= new Action1("Image-Red.bmp");
                //**********************************************************
                BMPRotations rotates = new BMPRotations();
                BMPRotations rotates1 = new BMPRotations();
                BMPRotations rotates2 = new BMPRotations();
                rotates1.HRotate();
                rotates.Efecto();
                //rotates.Hr();
                JFrame frame1 = new JFrame("BMPRotations");
                frame1.setVisible(true);
                frame1.setSize(670,510);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel1 = new JPanel();
                frame1.add(panel1);
                JButton button1 = new JButton("Next");
                panel.add(button1);
                button1.addActionListener(new Action1("Image-HR.bmp"));
                Action1 a1_= new Action1("Image-HR.bmp");
                System.out.println("rotates"); 
                //***************************************************************************
                System.out.println("grayscale.InfoHeader");
                BMPGrayscale grayscale2 = new BMPGrayscale();
                grayscale2.Grayscale();
                BMPGrayscale grayscale4 = new BMPGrayscale();
                grayscale4.PaletColors();
                BMPGrayscale grayscale = new BMPGrayscale();
                
                JFrame frame_ = new JFrame("BMPGrayscale");
                frame_.setVisible(true);
                frame_.setSize(670,510);
                frame_.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel_ = new JPanel();
                frame_.add(panel_);
                JButton button_ = new JButton("Next");
                panel_.add(button_); 
                button_.addActionListener(new Action1("Image-Grayscale.bmp"));
                Action1 a1_1= new Action1("Image-Grayscale.bmp");
    //********************************************************************************************           
                BMPRunLengthEncoding runlengthencoding1 = new BMPRunLengthEncoding();
                runlengthencoding1.RunLengthEncoding();
                BMPRunLengthEncoding runlengthencoding2 = new BMPRunLengthEncoding();
                runlengthencoding2.Rle();
                BMPRunLengthEncoding runlengthencoding = new BMPRunLengthEncoding();
                JFrame frame_1 = new JFrame("BMPRunLengthEncoding");
                frame_1.setVisible(true);
                frame_1.setSize(670,510);
                frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel_1 = new JPanel();
                frame_1.add(panel_1);
                JButton button_1 = new JButton("Next");
                panel_1.add(button_1); 
                button_1.addActionListener(new Action1("Image-RLE.bmp"));
                Action1 a1_2= new Action1("Image-RLE.bmp");
                System.out.println("rle");        
                break;
                    }//end of case 6
            case "-help":{
                System.out.println("*************************Benvenuto**************************");
                System.out.println("BmpImageHandler:\nBMPBasics\nBMPRotations\nBMPGrayscale\nBMPRunLengthEncoding\n");
                System.out.println("para tener acceso a las partes del proyecto debera escribir javac\n seguido del Nombre de la clase principal");
                System.out.println("Ejemplo\n;");
                 System.out.println("directorio/javac BmpImageHandler.java");
                System.out.println("luego ya compilada la clase principal:");
                System.out.println("para la clase BMPBasic debe hacer lo siguiente:");
                System.out.println("");
                System.out.println("java BmpImageHandler -basics imagen.bmp");
                System.out.println("para la segundo parte:");
                System.out.println("java BmpImageHandler -rotate imagen.bmp");
                System.out.println("para la parte de dos de la clase Rotates debe hacer lo siguiente:");
                System.out.println("java BmpImageHandler -bd imagen.bmp");
                System.out.println("para ejecutar la clase Grayscale debe escribir lo siguiente");
                System.out.println("java BmpImageHandler -grayscale imagen.bmp");
                System.out.println(" se debera hacer lo mismo con las otras clases");
                System.out.println("java BmpImageHandler -rle imagen.bmp");
                  break;
                    }//end of case 7
                }//end of swicht
            }//end of for
            
            }//end of method
}//end of class
