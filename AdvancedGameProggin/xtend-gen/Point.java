@SuppressWarnings("all")
public class Point {
  private double _x;
  
  public double getX() {
    return this._x;
  }
  
  public void setX(final double x) {
    this._x = x;
  }
  
  private double _y;
  
  public double getY() {
    return this._y;
  }
  
  public void setY(final double y) {
    this._y = y;
  }
  
  public Point(final int x, final int y) {
    this.setY(y);
    this.setX(x);
  }
}
