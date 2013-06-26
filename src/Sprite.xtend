import javafx.scene.Node
import java.util.List
import javafx.scene.image.Image
import javafx.scene.image.ImageView

abstract class Sprite 
{
	public List animations = newArrayList
	public Node displayNode
	
	public double vx = 0
	public double vy = 0
	
	public boolean isDead = false	
	
	def void update()
	def boolean collide(Sprite other)
	
	
}