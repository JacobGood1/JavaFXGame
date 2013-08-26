import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Level1 extends GameWorld {
  private Player player;
  
  private int gravityIntensity = 4;
  
  private final Vector marioVector = new Function0<Vector>() {
    public Vector apply() {
      Vector _vector = new Vector();
      return _vector;
    }
  }.apply();
  
  private final Vector player_to_planet = new Function0<Vector>() {
    public Vector apply() {
      Vector _vector = new Vector();
      return _vector;
    }
  }.apply();
  
  private final Vector crap = new Function0<Vector>() {
    public Vector apply() {
      Vector _vector = new Vector();
      return _vector;
    }
  }.apply();
  
  private Circle planet = new Function0<Circle>() {
    public Circle apply() {
      Circle _circle = new Circle(300, 300, 10);
      final Procedure1<Circle> _function = new Procedure1<Circle>() {
        public void apply(final Circle it) {
          it.setFill(Color.RED);
        }
      };
      Circle _doubleArrow = ObjectExtensions.<Circle>operator_doubleArrow(_circle, _function);
      return _doubleArrow;
    }
  }.apply();
  
  public Level1(final Stage stage) {
    super(stage);
    Scene _gameSurface = this.getGameSurface();
    Group _gameNodes = this.getGameNodes();
    SpriteManager _spriteManager = this.getSpriteManager();
    Assets _assets = this.getAssets();
    Player _player = new Player(_gameSurface, _gameNodes, _spriteManager, this.utilities, _assets);
    final Procedure1<Player> _function = new Procedure1<Player>() {
      public void apply(final Player it) {
        int _divide = (640 / 2);
        it.setX(_divide);
        int _divide_1 = (480 / 2);
        it.setY(_divide_1);
      }
    };
    Player _doubleArrow = ObjectExtensions.<Player>operator_doubleArrow(_player, _function);
    this.player = _doubleArrow;
    Group _gameNodes_1 = this.getGameNodes();
    ObservableList<Node> _children = _gameNodes_1.getChildren();
    _children.add(this.planet);
    this.planet.getCenterY();
    this.player.init();
  }
  
  public int gravitize() {
    int _xifexpression = (int) 0;
    boolean _equals = (this.gravityIntensity == 4);
    if (_equals) {
      int _gravityIntensity = this.gravityIntensity = 10;
      _xifexpression = _gravityIntensity;
    } else {
      int _gravityIntensity_1 = this.gravityIntensity = 4;
      _xifexpression = _gravityIntensity_1;
    }
    return _xifexpression;
  }
  
  public void updateSprites() {
    SpriteManager _spriteManager = this.getSpriteManager();
    ObservableList<Sprite> _sprites = _spriteManager.getSprites();
    final Procedure1<Sprite> _function = new Procedure1<Sprite>() {
      public void apply(final Sprite sprite) {
        sprite.update();
        Level1.this.utilities.clearVectors();
        final Procedure1<Vector> _function = new Procedure1<Vector>() {
          public void apply(final Vector it) {
            double _centerX = sprite.getCenterX();
            double _centerY = sprite.getCenterY();
            double _centerX_1 = sprite.getCenterX();
            double _vx = sprite.getVx();
            double _plus = (_centerX_1 + _vx);
            double _centerY_1 = sprite.getCenterY();
            double _vy = sprite.getVy();
            double _plus_1 = (_centerY_1 + _vy);
            it.update(_centerX, _centerY, _plus, _plus_1);
            Level1.this.utilities.drawVector(it, Color.ANTIQUEWHITE);
          }
        };
        ObjectExtensions.<Vector>operator_doubleArrow(
          Level1.this.marioVector, _function);
        final Procedure1<Vector> _function_1 = new Procedure1<Vector>() {
          public void apply(final Vector it) {
            double _centerX = Level1.this.planet.getCenterX();
            double _centerY = Level1.this.planet.getCenterY();
            double _centerX_1 = sprite.getCenterX();
            double _centerY_1 = sprite.getCenterY();
            it.update(_centerX, _centerY, _centerX_1, _centerY_1);
            Level1.this.utilities.drawVector(it, Color.BLUE);
          }
        };
        ObjectExtensions.<Vector>operator_doubleArrow(
          Level1.this.player_to_planet, _function_1);
        sprite.stageBoundsHandler();
      }
    };
    IterableExtensions.<Sprite>forEach(_sprites, _function);
  }
  
  public void checkCollisionsMoveSprites() {
    SpriteManager _spriteManager = this.getSpriteManager();
    _spriteManager.resetCollisionsToCheck();
    SpriteManager _spriteManager_1 = this.getSpriteManager();
    List<Sprite> _collisionsToCheck = _spriteManager_1.getCollisionsToCheck();
    final Procedure1<Sprite> _function = new Procedure1<Sprite>() {
      public void apply(final Sprite sprite) {
        sprite.collision();
        ImageView _appearance = sprite.getAppearance();
        _appearance.setLayoutX(sprite.xPos);
        ImageView _appearance_1 = sprite.getAppearance();
        _appearance_1.setLayoutY(sprite.yPos);
      }
    };
    IterableExtensions.<Sprite>forEach(_collisionsToCheck, _function);
  }
  
  public void cleanUpSprites() {
  }
}
