package DesignPatterns;

class MainSingleton {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        // Not thread safe
        SimpleSingleton obj1 = SimpleSingleton.getInstance();
        obj1.printLog("Custom Warning1");

        // Synchronized is safe but slow.
        ThreadSafeSynchronizedSingleton obj2 = ThreadSafeSynchronizedSingleton.getInstance();
        obj2.printLog("Custom Warning2");

        //Double-checked locking improves performance but is complex.
        DoubleCheckedLockingSingleton obj3 = DoubleCheckedLockingSingleton.getInstance();
        obj3.printLog("Custom Warning3");

        // Bill Pugh is clean and preferred in most cases
        BillPughSingleton obj4 = BillPughSingleton.getInstance();
        obj4.printLog("Custom Warning4");

    }
}

class SimpleSingleton {

    private static SimpleSingleton instance;

    private SimpleSingleton() {}

    public static SimpleSingleton getInstance() {
        if (instance == null) {
            instance = new SimpleSingleton();
        }
        return instance;
    }

    public void printLog(String message){
        System.out.println("Message logged: " + message);
    }
}

class ThreadSafeSynchronizedSingleton {

    private static ThreadSafeSynchronizedSingleton instance;

    private ThreadSafeSynchronizedSingleton() {}

    public static synchronized ThreadSafeSynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSynchronizedSingleton();
        }
        return instance;
    }

    public void printLog(String message){
        System.out.println("Message logged: " + message);
    }
}


class DoubleCheckedLockingSingleton {

    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {}

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized(DoubleCheckedLockingSingleton.class){
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    public void printLog(String message){
        System.out.println("Message logged: " + message);
    }
}

class BillPughSingleton {

    private BillPughSingleton() {}

    private static class Holder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return Holder.INSTANCE;
    }
    public void printLog(String message){
        System.out.println("Message logged: " + message);
    }

}
