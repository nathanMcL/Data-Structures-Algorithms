// Dining Philosophers: In the famous dining philosopher’s problem,
// a bunch of philosophers are sitting around a circular table with one chopstick between each of them.
// A philosopher needs both chopsticks to eat and always picks up the left chopstick before the right one.
// A deadlock could potentially occur if all the philosophers reached for the left chopstick at the same time.
// Using threads and locks, implement a simulation of the dining philosopher’s problem that prevents deadlocks.

class Chopstick {
    private Lock lock;

    public Chopstick() {
        lock = new ReentrantLock();
    }

    public boolean pickUp() {
        return lock.tryLock();
    }

    public void putDown() {
        lock.unlock();
    }
}

class Philosopher extends Thread {
    private int id;
    private Chopstick leftChopstick;
    private Chopstick rightChopstick;

    public Philosopher(int id, Chopstick left, Chopstick right) {
        this.id = id;
        this.leftChopstick = left;
        this.rightChopstick = right;
    }

    public void run() {
        while (true) {
            // Think
            think();
            // Pick up chopsticks
            if(pickUpChopsticks()) {
                // Eat
                eat();
                // Put down chopsticks
                putDownChopsticks();
            }
        }
    }

    private void think() {
        System.out.println("Philosopher " + id + " is thinking.");
        // ... thinking ...
    }

    private void eat() {
        System.out.println("Philosopher " + id + " is eating.");
        // ... eating ...
    }

    private boolean pickUpChopsticks() {
        // Try to pick up the lower-numbered chopstick first
        Chopstick first = id % 2 == 0 ? leftChopstick : rightChopstick;
        Chopstick second = id % 2 == 0 ? rightChopstick : leftChopstick;

        if (first.pickUp()) {
            if (second.pickUp()) {
                return true;
            } else {
                // Failed to pick up the second chopstick, put down the first one.
                first.putDown();
            }
        }
        return false;
    }

    private void putDownChopsticks() {
        leftChopstick.putDown();
        rightChopstick.putDown();
    }
}

public class DiningPhilosophers {
    public static void main(String[] args) {
        int numOfPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numOfPhilosophers];
        Chopstick[] chopsticks = new Chopstick[numOfPhilosophers];

        for (int i = 0; i < numOfPhilosophers; i++) {
            chopsticks[i] = new Chopstick();
        }

        for (int i = 0; i < numOfPhilosophers; i++) {
            Chopstick leftChopstick = chopsticks[i];
            Chopstick rightChopstick = chopsticks[(i + 1) % numOfPhilosophers];
            philosophers[i] = new Philosopher(i, leftChopstick, rightChopstick);
            philosophers[i].start();
        }
    }
}
