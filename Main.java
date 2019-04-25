package application;
	
import Game.Bishops;
import Game.Blank;
import Game.Kings;
import Game.Knights;
import Game.Pawns;
import Game.Pieces;
import Game.Player;
import Game.Queens;
import Game.Rooks;
import Game.Pieces.Type;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


/**
 * @author luis222
 *
 */



public class Main extends Application {
	
	public final static int BOARD_TILES=64;
	
	static Pieces[] Piece =new Pieces[BOARD_TILES];
	static ImageView[] Images = new ImageView[BOARD_TILES];
	static GridPane gridPane = new GridPane();
	static Button[] Buttons =new Button[68];
	public static Player player1 ;
	public static Player player2 ;
	public static Pieces typeWanted;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			changeStage(primaryStage, mainMenu(primaryStage));
			

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeStage(Stage primaryStage, Scene scene) {
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public Scene mainMenu(Stage primaryStage) {
		
		GridPane root = new GridPane();
		TextField name1 = new TextField("");
		Label name_1 = new Label("Name:");
		Label P2 = new Label("-Player 2-");
		Label P1 = new Label("-Player 1-");
		TextField name2 = new TextField("");
		Label name_2 = new Label("Name:");
		Button start = new Button("Start");
		Label DoubleClick = new Label("DoubleClick");
		RadioButton W1 = new RadioButton("White");
		W1.setSelected(true);
		RadioButton W2 = new RadioButton("White");
		RadioButton B1 = new RadioButton("Black");
		RadioButton B2 = new RadioButton("Black");
		B2.setSelected(true);
		
		B1.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent t) {
					if(B1.isSelected()) {
						B2.setSelected(false);
						W1.setSelected(false);
						W2.setSelected(true);
						
					}else if(!B1.isSelected()){
						B2.setSelected(true);
						W1.setSelected(true);
						W2.setSelected(false);
					}
			}
		});
		B2.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent t) {
					if(B2.isSelected()) {
						B1.setSelected(false);
						W1.setSelected(true);
						W2.setSelected(false);
						
					}else if(!B2.isSelected()){
						B1.setSelected(true);
						W1.setSelected(false);
						W2.setSelected(true);
					}
			}
		});
		W1.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent t) {
					if(W1.isSelected()) {
						B2.setSelected(true);
						B1.setSelected(false);
						W2.setSelected(false);
						
					}else if(W1.isSelected()){
						B2.setSelected(false);
						B1.setSelected(true);
						W2.setSelected(true);
					}
			}
		});
		W2.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent t) {
					if(W2.isSelected()) {
						B2.setSelected(false);
						B1.setSelected(true);
						W1.setSelected(false);
						
					}else if(!W2.isSelected()){
						B2.setSelected(true);
						B1.setSelected(false);
						W1.setSelected(true);
					}
			}
		});
		
		start.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent t) {
				
					if((name1.getText().equals(""))||(name2.getText().equals(""))||name1.getText().equals(name2.getText())) {
					}else {
						if(W1.isSelected()) {
							 player1= new Player(name1.getText(),"WHITE");
							
						}else if(B1.isSelected()) {
							 player1= new Player(name1.getText(),"BLACK");
							
						}
						
						if(W2.isSelected()) {
							 player2= new Player(name2.getText(),"WHITE");
							
						}else if(B2.isSelected()) {
							 player2= new Player(name2.getText(),"BLACK");
							
						}
						
						
						start.setOnAction(event -> changeStage(primaryStage ,Game(primaryStage)));
					}
			}
			
		});
		
		root.add(P1, 0, 0);
		root.add(name_1, 0, 1);
		root.add(name1, 2, 1);
		root.add(W1, 3, 1);
		root.add(B1, 4, 1);
		root.add(P2, 0, 2);
		root.add(name_2, 0, 3);
		root.add(name2, 2, 3);
		root.add(W2, 3, 3);
		root.add(B2, 4, 3);
		root.add(start, 4, 4);
		root.add(DoubleClick, 5, 4);
		
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		return scene;
	}
	
	public static Pieces Promote( Pieces Piece) {
		Stage SecondStage = new Stage();
		GridPane gridPane = new GridPane();
		SecondStage.setTitle("Promote");
		
		Image White_Rook =new Image("Chees_Images/White_Rook.JPG");
		Image White_Knight =new Image("Chees_Images/White_Knight.JPG");
		Image White_Queen =new Image("Chees_Images/White_Queen.JPG");
		Image White_Bishop =new Image("Chees_Images/White_Bishop.JPG");
		
		Button One= new Button();
		Button Two= new Button();
		Button Three= new Button();
		Button Four= new Button();
		Button Choose = new Button("Select");
		Choose.setVisible(false);
		
		ImageView ImaOne= new ImageView();
		ImageView ImaTwo= new ImageView();
		ImageView ImaThree= new ImageView();
		ImageView ImaFour= new ImageView();
		
		ImaOne.setImage(White_Rook);
		ImaTwo.setImage(White_Bishop);
		ImaThree.setImage(White_Queen);
		ImaFour.setImage(White_Knight);
		
		One.setGraphic(ImaOne);
		Two.setGraphic(ImaTwo);
		Three.setGraphic(ImaThree);
		Four.setGraphic(ImaFour);
		
		Pieces typeWanted = Piece;
		
		One.setOnAction(event-> {typeWanted.setType(Type.Rook); 
			Choose.setVisible(true);
			Two.setVisible(false);
			Three.setVisible(false);
			Four.setVisible(false);
			
		});
		Two.setOnAction(event-> {typeWanted.setType(Type.Bishop);
			Choose.setVisible(true);
			One.setVisible(false);
			Three.setVisible(false);
			Four.setVisible(false);
		});
		Three.setOnAction(event-> {typeWanted.setType(Type.Queen);
		Choose.setVisible(true);
		One.setVisible(false);
		Two.setVisible(false);
		Four.setVisible(false);
		});
		Four.setOnAction(event-> {typeWanted.setType(Type.Knight);
		Choose.setVisible(true);
		One.setVisible(false);
		Three.setVisible(false);
		Two.setVisible(false);
	});
		Choose.setOnAction(event -> SecondStage.close());
		
		gridPane.add(Choose, 1, 1);
		gridPane.add(One, 0, 0);
		gridPane.add(Two, 1, 0);
		gridPane.add(Three, 2, 0);
		gridPane.add(Four, 3, 0);
		
		Scene scene2 = new Scene(gridPane,-1,-1);
		SecondStage.setScene(scene2);
		SecondStage.show();
		
		return Piece;
		
	}
	
	public Scene Results(Stage primaryStage,int win) {
		GridPane gridPane = new GridPane();
		
		Label name = new Label();
		
		Label Status = new Label();
		
		
		
		if(win==1) {
			Status.setText("Won");
			if(player1.getColor()=="WHITE") {
			name.setText(player1.getName());}
			else if(player2.getColor()=="WHITE"){
				name.setText(player2.getName());	
			}
		}else if(win==2){
			Status.setText("Won");
			if(player1.getColor()=="BLACK") {
				name.setText(player1.getName());}
				else if(player2.getColor()=="BLACK"){
					name.setText(player2.getName());	
				}
		}else if(win==3){
			Status.setText("DRAW");
		}
		Button exit =new Button("Exit");
		gridPane.add(exit, 0, 2);
		exit.setOnAction(event -> System.exit(0));
		
		Button restart =new Button("Start Over");
		gridPane.add(restart, 0, 3);
		restart.setOnAction(event -> changeStage(primaryStage ,mainMenu(primaryStage)));
		
		gridPane.add(Status, 0, 1);
		gridPane.add(name, 0, 0);
		
		Scene scene = new Scene(gridPane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		return scene;
	}
	
	public Scene Game(Stage primaryStage) {
		BorderPane root = new BorderPane();
		GridPane gridPane = new GridPane();
		
		setup();
		
		root.setCenter(gridPane);
		Button exit =new Button("Exit");
		gridPane.add(exit, 9, 8);
		exit.setOnAction(event -> System.exit(0));
		Buttons[64] =new Button("Draw");
		gridPane.add(Buttons[64], 9, 7);
		Buttons[64].setDisable(true);
		Buttons[64].setVisible(false);
		Buttons[64].setOnAction(event-> changeStage(primaryStage ,Results(primaryStage,3)));
		
		Buttons[65] =new Button("-Check-");
		gridPane.add(Buttons[65], 9, 5);
		Buttons[65].setDisable(true);
		
		Buttons[66] =new Button("-Results-");
		gridPane.add(Buttons[66], 9, 4);
		Buttons[66].setDisable(true);
		Buttons[66].setVisible(false);
		Buttons[66].setOnAction(event-> changeStage(primaryStage ,Results(primaryStage,2)));
		
		Buttons[67] =new Button("-Results-");
		Buttons[67].setOnAction(event-> changeStage(primaryStage ,Results(primaryStage,1)));
		gridPane.add(Buttons[67], 9, 3);
		Buttons[67].setDisable(true);
		Buttons[67].setVisible(false);
		
		
		
		Button restart =new Button("Start Over");
		gridPane.add(restart, 9, 6);
		restart.setOnAction(event -> changeStage(primaryStage ,mainMenu(primaryStage)));
		
		for(int i=0;i<BOARD_TILES;i++) {
			
			
			Buttons[i]= new Button();
			Images[i]= new ImageView();
			Images[i].setFitHeight(50);
			 Images[i].setFitWidth(50);
	        Images[i].setPreserveRatio(false);
	        Images[i].setSmooth(true);
	        Images[i].setCache(true);
	        if(i<=7) {
	    	gridPane.add(Buttons[i], i, 0);
	    	}else if(i>=8&&i<=15) {
	    	gridPane.add(Buttons[i], i-8, 1);
	    	}else if(i>=16&&i<=23) {
		   	gridPane.add(Buttons[i], i-16, 2);
		    }else if(i>=24&&i<=31) {
		    gridPane.add(Buttons[i], i-24, 3);
		    }else if(i>=32&&i<=39) {
		    gridPane.add(Buttons[i], i-32, 4);
		    } else if(i>=40&&i<=47) {
		    gridPane.add(Buttons[i], i-40, 5);
		    }  else if(i>=48&&i<=55) {
		    gridPane.add(Buttons[i], i-48, 6);
		    }else if(i>=56&&i<64) {
		    gridPane.add(Buttons[i], i-56, 7);
		    }
	        
	        
	        
	        Buttons[i].setGraphic(Images[i]);
	        
	        
		        
	        Buttons[i].setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		setImages();
		setButtonsClickers();
		
		for(int i=0;i<BOARD_TILES;i++) {
		if(!(Piece[i].getColor().equals("WHITE"))) {
        	Buttons[i].setDisable(true);
        }
		}
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		return scene;
	}

	public static void setButtonsClickers() {
		Buttons[0].setOnMouseClicked((e)->{
        	
			if(Piece[0].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[0].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[0], Images,Buttons);

			}else if(!Piece[0].isEat()) {
				Piece[0].possibleMovements(Piece, Piece[0],Buttons);
				 
			}
		});
		
		Buttons[1].setOnMouseClicked((e)->{
	        	
				if(Piece[1].isEat()) {
					Pieces EaterPiece=null;
					EaterPiece=Piece[1].ReturSavedPiece();
					EaterPiece.changePieces(Piece,EaterPiece,Piece[1], Images,Buttons);
					 
				}else if(!Piece[1].isEat()) {
					Piece[1].possibleMovements(Piece, Piece[1],Buttons);
					 
				}
			});
		Buttons[2].setOnMouseClicked((e)->{
        	
			if(Piece[2].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[2].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[2], Images,Buttons);
				 
			}else if(!Piece[2].isEat()) {
				Piece[2].possibleMovements(Piece, Piece[2],Buttons);
				 
			}
		});
		Buttons[3].setOnMouseClicked((e)->{
        	
			if(Piece[3].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[3].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[3], Images,Buttons);
				 
			}else if(!Piece[3].isEat()) {
				Piece[3].possibleMovements(Piece, Piece[3],Buttons);
				 
			}
		});	
		Buttons[4].setOnMouseClicked((e)->{
        	
			if(Piece[4].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[4].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[4], Images,Buttons);
				 
			}else if(!Piece[4].isEat()) {
				Piece[4].possibleMovements(Piece, Piece[4],Buttons);
				 
			}
		});
		Buttons[5].setOnMouseClicked((e)->{
        	
			if(Piece[5].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[5].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[5], Images,Buttons);
				 
			}else if(!Piece[5].isEat()) {
				Piece[5].possibleMovements(Piece, Piece[5],Buttons);
				 
			}
		});
		Buttons[6].setOnMouseClicked((e)->{
        	
			if(Piece[6].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[6].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[6], Images,Buttons);
				 
			}else if(!Piece[6].isEat()) {
				Piece[6].possibleMovements(Piece, Piece[6],Buttons);
				 
			}
		});
		Buttons[7].setOnMouseClicked((e)->{
        	
			if(Piece[7].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[7].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[7], Images,Buttons);
				 
			}else if(!Piece[7].isEat()) {
				Piece[7].possibleMovements(Piece, Piece[7],Buttons);
				 
			}
		});
		Buttons[8].setOnMouseClicked((e)->{
        	
			if(Piece[8].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[8].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[8], Images,Buttons);
				 
			}else if(!Piece[8].isEat()) {
				Piece[8].possibleMovements(Piece, Piece[8],Buttons);
				 
			}
		});
		Buttons[9].setOnMouseClicked((e)->{
        	
			if(Piece[9].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[9].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[9], Images,Buttons);
				 
			}else if(!Piece[9].isEat()) {
				Piece[9].possibleMovements(Piece, Piece[9],Buttons);
				 
			}
		});
		Buttons[10].setOnMouseClicked((e)->{
        	
			if(Piece[10].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[10].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[10], Images,Buttons);
				 
			}else if(!Piece[10].isEat()) {
				Piece[10].possibleMovements(Piece, Piece[10],Buttons);
				 
			}
		});
		Buttons[11].setOnMouseClicked((e)->{
        	
			if(Piece[11].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[11].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[11], Images,Buttons);
				 
			}else if(!Piece[11].isEat()) {
				Piece[11].possibleMovements(Piece, Piece[11],Buttons);
				 
			}
		});
		Buttons[12].setOnMouseClicked((e)->{
        	
			if(Piece[12].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[12].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[12], Images,Buttons);
				 
			}else if(!Piece[12].isEat()) {
				Piece[12].possibleMovements(Piece, Piece[12],Buttons);
				 
			}
		});
		Buttons[13].setOnMouseClicked((e)->{
        	
			if(Piece[13].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[13].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[13], Images,Buttons);
				 
			}else if(!Piece[13].isEat()) {
				Piece[13].possibleMovements(Piece, Piece[13],Buttons);
				 
			}
		});
		Buttons[14].setOnMouseClicked((e)->{
        	
			if(Piece[14].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[14].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[14], Images,Buttons);
				 
			}else if(!Piece[14].isEat()) {
				Piece[14].possibleMovements(Piece, Piece[14],Buttons);
				 
			}
		});
		Buttons[15].setOnMouseClicked((e)->{
        	
			if(Piece[15].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[15].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[15], Images,Buttons);
				 
			}else if(!Piece[15].isEat()) {
				Piece[15].possibleMovements(Piece, Piece[15],Buttons);
				 
			}
		});
		Buttons[16].setOnMouseClicked((e)->{
        	
			if(Piece[16].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[16].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[16], Images,Buttons);
				 
			}else if(!Piece[16].isEat()) {
				Piece[16].possibleMovements(Piece, Piece[16],Buttons);
				 
			}
		});
		Buttons[17].setOnMouseClicked((e)->{
        	
			if(Piece[17].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[17].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[17], Images,Buttons);
				 
			}else if(!Piece[17].isEat()) {
				Piece[17].possibleMovements(Piece, Piece[17],Buttons);
				 
			}
		});
		Buttons[18].setOnMouseClicked((e)->{
        	
			if(Piece[18].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[18].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[18], Images,Buttons);
				 
			}else if(!Piece[18].isEat()) {
				Piece[18].possibleMovements(Piece, Piece[18],Buttons);
				 
			}
		});
		Buttons[19].setOnMouseClicked((e)->{
        	
			if(Piece[19].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[19].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[19], Images,Buttons);
				 
			}else if(!Piece[19].isEat()) {
				Piece[19].possibleMovements(Piece, Piece[19],Buttons);
				 
			}
		});
		Buttons[20].setOnMouseClicked((e)->{
        	
			if(Piece[20].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[20].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[20], Images,Buttons);
				 
			}else if(!Piece[20].isEat()) {
				Piece[20].possibleMovements(Piece, Piece[20],Buttons);
				 
			}
		});
		Buttons[21].setOnMouseClicked((e)->{
        	
			if(Piece[21].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[21].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[21], Images,Buttons);
				 
			}else if(!Piece[21].isEat()) {
				Piece[21].possibleMovements(Piece, Piece[21],Buttons);
				 
			}
		});
		Buttons[22].setOnMouseClicked((e)->{
        	
			if(Piece[22].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[22].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[22], Images,Buttons);
				 
			}else if(!Piece[22].isEat()) {
				Piece[22].possibleMovements(Piece, Piece[22],Buttons);
				 
			}
		});
		Buttons[23].setOnMouseClicked((e)->{
        	
			if(Piece[23].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[23].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[23], Images,Buttons);
				 
			}else if(!Piece[23].isEat()) {
				Piece[23].possibleMovements(Piece, Piece[23],Buttons);
				 
			}
		});
		Buttons[24].setOnMouseClicked((e)->{
        	
			if(Piece[24].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[24].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[24], Images,Buttons);
				 
			}else if(!Piece[24].isEat()) {
				Piece[24].possibleMovements(Piece, Piece[24],Buttons);
				 
			}
		});
		Buttons[25].setOnMouseClicked((e)->{
        	
			if(Piece[25].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[25].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[25], Images,Buttons);
				 
			}else if(!Piece[25].isEat()) {
				Piece[25].possibleMovements(Piece, Piece[25],Buttons);
				 
			}
		});
		Buttons[26].setOnMouseClicked((e)->{
        	
			if(Piece[26].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[26].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[26], Images,Buttons);
				 
			}else if(!Piece[26].isEat()) {
				Piece[26].possibleMovements(Piece, Piece[26],Buttons);
				 
			}
		});
		Buttons[27].setOnMouseClicked((e)->{
        	
			if(Piece[27].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[27].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[27], Images,Buttons);
				 
			}else if(!Piece[27].isEat()) {
				Piece[27].possibleMovements(Piece, Piece[27],Buttons);
				 
			}
		});
		Buttons[28].setOnMouseClicked((e)->{
        	
			if(Piece[28].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[28].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[28], Images,Buttons);
				 
			}else if(!Piece[28].isEat()) {
				Piece[28].possibleMovements(Piece, Piece[28],Buttons);
				 
			}
		});
		Buttons[29].setOnMouseClicked((e)->{
        	
			if(Piece[29].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[29].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[29], Images,Buttons);
				 
			}else if(!Piece[29].isEat()) {
				Piece[29].possibleMovements(Piece, Piece[29],Buttons);
				 
			}
		});
		Buttons[30].setOnMouseClicked((e)->{
        	
			if(Piece[30].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[30].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[30], Images,Buttons);
				 
			}else if(!Piece[30].isEat()) {
				Piece[30].possibleMovements(Piece, Piece[30],Buttons);
				 
			}
		});
		Buttons[31].setOnMouseClicked((e)->{
        	
			if(Piece[31].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[31].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[31], Images,Buttons);
				 
			}else if(!Piece[31].isEat()) {
				Piece[31].possibleMovements(Piece, Piece[31],Buttons);
				 
			}
		});
		Buttons[32].setOnMouseClicked((e)->{
        	
			if(Piece[32].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[32].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[32], Images,Buttons);
				 
			}else if(!Piece[32].isEat()) {
				Piece[32].possibleMovements(Piece, Piece[32],Buttons);
				 
			}
		});
		Buttons[33].setOnMouseClicked((e)->{
        	
			if(Piece[33].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[33].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[33], Images,Buttons);
				 
			}else if(!Piece[33].isEat()) {
				Piece[33].possibleMovements(Piece, Piece[33],Buttons);
				 
			}
		});
		Buttons[34].setOnMouseClicked((e)->{
        	
			if(Piece[34].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[34].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[34], Images,Buttons);
				 
			}else if(!Piece[34].isEat()) {
				Piece[34].possibleMovements(Piece, Piece[34],Buttons);
				 
			}
		});
		Buttons[35].setOnMouseClicked((e)->{
        	
			if(Piece[35].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[35].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[35], Images,Buttons);
				 
			}else if(!Piece[35].isEat()) {
				Piece[35].possibleMovements(Piece, Piece[35],Buttons);
				 
			}
		});
		Buttons[36].setOnMouseClicked((e)->{
        	
			if(Piece[36].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[36].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[36], Images,Buttons);
				 
			}else if(!Piece[36].isEat()) {
				Piece[36].possibleMovements(Piece, Piece[36],Buttons);
				 
			}
		});
		Buttons[37].setOnMouseClicked((e)->{
        	
			if(Piece[37].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[37].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[37], Images,Buttons);
				 
			}else if(!Piece[37].isEat()) {
				Piece[37].possibleMovements(Piece, Piece[37],Buttons);
				 
			}
		});
		Buttons[38].setOnMouseClicked((e)->{
        	
			if(Piece[38].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[38].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[38], Images,Buttons);
				 
			}else if(!Piece[38].isEat()) {
				Piece[38].possibleMovements(Piece, Piece[38],Buttons);
				 
			}
		});
		Buttons[39].setOnMouseClicked((e)->{
        	
			if(Piece[39].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[39].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[39], Images,Buttons);
				 
			}else if(!Piece[39].isEat()) {
				Piece[39].possibleMovements(Piece, Piece[39],Buttons);
				 
			}
		});
		Buttons[40].setOnMouseClicked((e)->{
        	
			if(Piece[40].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[40].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[40], Images,Buttons);
				 
			}else if(!Piece[40].isEat()) {
				Piece[40].possibleMovements(Piece, Piece[40],Buttons);
				 
			}
		});
		Buttons[41].setOnMouseClicked((e)->{
        	
			if(Piece[41].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[41].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[41], Images,Buttons);
				 
			}else if(!Piece[41].isEat()) {
				Piece[41].possibleMovements(Piece, Piece[41],Buttons);
				 
			}
		});
		Buttons[42].setOnMouseClicked((e)->{
        	
			if(Piece[42].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[42].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[42], Images,Buttons);
				 
			}else if(!Piece[42].isEat()) {
				Piece[42].possibleMovements(Piece, Piece[42],Buttons);
				 
			}
		});
		Buttons[43].setOnMouseClicked((e)->{
        	
			if(Piece[43].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[43].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[43], Images,Buttons);
				 
			}else if(!Piece[43].isEat()) {
				Piece[43].possibleMovements(Piece, Piece[43],Buttons);
				 
			}
		});
		Buttons[44].setOnMouseClicked((e)->{
        	
			if(Piece[44].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[44].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[44], Images,Buttons);
				 
			}else if(!Piece[44].isEat()) {
				Piece[44].possibleMovements(Piece, Piece[44],Buttons);
				 
			}
		});
		Buttons[45].setOnMouseClicked((e)->{
        	
			if(Piece[45].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[45].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[45], Images,Buttons);
				 
			}else if(!Piece[45].isEat()) {
				Piece[45].possibleMovements(Piece, Piece[45],Buttons);
				 
			}
		});
		Buttons[46].setOnMouseClicked((e)->{
        	
			if(Piece[46].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[46].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[46], Images,Buttons);
				 
			}else if(!Piece[46].isEat()) {
				Piece[46].possibleMovements(Piece, Piece[46],Buttons);
				 
			}
		});
		Buttons[47].setOnMouseClicked((e)->{
        	
			if(Piece[47].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[47].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[47], Images,Buttons);
				 
			}else if(!Piece[47].isEat()) {
				Piece[47].possibleMovements(Piece, Piece[47],Buttons);
				 
			}
		});
		Buttons[48].setOnMouseClicked((e)->{
        	
			if(Piece[48].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[48].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[48], Images,Buttons);
				 
			}else if(!Piece[48].isEat()) {
				Piece[48].possibleMovements(Piece, Piece[48],Buttons);
				 
			}
		});
		Buttons[49].setOnMouseClicked((e)->{
        	
			if(Piece[49].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[49].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[49], Images,Buttons);
				 
			}else if(!Piece[49].isEat()) {
				Piece[49].possibleMovements(Piece, Piece[49],Buttons);
				 
			}
		});
		Buttons[50].setOnMouseClicked((e)->{
        	
			if(Piece[50].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[50].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[50], Images,Buttons);
				 
			}else if(!Piece[50].isEat()) {
				Piece[50].possibleMovements(Piece, Piece[50],Buttons);
				 
			}
		});
		Buttons[51].setOnMouseClicked((e)->{
        	
			if(Piece[51].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[51].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[51], Images,Buttons);
				 
			}else if(!Piece[51].isEat()) {
				Piece[51].possibleMovements(Piece, Piece[51],Buttons);
				 
			}
		});
		Buttons[52].setOnMouseClicked((e)->{
        	
			if(Piece[52].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[52].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[52], Images,Buttons);
				 
			}else if(!Piece[52].isEat()) {
				Piece[52].possibleMovements(Piece, Piece[52],Buttons);
				 
			}
		});
		Buttons[53].setOnMouseClicked((e)->{
        	
			if(Piece[53].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[53].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[53], Images,Buttons);
				 
			}else if(!Piece[53].isEat()) {
				Piece[53].possibleMovements(Piece, Piece[53],Buttons);
				 
			}
		});
		Buttons[54].setOnMouseClicked((e)->{
	        	
			if(Piece[54].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[54].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[54], Images,Buttons);
				 
			}else if(!Piece[54].isEat()) {
				Piece[54].possibleMovements(Piece, Piece[54],Buttons);
				 
			}
		});
		Buttons[55].setOnMouseClicked((e)->{
        	
			if(Piece[55].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[55].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[55], Images,Buttons);
				 
			}else if(!Piece[55].isEat()) {
				Piece[55].possibleMovements(Piece, Piece[55],Buttons);
				 
			}
		});
		Buttons[56].setOnMouseClicked((e)->{
        	
			if(Piece[56].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[56].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[56], Images,Buttons);
				 
			}else if(!Piece[56].isEat()) {
				Piece[56].possibleMovements(Piece, Piece[56],Buttons);
				 
			}
		});
		Buttons[57].setOnMouseClicked((e)->{
        	
			if(Piece[57].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[57].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[57], Images,Buttons);
				 
			}else if(!Piece[57].isEat()) {
				Piece[57].possibleMovements(Piece, Piece[57],Buttons);
				 
			}
		});
		Buttons[58].setOnMouseClicked((e)->{
        	
			if(Piece[58].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[58].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[58], Images,Buttons);
				 
			}else if(!Piece[58].isEat()) {
				Piece[58].possibleMovements(Piece, Piece[58],Buttons);
				 
			}
		});
		Buttons[59].setOnMouseClicked((e)->{
        	
			if(Piece[59].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[59].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[59], Images,Buttons);
				 
			}else if(!Piece[59].isEat()) {
				Piece[59].possibleMovements(Piece, Piece[59],Buttons);
				 
			}
		});
		Buttons[60].setOnMouseClicked((e)->{
        	
			if(Piece[60].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[60].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[60], Images,Buttons);
				 
			}else if(!Piece[60].isEat()) {
				Piece[60].possibleMovements(Piece, Piece[60],Buttons);
				 
			}
		});
		Buttons[61].setOnMouseClicked((e)->{
        	
			if(Piece[61].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[61].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[61], Images,Buttons);
				 
			}else if(!Piece[61].isEat()) {
				Piece[61].possibleMovements(Piece, Piece[61],Buttons);
				 
			}
		});
		Buttons[62].setOnMouseClicked((e)->{
        	
			if(Piece[62].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[62].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[62], Images,Buttons);
				 
			}else if(!Piece[62].isEat()) {
				Piece[62].possibleMovements(Piece, Piece[62],Buttons);
				 
			}
		});
		Buttons[63].setOnMouseClicked((e)->{
        	
			if(Piece[63].isEat()) {
				Pieces EaterPiece=null;
				EaterPiece=Piece[63].ReturSavedPiece();
				EaterPiece.changePieces(Piece,EaterPiece,Piece[63], Images,Buttons);
				 
			}else if(!Piece[63].isEat()) {
				Piece[63].possibleMovements(Piece, Piece[63],Buttons);
				 
			}
		});
		
}
	
	
	public static void setImages() {
		for(int i=0;i<BOARD_TILES;i++) {
			


		
			if(Piece[i].getType().equals(Type.Pawn)&&Piece[i].getColor()=="WHITE") {
				Image White_Pawn =new Image("Chees_Images/White_Pawn.JPG");
				Images[i].setImage(White_Pawn);
				Buttons[i].setDisable(false);
			}else if(Piece[i].getType().equals(Type.Pawn)&&Piece[i].getColor()=="BLACK") {
				Image Black_Pawn =new Image("Chees_Images/Black_Pawn.JPG");
				Images[i].setImage(Black_Pawn);
				Buttons[i].setDisable(false);
			}else if(Piece[i].getType().equals(Type.Rook)&&Piece[i].getColor()=="WHITE") {
				Image White_Rook =new Image("Chees_Images/White_Rook.JPG");
				Images[i].setImage(White_Rook);
				Buttons[i].setDisable(false);
			}else if(Piece[i].getType().equals(Type.Rook)&&Piece[i].getColor()=="BLACK") {
				Image Black_Rook =new Image("Chees_Images/Black_Rook.JPG");
				Images[i].setImage(Black_Rook);
				Buttons[i].setDisable(false);
			}else if(Piece[i].getType().equals(Type.Bishop)&&Piece[i].getColor()=="WHITE") {
				Image White_Bishop =new Image("Chees_Images/White_Bishop.JPG");
				Images[i].setImage(White_Bishop);
				Buttons[i].setDisable(false);
			}else if(Piece[i].getType().equals(Type.Bishop)&&Piece[i].getColor()=="BLACK") {
				Image Black_Bishop =new Image("Chees_Images/Black_Bishop.JPG");
				Images[i].setImage(Black_Bishop);
				Buttons[i].setDisable(false);
			}else if(Piece[i].getType().equals(Type.Queen)&&Piece[i].getColor()=="WHITE") {
				Image White_Queen =new Image("Chees_Images/White_Queen.JPG");
				Images[i].setImage(White_Queen);
				Buttons[i].setDisable(false);
			}else if(Piece[i].getType().equals(Type.Queen)&&Piece[i].getColor()=="BLACK") {
				Image Black_Queen =new Image("Chees_Images/Black_Queen.JPG");
				Images[i].setImage(Black_Queen);
				Buttons[i].setDisable(false);
			}else if(Piece[i].getType().equals(Type.King)&&Piece[i].getColor()=="WHITE") {
				Image White_King =new Image("Chees_Images/White_King.JPG");
				Images[i].setImage(White_King);
				Buttons[i].setDisable(false);
			}else if(Piece[i].getType().equals(Type.King)&&Piece[i].getColor()=="BLACK") {
				Image Black_King =new Image("Chees_Images/Black_King.JPG");
				Images[i].setImage(Black_King);
				Buttons[i].setDisable(false);
			}else if(Piece[i].getType().equals(Type.Knight)&&Piece[i].getColor()=="WHITE") {
				Image White_Knight =new Image("Chees_Images/White_Knight.JPG");
				Images[i].setImage(White_Knight);
				Buttons[i].setDisable(false);
			}else if(Piece[i].getType().equals(Type.Knight)&&Piece[i].getColor()=="BLACK") {
				Image Black_Knight =new Image("Chees_Images/Black_Knight.JPG");
				Images[i].setImage(Black_Knight);
				Buttons[i].setDisable(false);
			}else {
				Image White = new Image("Chees_Images/White.JPG");
				Images[i].setImage(White);
			}			
		}
		
	}
	
