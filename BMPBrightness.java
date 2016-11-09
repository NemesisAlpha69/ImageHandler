import java.util.*;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
import java.io.FileOutputStream;
import java.io.FileInputStream;
public class BMPBrightness{
FileInputStream input; 
//*********constructor*******************
public BMPBrightness()throws Exception{
input = new FileInputStream("Image.bmp");
}
public void BR()throws Exception{
FileOutputStream output_shift_2 = new FileOutputStream("Image-Bright.bmp");
byte[] datos = new byte [input.available()];
input.read(datos);
byte[] copia = new byte[datos.length];//copia generate con el mismo length
for (int i = 0;i<= 53;i++ ) { //copia el header
    copia[i] = datos[i];
    //System.out.println(copia);
}
System.out.println(datos.length);
for (int j=54;j<copia.length-2;j+=1) {//new red
    copia[j]=(byte)(datos[j]*0.393+datos[j+=1]*0.769+datos[j+=1]*0.189);
}
for (int i=55;i<datos.length-2;i+=1) {//new green
    copia[i]=(byte)(datos[i]*0.349+datos[i+=1]*0.686+datos[i+=1]*0.168);
}    
copia[copia.length-2]=(byte)(datos[copia.length-3]*0.349+datos[copia.length-2]*0.686+datos[copia.length-1]*0.168);
for (int i=56;i<datos.length-2;i+=1) {//new blue
    copia[i]=(byte)(datos[i]*0.272+datos[i+=1]*0.534+datos[i+=1]*0.131);
}
copia[copia.length-1]=(byte)(datos[copia.length-3]*0.272+datos[copia.length-2]*0.534+datos[copia.length-1]*0.131);
output_shift_2.write(copia);
output_shift_2.close();
}


public void DR()throws Exception{
FileOutputStream output_shift_2 = new FileOutputStream("Image-Dark.bmp");
byte[] datos = new byte [input.available()];
input.read(datos);
byte[] copia = new byte[datos.length];//copia generate con el mismo length
for (int i = 0;i<= 53;i++ ) { //copia el header
    copia[i] = datos[i];
    //System.out.println(copia);
}
System.out.println(datos.length);
for (int j=54;j<copia.length-2;j+=1) {//new red
    copia[j]=(byte)((datos[j]*0.2126)+(datos[j+=1]*0.7152)+(datos[j+=1]*0.0722) );
}

for (int i=55;i<datos.length-2;i+=1) {//new green
    copia[i]=(byte)((datos[i]*0.299)+(datos[i+=1]*0.587)+(datos[i+=1]*0.114));
}    
copia[copia.length-2]=(byte)((datos[copia.length-3]*0.299)+(datos[copia.length-2]*0.587)+(datos[copia.length-1]*0.114));


for (int i=56;i<datos.length-2;i+=1) {//new blue
    copia[i]=(byte)(Math.sqrt( ((datos[i]^2)*0.299)+((datos[i+=1]^2)*0.587)+((datos[i+=1]^2)*0.114)));
}
copia[copia.length-1]=(byte)(Math.sqrt( ((datos[copia.length-3]^2)*0.299)+((datos[copia.length-2]^2)*0.587)+((datos[copia.length-1]^2)*0.114)));

output_shift_2.write(copia);
output_shift_2.close();
}
}//class BMPBrightness