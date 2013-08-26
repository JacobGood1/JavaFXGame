import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class FartCloud extends Sprite {
  private Player player;
  
  public FartCloud(final Scene gameSurface, final Group gameNodes, final SpriteManager spriteManager, final Utilities util, final Assets ass, final Player player) {
    super(gameSurface, gameNodes, spriteManager, util, ass);
    Function0<ImageView> _enemy = this.assets.getEnemy();
    ImageView _apply = _enemy.apply();
    this.setAppearance(_apply);
    this.player = player;
    spriteManager.addSprites(this);
    ObservableList<Node> _children = gameNodes.getChildren();
    ImageView _appearance = this.getAppearance();
    _children.add(_appearance);
  }
  
  public void personalUpdate() {
    double _accelerationX = this.getAccelerationX();
    InputOutput.<Double>println(Double.valueOf(_accelerationX));
  }
  
  public void collision() {
  }
  
  public void terminate() {
  }
}
