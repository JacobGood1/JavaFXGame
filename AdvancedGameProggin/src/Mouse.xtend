import javafx.scene.Scene
import javafx.scene.Group

class Mouse 
{
	@Property double x = 0
	@Property double y = 0
	
	new(Group group)
	{
		group.onMouseMoved = [x = group.layoutX y = group.layoutY]	
	}		
}