import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class BMPGrayscale {

            static FileInputStream input;
            static byte dataColors[] = new byte[0x4b000];
            static byte paletColors[] = new byte[1024];
            static byte copia[] = new byte[0x4b436];

            public BMPGrayscale() throws Exception {
/*  12*/        input = new FileInputStream("Image.bmp");
            }

            public static void InfoHeader() throws Exception {
/*  15*/        byte abyte0[] = new byte[input.available()];
/*  16*/        input.read(abyte0);
/*  19*/        System.out.println("Firma");
/*  20*/        for (int i = 0; i < 2; i++) {
/*  21*/            int k = abyte0[i] & 0xff;
/*  22*/            System.out.printf((new StringBuilder()).append((char)k).append(",").toString(), new Object[0]);
                }

/*  24*/        System.out.println("");
/*  26*/        System.out.println("tamanio de archivo");
/*  27*/        int j = abyte0[2] & 0xff;
/*  28*/        System.out.println(j);
/*  29*/        int l = (abyte0[3] & 0xff) << 8;
/*  30*/        System.out.println(l);
/*  31*/        int i1 = (abyte0[4] & 0xff) << 16;
/*  32*/        System.out.println(i1);
/*  33*/        int j1 = (abyte0[5] & 0xff) << 24;
/*  34*/        System.out.println(j1);
/*  35*/        int k1 = j + l + i1 + j1;
/*  36*/        System.out.println(k1);
/*  40*/        System.out.println("reserv");
/*  41*/        byte byte0 = 0;
/*  42*/        for (int l1 = 6; l1 < 10; l1++) {
/*  43*/            byte byte2 = 8;
/*  44*/            int l2 = (abyte0[l1] & 0xff) << byte2 * byte0++;
/*  45*/            System.out.println(l2);
                }

/*  47*/        System.out.println("dataOffset");
/*  48*/        byte byte1 = 0;
/*  49*/        for (int i2 = 10; i2 < 14; i2++) {
/*  50*/            byte byte3 = 8;
/*  51*/            int i3 = (abyte0[i2] & 0xff) << byte3 * byte1++;
/*  52*/            System.out.println(i3);
                }

/*  54*/        System.out.println("tamanio = 40");
/*  55*/        for (int j2 = 14; j2 < 18; j2++) {
/*  56*/            byte byte4 = 8;
/*  57*/            int j3 = 0;
/*  58*/            int i4 = (abyte0[j2] & 0xff) << byte4 * j3++;
/*  59*/            System.out.println(i4);
                }

/*  61*/        System.out.println("ancho width");
/*  62*/        int k2 = 0;
/*  63*/        byte byte5 = 0;
/*  64*/        for (int k3 = 18; k3 < 22; k3++) {
/*  65*/            byte byte6 = 8;
/*  66*/            int j4 = (abyte0[k3] & 0xff) << byte6 * byte5++;
/*  68*/            k2 += j4;
                }

/*  70*/        System.out.println(k2);
/*  72*/        System.out.println("altura height");
/*  73*/        int l3 = 0;
/*  74*/        byte byte7 = 0;
/*  75*/        for (int k4 = 22; k4 < 26; k4++) {
/*  76*/            byte byte8 = 8;
/*  77*/            int j5 = (abyte0[k4] & 0xff) << byte8 * byte7++;
/*  78*/            l3 += j5;
                }

/*  80*/        System.out.println(l3);
/*  82*/        System.out.println("planes = 1");
/*  83*/        int l4 = abyte0[26] & 0xff;
/*  84*/        int i5 = (abyte0[27] & 0xff) << 8;
/*  85*/        int k5 = l4 + i5;
/*  86*/        System.out.println(k5);
/*  88*/        System.out.println("bitcount: bits por pixel\n1 = palet monocromatic.Num colors =2\n4 = 4bits palletized.Num colors = 16\n8 = 8bits palletized.Num colors = 256\n16=16bits RBG.Num colors = 65536(?)");
/*  89*/        System.out.println("if 24 = 24bit.RGB.Num.colors =16M");
/*  90*/        byte byte9 = abyte0[28];
/*  91*/        int l5 = abyte0[29] << 8;
/*  92*/        System.out.println(byte9);
/*  93*/        System.out.println(l5);
/*  95*/        System.out.println("Compresion rle:\n0 = sin compresion\n1 = compresion 8 bits");
/*  96*/        int i6 = abyte0[30] & 0xff;
/*  97*/        int j6 = (abyte0[31] & 0xff) << 8;
/*  98*/        int k6 = (abyte0[32] & 0xff) << 16;
/*  99*/        int l6 = (abyte0[33] & 0xff) << 24;
/* 100*/        int i7 = i6 + j6 + k6 + l6;
/* 101*/        System.out.println(i7);
/* 103*/        System.out.println("IMAGE SIZE: comprimido tamanio de la imagen");
/* 104*/        int j7 = abyte0[34] & 0xff;
/* 105*/        int k7 = (abyte0[35] & 0xff) << 8;
/* 106*/        int l7 = (abyte0[36] & 0xff) << 16;
/* 107*/        int i8 = (abyte0[37] & 0xff) << 24;
/* 108*/        int j8 = j7 + k7 + l7 + i8;
/* 109*/        System.out.println(j8);
/* 111*/        System.out.println("resolucion Horizontal: Pixeles Por METRO");
/* 112*/        boolean flag = false;
/* 113*/        int l8 = 0;
/* 114*/        byte byte10 = 0;
/* 115*/        for (int i9 = 38; i9 < 42; i9++) {
/* 116*/            byte byte11 = 8;
/* 117*/            int k8 = (abyte0[i9] & 0xff) << byte11 * byte10++;
/* 118*/            int l9 = (abyte0[i9] & 0xff) << byte11 * byte10++;
/* 119*/            int i10 = (abyte0[++i9] & 0xff) << byte11 * byte10++;
/* 120*/            int l10 = (abyte0[++i9] & 0xff) << byte11 * byte10++;
/* 121*/            l8 += k8 + l9 + i10 + l10;
                }

/* 122*/        System.out.println(l8);
/* 124*/        System.out.println("resolucion vertical pixeles por metro");
/* 125*/        boolean flag1 = false;
/* 126*/        int k9 = 0;
/* 127*/        byte byte12 = 0;
/* 128*/        for (int j10 = 42; j10 < 45; j10++) {
/* 129*/            byte byte13 = 8;
/* 130*/            int j9 = (abyte0[j10] & 0xff) << byte13 * byte12++;
/* 131*/            int j11 = (abyte0[j10] & 0xff) << byte13 * byte12++;
/* 132*/            int k11 = (abyte0[++j10] & 0xff) << byte13 * byte12++;
/* 133*/            int j12 = (abyte0[++j10] & 0xff) << byte13 * byte12++;
/* 134*/            k9 += j9 + j11 + k11 + j12;
                }

/* 135*/        System.out.println(k9);
/* 137*/        System.out.println("Numero de colores utilizados en realidad");
/* 138*/        boolean flag2 = false;
/* 139*/        int i11 = 0;
/* 140*/        byte byte14 = 0;
/* 141*/        for (int l11 = 46; l11 < 49; l11++) {
/* 142*/            byte byte15 = 8;
/* 143*/            int k10 = (abyte0[l11] & 0xff) << byte15 * byte14++;
/* 144*/            int l12 = (abyte0[l11] & 0xff) << byte15 * byte14++;
/* 145*/            int j13 = (abyte0[++l11] & 0xff) << byte15 * byte14++;
/* 146*/            int k13 = (abyte0[++l11] & 0xff) << byte15 * byte14++;
/* 147*/            i11 += k10 + l12 + j13 + k13;
                }

/* 148*/        System.out.println(i11);
/* 149*/        System.out.println("\n");
/* 151*/        System.out.println("Colors Important = 0 all\npreset only if info.BitsPerPixel <=8");
/* 152*/        int i12 = 0;
/* 153*/        int k12 = 0;
/* 154*/        for (int i13 = 50; i13 < 54; i13++) {
/* 155*/            byte byte16 = 8;
/* 156*/            int l13 = (abyte0[i13] & 0xff) << byte16 * i12++;
/* 157*/            k12 += l13;
                }

/* 159*/        System.out.println(k12);
/* 160*/        System.out.println("WELLCOME TO PALET COLORS 4*NumColors bytes \npreset only if info.BitsPerPixel <=8");
            }

            public static void Grayscale() throws Exception {
/* 165*/        input = new FileInputStream("Image.bmp");
/* 166*/        byte abyte0[] = new byte[input.available()];
/* 167*/        input.read(abyte0);
/* 169*/        for (int i = 0; i < 3; i++) {
/* 170*/            copia[i] = abyte0[i];
                }

/* 173*/        boolean flag = false;
/* 174*/        byte byte0 = 0;
/* 175*/        byte byte1 = 8;
/* 176*/        int k = 0;
/* 177*/        for (int l = 2; l < 6; l++) {
/* 178*/            int j = (abyte0[l] & 0xff) << byte1 * byte0++;
/* 179*/            k += j;
                }

/* 182*/        int i1 = 0x4b436;
/* 183*/        System.out.println("size anterior");
/* 184*/        System.out.println(k);
/* 185*/        System.out.println("newSize");
/* 188*/        copia[2] = (byte)(i1 & 0xff);
/* 189*/        copia[3] = (byte)(i1 >> 8 & 0xff);
/* 190*/        copia[4] = (byte)(i1 >> 16 & 0xff);
/* 191*/        copia[5] = (byte)(i1 >> 24 & 0xff);
/* 192*/        int j1 = copia[2] & 0xff;
/* 194*/        System.out.println((new StringBuilder()).append(j1).append(" byte A").toString());
/* 195*/        int k1 = (copia[3] & 0xff) << 8;
/* 196*/        System.out.println((new StringBuilder()).append(k1).append(" Byte B").toString());
/* 197*/        int l1 = (copia[4] & 0xff) << 16;
/* 198*/        System.out.println((new StringBuilder()).append(l1).append(" BYTE C").toString());
/* 199*/        int i2 = (copia[5] & 0xff) << 24;
/* 200*/        System.out.println((new StringBuilder()).append(i2).append(" byte D").toString());
/* 201*/        int j2 = j1 + k1 + l1 + i2;
/* 202*/        System.out.println("size de copia");
/* 203*/        System.out.println(j2);
/* 206*/        for (int k2 = 6; k2 < 9; k2++) {
/* 207*/            copia[k2] = abyte0[k2];
                }

/* 209*/        byte byte2 = 0;
/* 210*/        int l2 = 0;
/* 211*/        for (int i3 = 10; i3 < 14; i3++) {
/* 212*/            byte byte3 = 8;
/* 213*/            l2 = (abyte0[i3] & 0xff) << byte3 * byte2++;
/* 214*/            System.out.println("dataOffset anterior");
/* 215*/            System.out.println(l2);
                }

/* 217*/        char c = '\u0436';
/* 218*/        System.out.println("NEW dataOffset");
/* 219*/        int j3 = c | l2;
/* 220*/        System.out.println(j3);
/* 222*/        copia[10] = (byte)(c & 0xff);
/* 223*/        copia[11] = (byte)(c >> 8 & 0xff);
/* 224*/        copia[12] = (byte)(c >> 16 & 0xff);
/* 225*/        copia[13] = (byte)(c >> 24 & 0xff);
/* 227*/        int k3 = copia[10] & 0xff;
/* 228*/        int l3 = (copia[11] & 0xff) << 8;
/* 229*/        int i4 = (copia[12] & 0xff) << 16;
/* 230*/        int j4 = (copia[13] & 0xff) << 24;
/* 231*/        int k4 = k3 + l3 + i4 + j4;
/* 232*/        System.out.println("new data dataOffset");
/* 233*/        System.out.println(k4);
/* 235*/        for (int l4 = 14; l4 < 28; l4++) {
/* 236*/            copia[l4] = abyte0[l4];
                }

/* 239*/        byte byte4 = abyte0[28];
/* 240*/        int i5 = abyte0[29] << 8;
/* 241*/        int j5 = byte4 + i5;
/* 242*/        System.out.println("bitCount");
/* 243*/        System.out.println(j5);
/* 244*/        byte byte5 = 8;
/* 245*/        int k5 = j5 & byte5;
/* 246*/        copia[28] = (byte)(byte5 & 0xff);
/* 247*/        copia[29] = (byte)(byte5 >> 8 & 0xff);
/* 248*/        byte byte6 = copia[28];
/* 249*/        int l5 = copia[29] << 8;
/* 250*/        System.out.println("newbitcount");
/* 251*/        int i6 = byte6 + l5;
/* 252*/        System.out.println(i6);
/* 254*/        System.out.println("Compresion rle:\n0 = sin compresion\n1 = compresion 8 bits");
/* 255*/        int j6 = abyte0[30] & 0xff;
/* 256*/        int k6 = (abyte0[31] & 0xff) << 8;
/* 257*/        int l6 = (abyte0[32] & 0xff) << 16;
/* 258*/        int i7 = (abyte0[33] & 0xff) << 24;
/* 259*/        int j7 = j6 + k6 + l6 + i7;
/* 260*/        System.out.println("anterior compresion");
/* 261*/        System.out.println(j7);
/* 262*/        for (int k7 = 30; k7 < 34; k7++) {
/* 263*/            copia[k7] = copia[k7];
                }

/* 272*/        int l7 = copia[30] & 0xff;
/* 273*/        int i8 = (copia[31] & 0xff) << 8;
/* 274*/        int j8 = (copia[32] & 0xff) << 16;
/* 275*/        int k8 = (copia[33] & 0xff) << 24;
/* 276*/        int l8 = l7 + i8 + j8 + k8;
/* 277*/        System.out.println("nueva compresion");
/* 278*/        System.out.println(l8);
/* 280*/        int i9 = abyte0[34] & 0xff;
/* 281*/        int j9 = (abyte0[35] & 0xff) << 8;
/* 282*/        int k9 = (abyte0[36] & 0xff) << 16;
/* 283*/        int l9 = (abyte0[37] & 0xff) << 24;
/* 284*/        int i10 = i9 + j9 + k9 + l9;
/* 285*/        System.out.println("image size(Compresion) anterior ");
/* 286*/        System.out.println(i10);
/* 288*/        int j10 = 0x4b000;
/* 289*/        int k10 = i10 | j10;
/* 290*/        byte byte7 = (byte)(j10 & 0xff);
/* 291*/        byte byte8 = (byte)(j10 >> 8 & 0xff);
/* 292*/        byte byte9 = (byte)(j10 >> 16 & 0xff);
/* 293*/        byte byte10 = (byte)(j10 >> 24 & 0xff);
/* 295*/        copia[34] = (byte)(j10 & 0xff);
/* 296*/        copia[35] = (byte)(j10 >> 8 & 0xff);
/* 297*/        copia[36] = (byte)(j10 >> 16 & 0xff);
/* 298*/        copia[37] = (byte)(j10 >> 24 & 0xff);
/* 300*/        int l10 = copia[34] & 0xff;
/* 301*/        int i11 = (copia[35] & 0xff) << 8;
/* 302*/        int j11 = (copia[36] & 0xff) << 16;
/* 303*/        int k11 = (copia[37] & 0xff) << 24;
/* 304*/        int l11 = l10 + i11 + j11 + k11;
/* 305*/        System.out.println("image size(Compresion) new ");
/* 306*/        System.out.println(l11);
/* 308*/        for (int i12 = 38; i12 < 46; i12++) {
/* 309*/            copia[i12] = abyte0[i12];
                }

/* 313*/        for (int j12 = 46; j12 < 50; j12++) {
/* 314*/            copia[j12] = abyte0[j12];
                }

/* 317*/        for (int k12 = 50; k12 < 54; k12++) {
/* 318*/            copia[k12] = abyte0[k12];
                }

            }

            public static void PaletColors() throws Exception {
/* 325*/        input = new FileInputStream("Image.bmp");
/* 326*/        FileOutputStream fileoutputstream = new FileOutputStream("Image-Grayscale.bmp");
/* 327*/        byte abyte0[] = new byte[input.available()];
/* 328*/        input.read(abyte0);
/* 330*/        byte byte0 = 30;
/* 331*/        byte byte1 = 59;
/* 332*/        byte byte2 = 11;
/* 333*/        boolean flag = false;
/* 334*/        boolean flag1 = false;
/* 335*/        boolean flag2 = false;
/* 336*/        boolean flag3 = false;
/* 337*/        boolean flag4 = false;
/* 338*/        boolean flag5 = false;
/* 339*/        boolean flag6 = false;
/* 340*/        int k1 = 0;
/* 341*/        boolean flag7 = false;
/* 342*/        int l1 = 54;
/* 343*/        for (int i2 = 0; i2 < 0x4b000; i2++) {
/* 345*/            byte byte3 = abyte0[l1];
/* 346*/            int i = abyte0[++l1] << 8;
/* 347*/            int j = abyte0[++l1] << 16;
/* 348*/            int k = byte3 * byte2;
/* 349*/            int l = i * byte1;
/* 350*/            int i1 = j * byte0;
/* 351*/            int j1 = k + l + i1 / 100;
/* 352*/            int j2 = (byte)(j1 & 0xff);
/* 354*/            dataColors[k1] = (byte)j2;
/* 356*/            k1++;
/* 357*/            l1++;
                }

/* 360*/        boolean flag8 = false;
/* 361*/        for (int k2 = 0; k2 < dataColors.length; k2++) {
/* 362*/            byte byte4 = dataColors[k2];
                }

/* 367*/        int l2 = 0;
/* 368*/        int i3 = 0;
/* 369*/        byte byte5 = 0;
/* 370*/        for (byte byte6 = 0; i3 < 256; byte6++) {
/* 372*/            paletColors[l2] = byte6;
/* 373*/            paletColors[l2 + 1] = byte6;
/* 374*/            paletColors[l2 + 1] = byte6;
/* 375*/            paletColors[l2 + 1] = byte5;
/* 376*/            l2++;
/* 377*/            i3++;
                }

/* 381*/        System.out.println("********************************Palette Complete********************************");
/* 383*/        int j3 = 0;
/* 384*/        int k3 = 0;
/* 385*/        int l3 = 54;
/* 386*/        for (; j3 < 1024; j3++) {
/* 387*/            copia[l3] = paletColors[k3];
/* 388*/            l3++;
/* 389*/            k3++;
                }

/* 393*/        System.out.println("********************************GraysImage Complete********************************");
/* 394*/        int i4 = 0;
/* 395*/        int j4 = 0;
/* 396*/        int k4 = 1078;
/* 397*/        for (; i4 < 0x4b000; i4++) {
/* 398*/            copia[k4] = dataColors[j4];
/* 399*/            k4++;
/* 400*/            j4++;
                }

/* 403*/        fileoutputstream.write(copia);
/* 404*/        fileoutputstream.close();
            }
}
