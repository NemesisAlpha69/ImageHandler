import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class BMPRunLengthEncoding {

            static FileInputStream input;
            static byte dataColors[] = new byte[0x4b000];
            static byte paletColors[] = new byte[1024];
            static byte copia[] = new byte[0x4b436];

            public BMPRunLengthEncoding() throws Exception {
/*  15*/        input = new FileInputStream("Image.bmp");
            }

            public static void RunLengthEncoding() throws Exception {
/*  19*/        FileOutputStream fileoutputstream = new FileOutputStream("Image-RLE.bmp");
/*  20*/        input = new FileInputStream("Image.bmp");
/*  21*/        byte abyte0[] = new byte[input.available()];
/*  22*/        input.read(abyte0);
/*  24*/        for (int i = 0; i < 3; i++) {
/*  25*/            copia[i] = abyte0[i];
                }

/*  28*/        int j = 0x4b436;
/*  29*/        copia[2] = (byte)(j & 0xff);
/*  30*/        copia[3] = (byte)(j >> 8 & 0xff);
/*  31*/        copia[4] = (byte)(j >> 16 & 0xff);
/*  32*/        copia[5] = (byte)(j >> 24 & 0xff);
/*  33*/        int k = copia[2] & 0xff;
/*  36*/        for (int l = 6; l < 9; l++) {
/*  37*/            copia[l] = abyte0[l];
                }

/*  39*/        char c = '\u0436';
/*  44*/        copia[10] = (byte)(c & 0xff);
/*  45*/        copia[11] = (byte)(c >> 8 & 0xff);
/*  46*/        copia[12] = (byte)(c >> 16 & 0xff);
/*  47*/        copia[13] = (byte)(c >> 24 & 0xff);
/*  50*/        for (int i1 = 14; i1 < 28; i1++) {
/*  51*/            copia[i1] = abyte0[i1];
                }

/*  53*/        byte byte0 = 8;
/*  55*/        copia[28] = (byte)(byte0 & 0xff);
/*  56*/        copia[29] = (byte)(byte0 >> 8 & 0xff);
/*  57*/        byte byte1 = copia[28];
/*  58*/        int j1 = copia[29] << 8;
/*  59*/        System.out.println("newbitcount");
/*  60*/        int k1 = byte1 + j1;
/*  61*/        System.out.println(k1);
/*  71*/        int l1 = 0x4b000;
/*  73*/        copia[34] = (byte)(l1 & 0xff);
/*  74*/        copia[35] = (byte)(l1 >> 8 & 0xff);
/*  75*/        copia[36] = (byte)(l1 >> 16 & 0xff);
/*  76*/        copia[37] = (byte)(l1 >> 24 & 0xff);
/*  79*/        for (int i2 = 38; i2 < 46; i2++) {
/*  80*/            copia[i2] = abyte0[i2];
                }

/*  84*/        for (int j2 = 46; j2 < 50; j2++) {
/*  85*/            copia[j2] = abyte0[j2];
                }

/*  88*/        for (int k2 = 50; k2 < 54; k2++) {
/*  89*/            copia[k2] = abyte0[k2];
                }

            }

            public static void Rle() throws Exception {
/*  94*/        FileOutputStream fileoutputstream = new FileOutputStream("Image-RLE.bmp");
/*  95*/        input = new FileInputStream("Image.bmp");
/*  96*/        byte abyte0[] = new byte[input.available()];
/*  97*/        input.read(abyte0);
/*  98*/        byte byte0 = 30;
/*  99*/        byte byte1 = 59;
/* 100*/        byte byte2 = 11;
/* 101*/        boolean flag = false;
/* 102*/        boolean flag1 = false;
/* 103*/        boolean flag2 = false;
/* 104*/        boolean flag3 = false;
/* 105*/        boolean flag4 = false;
/* 106*/        boolean flag5 = false;
        boolean flag6 = false;
        int k1 = 0;
/* 109*/        boolean flag7 = false;
/* 110*/        int l1 = 54;
        for (int i2 = 0; i2 < 0x4b000; i2++) {
           byte byte3 = abyte0[l1];
/* 114*/            int i = abyte0[++l1] << 8;
/* 115*/            int j = abyte0[++l1] << 16;
            int k = byte3 * byte2;
/* 117*/            int l = i * byte1;
            int i1 = j * byte0;
/* 119*/            int j1 = k + l + i1 / 100;
            dataColors[k1] = (byte)(j1 & 0xff);
/* 121*/            k1++;
            l1++;
                }

        int j2 = 0;
/* 126*/        int k2 = 0;
/* 127*/        byte byte4 = 0;
/* 128*/        for (byte byte5 = 0; k2 < 256; byte5++) {
/* 130*/            paletColors[j2] = byte5;
/* 131*/            paletColors[j2 + 1] = byte5;
/* 132*/            paletColors[j2 + 1] = byte5;
/* 133*/            paletColors[j2 + 1] = byte4;
/* 134*/            j2++;
            k2++;
                }

        System.out.println("********************************Palette Complete********************************");
        int l2 = 0;
        int i3 = 0;
        int j3 = 54;
        for (; l2 < 1024; l2++) {
            copia[j3] = paletColors[i3];
            j3++;
            i3++;
                }

        System.out.println("********************************GraysImage Complete********************************");
        int k3 = 0;
        int l3 = 0;
        int i4 = 1078;
       for (; k3 < 0x4b000; k3++) {
            copia[i4] = dataColors[l3];
            i4++;
            l3++;
               }

        fileoutputstream.write(copia);
        fileoutputstream.close();
            }

            public void RLE() {
        System.out.println("length de data colors");
      System.out.println(dataColors.length);
      LinkedList linkedlist = new LinkedList();
      boolean flag = false;
      boolean flag1 = false;
   boolean flag2 = true;
     boolean flag3 = false;
     boolean flag4 = false;
      boolean flag5 = false;
    boolean flag6 = false;
      boolean flag7 = false;
      boolean flag8 = false;
        int j = 1;
        int k = dataColors[0];
        int l = 0;
        boolean flag9 = false;
      boolean flag10 = false;
      while (k == dataColors[l])  {
          l++;
          j++;
             }
      if (--j == 255) {
          byte byte0 = (byte)j;
          byte byte5 = (byte)k;
          linkedlist.add(Byte.valueOf(byte0));
           linkedlist.add(Byte.valueOf(byte5));
          k = dataColors[l + 1];
               } else
      if (j < 255) {
          byte byte1 = (byte)j;
           byte byte6 = (byte)k;
           linkedlist.add(Byte.valueOf(byte1));
            linkedlist.add(Byte.valueOf(byte6));
               } else
       if (j > 255) {
           do {
                if (j <= 255) {
                   break;
                       }
               int i = j;
                do {
                    j -= 255;
                       } while (j > 255);
                if (j == 255) {
                    byte byte2 = (byte)j;
                    byte byte7 = (byte)k;
                       }
                if (j < 255) {
                    int i1 = 255 - j;
                    i -= i1;
                    j += i1;
                   byte byte3 = (byte)j;
                    byte byte8 = (byte)k;
                      }
                if (i < 255) {
                    byte byte4 = (byte)i;
                   byte byte9 = (byte)k;
                       } else
                if (i > 255) {
                    j = i;
                        }
                    } while (true);
                }
            }

}
