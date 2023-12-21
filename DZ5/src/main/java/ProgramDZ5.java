public class ProgramDZ5 {
    public static void main(String[] args) {
        Table table = new Table();
        for (int i = 0; i < 5; i++) {
            Thread philThread = new Thread(new Philosopher(table), "Философ №" + (i + 1));
            philThread.start();
        }
    }

    static class Table {
        synchronized void useTable() {
            String name = Thread.currentThread().getName();
            System.out.println(name + ": кушаю");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + ": стол свободен!");
            notifyAll();
            try {
                System.out.println(Thread.currentThread().getName() + ": Думаю...");
                wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    static class Philosopher implements Runnable {
        final Table table;

        Philosopher(Table table) {
            this.table = table;
        }
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                table.useTable();
            }
        }
    }
}
