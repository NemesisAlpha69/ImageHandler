import java.util.*;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
import java.io.FileOutputStream;
import java.io.FileInputStream;


public class BMPBasic{
//********campos**************
FileInputStream input; 
//*********constructor*******************
public BMPBasic()throws Exception{
input = new FileInputStream("Image.bmp");
}

public void BlueImage()throws Exception{
FileOutputStream output_Blue = new FileOutputStream("Image-Blue.bmp");
byte[] datos = new byte [input.available()];
input.read(datos);
byte[] copia = new byte[datos.length];//copia generate con el mismo length
for (int i = 0;i<= 53;i++ ) {
    copia[i] = datos[i];
    //System.out.println(copia);
}
for(int j = 54;j<datos.length;j+=3){ //copia azul
    copia[j] = datos[j];
}
 output_Blue.write(copia);
 output_Blue.close();

}//end of method BlueImage
public  void GreenImage()throws Exception{
FileOutputStream output_Green = new FileOutputStream("Image-Green.bmp");
byte[] datos = new byte [input.available()];
input.read(datos);
byte[] copia_1 = new byte[datos.length];//copia generate con el mismo length
for (int i = 0;i<= 53;i++ ) {
    copia_1[i] = datos[i];
    //System.out.println(copia);
}
for(int j = 55;j<datos.length;j+=3){//copia verde
copia_1[j] = datos[j];
}
output_Green.write(copia_1);
output_Green.close();
}//end of Green
public void RedImage()throws Exception{
FileOutputStream output_Red = new FileOutputStream("Image-Red.bmp");
byte[] datos = new byte [input.available()];
input.read(datos);
byte[] copia_1 = new byte[datos.length];//copia generate con el mismo length
for (int i = 0;i<= 53;i++ ) {
    copia_1[i] = datos[i];
    //System.out.println(copia);
}
for(int i=56;i< datos.length;i+=3){//copia roja
copia_1[i] = datos[i];
}
output_Red.write(copia_1);
output_Red.close();
}//red image
public void RImage()throws Exception{
FileOutputStream output_shift_1 = new FileOutputStream("Image-Mixed.bmp");//azul al rojo
byte[] datos = new byte [input.available()];
input.read(datos);
byte[] copia = new byte[datos.length];//copia generate con el mismo length
for (int i = 0;i<= 53;i++ ) {
    copia[i] = datos[i];
    //System.out.println(copia);
}
for(int i=54;i<datos.length-1;i++){//corrimiento en 1, RAVImage.bmp
copia[i] = datos[i+1];
}
copia[copia.length-1] = datos[54];
output_shift_1.write(copia);
output_shift_1.close();
}
public void RImage_1()throws Exception{
FileOutputStream output_shift_2 = new FileOutputStream("Image-Sepia.bmp");
byte[] datos = new byte [input.available()];
input.read(datos);
byte[] copia = new byte[datos.length];//copia generate con el mismo length
for (int i = 0;i<= 53;i++ ) { //copia el header
    copia[i] = datos[i];
    //System.out.println(copia);
}
System.out.println(datos.length);
for (int j=54;j<copia.length-2;j+=1) {//new red
    copia[j]=(byte)((datos[j]*0.393)+(datos[j+=1]*0.769)+(datos[j+=1]*0.189));
}
for (int i=55;i<datos.length-2;i+=1) {//new green
    copia[i]=(byte)((datos[i]*0.349)+(datos[i+=1]*0.686)+(datos[i+=1]*0.168));
}    
copia[copia.length-2]=(byte)((datos[copia.length-3]*0.349)+(datos[copia.length-2]*0.686)+(datos[copia.length-1]*0.168));
for (int i=56;i<datos.length-2;i+=1) {//new blue
    copia[i]=(byte)((datos[i]*0.272)+(datos[i+=1]*0.534)+(datos[i+=1]*0.131));
}
copia[copia.length-1]=(byte)((datos[copia.length-3]*0.272)+(datos[copia.length-2]*0.534)+(datos[copia.length-1]*0.131));
output_shift_2.write(copia);
output_shift_2.close();
}

}//end of class
