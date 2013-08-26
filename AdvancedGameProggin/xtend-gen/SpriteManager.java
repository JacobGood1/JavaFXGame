import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class SpriteManager {
  private List<Sprite> CHECK_COLLISION_LIST = new Function0<List<Sprite>>() {
    public List<Sprite> apply() {
      ArrayList<Sprite> _newArrayList = CollectionLiterals.<Sprite>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  private Set<Sprite> CLEAN_UP_SPRITES_LIST = new Function0<Set<Sprite>>() {
    public Set<Sprite> apply() {
      HashSet<Sprite> _newHashSet = CollectionLiterals.<Sprite>newHashSet();
      return _newHashSet;
    }
  }.apply();
  
  private ObservableList<Sprite> GAME_SPRITES_ON_CURRENT_SCENE_LIST = new Function0<ObservableList<Sprite>>() {
    public ObservableList<Sprite> apply() {
      ArrayList<Sprite> _newArrayList = CollectionLiterals.<Sprite>newArrayList();
      ObservableList<Sprite> _observableList = FXCollections.<Sprite>observableList(_newArrayList);
      return _observableList;
    }
  }.apply();
  
  public ObservableList<Sprite> getSprites() {
    return this.GAME_SPRITES_ON_CURRENT_SCENE_LIST;
  }
  
  public Set<Sprite> getCleanUpSpritesList() {
    return this.CLEAN_UP_SPRITES_LIST;
  }
  
  public boolean addSprites(final Sprite... sprites) {
    boolean _addAll = this.GAME_SPRITES_ON_CURRENT_SCENE_LIST.addAll(sprites);
    return _addAll;
  }
  
  public boolean removeSprites(final Sprite... sprites) {
    boolean _removeAll = this.GAME_SPRITES_ON_CURRENT_SCENE_LIST.removeAll(sprites);
    return _removeAll;
  }
  
  public Set<Sprite> getSpritesToBeRemoved() {
    return this.CLEAN_UP_SPRITES_LIST;
  }
  
  public boolean addSpritesToBeRemoved(final Sprite... sprites) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      int _length = sprites.length;
      boolean _greaterThan = (_length > 1);
      if (_greaterThan) {
        _matched=true;
        boolean _addAll = CollectionExtensions.<Sprite>addAll(this.CLEAN_UP_SPRITES_LIST, sprites);
        _switchResult = _addAll;
      }
    }
    if (!_matched) {
      Sprite _get = sprites[0];
      boolean _add = this.CLEAN_UP_SPRITES_LIST.add(_get);
      _switchResult = _add;
    }
    return _switchResult;
  }
  
  public List<Sprite> getCollisionsToCheck() {
    return this.CHECK_COLLISION_LIST;
  }
  
  public boolean resetCollisionsToCheck() {
    boolean _xblockexpression = false;
    {
      this.CHECK_COLLISION_LIST.clear();
      boolean _addAll = this.CHECK_COLLISION_LIST.addAll(this.GAME_SPRITES_ON_CURRENT_SCENE_LIST);
      _xblockexpression = (_addAll);
    }
    return _xblockexpression;
  }
  
  public void cleanUpSprites() {
    this.removeSprites(((Sprite[])Conversions.unwrapArray(this.CLEAN_UP_SPRITES_LIST, Sprite.class)));
    final Procedure1<Sprite> _function = new Procedure1<Sprite>() {
      public void apply(final Sprite sprite) {
        sprite.terminate();
      }
    };
    IterableExtensions.<Sprite>forEach(this.CLEAN_UP_SPRITES_LIST, _function);
    this.CLEAN_UP_SPRITES_LIST.clear();
  }
}
