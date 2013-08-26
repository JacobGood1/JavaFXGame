import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Player extends Sprite {
  private boolean fart = false;
  
  private final Map<String,KeyCode> controls = new Function0<Map<String,KeyCode>>() {
    public Map<String,KeyCode> apply() {
      Map<String,KeyCode> _xsetliteral = null;
      Map<String,KeyCode> _tempMap = Maps.<String, KeyCode>newHashMap();
      _tempMap.put("w", KeyCode.W);
      _tempMap.put("a", KeyCode.A);
      _tempMap.put("s", KeyCode.S);
      _tempMap.put("d", KeyCode.D);
      _xsetliteral = Collections.<String, KeyCode>unmodifiableMap(_tempMap);
      return _xsetliteral;
    }
  }.apply();
  
  private List<KeyCode> keyPresses = new Function0<List<KeyCode>>() {
    public List<KeyCode> apply() {
      ArrayList<KeyCode> _newArrayList = CollectionLiterals.<KeyCode>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public Player(final Scene gameSurface, final Group gameNodes, final SpriteManager spriteManager, final Utilities util, final Assets ass) {
    super(gameSurface, gameNodes, spriteManager, util, ass);
    ImageView _player = this.assets.getPlayer();
    this.setAppearance(_player);
    this.setSPEED(10);
    this.setId("player");
    this.setTERMINAL_VELOCITY(2);
    this.setTERMINAL_FRICTION(2);
    this.setFriction(0);
    final EventHandler<KeyEvent> _function = new EventHandler<KeyEvent>() {
      public void handle(final KeyEvent it) {
        Player.this.keyDown(it);
      }
    };
    gameSurface.setOnKeyPressed(_function);
    final EventHandler<KeyEvent> _function_1 = new EventHandler<KeyEvent>() {
      public void handle(final KeyEvent it) {
        Player.this.keyUp(it);
      }
    };
    gameSurface.setOnKeyReleased(_function_1);
  }
  
  public void collision() {
  }
  
  public int toInteger(final Object a) {
    int _hashCode = a.hashCode();
    return _hashCode;
  }
  
  public void terminate() {
    SpriteManager _spriteManager = this.getSpriteManager();
    _spriteManager.removeSprites(this);
    Group _gameNodes = this.getGameNodes();
    ObservableList<Node> _children = _gameNodes.getChildren();
    ImageView _appearance = this.getAppearance();
    _children.remove(_appearance);
  }
  
  public boolean code(final KeyCode code, final String keyBoardKey) {
    KeyCode _get = this.controls.get(keyBoardKey);
    boolean _equals = Objects.equal(code, _get);
    return _equals;
  }
  
  public Boolean keyDown(final KeyEvent ke) {
    Boolean _xblockexpression = null;
    {
      this.fart = true;
      Boolean _xifexpression = null;
      KeyCode _code = ke.getCode();
      boolean _contains = this.keyPresses.contains(_code);
      boolean _not = (!_contains);
      if (_not) {
        KeyCode _code_1 = ke.getCode();
        boolean _add = this.keyPresses.add(_code_1);
        _xifexpression = Boolean.valueOf(_add);
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public boolean keyUp(final KeyEvent ke) {
    boolean _xblockexpression = false;
    {
      final KeyCode code = ke.getCode();
      this.keyPresses.remove(code);
      boolean _code = this.code(code, "w");
      if (_code) {
        this.setAcceleration(0);
      }
      boolean _fart = this.fart = false;
      _xblockexpression = (_fart);
    }
    return _xblockexpression;
  }
  
  public void personalUpdate() {
    final Procedure1<KeyCode> _function = new Procedure1<KeyCode>() {
      public void apply(final KeyCode currentKey) {
        boolean _code = Player.this.code(currentKey, "w");
        if (_code) {
          double _acceleration = Player.this.getAcceleration();
          double _sPEED = Player.this.getSPEED();
          double _plus = (_acceleration + _sPEED);
          Player.this.setAcceleration(_plus);
          Player.this.assets.marioFart(Player.this);
        } else {
          boolean _code_1 = Player.this.code(currentKey, "a");
          if (_code_1) {
            int _minus = (-3);
            Player.this.rotate(_minus);
          } else {
            boolean _code_2 = Player.this.code(currentKey, "d");
            if (_code_2) {
              Player.this.rotate(3);
            }
          }
        }
      }
    };
    IterableExtensions.<KeyCode>forEach(this.keyPresses, _function);
    ImageView _appearance = this.getAppearance();
    double _rotate = _appearance.getRotate();
    double _multiply = (_rotate * Math.PI);
    final double angle = (_multiply / 180);
    double _cos = Math.cos(angle);
    double _acceleration = this.getAcceleration();
    double _multiply_1 = (_cos * _acceleration);
    this.setAccelerationX(_multiply_1);
    double _sin = Math.sin(angle);
    double _acceleration_1 = this.getAcceleration();
    double _multiply_2 = (_sin * _acceleration_1);
    this.setAccelerationY(_multiply_2);
    boolean _not = (!this.fart);
    if (_not) {
      boolean _and = false;
      double _vx = this.getVx();
      double _abs = Math.abs(_vx);
      boolean _lessThan = (_abs < 0.1);
      if (!_lessThan) {
        _and = false;
      } else {
        double _vy = this.getVy();
        double _abs_1 = Math.abs(_vy);
        boolean _lessThan_1 = (_abs_1 < 0.1);
        _and = (_lessThan && _lessThan_1);
      }
      if (_and) {
        this.setAccelerationX(0);
        this.setAccelerationY(0);
        this.setFrictionX(0);
        this.setFrictionY(0);
      }
    }
  }
}
