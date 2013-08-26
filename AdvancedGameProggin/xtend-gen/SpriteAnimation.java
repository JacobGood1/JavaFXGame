import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

@SuppressWarnings("all")
public class SpriteAnimation extends Transition {
  private ImageView imageView;
  
  private int count;
  
  private int columns;
  
  private int offsetX;
  
  private int offsetY;
  
  private int width;
  
  private int height;
  
  private int lastIndex;
  
  public SpriteAnimation(final ImageView imageView, final Duration duration, final int count, final int columns, final int offsetX, final int offsetY, final int width, final int height) {
    this.imageView = imageView;
    this.count = count;
    this.columns = columns;
    this.offsetX = offsetX;
    this.offsetY = offsetY;
    this.width = width;
    this.height = height;
    this.setCycleDuration(duration);
    this.setInterpolator(Interpolator.LINEAR);
  }
  
  public void interpolate(final double k) {
    double _multiply = (k * this.count);
    double _floor = Math.floor(_multiply);
    int _minus = (this.count - 1);
    double _min = Math.min(_floor, _minus);
    final int index = Double.valueOf(_min).intValue();
    boolean _notEquals = (index != this.lastIndex);
    if (_notEquals) {
      int _modulo = (index % this.columns);
      int _intValue = Integer.valueOf(_modulo).intValue();
      int _multiply_1 = (_intValue * this.width);
      final int x = (_multiply_1 + this.offsetX);
      int _divide = (index / this.columns);
      int _intValue_1 = Integer.valueOf(_divide).intValue();
      int _multiply_2 = (_intValue_1 * this.height);
      final int y = (_multiply_2 + this.offsetY);
      Rectangle2D _rectangle2D = new Rectangle2D(x, y, this.width, this.height);
      this.imageView.setViewport(_rectangle2D);
      int _intValue_2 = Integer.valueOf(index).intValue();
      this.lastIndex = _intValue_2;
    }
  }
}
