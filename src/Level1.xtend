import javafx.stage.Stage
import javafx.scene.control.Button
import javafx.scene.shape.Circle
import javafx.scene.paint.Color
import com.sun.media.jfxmedia.events.PlayerStateEvent.PlayerState

class Level1 extends GameWorld
{	
	Player player
	int gravityIntensity = 4
	val marioVector = new Vector
	val player_to_planet = new Vector
	val crap = new Vector
	Circle planet = new Circle(300, 300, 10) => [fill = Color::RED]
	new(Stage stage)
	{
		super(stage)
		player = new Player(gameSurface, gameNodes, spriteManager, utilities, assets) => [x = 640/2 y = 480/2]
		gameNodes.children.add(planet)
		//(0..1000).forEach[new Star(gameSurface, gameNodes, spriteManager, utilities, assets, player)]
		
		
		
		planet.centerY
		//val enemy = new FartCloud(gameSurface, gameNodes, spriteManager, utilities, assets, player)
		 //enemy => [posX = 0 posY = 0 vx = 0 vy = 0 SPEED = 0.5 acceleration = 0.1]]])
		player.init
	}
	
	def gravitize()
	{
		if(gravityIntensity == 4){gravityIntensity = 10}
		else{gravityIntensity = 4}
	}
	
	override void updateSprites() //put anon fn here, level1 will take this and do something with it
	{
		//println(gameNodes.children.length)
		
		
		
		
		spriteManager.sprites.forEach
		[sprite| 
			sprite.update 
			/*
			 * val center_x =  -planet.centerX + sprite.x + sprite.width / 2
			val center_y =  -planet.centerY + sprite.y + sprite.height / 2
			val gravity = Math::sqrt(center_x * center_x + center_y * center_y)
			val dx = center_x / gravity
			val dy = center_y / gravity
			*/
			//val dotty = 
			//println(gameNodes.children)
			clearVectors
			
			marioVector => [update(sprite.centerX, sprite.centerY, (sprite.centerX + sprite.vx), (sprite.centerY + sprite.vy)) drawVector(Color.ANTIQUEWHITE)]
			
			player_to_planet => [update(planet.centerX, planet.centerY, sprite.centerX, sprite.centerY) drawVector(Color::BLUE)]
			//crap => [update(player.centerX, player.centerY, player_to_planet.leftNormal.b.x, player_to_planet.leftNormal.b.y) drawVectorWithNorms]
			//println(player_to_planet.dotProduct(crap))
			
			
			//player.x = player.x + player_to_planet.dx * gravityIntensity
			//player.y = player.y + player_to_planet.dy * gravityIntensity
			//println(player_to_planet.dx)
			
			
			sprite.stageBoundsHandler
			//sprite.stageWrap
			//println("VX: " + sprite.vx + " VY: " + sprite.vy)
			
		]
		
		
				
	}
	override void checkCollisionsMoveSprites()
	{
		spriteManager.resetCollisionsToCheck
		spriteManager.collisionsToCheck.forEach
		[
			sprite|
			sprite.collision
			sprite.appearance.layoutX = sprite.xPos
			sprite.appearance.layoutY = sprite.yPos
		]	
	}
	
	override void cleanUpSprites()
	{
		//spriteManager.cleanUpSprites		
	}	
	
}