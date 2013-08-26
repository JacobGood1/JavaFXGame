import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public abstract class GameWorld {
  private Scene _gameSurface;
  
  public Scene getGameSurface() {
    return this._gameSurface;
  }
  
  public void setGameSurface(final Scene gameSurface) {
    this._gameSurface = gameSurface;
  }
  
  private Group _gameNodes;
  
  public Group getGameNodes() {
    return this._gameNodes;
  }
  
  public void setGameNodes(final Group gameNodes) {
    this._gameNodes = gameNodes;
  }
  
  private SpriteManager _spriteManager = new Function0<SpriteManager>() {
    public SpriteManager apply() {
      SpriteManager _spriteManager = new SpriteManager();
      return _spriteManager;
    }
  }.apply();
  
  public SpriteManager getSpriteManager() {
    return this._spriteManager;
  }
  
  public void setSpriteManager(final SpriteManager spriteManager) {
    this._spriteManager = spriteManager;
  }
  
  @Extension
  public Utilities utilities;
  
  private Assets _assets;
  
  public Assets getAssets() {
    return this._assets;
  }
  
  public void setAssets(final Assets assets) {
    this._assets = assets;
  }
  
  private double gameWindowWidth = 640;
  
  private double gameWindowHeight = 480;
  
  public GameWorld(final Stage stage) {
    Timeline _timeline = new Timeline();
    final Procedure1<Timeline> _function = new Procedure1<Timeline>() {
      public void apply(final Timeline it) {
        it.setCycleCount(Timeline.INDEFINITE);
      }
    };
    final Timeline gameLoop = ObjectExtensions.<Timeline>operator_doubleArrow(_timeline, _function);
    Duration _millis = Duration.millis(17);
    final EventHandler<ActionEvent> _function_1 = new EventHandler<ActionEvent>() {
      public void handle(final ActionEvent it) {
        GameWorld.this.updateSprites();
        GameWorld.this.checkCollisionsMoveSprites();
        GameWorld.this.cleanUpSprites();
      }
    };
    KeyFrame _keyFrame = new KeyFrame(_millis, _function_1);
    final KeyFrame oneFrameOfTheGame = _keyFrame;
    ObservableList<KeyFrame> _keyFrames = gameLoop.getKeyFrames();
    _keyFrames.add(oneFrameOfTheGame);
    Group _group = new Group();
    this.setGameNodes(_group);
    Group _gameNodes = this.getGameNodes();
    Utilities _utilities = new Utilities(_gameNodes);
    this.utilities = _utilities;
    Group _gameNodes_1 = this.getGameNodes();
    Assets _assets = new Assets(_gameNodes_1);
    this.setAssets(_assets);
    Group _gameNodes_2 = this.getGameNodes();
    Scene _scene = new Scene(_gameNodes_2, this.gameWindowWidth, this.gameWindowHeight);
    this.setGameSurface(_scene);
    Scene _gameSurface = this.getGameSurface();
    stage.setScene(_gameSurface);
    stage.show();
    gameLoop.play();
  }
  
  public abstract void updateSprites();
  
  public abstract void checkCollisionsMoveSprites();
  
  public abstract void cleanUpSprites();
}
