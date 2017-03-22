/*
 *Name    = Jennifer Guenst
 *Class   = CS 1233
 *Time    = 2:00 PM MWF
 *Program = Guitar String setup class.
 */



import java.lang.Math;
import java.util.Scanner;

public class GuitarString{
    // Attributes
    private final int SAMPLINGRATE = 44100;
    private final double DECAYFACTOR = 0.994;
    private int capacityForBuffer;
    private int numOfTics;
    private RingBuffer ring;
    //Constructors
    public GuitarString(){}

    public GuitarString(double frequency){// create a guitar string of the given frequency, using a sampling rate of 44,100
      try{
        numOfTics = 0;
        int mainCapacity = (int) Math.ceil(SAMPLINGRATE / frequency);
        capacityForBuffer = mainCapacity;
        ring = new RingBuffer(mainCapacity);
        while(!ring.isFull()){
            ring.enqueue(0);
          }

          }
          catch(Exception e){
            System.out.println("Caught: " + e);

              }
        }


    public GuitarString(double[] init){// create a guitar string whose size and initial values are given by the array
        try{
          numOfTics = 0;
          ring = new RingBuffer(init.length);
          for(int a = 0; a < init.length; a++){
                ring.enqueue(init[a]);
        }



        }
        catch(Exception ex){
          System.out.println("Caught: " + ex);
        }

    }

    // methods
    public void pluck(){// set the buffer to white noise
        try{

          for(int i = 0; i < capacityForBuffer; i++){
              double random = Math.random() - 0.5;
              ring.enqueue(random);

        }


        }
        catch(Exception exc){
          System.out.println("Caught: " + exc);
        }

    }
    public void tic(){// advance the simulation one time step
      try{
          double stepOne = ring.dequeue();
          double stepTwo = sample();
          double calculation = DECAYFACTOR * ((stepOne + stepTwo) / 2);
          ring.enqueue(calculation);
          numOfTics++;
      }
      catch(Exception exce)
      {
        System.out.println("Caught: " + exce);
      }

    }
    public double sample(){// returns the current sample
      try{
        return ring.peek();
      }
      catch(Exception excep){

        System.out.println("Caught: " + excep);

      }
      return 0.0;
    }
    public int time(){ // return num of tics
        return numOfTics;

    }


}
