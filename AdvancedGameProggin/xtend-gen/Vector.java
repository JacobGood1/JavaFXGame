import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class Vector {
  private Point _a = new Function0<Point>() {
    public Point apply() {
      Point _point = new Point(0, 0);
      return _point;
    }
  }.apply();
  
  public Point getA() {
    return this._a;
  }
  
  public void setA(final Point a) {
    this._a = a;
  }
  
  private Point _b = new Function0<Point>() {
    public Point apply() {
      Point _point = new Point(0, 0);
      return _point;
    }
  }.apply();
  
  public Point getB() {
    return this._b;
  }
  
  public void setB(final Point b) {
    this._b = b;
  }
  
  private String id;
  
  private double vx;
  
  private double vy;
  
  public Vector() {
    this(0, 0, 0, 0, 0, 0, "");
  }
  
  public Vector(final double startX, final double startY, final double endX, final double endY, final double newVx, final double newVy, final String id) {
    this.id = id;
    this.update(startX, startY, endX, endY, newVx, newVy);
  }
  
  public Vector(final double startX, final double startY, final double endX, final double endY, final double newVx, final double newVy) {
    this.id = this.id;
    this.update(startX, startY, endX, endY, newVx, newVy);
  }
  
  public Vector(final double startX, final double startY, final double endX, final double endY, final String id) {
    this.id = id;
    this.update(startX, startY, endX, endY, 0, 0);
  }
  
  public Vector(final String id) {
    this.id = id;
    this.update(0, 0, 0, 0, 0, 0);
  }
  
  public Vector(final Double x, final Double y) {
    this.id = "";
    this.vx = (x).doubleValue();
    this.vy = (y).doubleValue();
  }
  
  public Vector(final Double x, final Double y, final String id) {
    this.id = id;
    this.vx = (x).doubleValue();
    this.vy = (y).doubleValue();
  }
  
  public void update(final Vector v, final double startX, final double startY, final double endX, final double endY) {
    this.update(startX, startY, endX, endY, 0, 0);
  }
  
  public void update(final double startX, final double startY, final double endX, final double endY) {
    this.update(startX, startY, endX, endY, 0, 0);
  }
  
  public void update(final double startX, final double startY, final double endX, final double endY, final double newVx, final double newVy) {
    boolean _and = false;
    boolean _equals = (newVx == 0);
    if (!_equals) {
      _and = false;
    } else {
      boolean _equals_1 = (newVy == 0);
      _and = (_equals && _equals_1);
    }
    if (_and) {
      Point _a = this.getA();
      _a.setX(startX);
      Point _a_1 = this.getA();
      _a_1.setY(startY);
      Point _b = this.getB();
      _b.setX(endX);
      Point _b_1 = this.getB();
      _b_1.setY(endY);
    } else {
      this.vx = newVx;
      this.vy = newVy;
    }
  }
  
  public double getVx() {
    double _xifexpression = (double) 0;
    boolean _equals = (this.vx == 0);
    if (_equals) {
      Point _b = this.getB();
      double _x = _b.getX();
      Point _a = this.getA();
      double _x_1 = _a.getX();
      double _minus = (_x - _x_1);
      _xifexpression = _minus;
    } else {
      _xifexpression = this.vx;
    }
    return _xifexpression;
  }
  
  public double getVy() {
    double _xifexpression = (double) 0;
    boolean _equals = (this.vy == 0);
    if (_equals) {
      Point _b = this.getB();
      double _y = _b.getY();
      Point _a = this.getA();
      double _y_1 = _a.getY();
      double _minus = (_y - _y_1);
      _xifexpression = _minus;
    } else {
      _xifexpression = this.vy;
    }
    return _xifexpression;
  }
  
  public double getAngle() {
    double _vy = this.getVy();
    double _vx = this.getVx();
    double _atan2 = Math.atan2(_vy, _vx);
    double _multiply = (_atan2 * 180.0);
    double _divide = (_multiply / Math.PI);
    return _divide;
  }
  
  public double magnitude() {
    double _xifexpression = (double) 0;
    boolean _or = false;
    double _vx = this.getVx();
    boolean _notEquals = (_vx != 0);
    if (_notEquals) {
      _or = true;
    } else {
      double _vy = this.getVy();
      boolean _notEquals_1 = (_vy != 0);
      _or = (_notEquals || _notEquals_1);
    }
    if (_or) {
      double _vx_1 = this.getVx();
      double _vx_2 = this.getVx();
      double _multiply = (_vx_1 * _vx_2);
      double _vy_1 = this.getVy();
      double _vy_2 = this.getVy();
      double _multiply_1 = (_vy_1 * _vy_2);
      double _plus = (_multiply + _multiply_1);
      double _sqrt = Math.sqrt(_plus);
      _xifexpression = _sqrt;
    } else {
      _xifexpression = 0.001;
    }
    return _xifexpression;
  }
  
  public Vector getLeftNormal() {
    Vector _xblockexpression = null;
    {
      Vector _vector = new Vector();
      final Vector leftN = _vector;
      boolean _and = false;
      boolean _equals = (this.vx == 0);
      if (!_equals) {
        _and = false;
      } else {
        boolean _equals_1 = (this.vy == 0);
        _and = (_equals && _equals_1);
      }
      if (_and) {
        Point _a = this.getA();
        double _x = _a.getX();
        Point _a_1 = this.getA();
        double _y = _a_1.getY();
        Point _a_2 = this.getA();
        double _x_1 = _a_2.getX();
        double _lx = this.getLx();
        double _plus = (_x_1 + _lx);
        Point _a_3 = this.getA();
        double _y_1 = _a_3.getY();
        double _ly = this.getLy();
        double _plus_1 = (_y_1 + _ly);
        leftN.update(_x, _y, _plus, _plus_1);
      } else {
        double _vx = this.getVx();
        double _vy = this.getVy();
        leftN.update(0, 0, 0, 0, _vx, _vy);
      }
      _xblockexpression = (leftN);
    }
    return _xblockexpression;
  }
  
  public Vector getRightNormal() {
    Vector _xblockexpression = null;
    {
      Vector _vector = new Vector();
      final Vector rightN = _vector;
      boolean _and = false;
      boolean _equals = (this.vx == 0);
      if (!_equals) {
        _and = false;
      } else {
        boolean _equals_1 = (this.vy == 0);
        _and = (_equals && _equals_1);
      }
      if (_and) {
        Point _a = this.getA();
        double _x = _a.getX();
        Point _a_1 = this.getA();
        double _y = _a_1.getY();
        Point _a_2 = this.getA();
        double _x_1 = _a_2.getX();
        double _rx = this.getRx();
        double _plus = (_x_1 + _rx);
        Point _a_3 = this.getA();
        double _y_1 = _a_3.getY();
        double _ry = this.getRy();
        double _plus_1 = (_y_1 + _ry);
        rightN.update(_x, _y, _plus, _plus_1);
      } else {
        double _vx = this.getVx();
        double _vy = this.getVy();
        rightN.update(0, 0, 0, 0, _vx, _vy);
      }
      _xblockexpression = (rightN);
    }
    return _xblockexpression;
  }
  
  public Object normalize() {
    return null;
  }
  
  public double setVx(final double value) {
    double _vx = this.vx = value;
    return _vx;
  }
  
  public double setVy(final double value) {
    double _vy = this.vy = value;
    return _vy;
  }
  
  public double getDx() {
    double _vx = this.getVx();
    double _magnitude = this.magnitude();
    double _divide = (_vx / _magnitude);
    return _divide;
  }
  
  public double getDy() {
    double _vy = this.getVy();
    double _magnitude = this.magnitude();
    double _divide = (_vy / _magnitude);
    return _divide;
  }
  
  public double getRx() {
    double _vy = this.getVy();
    double _minus = (-_vy);
    return _minus;
  }
  
  public double getRy() {
    double _vx = this.getVx();
    return _vx;
  }
  
  public double getLx() {
    double _vy = this.getVy();
    return _vy;
  }
  
  public double getLy() {
    double _vx = this.getVx();
    double _minus = (-_vx);
    return _minus;
  }
  
  public double operator_plus(final Vector other) {
    double _xblockexpression = (double) 0;
    {
      double _vx = this.getVx();
      double _vx_1 = other.getVx();
      double _plus = (_vx + _vx_1);
      this.vx = _plus;
      double _vy = this.getVy();
      double _vy_1 = other.getVy();
      double _plus_1 = (_vy + _vy_1);
      double _vy_2 = this.vy = _plus_1;
      _xblockexpression = (_vy_2);
    }
    return _xblockexpression;
  }
  
  public double operator_plus(final Sprite other) {
    double _xblockexpression = (double) 0;
    {
      double _x = other.getX();
      double _vx = this.getVx();
      double _plus = (_x + _vx);
      other.setX(_plus);
      double _y = other.getY();
      double _vy = this.getVy();
      double _plus_1 = (_y + _vy);
      double _setY = other.setY(_plus_1);
      _xblockexpression = (_setY);
    }
    return _xblockexpression;
  }
  
  public Object drawNorms() {
    Object _drawNorms = this.drawNorms();
    return _drawNorms;
  }
}
