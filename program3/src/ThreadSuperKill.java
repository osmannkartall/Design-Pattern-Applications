import java.util.concurrent.atomic.AtomicBoolean;

class ThreadSuperKill {
    static class ThreadKill implements Runnable {

        private Thread worker;
        private AtomicBoolean finished = new AtomicBoolean(false);


        ThreadKill() {
            worker = new Thread(this);
            System.out.println("New thread: " + worker.getName());
        }

        public void run()
        {
            while (!Thread.currentThread().isInterrupted() && !finished.get()) {
                dft();
                finished.set(true);
            }

            System.out.println("Thread has stopped.");
        }

        void start() {
            worker.start();
        }

        void interrupt() {
            worker.interrupt();
        }

        void dft() {
            for (int i = 0; i < 1000000; i++)
                for (int j = 0; j < 1000000; j++)
                    finished.set(false);
        }

        void join() throws InterruptedException {
            worker.join();
        }
    }
}