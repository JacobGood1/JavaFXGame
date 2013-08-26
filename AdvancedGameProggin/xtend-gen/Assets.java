import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class Assets {
  private final Group _gameNodes;
  
  public Group getGameNodes() {
    return this._gameNodes;
  }
  
  public Assets(final Group gameNodes) {
    this._gameNodes = gameNodes;
  }
  
  private final Image _playerImage = new Function0<Image>() {
    public Image apply() {
      Image _image = new Image("images/player.png");
      return _image;
    }
  }.apply();
  
  public Image getPlayerImage() {
    return this._playerImage;
  }
  
  private final ImageView _player = new Function0<ImageView>() {
    public ImageView apply() {
      ImageView _imageView = new ImageView();
      final Procedure1<ImageView> _function = new Procedure1<ImageView>() {
        public void apply(final ImageView it) {
          Image _playerImage = Assets.this.getPlayerImage();
          it.setImage(_playerImage);
          it.setFitWidth(50);
          it.setFitHeight(50);
        }
      };
      ImageView _doubleArrow = ObjectExtensions.<ImageView>operator_doubleArrow(_imageView, _function);
      return _doubleArrow;
    }
  }.apply();
  
  public ImageView getPlayer() {
    return this._player;
  }
  
  private final Image _marioFartCloud = new Function0<Image>() {
    public Image apply() {
      Image _image = new Image("http://gushh.net/blog/wp-content/uploads/2011/06/smoke_1_40_128_corrected.png");
      return _image;
    }
  }.apply();
  
  public Image getMarioFartCloud() {
    return this._marioFartCloud;
  }
  
  private final AudioClip _gasAttack = new Function0<AudioClip>() {
    public AudioClip apply() {
      AudioClip _audioClip = new AudioClip("http://soundbible.com/grab.php?id=1312&type=mp3");
      return _audioClip;
    }
  }.apply();
  
  public AudioClip getGasAttack() {
    return this._gasAttack;
  }
  
  private final Image _BACKGROUND = new Function0<Image>() {
    public Image apply() {
      Image _image = new Image("http://t0.gstatic.com/images?q=tbn:ANd9GcQjBZlPyHD7CYZRNchCgVk_c_88Zhl2bJkAKBpe7TgGeqegBxYE2g");
      return _image;
    }
  }.apply();
  
  public Image getBACKGROUND() {
    return this._BACKGROUND;
  }
  
  private final ImageView _background = new Function0<ImageView>() {
    public ImageView apply() {
      ImageView _imageView = new ImageView();
      final Procedure1<ImageView> _function = new Procedure1<ImageView>() {
        public void apply(final ImageView it) {
          Image _bACKGROUND = Assets.this.getBACKGROUND();
          it.setImage(_bACKGROUND);
        }
      };
      ImageView _doubleArrow = ObjectExtensions.<ImageView>operator_doubleArrow(_imageView, _function);
      return _doubleArrow;
    }
  }.apply();
  
  public ImageView getBackground() {
    return this._background;
  }
  
  private final Image _STAR = new Function0<Image>() {
    public Image apply() {
      Image _image = new Image("http://t0.gstatic.com/images?q=tbn:ANd9GcQjBZlPyHD7CYZRNchCgVk_c_88Zhl2bJkAKBpe7TgGeqegBxYE2g");
      return _image;
    }
  }.apply();
  
  public Image getSTAR() {
    return this._STAR;
  }
  
  public ImageView star() {
    ImageView _imageView = new ImageView();
    final Procedure1<ImageView> _function = new Procedure1<ImageView>() {
      public void apply(final ImageView it) {
        Image _sTAR = Assets.this.getSTAR();
        it.setImage(_sTAR);
      }
    };
    ImageView _doubleArrow = ObjectExtensions.<ImageView>operator_doubleArrow(_imageView, _function);
    return _doubleArrow;
  }
  
  private final Image _ENEMY = new Function0<Image>() {
    public Image apply() {
      Image _image = new Image("http://www.web2generators.com/application/img/sprite-sample.png");
      return _image;
    }
  }.apply();
  
  public Image getENEMY() {
    return this._ENEMY;
  }
  
  private final Function0<ImageView> _enemy = new Function0<Function0<ImageView>>() {
    public Function0<ImageView> apply() {
      final Function0<ImageView> _function = new Function0<ImageView>() {
        public ImageView apply() {
          ImageView _imageView = new ImageView();
          final Procedure1<ImageView> _function = new Procedure1<ImageView>() {
            public void apply(final ImageView it) {
              Image _eNEMY = Assets.this.getENEMY();
              it.setImage(_eNEMY);
              Rectangle2D _rectangle2D = new Rectangle2D(100, 100, 50, 50);
              it.setViewport(_rectangle2D);
            }
          };
          ImageView _doubleArrow = ObjectExtensions.<ImageView>operator_doubleArrow(_imageView, _function);
          return _doubleArrow;
        }
      };
      return _function;
    }
  }.apply();
  
  public Function0<ImageView> getEnemy() {
    return this._enemy;
  }
  
  public void marioFart(final Sprite sprite) {
    final Function0<ImageView> _function = new Function0<ImageView>() {
      public ImageView apply() {
        ImageView _imageView = new ImageView();
        final Procedure1<ImageView> _function = new Procedure1<ImageView>() {
          public void apply(final ImageView it) {
            Image _marioFartCloud = Assets.this.getMarioFartCloud();
            it.setImage(_marioFartCloud);
            double _x = sprite.getX();
            double _width = sprite.getWidth();
            double _minus = (_x - _width);
            it.setLayoutX(_minus);
            double _y = sprite.getY();
            double _height = sprite.getHeight();
            double _height_1 = sprite.getHeight();
            double _divide = (_height_1 / 2);
            double _plus = (_height + _divide);
            double _minus_1 = (_y - _plus);
            it.setLayoutY(_minus_1);
            Rectangle2D _rectangle2D = new Rectangle2D(0, 0, 128, 128);
            it.setViewport(_rectangle2D);
          }
        };
        ImageView _doubleArrow = ObjectExtensions.<ImageView>operator_doubleArrow(_imageView, _function);
        return _doubleArrow;
      }
    };
    final Function0<ImageView> fart = _function;
    final ImageView fartSprites = fart.apply();
    Group _gameNodes = this.getGameNodes();
    ObservableList<Node> _children = _gameNodes.getChildren();
    _children.add(fartSprites);
    Duration _millis = Duration.millis(1000);
    int _multiply = (8 * 4);
    int _plus = (_multiply + 5);
    SpriteAnimation _spriteAnimation = new SpriteAnimation(fartSprites, _millis, _plus, 8, 0, 0, 128, 128);
    final Procedure1<SpriteAnimation> _function_1 = new Procedure1<SpriteAnimation>() {
      public void apply(final SpriteAnimation it) {
        it.setCycleCount(1);
        final EventHandler<ActionEvent> _function = new EventHandler<ActionEvent>() {
          public void handle(final ActionEvent it) {
            fartSprites.setVisible(false);
            Group _gameNodes = Assets.this.getGameNodes();
            ObservableList<Node> _children = _gameNodes.getChildren();
            _children.remove(fartSprites);
          }
        };
        it.setOnFinished(_function);
      }
    };
    final SpriteAnimation fartAnim = ObjectExtensions.<SpriteAnimation>operator_doubleArrow(_spriteAnimation, _function_1);
    fartAnim.play();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_gameNodes== null) ? 0 : _gameNodes.hashCode());
    result = prime * result + ((_playerImage== null) ? 0 : _playerImage.hashCode());
    result = prime * result + ((_player== null) ? 0 : _player.hashCode());
    result = prime * result + ((_marioFartCloud== null) ? 0 : _marioFartCloud.hashCode());
    result = prime * result + ((_gasAttack== null) ? 0 : _gasAttack.hashCode());
    result = prime * result + ((_BACKGROUND== null) ? 0 : _BACKGROUND.hashCode());
    result = prime * result + ((_background== null) ? 0 : _background.hashCode());
    result = prime * result + ((_STAR== null) ? 0 : _STAR.hashCode());
    result = prime * result + ((_ENEMY== null) ? 0 : _ENEMY.hashCode());
    result = prime * result + ((_enemy== null) ? 0 : _enemy.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Assets other = (Assets) obj;
    if (_gameNodes == null) {
      if (other._gameNodes != null)
        return false;
    } else if (!_gameNodes.equals(other._gameNodes))
      return false;
    if (_playerImage == null) {
      if (other._playerImage != null)
        return false;
    } else if (!_playerImage.equals(other._playerImage))
      return false;
    if (_player == null) {
      if (other._player != null)
        return false;
    } else if (!_player.equals(other._player))
      return false;
    if (_marioFartCloud == null) {
      if (other._marioFartCloud != null)
        return false;
    } else if (!_marioFartCloud.equals(other._marioFartCloud))
      return false;
    if (_gasAttack == null) {
      if (other._gasAttack != null)
        return false;
    } else if (!_gasAttack.equals(other._gasAttack))
      return false;
    if (_BACKGROUND == null) {
      if (other._BACKGROUND != null)
        return false;
    } else if (!_BACKGROUND.equals(other._BACKGROUND))
      return false;
    if (_background == null) {
      if (other._background != null)
        return false;
    } else if (!_background.equals(other._background))
      return false;
    if (_STAR == null) {
      if (other._STAR != null)
        return false;
    } else if (!_STAR.equals(other._STAR))
      return false;
    if (_ENEMY == null) {
      if (other._ENEMY != null)
        return false;
    } else if (!_ENEMY.equals(other._ENEMY))
      return false;
    if (_enemy == null) {
      if (other._enemy != null)
        return false;
    } else if (!_enemy.equals(other._enemy))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
