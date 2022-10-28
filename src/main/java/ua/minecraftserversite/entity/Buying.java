package ua.minecraftserversite.entity;


public interface Buying {
    long id = 0;
    String name = null;
    String description = null;
    int cost = 0;
    public long getId();
    public String getName();
    public String getDescription();
    public int getCost();
}
