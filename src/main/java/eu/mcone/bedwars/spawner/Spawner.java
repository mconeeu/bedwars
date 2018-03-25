package eu.mcone.bedwars.spawner;

public abstract class Spawner {

    public static final int GOLD = 0;
    public static final int IRON = 1;
    public static final int BRONZE = 2;

    public abstract void start();
    public abstract void end();
    public abstract int getThread();

}
