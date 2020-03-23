package NewBaghbondi;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BoardScene {
    Stage stage;
    BoardScene(Stage stage){
        this.stage = stage;

    }
    public Scene createMainScene()
    {
        Button button = new Button();
        Button button0 = new Button();

        Label label= new Label("           Welcome!\nPlease select an option:");
        button.setText("Start Default Game");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new BoardStage().boardStage();
                stage.close();
            }
        });

        button0.setText("Language Options");
        button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(createSceneLanguageOption());
            }
        });

        VBox layout = new VBox(5);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label,button,button0);

        Scene scene = new Scene(layout, 800,600);

        return scene;
    }
    public Scene createSceneLanguageOption()
    {
        Button button1 = new Button();
        Button button2 = new Button();

        Label label= new Label("Please select a language:");

        button1.setText("Bengali");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("button1.setOnAction()");
                //boardStage.setScene(createGameScene());
            }
        });

        button2.setText("English");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("button2.setOnAction()");
                //boardStage.setScene(new Scene(createContent()));
            }
        });

        VBox vBox= new VBox(5);

        vBox.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(label,button1,button2);


        Scene scene = new Scene(vBox,800,600);

        return scene;
    }

    public Scene gameOverScene()
    {
        Label label= new Label("Game Over!");
        label.setFont(new Font("Arial",30));
        label.setTextFill(Color.web("#228b22",1.0));

        String type;

        if(true){
            type = "Tiger";
        }
        else{
            type = "Goat";
        }

        Label label2 = new Label(type+" has won the game!!");
        label2.setFont(new Font("Arial",35));
        label2.setTextFill(Color.web("#ff4500",1.0));

        VBox vBox= new VBox(5);

        vBox.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(label, label2);

        Scene scene = new Scene(vBox,800,600);

        return scene;
    }
}