import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.KeyEvent
import javafx.scene.input.KeyCode
import java.util.List
import javafx.scene.Scene

class Player extends Sprite 
{
	val SPEED = 5
	val List<KeyCode> KEY_PRESSES = newArrayList
	
	new(Scene gameSurface) 
	{
		displayNode = new ImageView => [image = new Image("images/character.png")]
		gameSurface.onKeyPressed = [keyPress]
		gameSurface.onKeyReleased = [keyReleased]
	}
	
	override update() 
	{
		displayNode.layoutX = displayNode.layoutX + vx
		displayNode.layoutY = displayNode.layoutY + vy	
		setVelocity(KEY_PRESSES.last)						
	}
	
	
	def keyPress(KeyEvent ke)
	{
		val code = ke.code
		
		if(!KEY_PRESSES.contains(code))
		{
			KEY_PRESSES.add(ke.code)	
		}
	}
	
	def keyReleased(KeyEvent ke) 
	{
		val code = ke.code
		
		KEY_PRESSES.remove(code)
		if(code == KeyCode::W || code == KeyCode::S)
		{
			vy = 0
		}
		else
		{
			vx = 0
		}
	}
	
	def setVelocity(KeyCode code)
	{
		switch(code)
		{
			case KeyCode::W : vy = -SPEED
			case KeyCode::A : vx = -SPEED
			case KeyCode::S : vy = SPEED
			case KeyCode::D : vx = SPEED
		}	
	}
	
	
	
	override collide(Sprite other) 
	{
		Utilities::collide(this.displayNode, other.displayNode)	
	}
}