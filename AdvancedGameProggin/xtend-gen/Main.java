import javafx.application.Application;
import javafx.stage.Stage;

@SuppressWarnings("all")
public class Main extends Application {
  public void start(final Stage stage) throws Exception {
    new Level1(stage);
  }
  
  public static void main(final String[] args) {
    Application.launch(args);
  }
}