public static void setup() {
		
		
		for(int i=16;i<=47;i++) {
				Pieces Blank = new Blank("BLANK",Pieces.Type.Blank,i,false);
				Piece[i]=Blank;
		}
		
		//Black Pieces
				Pieces B_1_Rook = new Rooks("BLACK",Pieces.Type.Rook,0,false);
				Piece[0]=B_1_Rook;
				Pieces B_1_Knight = new Knights("BLACK",Pieces.Type.Knight, 1,false);
				Piece[1]=B_1_Knight;
				Pieces B_1_Bishop = new Bishops("BLACK",Pieces.Type.Bishop, 2,false);
				Piece[2]=B_1_Bishop;
				Pieces B_1_Queen = new Queens("BLACK",Pieces.Type.Queen, 3,false);
				Piece[3]=B_1_Queen;
				Pieces B_1_King = new Kings("BLACK",Pieces.Type.King, 4,false);
				Piece[4]=B_1_King;
				Pieces B_2_Bishop = new Bishops("BLACK",Pieces.Type.Bishop, 5,false);
				Piece[5]=B_2_Bishop;
				Pieces B_2_Knight = new Knights("BLACK",Pieces.Type.Knight, 6,false);
				Piece[6]=B_2_Knight;
				Pieces B_2_Rook = new Rooks("BLACK",Pieces.Type.Rook, 7,false);
				Piece[7]=B_2_Rook;				
				Pieces B_1_Pawn = new Pawns("BLACK",Pieces.Type.Pawn,8,false,true);
				Piece[8]=B_1_Pawn;
				Pieces B_2_Pawn = new Pawns("BLACK",Pieces.Type.Pawn,9,false,true);
				Piece[9]=B_2_Pawn;
				Pieces B_3_Pawn = new Pawns("BLACK",Pieces.Type.Pawn,10,false,true);
				Piece[10]=B_3_Pawn;
				Pieces B_4_Pawn = new Pawns("BLACK",Pieces.Type.Pawn,11,false,true);
				Piece[11]=B_4_Pawn;
				Pieces B_5_Pawn = new Pawns("BLACK",Pieces.Type.Pawn,12,false,true);
				Piece[12]=B_5_Pawn;
				Pieces B_6_Pawn = new Pawns("BLACK",Pieces.Type.Pawn,13,false,true);
				Piece[13]=B_6_Pawn;
				Pieces B_7_Pawn = new Pawns("BLACK",Pieces.Type.Pawn,14,false,true);
				Piece[14]=B_7_Pawn;
				Pieces B_8_Pawn = new Pawns("BLACK",Pieces.Type.Pawn,15,false,true);
				Piece[15]=B_8_Pawn;
				
				//White Pieces
				Pieces W_1_Rook = new Rooks("WHITE",Pieces.Type.Rook, 56,false);
				Piece[56]=W_1_Rook;
				Pieces W_1_Knight = new Knights("WHITE",Pieces.Type.Knight, 57,false);
				Piece[57]=W_1_Knight;
				Pieces W_1_Wishop = new Bishops("WHITE",Pieces.Type.Bishop, 58,false);
				Piece[58]=W_1_Wishop;
				Pieces W_1_Queen = new Queens("WHITE",Pieces.Type.Queen, 59,false);
				Piece[59]=W_1_Queen;
				Pieces W_1_King = new Kings("WHITE",Pieces.Type.King, 60,false);
				Piece[60]=W_1_King;
				Pieces W_2_Wishop = new Bishops("WHITE",Pieces.Type.Bishop, 61,false);
				Piece[61]=W_2_Wishop;
				Pieces W_2_Rook = new Rooks("WHITE",Pieces.Type.Rook, 63,false);
				Piece[63]=W_2_Rook;
				Pieces W_2_Knight = new Knights("WHITE",Pieces.Type.Knight, 62,false);
				Piece[62]=W_2_Knight;
				Pieces W_1_Pawn = new Pawns("WHITE",Pieces.Type.Pawn,48,false,true);
				Piece[48]=W_1_Pawn;	
				Pieces W_2_Pawn = new Pawns("WHITE",Pieces.Type.Pawn,49,false,true);
				Piece[49]=W_2_Pawn;
				Pieces W_3_Pawn = new Pawns("WHITE",Pieces.Type.Pawn,50,false,true);
				Piece[50]=W_3_Pawn;
				Pieces W_4_Pawn = new Pawns("WHITE",Pieces.Type.Pawn,51,false,true);
				Piece[51]=W_4_Pawn;
				Pieces W_5_Pawn = new Pawns("WHITE",Pieces.Type.Pawn,52,false,true);
				Piece[52]=W_5_Pawn;
				Pieces W_6_Pawn = new Pawns("WHITE",Pieces.Type.Pawn,53,false,true);
				Piece[53]=W_6_Pawn;
				Pieces W_7_Pawn = new Pawns("WHITE",Pieces.Type.Pawn,54,false,true);
				Piece[54]=W_7_Pawn;
				Pieces W_8_Pawn = new Pawns("WHITE",Pieces.Type.Pawn,55,false,true);
				Piece[55]=W_8_Pawn;
				
				
	}
	
public static Pieces returnerWanted() {
	
	return typeWanted;
}

}
