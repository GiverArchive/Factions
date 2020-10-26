package me.giverplay.factions.area;

public class Area
{
  private String name;
  
  private final int x;
  private final int y;
  private final int radius;
  
  public Area(String name, int x, int y, int radius)
  {
    this.name = name;
    this.x = x;
    this.y = y;
    this.radius = radius;
  }
  
  public int getX()
  {
    return x;
  }
  
  public int getY()
  {
    return y;
  }
  
  public int getRadius()
  {
    return radius;
  }
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public boolean overlaps(Area other)
  {
    return Math.sqrt((other.x - x)^2 - (other.y - y)^2) < other.radius + radius;
  }
}
