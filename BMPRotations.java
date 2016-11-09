import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BMPRotations {

    FileInputStream input;

public BMPRotations() throws Exception {
    input = new FileInputStream("Image.bmp");
    }

public void Hr() throws Exception{
    FileOutputStream fileoutputstream = new FileOutputStream("Image-HR.bmp");
    byte datos[] = new byte[input.available()];
    input.read(datos);
    byte copia[]= new byte[datos.length];
    System.out.println(copia.length);
  for (int i=0;i<54;i++) {
        copia[i]=datos[i];
    }
    int p=datos.length-1;
    for (int j=54;j<datos.length;j++) {
        copia[j]=datos[p];
        p--;
    }
    
    fileoutputstream.write(copia);
    fileoutputstream.close();            
}//end of Hr*/

public void HRotate() throws Exception {
        FileOutputStream fileoutputstream = new FileOutputStream("Image-VR.bmp");
        byte abyte0[] = new byte[input.available()];
        input.read(abyte0);
        byte abyte1[] = new byte[abyte0.length];
        for (int i = 0; i <= 53; i++) {
            abyte1[i] = abyte0[i];
                }

        int j = 54;
        int k = abyte0.length - 1;
        for (int i = 0; i < 959; i++) {
            for (int i1 = 0; i1 < 1920; i1++) {
                abyte1[j] = abyte0[k];
                abyte1[j + 1] = abyte0[k - 1];
                abyte1[j + 1] = abyte0[k - 1];
                j++;
                i1++;
                k--;
                    }

/*  33*/            j++;
/*  34*/            k--;
                }

/*  38*/        fileoutputstream.write(abyte1);
/*  39*/        fileoutputstream.close();
            }

            public void Efecto() throws Exception {
/*  43*/        FileOutputStream fileoutputstream = new FileOutputStream("Image-Efecto.bmp");
/*  44*/        byte abyte0[] = new byte[input.available()];
/*  45*/        input.read(abyte0);
/*  46*/        byte abyte1[] = new byte[abyte0.length];
/*  47*/        for (int i = 0; i <= 53; i++) {
/*  48*/            abyte1[i] = abyte0[i];
                }

/*  51*/        int j = 54;
/*  52*/        int k = abyte0.length - 1921;
/*  53*/        for (int l = 0; l < 720; l++) {
/*  55*/            for (int i1 = 0; i1 < 1920; i1++) {
/*  56*/                abyte1[j] = abyte0[k];
/*  57*/                j++;
/*  58*/                i1++;
/*  59*/                k++;
                    }

/*  62*/            j += 320;
/*  63*/            k -= 1921;
                }

/*  65*/        fileoutputstream.write(abyte1);
/*  66*/        fileoutputstream.close();
            }
}



/*byte copia_2[]= new byte[copia.length];
for (int m=0;m<54;m++) {//copia el header
    copia_2[m]=copia[m];
}
int o=copia.length-1;
for (int q=54;q<copia.length;q++) {
    copia_2[q]=copia[o];
    o-=1;
}*/