import java.util.Random;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Star extends Sprite {
  private Player player;
  
  private double starSize = 70;
  
  public Star(final Scene gameSurface, final Group gameNodes, final SpriteManager spriteManager, final Utilities util, final Assets ass, final Player player) {
    super(gameSurface, gameNodes, spriteManager, util, ass);
    this.player = player;
    ImageView _star = this.assets.star();
    this.setAppearance(_star);
    this.randomizeStarSizeAndPosition();
    this.init();
  }
  
  public void personalUpdate() {
    double _x = this.getX();
    double _vx = this.player.getVx();
    double _multiply = (_vx * this.starSize);
    double _minus = (_x - _multiply);
    this.setX(_minus);
    double _y = this.getY();
    double _vy = this.player.getVy();
    double _multiply_1 = (_vy * this.starSize);
    double _minus_1 = (_y - _multiply_1);
    this.setY(_minus_1);
  }
  
  public void collision() {
  }
  
  public void terminate() {
  }
  
  public Star randomizeStarSizeAndPosition() {
    Star _xblockexpression = null;
    {
      Random _rng = this.utilities.getRng();
      int _nextInt = _rng.nextInt(10);
      int prelimStarSize = (_nextInt - 3);
      boolean _lessEqualsThan = (prelimStarSize <= 3);
      if (_lessEqualsThan) {
        int _multiply = (3 * 10);
        prelimStarSize = _multiply;
      }
      double _divide = (prelimStarSize / this.starSize);
      this.starSize = _divide;
      final int starSize = prelimStarSize;
      final Procedure1<Star> _function = new Procedure1<Star>() {
        public void apply(final Star it) {
          Random _rng = Star.this.utilities.getRng();
          int _nextInt = _rng.nextInt(640);
          it.setX(_nextInt);
          Random _rng_1 = Star.this.utilities.getRng();
          int _nextInt_1 = _rng_1.nextInt(480);
          it.setY(_nextInt_1);
          ImageView _appearance = it.getAppearance();
          final Procedure1<ImageView> _function = new Procedure1<ImageView>() {
            public void apply(final ImageView it) {
              it.setFitWidth(starSize);
              it.setFitHeight(starSize);
            }
          };
          ObjectExtensions.<ImageView>operator_doubleArrow(_appearance, _function);
        }
      };
      Star _doubleArrow = ObjectExtensions.<Star>operator_doubleArrow(this, _function);
      _xblockexpression = (_doubleArrow);
    }
    return _xblockexpression;
  }
}
