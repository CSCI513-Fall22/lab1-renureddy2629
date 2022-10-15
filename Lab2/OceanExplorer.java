import java.util.Random;
import javafx.application.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class OceanExplorer extends Application {
	int[][] islandMap;
	int count;
	final int dimensions = 10;
	final int scale = 20;
	final int islandCount = 10;
	Scene scene;
	Pane root;
	OceanMap oceanMap;
	Ship ship;
	ImageView shipImageView;
	Label moves;
	@Override
	public void start(Stage oceanStage) throws Exception {
		//count = total amount of moves for each game
		count = 0;
		oceanMap = new OceanMap(dimensions, scale);
		islandMap = oceanMap.getMap();		
		root = new AnchorPane();
		drawMap();
		drawIslands(10);
		ship = new Ship(oceanMap);
		loadShipImage();
		moves = new Label("Total moves: " + count);
		moves.setLayoutX(100);
		moves.setLayoutY(200);
		root.getChildren().add(moves);
		scene = new Scene(root, 200, 226);
		oceanStage.setTitle("Christopher Columbus Sails the Ocean Blue");
		oceanStage.setScene(scene);
		oceanStage.show();
		startSailing();
	}
	public void drawMap(){
		for(int x = 0; x < dimensions; x++){
			for(int y = 0; y < dimensions; y++){
			Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
			rect.setStroke(Color.BLACK); 
			rect.setFill(Color.PALETURQUOISE); 
			root.getChildren().add(rect); 
			}
		}
	}
	public void loadShipImage(){
		Image shipImage = new Image("C:\\Users\\Z1971177\\eclipse\\SE Lab\\Lab2\\ship.png.jpeg",18,18,true,true); 
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getShipLocation().x * scale);
		shipImageView.setY(ship.getShipLocation().y * scale);
		root.getChildren().add(shipImageView);
	}
	public void drawIslands(int i){
		int count = 0;
		Random rand = new Random();
		while(count<i){
			int x;
			int y;
			while(true){
				x = rand.nextInt(dimensions);
				y = rand.nextInt(dimensions);
				if(islandMap[x][y]!=1)
					break;
			}
			Image islandImage = new Image("C:\\Users\\Z1971177\\eclipse\\SE Lab\\Lab2\\island.png.jpeg",18,18,true,true); 
			ImageView islandImageView = new ImageView(islandImage);
			islandImageView.setX(x*scale);
			islandImageView.setY(y*scale);
			islandMap[x][y] = 1;
			root.getChildren().add(islandImageView);
			count++;
		}
	}
	private void startSailing(){
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
	public void handle(KeyEvent ke) {
		switch(ke.getCode()){
			case RIGHT:
			ship.move("EAST");
			break;
			case LEFT:
			ship.move("WEST");
			break;
			case UP:
			ship.move("NORTH");
			break;
			case DOWN:
			ship.move("SOUTH");
			break;
			default:
			break;
		}
		moves.setText("Total moves: "+ ++count);
		shipImageView.setX(ship.getShipLocation().x*scale);
		shipImageView.setY(ship.getShipLocation().y*scale);
		}});
		 }
	public static void main(String[] args) {
		launch(args);
	}
}