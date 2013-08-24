import javafx.scene.Scene
import javafx.scene.Group

class Star extends Sprite 
{
	Player player	
	double starSize = 70
	new(Scene gameSurface, Group gameNodes, SpriteManager spriteManager, Utilities util, Assets ass, Player player) 
	{
		super(gameSurface, gameNodes, spriteManager, util, ass)
		this.player = player
		appearance = star
		randomizeStarSizeAndPosition
		init
	}
	
	override personalUpdate() 
	{
		this.x = this.x - player.vx * starSize
		this.y = this.y - player.vy * starSize
	}
	
	override collision() 
	{
		//this.starShooter
	}
	
	override terminate() 
	{
	}
	
	def randomizeStarSizeAndPosition()
	{
		var prelimStarSize = rng.nextInt(10) - 3
		if(prelimStarSize <= 3)
		{
			prelimStarSize = 3 * 10		
		}
		starSize = prelimStarSize / starSize
		val starSize = prelimStarSize
		this => 
		[
			x = rng.nextInt(640) 
			y = rng.nextInt(480)
			appearance => [fitWidth = starSize fitHeight = starSize]
		]
	}
	
}