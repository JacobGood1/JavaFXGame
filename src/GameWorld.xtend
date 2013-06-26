import javafx.animation.Timeline
import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.util.Duration
import javafx.scene.Scene
import javafx.scene.Group
import javafx.stage.Stage
import java.util.Random
import javafx.scene.control.Button

abstract class GameWorld 
{
	@Property Scene gameSurface
	@Property Group sceneNodes
	@Property boolean initialised
	@Property Timeline gameLoop
	KeyFrame oneFrame
	
	Player player
	public int bombAmount
	Random rng = new Random
	
	public Button nextLvl
	public boolean nxtLvl = false
	
	
	@Property SpriteManager spriteManager = new SpriteManager
	
	new()
	{
	
		gameLoop = new Timeline => [cycleCount = Animation::INDEFINITE]
		oneFrame = new KeyFrame(Duration::millis(16), [updateSprites checkCollisions cleanUpSprites])
		
		gameLoop.keyFrames.add(oneFrame)
		
		gameLoop.play
	}
	
	def updateSprites() 
	{
		for(sprite : spriteManager.getSprites)
		{
			handleUpdate(sprite)
		}
	}
	
	
	
	def handleUpdate(Sprite sprite) 
	{
		sprite.update
	}
	
	def checkCollisions() 
	{
		spriteManager.resetCollisionsToCheck
		spriteManager.collisionsToCheck.forEach[sp | 
			if(player.collide(sp))
			{
				if(!player.equals(sp))
				{
					sp.isDead = true 
					spriteManager.addSpritesToBeRemoved(sp)	
				}
			}
		]
		
	}
	
	def setupSpriteManager(Scene gameSurface)
	{
		for(num : (0..<bombAmount))
		{
			val bomb = new Bomb => [displayNode.layoutX = rng.nextInt(640) displayNode.layoutY = rng.nextInt(480)]
			spriteManager.addSprites(bomb)
		}	
		player = new Player(gameSurface)
		spriteManager.addSprites(player)
	}
	
	def handleLevel()
	{
		if(nxtLvl)
		{
			
		}
	}
	
	
	def void cleanUpSprites()
	def void init(Stage stage)
	
}