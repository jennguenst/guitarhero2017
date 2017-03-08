

/*
 *Name    = Jennifer Guenst
 *Class   = CS 1233
 *Time    = 2:00 PM MWF
 *Program = Buffer data structure as first in, first out.
 */
import java.lang.Math;
import stdlib.*;
public class GuitarHero{
   private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
   public static void main(String[] args) {


         GuitarString[] stringsArray = new GuitarString[keyboard.length()];
         // create the base string for Concert A
         for(int i = 0; i < stringsArray.length; i++){
              double frequenz = 440.0 * Math.pow(1.05956, (i - 24));
              stringsArray[i] = new GuitarString(frequenz);

         }
         while (true) {

             // check if the user has typed a key; if so, process it
             if (StdDraw.hasNextKeyTyped()) {
                 char key = StdDraw.nextKeyTyped();
                 if(keyboard.contains(String.valueOf(key)))
                      stringsArray[keyboard.indexOf(key)].pluck();

                 }


             // compute the superposition of samples
             double sample = 0.0;
             for(int j = 0; j < stringsArray.length; j++){
                  sample = sample + stringsArray[j].sample();

             }

             // play the sample on standard audio
             StdAudio.play(sample);

            for(int t = 0; t < stringsArray.length; t++){
              stringsArray[t].tic();
            }


         }
      }
}
