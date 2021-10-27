
/**
 * tutorRoom.java
 * One TA in office, one student in office, three in hallway. Protect hallway and office, sync TA and student
 *
 */
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class tutorRoom {
   public static void main(String args[]) {
      dashboard board = new dashboard();
      String[] names = { "Mary", "Emma", "Jennifer", "Mike", "Alan", "Bruce", "Tom" };
      Thread[] collegestudents = new Thread[7];
      Lock mutexBoardLock = new ReentrantLock(); // Remove if you use other tools
      Semaphore sem = new Semaphore(3);

      String TAname = "David";

      Thread teachingAssistant = new Thread(new TA(board, TAname, mutexBoardLock));
      for (int i = 0; i < 7; i++)
         collegestudents[i] = new Thread(new students(board, mutexBoardLock, names[i], sem));

      teachingAssistant.start();
      for (int i = 0; i < 7; i++)
         collegestudents[i].start();
   }
}
