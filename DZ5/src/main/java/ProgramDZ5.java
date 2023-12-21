public class ProgramDZ5 {
    public static void main(String[] args) {
        Table table = new Table();
        for (int i = 0; i < 5; i++) {
            Thread philThread = new Thread(new Philosopher(table), "Философ №" + (i + 1));
            philThread.start();
        }
    }

    static class Table {
        boolean tableOccupied = false;

        synchronized void useTable() {
            String name = Thread.currentThread().getName();
            while (tableOccupied) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            tableOccupied = true;
            System.out.println(name + ": кушаю");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + ": стол свободен!");
            tableOccupied = false;
            notifyAll();
        }
    }


    static class Philosopher implements Runnable {
        final Table table;

        Philosopher(Table table) {
            this.table = table;
        }

        void think() {
            System.out.println(Thread.currentThread().getName()+": Думаю...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                table.useTable();
                think();
            }
        }
    }
}
