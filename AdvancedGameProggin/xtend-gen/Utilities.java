import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Utilities {
  private Random _rng = new Function0<Random>() {
    public Random apply() {
      Random _random = new Random();
      return _random;
    }
  }.apply();
  
  public Random getRng() {
    return this._rng;
  }
  
  public void setRng(final Random rng) {
    this._rng = rng;
  }
  
  private Group gameNodes;
  
  public Utilities(final Group gameNodes) {
    this.gameNodes = gameNodes;
  }
  
  private int stageBoundary = 10;
  
  public void stageBounds(final Sprite sprite, final Scene scene) {
    double _x = sprite.getX();
    double _width = sprite.getWidth();
    double _plus = (_x + _width);
    double _width_1 = scene.getWidth();
    double _minus = (_width_1 - this.stageBoundary);
    boolean _greaterThan = (_plus > _minus);
    if (_greaterThan) {
      double _width_2 = scene.getWidth();
      double _minus_1 = (_width_2 - this.stageBoundary);
      double _width_3 = sprite.getWidth();
      double _minus_2 = (_minus_1 - _width_3);
      sprite.setX(_minus_2);
      sprite.setVx(0);
    } else {
      double _x_1 = sprite.getX();
      boolean _lessThan = (_x_1 < this.stageBoundary);
      if (_lessThan) {
        sprite.setX(this.stageBoundary);
        sprite.setVx(0);
      }
    }
    double _y = sprite.getY();
    double _height = sprite.getHeight();
    double _plus_1 = (_y + _height);
    double _height_1 = scene.getHeight();
    double _minus_3 = (_height_1 - this.stageBoundary);
    boolean _greaterThan_1 = (_plus_1 > _minus_3);
    if (_greaterThan_1) {
      double _height_2 = scene.getHeight();
      double _minus_4 = (_height_2 - this.stageBoundary);
      double _height_3 = sprite.getHeight();
      double _minus_5 = (_minus_4 - _height_3);
      sprite.setY(_minus_5);
      sprite.setVy(0);
    } else {
      double _y_1 = sprite.getY();
      boolean _lessThan_1 = (_y_1 < this.stageBoundary);
      if (_lessThan_1) {
        sprite.setY(this.stageBoundary);
        sprite.setVy(0);
      }
    }
  }
  
  public double dotProduct(final Vector v1, final Vector v2) {
    double _vx = v1.getVx();
    double _dx = v2.getDx();
    double _multiply = (_vx * _dx);
    double _vy = v1.getVy();
    double _dy = v2.getDy();
    double _multiply_1 = (_vy * _dy);
    double _plus = (_multiply + _multiply_1);
    return _plus;
  }
  
  public boolean drawVector(final Vector v, final Color color, final int strokeW) {
    ObservableList<Node> _children = this.gameNodes.getChildren();
    Line _line = new Line();
    final Procedure1<Line> _function = new Procedure1<Line>() {
      public void apply(final Line it) {
        Point _a = v.getA();
        double _x = _a.getX();
        it.setStartX(_x);
        Point _b = v.getB();
        double _x_1 = _b.getX();
        it.setEndX(_x_1);
        Point _a_1 = v.getA();
        double _y = _a_1.getY();
        it.setStartY(_y);
        Point _b_1 = v.getB();
        double _y_1 = _b_1.getY();
        it.setEndY(_y_1);
        it.setStroke(color);
        it.setStrokeWidth(strokeW);
      }
    };
    Line _doubleArrow = ObjectExtensions.<Line>operator_doubleArrow(_line, _function);
    boolean _add = _children.add(_doubleArrow);
    return _add;
  }
  
  public boolean drawVector(final Vector v, final Color color) {
    ObservableList<Node> _children = this.gameNodes.getChildren();
    Line _line = new Line();
    final Procedure1<Line> _function = new Procedure1<Line>() {
      public void apply(final Line it) {
        Point _a = v.getA();
        double _x = _a.getX();
        it.setStartX(_x);
        Point _b = v.getB();
        double _x_1 = _b.getX();
        it.setEndX(_x_1);
        Point _a_1 = v.getA();
        double _y = _a_1.getY();
        it.setStartY(_y);
        Point _b_1 = v.getB();
        double _y_1 = _b_1.getY();
        it.setEndY(_y_1);
        it.setStroke(color);
      }
    };
    Line _doubleArrow = ObjectExtensions.<Line>operator_doubleArrow(_line, _function);
    boolean _add = _children.add(_doubleArrow);
    return _add;
  }
  
  public boolean drawVector(final Vector v, final int strokeW) {
    ObservableList<Node> _children = this.gameNodes.getChildren();
    Line _line = new Line();
    final Procedure1<Line> _function = new Procedure1<Line>() {
      public void apply(final Line it) {
        Point _a = v.getA();
        double _x = _a.getX();
        it.setStartX(_x);
        Point _b = v.getB();
        double _x_1 = _b.getX();
        it.setEndX(_x_1);
        Point _a_1 = v.getA();
        double _y = _a_1.getY();
        it.setStartY(_y);
        Point _b_1 = v.getB();
        double _y_1 = _b_1.getY();
        it.setEndY(_y_1);
        it.setStrokeWidth(strokeW);
      }
    };
    Line _doubleArrow = ObjectExtensions.<Line>operator_doubleArrow(_line, _function);
    boolean _add = _children.add(_doubleArrow);
    return _add;
  }
  
  public boolean drawVector(final Vector v, final boolean firstDraw) {
    ObservableList<Node> _children = this.gameNodes.getChildren();
    Line _line = new Line();
    final Procedure1<Line> _function = new Procedure1<Line>() {
      public void apply(final Line it) {
        Point _a = v.getA();
        double _x = _a.getX();
        it.setStartX(_x);
        Point _b = v.getB();
        double _x_1 = _b.getX();
        it.setEndX(_x_1);
        Point _a_1 = v.getA();
        double _y = _a_1.getY();
        it.setStartY(_y);
        Point _b_1 = v.getB();
        double _y_1 = _b_1.getY();
        it.setEndY(_y_1);
      }
    };
    Line _doubleArrow = ObjectExtensions.<Line>operator_doubleArrow(_line, _function);
    boolean _add = _children.add(_doubleArrow);
    return _add;
  }
  
  public boolean clearVectors() {
    boolean _xblockexpression = false;
    {
      final ArrayList<Node> nukeLines = CollectionLiterals.<Node>newArrayList();
      ObservableList<Node> _children = this.gameNodes.getChildren();
      final Procedure1<Node> _function = new Procedure1<Node>() {
        public void apply(final Node child) {
          if ((child instanceof Line)) {
            nukeLines.add(child);
          }
        }
      };
      IterableExtensions.<Node>forEach(_children, _function);
      ObservableList<Node> _children_1 = this.gameNodes.getChildren();
      boolean _removeAll = _children_1.removeAll(nukeLines);
      _xblockexpression = (_removeAll);
    }
    return _xblockexpression;
  }
  
  public boolean drawVectorWithNorms(final Vector v) {
    boolean _xblockexpression = false;
    {
      final Vector leftNorm = v.getLeftNormal();
      final Vector rightNorm = v.getRightNormal();
      ObservableList<Node> _children = this.gameNodes.getChildren();
      Line _line = new Line();
      final Procedure1<Line> _function = new Procedure1<Line>() {
        public void apply(final Line it) {
          Point _a = v.getA();
          double _x = _a.getX();
          it.setStartX(_x);
          Point _b = v.getB();
          double _x_1 = _b.getX();
          it.setEndX(_x_1);
          Point _a_1 = v.getA();
          double _y = _a_1.getY();
          it.setStartY(_y);
          Point _b_1 = v.getB();
          double _y_1 = _b_1.getY();
          it.setEndY(_y_1);
        }
      };
      Line _doubleArrow = ObjectExtensions.<Line>operator_doubleArrow(_line, _function);
      Line _line_1 = new Line();
      final Procedure1<Line> _function_1 = new Procedure1<Line>() {
        public void apply(final Line it) {
          Point _a = leftNorm.getA();
          double _x = _a.getX();
          it.setStartX(_x);
          Point _b = leftNorm.getB();
          double _x_1 = _b.getX();
          it.setEndX(_x_1);
          Point _a_1 = leftNorm.getA();
          double _y = _a_1.getY();
          it.setStartY(_y);
          Point _b_1 = leftNorm.getB();
          double _y_1 = _b_1.getY();
          it.setEndY(_y_1);
        }
      };
      Line _doubleArrow_1 = ObjectExtensions.<Line>operator_doubleArrow(_line_1, _function_1);
      Line _line_2 = new Line();
      final Procedure1<Line> _function_2 = new Procedure1<Line>() {
        public void apply(final Line it) {
          Point _a = rightNorm.getA();
          double _x = _a.getX();
          it.setStartX(_x);
          Point _b = rightNorm.getB();
          double _x_1 = _b.getX();
          it.setEndX(_x_1);
          Point _a_1 = rightNorm.getA();
          double _y = _a_1.getY();
          it.setStartY(_y);
          Point _b_1 = rightNorm.getB();
          double _y_1 = _b_1.getY();
          it.setEndY(_y_1);
        }
      };
      Line _doubleArrow_2 = ObjectExtensions.<Line>operator_doubleArrow(_line_2, _function_2);
      boolean _addAll = _children.addAll(
        new Node[] { _doubleArrow, _doubleArrow_1, _doubleArrow_2 });
      _xblockexpression = (_addAll);
    }
    return _xblockexpression;
  }
  
  public void drawVectors(final Vector... vs) {
    final Procedure1<Vector> _function = new Procedure1<Vector>() {
      public void apply(final Vector v) {
        ObservableList<Node> _children = Utilities.this.gameNodes.getChildren();
        Line _line = new Line();
        final Procedure1<Line> _function = new Procedure1<Line>() {
          public void apply(final Line it) {
            Point _a = v.getA();
            double _x = _a.getX();
            it.setStartX(_x);
            Point _b = v.getB();
            double _x_1 = _b.getX();
            it.setEndX(_x_1);
            Point _a_1 = v.getA();
            double _y = _a_1.getY();
            it.setStartY(_y);
            Point _b_1 = v.getB();
            double _y_1 = _b_1.getY();
            it.setEndY(_y_1);
          }
        };
        Line _doubleArrow = ObjectExtensions.<Line>operator_doubleArrow(_line, _function);
        _children.add(_doubleArrow);
      }
    };
    IterableExtensions.<Vector>forEach(((Iterable<Vector>)Conversions.doWrapArray(vs)), _function);
  }
  
  public void stageWrap(final Sprite sprite, final Scene scene) {
    double _x = sprite.getX();
    boolean _lessThan = (_x < 0);
    if (_lessThan) {
      double _width = scene.getWidth();
      double _width_1 = sprite.getWidth();
      double _minus = (_width - _width_1);
      sprite.setX(_minus);
    }
    double _x_1 = sprite.getX();
    double _width_2 = sprite.getWidth();
    double _plus = (_x_1 + _width_2);
    double _width_3 = scene.getWidth();
    boolean _greaterThan = (_plus > _width_3);
    if (_greaterThan) {
      sprite.setX(0);
    }
    double _y = sprite.getY();
    boolean _lessThan_1 = (_y < 0);
    if (_lessThan_1) {
      double _height = scene.getHeight();
      double _height_1 = sprite.getHeight();
      double _minus_1 = (_height - _height_1);
      sprite.setY(_minus_1);
    }
    double _y_1 = sprite.getY();
    double _height_2 = sprite.getHeight();
    double _plus_1 = (_y_1 + _height_2);
    double _height_3 = scene.getHeight();
    boolean _greaterThan_1 = (_plus_1 > _height_3);
    if (_greaterThan_1) {
      sprite.setY(0);
    }
  }
  
  public double dx(final Sprite one, final Sprite two) {
    double _x = one.getX();
    double _x_1 = two.getX();
    double _minus = (_x - _x_1);
    return _minus;
  }
  
  public double dy(final Sprite one, final Sprite two) {
    double _y = one.getY();
    double _y_1 = two.getY();
    double _minus = (_y - _y_1);
    return _minus;
  }
  
  public double distance(final Sprite one, final Sprite two) {
    double _xblockexpression = (double) 0;
    {
      final double dx = this.dx(one, two);
      final double dy = this.dy(one, two);
      double _multiply = (dx * dx);
      double _multiply_1 = (dy * dy);
      double _plus = (_multiply + _multiply_1);
      double _sqrt = Math.sqrt(_plus);
      _xblockexpression = (_sqrt);
    }
    return _xblockexpression;
  }
  
  public ArrayList<Object> map2(final Function2<? super Object,? super Object,? extends Object> fn, final List<? extends Object> bs, final List<? extends Object> cs) {
    ArrayList<Object> _xblockexpression = null;
    {
      final ArrayList<Object> finalResult = CollectionLiterals.<Object>newArrayList();
      int _length = ((Object[])Conversions.unwrapArray(bs, Object.class)).length;
      int _minus = (_length - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      final Procedure1<Integer> _function = new Procedure1<Integer>() {
        public void apply(final Integer i) {
          Object _get = bs.get(i);
          Object _get_1 = cs.get(i);
          Object _apply = fn.apply(_get, _get_1);
          finalResult.add(_apply);
        }
      };
      IterableExtensions.<Integer>forEach(_upTo, _function);
      _xblockexpression = (finalResult);
    }
    return _xblockexpression;
  }
  
  public void rotateToMouse(final Line line, final Mouse mouse) {
    double _x = mouse.getX();
    double _layoutX = line.getLayoutX();
    double _minus = (_x - _layoutX);
    double _y = mouse.getY();
    double _layoutY = line.getLayoutY();
    double _minus_1 = (_y - _layoutY);
    final double angle = Math.atan2(_minus, _minus_1);
    double _rotate = line.getRotate();
    double _plus = (_rotate + angle);
    line.setRotate(_plus);
  }
}
