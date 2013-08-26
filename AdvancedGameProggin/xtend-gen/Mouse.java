import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;

@SuppressWarnings("all")
public class Mouse {
  private double _x = 0;
  
  public double getX() {
    return this._x;
  }
  
  public void setX(final double x) {
    this._x = x;
  }
  
  private double _y = 0;
  
  public double getY() {
    return this._y;
  }
  
  public void setY(final double y) {
    this._y = y;
  }
  
  public Mouse(final Group group) {
    final EventHandler<MouseEvent> _function = new EventHandler<MouseEvent>() {
      public void handle(final MouseEvent it) {
        double _layoutX = group.getLayoutX();
        Mouse.this.setX(_layoutX);
        double _layoutY = group.getLayoutY();
        Mouse.this.setY(_layoutY);
      }
    };
    group.setOnMouseMoved(_function);
  }
}
