public class SingleTon {
    private static SingleTon instance;

    private SingleTon() {}

    public static SingleTon  getInstace() {
        if(instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                }

            }
        }
        return instance;
    }
}
