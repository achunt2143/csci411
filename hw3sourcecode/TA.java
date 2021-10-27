
/**
 * Worker.java
 * 
 * This thread is used to demonstrate the operation of a semaphore.
 * 
 */

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TA implements Runnable {

	private dashboard board;
	private String name;
	private Lock lock;

	public TA(dashboard board, String name, Lock lock) {
		this.name = name;
		this.board = board;
		this.lock = lock;
	}

	public void run() {

		while (true) {

			// sleep for a while if there is no student waiting
			if (lock.tryLock()) {
				try {
					board.officeMessage("TA " + name + " is sleeping");
					SleepUtilities.nap();
				} finally {
					lock.unlock();
				}
			} else {

				// work with the student
				board.officeMessage("TA " + name + " is working with students");
				SleepUtilities.nap();
				// check whether there are student who is waiting
				board.officeMessage("TA " + name + " is done with students");
				SleepUtilities.nap();
			}

		}
	}

}
