package code;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ClientScene{

    private Scene clientScene;
    private int languageOption;
    private Label notice;
    private TextField ipField;
    private Label ipText;
    private Pane clientScenePane;
    private String ip;

    private SceneBuilder sceneBuilder;

    protected ClientScene(int languageOption){
        this.languageOption = languageOption;
        sceneBuilder = new SceneBuilder();
        createClientScene();
    }

    private void createNoticeLabel(){
        notice = sceneBuilder.createLabel(30);
        if(languageOption == 1) notice.setText("আপনার বন্ধুর সার্ভারের আইপিটি সংগ্রহ করুন");
        else notice.setText("Please Get IP of the server from your friend");
        notice.setLayoutX(200);
        notice.setLayoutY(300);
        notice.setTextFill(Color.web("#003300"));
    }

    private void createIPText(){
        ipText = sceneBuilder.createLabel(20);
        ipText.setTextFill(Color.web("#003300"));
        if(languageOption == 1) {
            ipText.setText("আইপিঃ");
            ipText.setLayoutX(380);
        }
        else {
            ipText.setText("IP:");
            ipText.setLayoutX(418);
        }
        ipText.setLayoutY(335);
    }

    private void createIPTextField(){
        ipField = new TextField();
        ipField.setLayoutX(465);
        ipField.setLayoutY(335);
    }

    protected void ipFieldEventHandler(Stage stage, GameScene gameScene){
        ipField.setOnAction(e-> {
            ip = ipField.getText();
            stage.setScene(gameScene.getSceneOfGame());
            BoardListener boardListener = new BoardListener(stage, gameScene.getGameBoard(), gameScene.getPaneOfGame(), languageOption);
        });
    }

    private void creatPane(){
        createNoticeLabel();
        createIPText();
        createIPTextField();
        clientScenePane = new Pane();
        clientScenePane.setPrefSize(950, 650);
        clientScenePane.setBackground(sceneBuilder.setBackgroundPicture("resources/gameStartScene.png"));
        clientScenePane.getChildren().addAll(notice, ipText, ipField);
    }

    private void createClientScene(){
        creatPane();
        clientScene = new Scene(clientScenePane);
    }

    protected Scene getClientScene(){
        return clientScene;
    }

    protected String getIp(){
        return ip;
    }
}