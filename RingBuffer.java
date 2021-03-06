/*
 *Name    = Jennifer Guenst
 *Class   = CS 1233
 *Time    = 2:00 PM MWF
 *Program = Buffer data structure as first in, first out.
 */

import java.util.Scanner;

public class RingBuffer{
  //Attributes
  private int head; // where to remove elements
  private int tail; // where to add elements
  private int numElements;
  private double buffer[];
  private int capacityActual;

  public RingBuffer()
  {}
  public RingBuffer(int capacity)
  {
      numElements = 0;
      capacityActual = capacity;
      this.buffer = new double[capacity];
      head = 0;
      tail = head;

  }
  public int size(){          //checks array size
      return numElements;
    }
  public boolean isEmpty(){   //checks if array is empty
      if(numElements == 0){
        return true;
      }
      else{
        return false;

      }

  }
  public boolean isFull(){   //checks if array is full
      if(numElements == capacityActual){
        return true;
      }
      else{
        return false;
      }
  }
  public void enqueue(double x) throws Exception{
    if(tail == capacityActual){
      tail = 0;
      enqueue(x);
    }
    else if(isFull()){
        if(head != tail){
            throw new Exception("ERROR! CANNOT ENQUEUE WHEN FULL!");


        }
        buffer[tail] = x;
        if(head + 1 == capacityActual){
          head = 0;
        }
        else{
          head++;
        }
        tail++;
    }
    else{
      buffer[tail] = x;
      tail++;
      numElements++;

    }
  }

  public double dequeue()throws Exception{   //returns and deletes first item
    if(isEmpty()){
        throw new Exception("ERROR! CANNOT DEQUEUE WHEN EMPTY!");


    }
    double value = buffer[head];
    if(head == capacityActual - 1){
        head = 0;
    }
    else{
        head++;

    }
    numElements--;
    return value;

  }
  public double peek() throws Exception{     //returns but doesnt delete first item in array
    if(isEmpty()){
        throw new Exception("ERROR! CANNOT PEEK WHEN EMPTY!");


    }
    else{
      return buffer[head];

    }



}
}
