public class ProgramForks {
    public static void main(String[] args) {
        Fork[] forks = new Fork[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new Fork();
        }
        for (int i = 0; i < 5; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % 5];
            Thread philThread;
            if (i == 4) {
                philThread = new Thread(new Philosopher(rightFork, leftFork), "Phil №" + (i+1));
            } else {
                philThread = new Thread(new Philosopher(leftFork, rightFork), "Phil №" + (i+1));
            }
            philThread.start();
        }
    }

    static class Philosopher implements Runnable {
        final Fork leftFork;
        final Fork rightFork;

        Philosopher(Fork leftFork, Fork rightFork) {
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    eat();
                    think();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        void eat() throws InterruptedException {
            String philosopherID = Thread.currentThread().getName();
            System.out.printf("%s: hungry%n", philosopherID);
            synchronized (leftFork) {
                System.out.printf("%s: picked up left fork%n", philosopherID);
                Thread.sleep(100);
                synchronized (rightFork) {
                    System.out.printf("%s: picked up right fork%n", philosopherID);
                    Thread.sleep(100);
                    System.out.printf("%s: eating%n", philosopherID);
                    Thread.sleep(500);
                    System.out.printf("%s: put down right fork%n", philosopherID);
                    Thread.sleep(100);
                }
                System.out.printf("%s: put down left fork%n", philosopherID);
                Thread.sleep(100);
            }
            System.out.printf("%s: full!%n", philosopherID);
        }

        void think() throws InterruptedException {
            System.out.printf("%s: thinking...", Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }

    static class Fork {
    }
}
