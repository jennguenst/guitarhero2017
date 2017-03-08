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
        numOfTics = 0;
        int mainCapacity = (int) Math.ceil(SAMPLINGRATE / frequency);
        capacityForBuffer = mainCapacity;
        ring = new RingBuffer(mainCapacity);
        while(!ring.isFull()){
            ring.enqueue(0);

        }
    }

    public GuitarString(double[] init){// create a guitar string whose size and initial values are given by the array
        numOfTics = 0;
        ring = new RingBuffer(init.length);
        for(int a = 0; a < init.length; a++){
              ring.enqueue(init[a]);

        }

    }

    // methods
    public void pluck(){// set the buffer to white noise
        for(int i = 0; i < capacityForBuffer; i++){
            double random = Math.random() - 0.5;
            ring.enqueue(random);

        }

    }
    public void tic(){// advance the simulation one time step
        double stepOne = ring.dequeue();
        double stepTwo = sample();
        double calculation = DECAYFACTOR * ((stepOne + stepTwo) / 2);
        ring.enqueue(calculation);
        numOfTics++;

    }
    public double sample(){// returns the current sample
        return ring.peek();

    }
    public int time(){ // return num of tics
        return numOfTics;

    }


}
