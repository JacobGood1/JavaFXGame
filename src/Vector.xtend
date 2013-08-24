class Vector 
{
	@Property Point a = new Point(0,0)
	@Property Point b = new Point(0,0)
	
	String id
	
	double vx
	double vy
	
	new()
	{
		this(0,0,0,0,0,0, "")
	}
	
	new(double startX, double startY, double endX, double endY, double newVx, double newVy, String id)
	{
		this.id = id
		update(startX, startY, endX, endY, newVx, newVy)	
	}
	new(double startX, double startY, double endX, double endY, double newVx, double newVy)
	{
		this.id = id
		update(startX, startY, endX, endY, newVx, newVy)	
	}
	new(double startX, double startY, double endX, double endY, String id)
	{
		this.id = id
		update(startX, startY, endX, endY, 0, 0)	
	}
	new(String id)
	{
		this.id = id
		update(0,0,0,0,0,0)	
	}
	
	new(Double x, Double y)
	{
		id = ""
		vx = x
		vy = y
	}
	
	new(Double x, Double y, String id)
	{
		this.id = id 
		vx = x
		vy = y
	}
	
	def void update(Vector v, double startX, double startY, double endX, double endY)
	{
		update(startX, startY, endX, endY, 0, 0)	
	}
	def void update(double startX, double startY, double endX, double endY)
	{
		update(startX, startY, endX, endY, 0, 0)	
	}
	
	def void update(double startX, double startY, double endX,  double endY, double newVx, double newVy)
	{
		if(newVx == 0 && newVy == 0)
		{
			a.x = startX
			a.y = startY
			b.x = endX
			b.y = endY	
		}	
		else
		{
			vx = newVx
			vy = newVy
		}
	}
	
	def getVx()
	{
		if(vx == 0)
		{
			b.x - a.x		
		}
		else
		{
			vx
		}
	}
	
	def getVy()
	{
		if(vy == 0)
		{
			b.y - a.y
		}
		else
		{
			vy
		}
	}
	
	def getAngle() //degrees
	{
		Math::atan2(getVy, getVx) * 180.0 / Math::PI
	}
	
	def magnitude()
	{
		if(getVx != 0 || getVy != 0)
		{
			Math::sqrt(getVx * getVx + getVy * getVy)
		}
		else
		{
			0.001
		}
	}
	
	def Vector getLeftNormal()
	{
		val Vector leftN = new Vector
		if(vx == 0 && vy == 0)
		{
			leftN.update(a.x, a.y, a.x + lx, a.y + ly)
		}
		else
		{
			leftN.update(0,0,0,0,getVx,getVy)	
		}
		leftN
	}
	
	def Vector getRightNormal()
	{
		val Vector rightN = new Vector
		if(vx == 0 && vy == 0)
		{
			rightN.update(a.x, a.y, a.x + rx, a.y + ry)
		}
		else
		{
			rightN.update(0,0,0,0,getVx,getVy)	
		}
		rightN
	}
	
	def normalize()
	{
		//dx = getVx / magnitude
		//dy = getVy / magnitude	
	}
	
	def setVx(double value)
	{
		vx = value
	}
	def setVy(double value)
	{
		vy = value
	}
	
	
	def getDx()
	{
		getVx / magnitude	
	}
	def getDy()
	{
		getVy / magnitude	
	}
	
	def getRx()
	{
		-getVy	
	}
	def getRy()
	{
		getVx
	}
	
	def getLx()
	{
		getVy
	}
	def getLy()
	{
		-getVx	
	}
	
	
	def operator_plus(Vector other)
	{
		vx = getVx + other.getVx
		vy = getVy + other.getVy	
	}
	
	def operator_plus(Sprite other)
	{
		other.x = other.x + getVx
		other.y = other.y + getVy	
	}
	
	def drawNorms()
	{
		this.drawNorms
	}
	
	/*def setVx(double value)
	{
		vx.value = value	
	}
	def setVy(double value)
	{
		vy.value = value	
	}*/
		
}