
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class Javafx extends Application {
    public void start(Stage s)
    {
        s.setTitle("creating label");
        Label b = new Label("This is a label");

        
        StackPane r = new StackPane();

        
        r.getChildren().add(b);

        
        Scene sc = new Scene(r, 200, 200);

    
        s.setScene(sc);

        s.show();
    }

    public static void main(String args[])
    {
         launch(args);
    }
}