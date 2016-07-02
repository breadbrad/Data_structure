/** Deque interface 
	insertions and removals from both ends (front & rear) */
/** Class to simulate a queue of passengers.
 *  @author Koffman & Wolfgang
 * */
import java.util.*;

class AirlineCheckin {
	private PassengerQueue frequentFlyerQueue = new PassengerQueue("Frequent Flyer");
	private PassengerQueue regularPassengerQueue = new PassengerQueue("Regular Passenger");
	private int frequentFlyerMax;
	private int maxProcessingTime;
	private int totaltime;
	private boolean showAll;
	private int clock;
	private int timeDone;
	private int frequentFlyersSinceRP;


	public static void main(String[] args) {
		AirlineCheckin sim = new AirlineCheckin();
		/** enterData gets the input values */
		sim.enterData();
		sim.runSimulation();
		sim.showStats();
		System.exit(0);
	}
	/** executed for each minute of simulated time 
		checkNewArrival -> checks each line whether any new passengers have arrived  */
	private void runSimulation() {
		for (clock = 0; clock < totaltime; clock++) {
			frequentFlyerQueue.checkNewArrival(clock, showAll);
			regularPassengerQueue.checkNewArrival(clock, showAll);
			if (clock >= timeDone) {
				startServe();
			}
		}
	}

	private void startServe() {
		if(!frequentFlyerQueue.isEmpty() && ((frequentFlyersSinceRP <= frequentFlyerMax) || regularPassengerQueue.isEmpty())) {
			frequentFlyersSinceRP++;
			timeDone = frequentFlyerQueue.update(clock, showAll);
		} else if (!regularPassengerQueue.isEmpty()){ 
			frequentFlyersSinceRP = 0;
			timeDone = regularPassengerQueue.update(clock, showAll);
		} else if (showAll) {
			System.out.println("Time is " + clock + " server is idle");
		}
	}

	/** Method to show the statistics. */
    private void showStats() {
        System.out.println("\nThe number of regular passengers served was "
                + regularPassengerQueue.getNumServed());
        double averageWaitingTime =
                (double) regularPassengerQueue.getTotalWait()
                / (double) regularPassengerQueue.getNumServed();
        System.out.println(" with an average waiting time of "
                + averageWaitingTime);
        System.out.println("The number of frequent flyers served was "
                + frequentFlyerQueue.getNumServed());
        averageWaitingTime =
                (double) frequentFlyerQueue.getTotalWait()
                / (double) frequentFlyerQueue.getNumServed();
        System.out.println(" with an average waiting time of "
                + averageWaitingTime);
        System.out.println("Passengers in frequent flyer queue: "
                + frequentFlyerQueue.size());
        System.out.println("Passengers in regular queue: "
                + regularPassengerQueue.size());

    }


}
////////////////////////////////////
class PassengerQueue {
	private Queue <Passenger> theQueue;
	private int numServed;
	private int totalWait;
	private String queueName;
	private double arrivalRate;

	public PassengerQueue (String queueName) {
		numServed = 0;
		totalWait = 0;
		this.queueName = queueName;
		theQueue = new LinkedList <Passenger> ();

	}

	public int getNumServed() {
    return numServed;
  }

  /** Return the total wait time
      @return The total wait time
   */
  public int getTotalWait() {
    return totalWait;
  }

  /** Return the queue name
      @return - The queu name
   */
  public String getQueueName() {
    return queueName;
  }

  /** Set the arrival rate
      @param arrivalRate the value to set
   */
  public void setArrivalRate(double arrivalRate) {
    this.arrivalRate = arrivalRate;
  }

  public double getArrivalRate() {
	  return arrivalRate;
  }
  
  /** Determine if the passenger queue is empty
          @return true if the passenger queue is empty
   */
  public boolean isEmpty() {
    return theQueue.isEmpty();
  }

  /** Determine the size of the passenger queue
      @return the size of the passenger queue
   */
  public int size() {
    return theQueue.size();
  }

  /** Check if a new arrival has occurred.
      @param clock The current simulated time
      @param showAll Flag to indicate that detailed
                     data should be output
   */
  public void checkNewArrival(int clock, boolean showAll) {
    if (Math.random() < arrivalRate) {
      theQueue.add(new Passenger(clock));
      if (showAll) {
        System.out.println("Time is "
                           + clock + ": "
                           + queueName
                           + " arrival, new queue size is "
                           + theQueue.size());
      }
    }
  }

  /** Update statistics.
      pre: The queue is not empty.
      @param clock The current simulated time
      @param showAll Flag to indicate whether to show detail
      @return Time passenger is done being served
   */
  public int update(int clock, boolean showAll) {
    Passenger nextPassenger = theQueue.remove();
    int timeStamp = nextPassenger.getArrivalTime();
    int wait = clock - timeStamp;
    totalWait += wait;
    numServed++;
    if (showAll) {
      System.out.println("Time is " + clock
                         + ": Serving "
                         + queueName
                         + " with time stamp "
                         + timeStamp);
    }
    return clock + nextPassenger.getProcessingTime();
  }
}
/////////////////////////////////////////
public class Passenger {

  // Data Fields
  /** The ID number for this passenger. */
  private int passengerId;

  /** The time needed to process this passenger. */
  private int processingTime;

  /** The time this passenger arrives. */
  private int arrivalTime;

  /** The maximum time to process a passenger. */
  private static int maxProcessingTime;

  /** The sequence number for passengers. */
  private static int idNum = 0;

  /** Create a new passenger.
      @param arrivalTime The time this passenger arrives */
  public Passenger(int arrivalTime) {
    this.arrivalTime = arrivalTime;
    processingTime = 1 + (new Random()).nextInt(maxProcessingTime);
    passengerId = idNum++;
  }

  /** Get the arrival time.
      @return The arrival time */
  public int getArrivalTime() {
    return arrivalTime;
  }

  /** Get the processing time.
      @return The processing time */
  public int getProcessingTime() {
    return processingTime;
  }

  /** Get the passenger ID.
      @return The passenger ID */
  public int getId() {
    return passengerId;
  }

  /** Set the maximum processing time
      @param maxProcessingTime The new value */
  public static void setMaxProcessingTime(int maxProcessTime) {
    maxProcessingTime = maxProcessTime;
  }
  
  public static int getMaxProcessingTime () {
	  return maxProcessingTime;
  }
}