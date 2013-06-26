import javafx.stage.Stage
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.control.Button

class Level1 extends GameWorld 
{
	override init(Stage stage) 
	{
		
		bombAmount = 2000
		//this adds shat to the spritemanager which,of course, manages the sprites!
		
		sceneNodes = new Group	
		gameSurface = new Scene(sceneNodes, 640, 480)
		
		nextLvl = new Button => [scaleX = 10 scaleY = 10 layoutX = 100 layoutY = 20]
		
		nextLvl.onAction = [nextLevel(stage)]
		
		setupSpriteManager(gameSurface)
		
		spriteManager.sprites.forEach[sprite | sceneNodes.children.add(sprite.displayNode)]
		sceneNodes.children.add(nextLvl)
		
		stage.setScene(gameSurface)
		
		stage.show
	}
	
	override cleanUpSprites() 
	{
		
		spriteManager.cleanupSprites(this)	
	}
	
	def nextLevel(Stage stage)
	{
		gameLoop.stop	
		stage.scene = null
	}
		
}