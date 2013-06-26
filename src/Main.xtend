import javafx.application.Application
import javafx.stage.Stage

class MyJAVAFXGAME extends Application
{
	
	GameWorld lvl1 
	GameWorld lvl2
	
	override start(Stage stage) throws Exception 
	{
		lvl1 = new Level1
		lvl2 = new Level2	
		
		lvl1.init(stage)
		
		
		lvl1.nextLvl.onAction = [
			lvl2.init(stage)
			lvl1 = null
		]
		
			
	}
	
	def public static void main(String[] args)
	{
		launch(args)
	}
	
	
		
}