import javafx.animation.Timeline
import javafx.animation.KeyFrame
import javafx.util.Duration
import javafx.scene.Scene
import javafx.scene.Group
import javafx.stage.Stage
import javafx.scene.shape.Line

abstract class GameWorld 
{
	@Property Scene gameSurface
	@Property Group gameNodes
	@Property SpriteManager spriteManager = new SpriteManager
	public extension Utilities utilities
	@Property Assets assets
	
	double gameWindowWidth = 640
	double gameWindowHeight = 480
	
	new(Stage stage)
	{
		val gameLoop = new Timeline => [cycleCount = Timeline::INDEFINITE]
		val oneFrameOfTheGame = new KeyFrame(Duration::millis(17), [updateSprites checkCollisionsMoveSprites cleanUpSprites])
		gameLoop.keyFrames.add(oneFrameOfTheGame)
		
		gameNodes = new Group
		this.utilities = new Utilities(gameNodes)
		
		assets = new Assets(gameNodes)
		gameSurface = new Scene(gameNodes, gameWindowWidth, gameWindowHeight)
		
		stage.setScene(gameSurface)
		stage.show
		gameLoop.play
	}
	
	def void updateSprites()
	def void checkCollisionsMoveSprites()
	def void cleanUpSprites() 
}