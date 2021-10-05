import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;


public class fajl {
    
    public static void main(String[] args) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("Text.txt"));
            Random rand = new Random();
            int a = 0;
            while (a < 1000) {
                int pickedNumber = rand.nextInt(14) + 1;
                int[] niz = new int[pickedNumber];
                for (int i = 0; i < niz.length; i++) {
                    int numberArray = rand.nextInt(10);
                    niz[i] = numberArray;
                }
                String s = Arrays.toString(niz);
                s = s.substring(1, s.length()-1);
                int[] n = new int[niz.length];
                int j = 0;
                for (int i = 0; i < niz.length; i++) {
                    if (niz[i] != 0) {
                        n[j] = niz[i];
                        j++;
                    }
                }
                    String b = Arrays.toString(n);
                    b = b.substring(1, b.length() - 1);
                bw.append("assertEquals(new int[]{" + b +"}, imeFunkcije(new int[]{" + s + "});");
                bw.newLine();
                    a++;
                }
            bw.close();
            }
         catch (IOException e) {
            e.printStackTrace();
        }

    }
}
