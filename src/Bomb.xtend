import javafx.scene.image.Image
import javafx.scene.image.ImageView

class Bomb extends Sprite 
{
	new()
	{
		displayNode = new ImageView => [image = new Image("images/bomb.png") fitHeight = 15 fitWidth = 15 cache = true]		
	}
	
	
	override update() 
	{
		if(isDead)
		{
			displayNode.visible = false
		}	
	}
	
	override collide(Sprite other) 
	{
		
		false
	}
		
}