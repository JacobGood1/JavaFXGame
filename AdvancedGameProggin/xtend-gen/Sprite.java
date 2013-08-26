import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public abstract class Sprite {
  @Extension
  public Utilities utilities;
  
  @Extension
  public Assets assets;
  
  private Group _gameNodes;
  
  public Group getGameNodes() {
    return this._gameNodes;
  }
  
  public void setGameNodes(final Group gameNodes) {
    this._gameNodes = gameNodes;
  }
  
  private Scene _gameSurface;
  
  public Scene getGameSurface() {
    return this._gameSurface;
  }
  
  public void setGameSurface(final Scene gameSurface) {
    this._gameSurface = gameSurface;
  }
  
  private SpriteManager _spriteManager;
  
  public SpriteManager getSpriteManager() {
    return this._spriteManager;
  }
  
  public void setSpriteManager(final SpriteManager spriteManager) {
    this._spriteManager = spriteManager;
  }
  
  private ImageView _appearance;
  
  public ImageView getAppearance() {
    return this._appearance;
  }
  
  public void setAppearance(final ImageView appearance) {
    this._appearance = appearance;
  }
  
  private String _id = "";
  
  public String getId() {
    return this._id;
  }
  
  public void setId(final String id) {
    this._id = id;
  }
  
  private double _SPEED;
  
  public double getSPEED() {
    return this._SPEED;
  }
  
  public void setSPEED(final double SPEED) {
    this._SPEED = SPEED;
  }
  
  private double _TERMINAL_VELOCITY;
  
  public double getTERMINAL_VELOCITY() {
    return this._TERMINAL_VELOCITY;
  }
  
  public void setTERMINAL_VELOCITY(final double TERMINAL_VELOCITY) {
    this._TERMINAL_VELOCITY = TERMINAL_VELOCITY;
  }
  
  private double _TERMINAL_FRICTION;
  
  public double getTERMINAL_FRICTION() {
    return this._TERMINAL_FRICTION;
  }
  
  public void setTERMINAL_FRICTION(final double TERMINAL_FRICTION) {
    this._TERMINAL_FRICTION = TERMINAL_FRICTION;
  }
  
  private double _acceleration;
  
  public double getAcceleration() {
    return this._acceleration;
  }
  
  public void setAcceleration(final double acceleration) {
    this._acceleration = acceleration;
  }
  
  private double _accelerationX;
  
  public double getAccelerationX() {
    return this._accelerationX;
  }
  
  public void setAccelerationX(final double accelerationX) {
    this._accelerationX = accelerationX;
  }
  
  private double _accelerationY;
  
  public double getAccelerationY() {
    return this._accelerationY;
  }
  
  public void setAccelerationY(final double accelerationY) {
    this._accelerationY = accelerationY;
  }
  
  private double _friction;
  
  public double getFriction() {
    return this._friction;
  }
  
  public void setFriction(final double friction) {
    this._friction = friction;
  }
  
  private double _frictionX;
  
  public double getFrictionX() {
    return this._frictionX;
  }
  
  public void setFrictionX(final double frictionX) {
    this._frictionX = frictionX;
  }
  
  private double _frictionY;
  
  public double getFrictionY() {
    return this._frictionY;
  }
  
  public void setFrictionY(final double frictionY) {
    this._frictionY = frictionY;
  }
  
  private double _direction;
  
  public double getDirection() {
    return this._direction;
  }
  
  public void setDirection(final double direction) {
    this._direction = direction;
  }
  
  private double _previous_x = 0;
  
  public double getPrevious_x() {
    return this._previous_x;
  }
  
  public void setPrevious_x(final double previous_x) {
    this._previous_x = previous_x;
  }
  
  private double _previous_y = 0;
  
  public double getPrevious_y() {
    return this._previous_y;
  }
  
  public void setPrevious_y(final double previous_y) {
    this._previous_y = previous_y;
  }
  
  private double _temporary_x = 0;
  
  public double getTemporary_x() {
    return this._temporary_x;
  }
  
  public void setTemporary_x(final double temporary_x) {
    this._temporary_x = temporary_x;
  }
  
  private double _temporary_y = 0;
  
  public double getTemporary_y() {
    return this._temporary_y;
  }
  
  public void setTemporary_y(final double temporary_y) {
    this._temporary_y = temporary_y;
  }
  
  public double xPos = 0;
  
  public double yPos = 0;
  
  public Sprite(final Scene gameSurface, final Group gameNodes, final SpriteManager spriteManager, final Utilities util, final Assets ass) {
    this.utilities = util;
    this.assets = ass;
    this.setGameNodes(gameNodes);
    this.setGameSurface(gameSurface);
    this.setSpriteManager(spriteManager);
  }
  
  public abstract void personalUpdate();
  
  public void update() {
    this.personalUpdate();
    this.setTemporary_x(this.xPos);
    this.setTemporary_y(this.yPos);
    double _acceleration = this.getAcceleration();
    double _tERMINAL_VELOCITY = this.getTERMINAL_VELOCITY();
    boolean _greaterEqualsThan = (_acceleration >= _tERMINAL_VELOCITY);
    if (_greaterEqualsThan) {
      double _tERMINAL_VELOCITY_1 = this.getTERMINAL_VELOCITY();
      this.setAcceleration(_tERMINAL_VELOCITY_1);
    }
    double _vx = this.getVx();
    double _friction = this.getFriction();
    double _multiply = (_vx * _friction);
    this.setFrictionX(_multiply);
    double _vy = this.getVy();
    double _friction_1 = this.getFriction();
    double _multiply_1 = (_vy * _friction_1);
    this.setFrictionY(_multiply_1);
    double _accelerationX = this.getAccelerationX();
    double _plus = (this.xPos + _accelerationX);
    double _frictionX = this.getFrictionX();
    double _plus_1 = (_plus + _frictionX);
    this.xPos = _plus_1;
    double _accelerationY = this.getAccelerationY();
    double _plus_2 = (this.yPos + _accelerationY);
    double _frictionY = this.getFrictionY();
    double _plus_3 = (_plus_2 + _frictionY);
    this.yPos = _plus_3;
    double _temporary_x = this.getTemporary_x();
    this.setPrevious_x(_temporary_x);
    double _temporary_y = this.getTemporary_y();
    this.setPrevious_y(_temporary_y);
  }
  
  public abstract void collision();
  
  public abstract void terminate();
  
  public double getVx() {
    double _previous_x = this.getPrevious_x();
    double _minus = (this.xPos - _previous_x);
    return _minus;
  }
  
  public void setVx(final double value) {
    double _minus = (this.xPos - value);
    this.setPrevious_x(_minus);
  }
  
  public double setX(final double value) {
    double _xblockexpression = (double) 0;
    {
      double _vx = this.getVx();
      double _minus = (value - _vx);
      this.setPrevious_x(_minus);
      double _xPos = this.xPos = value;
      _xblockexpression = (_xPos);
    }
    return _xblockexpression;
  }
  
  public double getX() {
    return this.xPos;
  }
  
  public double getY() {
    return this.yPos;
  }
  
  public double getVy() {
    double _previous_y = this.getPrevious_y();
    double _minus = (this.yPos - _previous_y);
    return _minus;
  }
  
  public void setVy(final double value) {
    double _minus = (this.yPos - value);
    this.setPrevious_y(_minus);
  }
  
  public double setY(final double value) {
    double _xblockexpression = (double) 0;
    {
      double _vy = this.getVy();
      double _minus = (value - _vy);
      this.setPrevious_y(_minus);
      double _yPos = this.yPos = value;
      _xblockexpression = (_yPos);
    }
    return _xblockexpression;
  }
  
  public double getWidth() {
    ImageView _appearance = this.getAppearance();
    Bounds _boundsInLocal = _appearance.getBoundsInLocal();
    double _width = _boundsInLocal.getWidth();
    return _width;
  }
  
  public double getHeight() {
    ImageView _appearance = this.getAppearance();
    Bounds _boundsInLocal = _appearance.getBoundsInLocal();
    double _height = _boundsInLocal.getHeight();
    return _height;
  }
  
  public void stageBoundsHandler() {
    Scene _gameSurface = this.getGameSurface();
    this.utilities.stageBounds(this, _gameSurface);
  }
  
  public void stageWrap() {
    Scene _gameSurface = this.getGameSurface();
    this.utilities.stageWrap(this, _gameSurface);
  }
  
  public void rotate(final int degrees) {
    ImageView _appearance = this.getAppearance();
    ImageView _appearance_1 = this.getAppearance();
    double _rotate = _appearance_1.getRotate();
    double _plus = (_rotate + degrees);
    _appearance.setRotate(_plus);
  }
  
  public double getCenterX() {
    double _x = this.getX();
    double _width = this.getWidth();
    double _divide = (_width / 2);
    double _plus = (_x + _divide);
    return _plus;
  }
  
  public double getCenterY() {
    double _y = this.getY();
    double _height = this.getHeight();
    double _divide = (_height / 2);
    double _plus = (_y + _divide);
    return _plus;
  }
  
  public boolean init() {
    boolean _xblockexpression = false;
    {
      SpriteManager _spriteManager = this.getSpriteManager();
      _spriteManager.addSprites(this);
      Group _gameNodes = this.getGameNodes();
      ObservableList<Node> _children = _gameNodes.getChildren();
      ImageView _appearance = this.getAppearance();
      boolean _add = _children.add(_appearance);
      _xblockexpression = (_add);
    }
    return _xblockexpression;
  }
}
