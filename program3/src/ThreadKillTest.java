public class ThreadKillTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.activeCount());
        ThreadSuperKill.ThreadKill t1 = new ThreadSuperKill.ThreadKill();
        t1.start();
        t1.interrupt();
        t1.join();
        System.out.println(Thread.activeCount());
    }
}
