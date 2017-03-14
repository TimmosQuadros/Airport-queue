package com.mycompany.assignment2airportqueue;



import java.util.ArrayList;
import java.util.List;

public class Program {
  private static List<Plane> planes = new ArrayList<>();
  private static PassengerProducer producer;
  private static PassengerConsumer consumer;
  private static PriorityQueue<Passenger> queue;
  private static Clock clock;
  
  private static void setup() {
    for (int hour = 7; hour <= 22; hour++) {
      planes.add(new Plane(new Time(hour, 00, 00)));
      }
    //queue = new NotPrioritisingPassengerArrayQueue(10000); //Replace with ur own queue
    queue = new PassengerHeap(10000);
    producer = new PassengerProducer(planes, queue);
    consumer = new PassengerConsumer(planes, queue);
    clock = new Clock(producer, consumer, new Time(05, 00, 00));
    }
  
  public static void main(String[] args) {
    setup();
    System.out.println("Hello Airport");
    new Thread(clock).start(); //Remove when you need to run simulation

//        PassengerHeap ph = new PassengerHeap(11);
//        ph.enqueue(new Passenger(1, new Time(10, 0, 0), Category.Family, new Plane(new Time(5, 0, 0))));
//        ph.enqueue(new Passenger(2, new Time(10, 0, 0), Category.Family, new Plane(new Time(5, 0, 0))));
//        ph.enqueue(new Passenger(3, new Time(10, 0, 0), Category.Family, new Plane(new Time(5, 0, 0))));
//        ph.enqueue(new Passenger(4, new Time(10, 0, 0), Category.Family, new Plane(new Time(5, 0, 0))));
//        ph.enqueue(new Passenger(5, new Time(10, 0, 0), Category.Family, new Plane(new Time(5, 0, 0))));
//        ph.enqueue(new Passenger(6, new Time(10, 0, 0), Category.Family, new Plane(new Time(5, 0, 0))));
//        ph.enqueue(new Passenger(7, new Time(10, 0, 0), Category.Disabled, new Plane(new Time(5, 0, 0))));
//        ph.enqueue(new Passenger(8, new Time(10, 0, 0), Category.BusinessClass, new Plane(new Time(5, 0, 0))));
//        ph.enqueue(new Passenger(9, new Time(10, 0, 0), Category.BusinessClass, new Plane(new Time(5, 0, 0))));
//        ph.enqueue(new Passenger(10, new Time(10, 0, 0), Category.LateToFlight, new Plane(new Time(5, 0, 0))));
//        Passenger[] item = ph.getData();
//        System.out.print("BeginArray[");
//        for (int i = 1; i < ph.size()+1; i++) {
//          
//          if(ph.size()!=i){System.out.print(item[i].getCategory()+",");}else{
//                    System.out.print(item[i].getCategory());
//                }
//      }
//        System.out.println("]");
//        
//        System.out.println("Size: "+ph.size());
//        final int startingSize = ph.size()+1;
//        for (int i = 1; i < startingSize; i++) {
//            System.out.println("Remove: "+ph.dequeue().getCategory());
//            System.out.print("ResultArray[");
//            for (int j = 1; j < ph.size()+1; j++) {
//                if(ph.size()!=j){System.out.print(item[j].getCategory()+",");}else{
//                    System.out.print(item[j].getCategory());
//                }
//            }
//            System.out.println("]");
//        }
    
    }
  
  }
