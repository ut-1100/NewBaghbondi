package NewBaghbondi;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOverWorks {

    Stage boardStage;
    Position[][] board;
    int numberOfGoat = 7;
    int minimumNumberOfGoats = 1;

    GameOverWorks(Stage boardStage, Position[][] board) {
        this.boardStage = boardStage;
        this.board = board;
    }

    public boolean goatWinCase(Piece piece) {
        if (endTigerGame(piece)) {
            boardStage.setScene(gameOverScene(false));
            return true;
        }
        return false;
    }
    public void killGoat(){
        numberOfGoat--;
    }
    public boolean tigerWinCase(){
        if (numberOfGoat<minimumNumberOfGoats) {
            boardStage.setScene(gameOverScene(true));
            return true;
        }
        return false;
    }
    private boolean endTigerGame(Piece piece) {
        int i, j, horizontal, vertical, vertical0, horizontal0;
        boolean k = true, k1 = true;
        horizontal = (int) piece.getOldHorizontal() / 100;
        vertical = (int) piece.getOldVertical() / 100;

        System.out.println(horizontal + " ,hi " + vertical);

        if (piece.getPieceTypeEnum() == PieceTypeEnum.TIGER) {
            //System.out.println("label1");

            //k=board[0][4].hasPiece() && board[4][0].hasPiece();
            //System.out.println(k);

            if ((horizontal == 2) && (vertical == 2)) {
                //System.out.println("label2");
                for (i = 0, j = 0; i < 3; i++, j += 2) {
                    //System.out.println("label3");
                    k = (board[1 + i][1].hasPiece() && board[1 + i][3].hasPiece()) && (board[j][0].hasPiece() && board[j][4].hasPiece());
                    if (!k) return k;
                }
                return k;
            }
            else if (horizontal == 2 && (vertical == 0 || vertical == 4)) {
                //System.out.println("label3");
                k = (board[0][vertical].hasPiece() && board[4][vertical].hasPiece())&& board[2][2].hasPiece();
                if (vertical == 0) k = k && board[2][1].hasPiece();
                else k = k && board[2][3].hasPiece();
                //System.out.println("label3");
                return k;
            }
            else if (horizontal == 2 && (vertical == 1 || vertical == 3)) {
                if (board[horizontal][vertical - 1].hasPiece()) System.out.println("Yes");
                k = (board[horizontal][vertical - 1].hasPiece() && board[horizontal][vertical + 1].hasPiece()) && (board[horizontal - 1][vertical].hasPiece() && board[horizontal + 1][vertical].hasPiece());
                //System.out.println("label3 hghghg");
                if (k) {
                    // System.out.println("label4");
                    if (vertical == 1) k = k && board[horizontal][vertical + 2].hasPiece();
                    else k = k && board[horizontal][vertical - 2].hasPiece();
                    return k;
                } else {// System.out.println("label2");
                    return false;
                }
            }
            else if ((horizontal == 0 || horizontal == 4) && (vertical == 0 || vertical == 4)) {
                ///  System.out.println("label2");
                if (horizontal == 4) {
                    horizontal0 = 3;
                } else {
                    horizontal0 = 1;
                }
                if (vertical == 4) {
                    vertical0 = 3;
                } else {
                    vertical0 = 1;
                }

                k = (board[horizontal0][vertical0].hasPiece() && board[2][vertical].hasPiece()) && board[2][2].hasPiece();

                System.out.println(k);

                if (horizontal == 4) horizontal0 = 0;
                else horizontal0 = 0;

                k = k && board[horizontal0][vertical].hasPiece();

                System.out.println("label5" + k);

                return k;
            }
            else if ((horizontal == 1 || horizontal == 3) && (vertical == 1 || vertical == 3)) {
                if (horizontal == 1) horizontal0 = 0;
                else horizontal0 = 4;
                if (vertical == 1) vertical0 = 0;
                else vertical0 = 4;

                k = (board[horizontal0][vertical0].hasPiece() && board[2][vertical].hasPiece()) && board[2][2].hasPiece();

                if (horizontal == 3) horizontal0 = horizontal - 2;
                else horizontal0 = horizontal + 2;
                if (vertical == 3) vertical0 = vertical - 2;
                else vertical0 = vertical + 2;

                k = k && board[horizontal0][vertical].hasPiece() && board[horizontal0][vertical0].hasPiece();

                return k;
            }
        }
        return false;
    }

    private Scene gameOverScene(boolean tigerWin) {
        Label label = new Label("Game Over!");
        label.setFont(new Font("Arial", 30));
        label.setTextFill(Color.web("#228b22", 1.0));

        String type;

        if (tigerWin) {
            type = "Tiger";
        } else {
            type = "Goat";
        }

        Label label2 = new Label(type + " has won the game!!");
        label2.setFont(new Font("Arial", 35));
        label2.setTextFill(Color.web("#ff4500", 1.0));

        VBox vBox = new VBox(5);

        vBox.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(label, label2);

        Scene scene = new Scene(vBox, 800, 600);

        return scene;
    }


}