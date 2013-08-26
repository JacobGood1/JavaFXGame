import javafx.scene.Scene
import javafx.scene.Group

class FartCloud extends Sprite
{
	Player player
	
	new(Scene gameSurface, Group gameNodes, SpriteManager spriteManager, Utilities util, Assets ass, Player player) 
	{
		super(gameSurface, gameNodes, spriteManager, util, ass)
		appearance = enemy.apply
		this.player = player
		spriteManager.addSprites(this)
		gameNodes.children.add(appearance)
	}
	
	override personalUpdate() 
	{
		//accelerationX = this.dx(player) * 1/100 * -1
		//accelerationY = this.dy(player)	* 1/100 * - 1
		println(accelerationX)
	}
	
	override collision() {
		
	}
	
	override terminate() {
		
	}
		
}