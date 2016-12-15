/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package honors.pkgfinal.project.semester.pkg1;

import java.io.File;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author BobbyGehr
 */
public class HonorsFinalProjectSemester1 extends Application {
    
    private int randSpawn =0;
    private int randLane =0;
    private int scores = 0;
    private int highScore = 0;
    private boolean gameOver = false;
    
    //private double playerSpeed = 1650.0;
    //private double enemySpeed = 4000.0;
    
    @Override
    public void start(Stage primaryStage) {
        
        Rectangle player = new Rectangle(60, 75, 40, 40);
        player.setFill(Color.INDIANRED);
        player.setStroke(Color.LIGHTGRAY);
        Rectangle enemy1 = new Rectangle(600, 20, 30, 30);
        enemy1.setFill(Color.GREEN);
        Rectangle enemy2 = new Rectangle(600, 140, 30, 30);
        enemy2.setFill(Color.GREEN);
        Rectangle enemy3 = new Rectangle(600, 80, 30, 30);
        enemy3.setFill(Color.GREEN);
        enemy3.setRotate(90);
        enemy3.setStroke(Color.LIGHTGRAY);
        Rectangle wall1 = new Rectangle(0, 0, 600, 20);
        wall1.setFill(Color.GREEN);
        Rectangle wall2 = new Rectangle(0, 170, 600, 20);
        wall2.setFill(Color.GREEN);
        Line path1 = new Line(80, 35, 80, 155);
        path1.setStroke(Color.TRANSPARENT);
        Line path2 = new Line(80, 55, 80, 155);
        path2.setStroke(Color.TRANSPARENT);
        Line enemyPath1 = new Line(650, 35, -50, 35);
        Line enemyPath2 = new Line(650, 155, -50, 155);
        Line enemyPath3 = new Line(650, 95, -50, 95);
        Text score = new Text(265, 182, "Score: " + scores);
        score.setScaleX(1.3);
        score.setFill(Color.WHITE);
        Text highScoreText = new Text(155, 160, "High Score: " + highScore);
        highScoreText.setScaleX(4);
        highScoreText.setScaleY(4);
        highScoreText.setFill(Color.WHITE);
        Text score2 = new Text(170, 115, "Score: " + scores);
        score2.setScaleX(2);
        score2.setScaleY(2);
        score2.setFill(Color.LIGHTGRAY);
        Text gameOverText = new Text(255, 100, "GAME OVER!");
        gameOverText.setScaleX(5);
        gameOverText.setScaleY(5);
        gameOverText.setFill(Color.TRANSPARENT);
        Button continueBtn = new Button("CONTINUE");
        continueBtn.setVisible(false);
        continueBtn.setTranslateX(250);
        continueBtn.setTranslateY(130);
        Button playAgain = new Button("Play Again!");
        playAgain.setTranslateX(160);
        playAgain.setTranslateY(230);
        playAgain.setScaleX(3);
        playAgain.setScaleY(3);
        RadioButton borders = new RadioButton("Borders");
        borders.setTranslateX(350);
        borders.setTranslateY(171);
        borders.setScaleX(0.8);
        borders.setScaleY(0.8);
        
        Image image = new Image("http://rs493.pbsrc.com/albums/rr292/marcel_freezer/helicopter.gif~c200");
        ImagePattern imagePattern = new ImagePattern(image);
        player.setFill(imagePattern);
        
        Image image2 = new Image("http://i.imgur.com/5kzvpsa.gif");
        ImagePattern imagePattern2 = new ImagePattern(image2);
        enemy3.setFill(imagePattern2);
        
        Image image3 = new Image("https://media.giphy.com/media/By8QQiy2c7DUc/giphy.gif");
        ImagePattern imagePattern3 = new ImagePattern(image3);
        
        Pane root = new Pane();
        root.getChildren().addAll(path1, path2, player, wall1, wall2, borders, score, enemy1, enemy2, enemy3, gameOverText, continueBtn);
        root.setStyle("-fx-background-color: black");
        
        Pane root2 = new Pane();
        root2.getChildren().addAll(highScoreText, score2, playAgain);
        root2.setStyle("-fx-background-color: green");
        
        
        borders.setOnAction(f -> {
                    root.requestFocus();
                    if(borders.isSelected()){
                        player.setStroke(Color.TRANSPARENT);
                        enemy3.setStroke(Color.TRANSPARENT);
                    }else{
                        player.setStroke(Color.LIGHTGRAY);
                        enemy3.setStroke(Color.LIGHTGRAY);
                    }
                });
        
        
        PathTransition pt = new PathTransition(Duration.millis(1650), path1, player);
        pt.setCycleCount(1);
        pt.setInterpolator(Interpolator.LINEAR);
        pt.play();
        PathTransition PtEnemyPath1 = new PathTransition(Duration.millis(4000), enemyPath1, enemy1);
        PtEnemyPath1.setCycleCount(1);
        PtEnemyPath1.setInterpolator(Interpolator.LINEAR);
        PathTransition PtEnemyPath2 = new PathTransition(Duration.millis(4000), enemyPath2, enemy2);
        PtEnemyPath2.setCycleCount(1);
        PtEnemyPath2.setInterpolator(Interpolator.LINEAR);
        PathTransition PtEnemyPath3 = new PathTransition(Duration.millis(4000), enemyPath3, enemy3);
        PtEnemyPath3.setCycleCount(1);
        PtEnemyPath3.setInterpolator(Interpolator.LINEAR);
        
        File file = new File("/sound/music.wav");
        
        String soundFileName = "file:" + System.getProperty("user.dir") + file;
        MediaPlayer mp1 = new MediaPlayer(new Media(soundFileName));
        mp1.setAutoPlay(true);
        mp1.play();
        
        Timeline animation = new Timeline(
                
                new KeyFrame(Duration.millis(100), e -> {
                    Random rand = new Random();
                    randSpawn = rand.nextInt(1000) +1;
                    System.out.println(randSpawn);
                    randLane = rand.nextInt(3) +1;
                    System.out.println(randLane);
                    if(gameOver==false){
                        scores++;
                        score.setText("Score:" + scores);
                    }else{
                        if(scores > highScore){
                            System.out.println("THIS HAPPENED");
                            highScore = scores;
                        }
                        highScoreText.setText("High Score: " + highScore);
                        score2.setText("Score: " + scores);
                    }
                    
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        Timeline animation2 = new Timeline(
                
                new KeyFrame(Duration.millis(10), e -> {
                    
                    if(randSpawn % 8 == 0){
                        if(randLane == 1 && PtEnemyPath1.getStatus() != Animation.Status.RUNNING){
                            PtEnemyPath1.setDuration(Duration.millis(4000));
                            System.out.println("Block 1!");
                            if(PtEnemyPath2.getStatus() == Animation.Status.RUNNING && PtEnemyPath3.getStatus() == Animation.Status.RUNNING){
                                PtEnemyPath1.setDuration(Duration.millis(5500));
                            }
                            PtEnemyPath1.playFromStart();
                        }
                        if(randLane == 2 && PtEnemyPath2.getStatus() != Animation.Status.RUNNING){
                            PtEnemyPath2.setDuration(Duration.millis(4000));
                            System.out.println("Block 2!");
                            if(PtEnemyPath1.getStatus() == Animation.Status.RUNNING && PtEnemyPath3.getStatus() == Animation.Status.RUNNING){
                                PtEnemyPath2.setDuration(Duration.millis(5500));
                            }
                            PtEnemyPath2.playFromStart();
                        }
                        if(randLane == 3 && PtEnemyPath3.getStatus() != Animation.Status.RUNNING){
                            PtEnemyPath3.setDuration(Duration.millis(4000));
                            System.out.println("Block 3!");
                            if(PtEnemyPath1.getStatus() == Animation.Status.RUNNING && PtEnemyPath2.getStatus() == Animation.Status.RUNNING){
                                PtEnemyPath3.setDuration(Duration.millis(5500));
                            }
                            PtEnemyPath3.playFromStart();
                        }
                    }
                    if (player.getBoundsInParent().intersects(enemy1.getBoundsInParent()) || 
                                player.getBoundsInParent().intersects(enemy2.getBoundsInParent()) || 
                                    player.getBoundsInParent().intersects(enemy3.getBoundsInParent())) {
                        player.setFill(imagePattern3);
                        pt.setRate(1.0);
                        pt.play();
                        gameOver = true;
                    }
                    if(pt.getStatus() != Animation.Status.RUNNING){
                        gameOver=true;
                        mp1.stop();
                        continueBtn.setVisible(true);
                        player.setFill(imagePattern3);
                        PtEnemyPath1.pause();
                        PtEnemyPath2.pause();
                        PtEnemyPath3.pause();
                        gameOverText.setFill(Color.RED);
                    }
                    
        }));
        animation2.setCycleCount(Timeline.INDEFINITE);
        animation2.play();
        
        root.setOnKeyPressed(e -> {
            switch(e.getCode()){
                case SPACE: {
                    if(gameOver==false){
                        pt.setRate(-1.0);
                        pt.setDuration(Duration.millis(1650));
                        pt.play();
                        break;
                    }
                }
            }
        });
        root.setOnKeyReleased(e -> {
            switch(e.getCode()){
                case SPACE: {
                    if(gameOver==false){
                        pt.setRate(1.0);
                        pt.setDuration(Duration.millis(1150));
                        pt.play();
                        break;
                    }
                }
            }
        });
        
        Scene scene = new Scene(root, 600, 190);
        Scene scoreScreen = new Scene(root2, 400, 400);
        
        continueBtn.setOnAction(e -> {
            primaryStage.setScene(scoreScreen);
            animation.pause();
            animation2.pause();
        });
        playAgain.setOnAction(e -> {
                        
            animation.play();
            animation2.play();
            
            primaryStage.setScene(scene);
            player.setFill(imagePattern);
            pt.play();
            root.requestFocus();
            gameOver = false;
            gameOverText.setFill(Color.TRANSPARENT);
            continueBtn.setVisible(false);
            enemy1.setTranslateX(-1000);
            enemy2.setTranslateX(-1000);
            enemy3.setTranslateX(-1000);
            scores = 0;
            mp1.play();
        });
        
        primaryStage.setTitle("Cube Dodge!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        root.requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
