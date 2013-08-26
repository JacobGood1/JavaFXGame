import javafx.scene.image.ImageView
import javafx.scene.Group
import javafx.scene.Scene

abstract class Sprite
{
	public extension Utilities utilities
	public extension Assets assets
	
	@Property Group gameNodes
	@Property Scene gameSurface
	@Property SpriteManager spriteManager
	
	@Property ImageView appearance
	
	@Property String id = ""
	
	@Property double SPEED
	@Property double TERMINAL_VELOCITY
	@Property double TERMINAL_FRICTION
	
	@Property double acceleration
	@Property double accelerationX
	@Property double accelerationY
	
	@Property double friction
	@Property double frictionX
	@Property double frictionY
	
	@Property double direction
	
	//Variables required for verlet integration
	@Property double previous_x = 0
	@Property double previous_y = 0
	
	@Property double temporary_x = 0
	@Property double temporary_y = 0
	
	public double xPos = 0
	public double yPos = 0
	
	new(Scene gameSurface, Group gameNodes, SpriteManager spriteManager, Utilities util, Assets ass)
	{
		this.utilities = util
		this.assets = ass
		this.gameNodes = gameNodes
		this.gameSurface = gameSurface
		this.spriteManager = spriteManager	
	}
	
	def void personalUpdate()
	def update()
	{
		personalUpdate
		temporary_x = xPos
		temporary_y = yPos

		if(acceleration >= TERMINAL_VELOCITY)
		{
			acceleration = TERMINAL_VELOCITY
		}
		
		frictionX = vx * friction
		frictionY = vy * friction
		
		xPos = xPos + accelerationX + frictionX
		yPos = yPos + accelerationY + frictionY
		
		
		previous_x = temporary_x
		previous_y = temporary_y
		
	} //update the sprite each frame update
	def void collision()
	def void terminate() //the sprite is no longer useful or is dead, use this method	
	
	
	//functions for calculating current velocities according to verlet integration
	def getVx()
	{
		xPos - previous_x
	}
	def setVx(double value)
	{
		previous_x = xPos - value		
	}
	
	def setX(double value)
	{
		previous_x = value - vx
		xPos = value	
	}
	
	def getX()
	{
		xPos
	}
	def getY()
	{
		yPos
	}
	def getVy()
	{
		yPos - previous_y
	}
	def setVy(double value)
	{
		previous_y = yPos - value		
	}
	def setY(double value)
	{
		previous_y = value - vy
		yPos = value	
	}
	def getWidth()
	{
		appearance.boundsInLocal.width
	}
	def getHeight()
	{
		appearance.boundsInLocal.height
	}
	def stageBoundsHandler()
	{
		this.stageBounds(gameSurface)
	}
	def stageWrap()
	{
		this.stageWrap(gameSurface)
	}
	def rotate(int degrees)
	{
		appearance.rotate = appearance.rotate + degrees
	}
	
	def getCenterX()
	{
		x + width / 2	
	}
	
	def getCenterY()
	{
		y + height / 2	
	}
	
	def init()
	{
		spriteManager.addSprites(this)
		gameNodes.children.add(this.appearance)
	}
}