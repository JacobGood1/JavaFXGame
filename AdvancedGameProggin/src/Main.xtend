import javafx.application.Application
import javafx.stage.Stage

class Main extends Application
{
	override start(Stage stage) throws Exception 
	{
		new Level1(stage)
		
	}
	
	def public static void main(String[] args)
	{
		launch(args)
	}
}