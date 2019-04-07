//===================================================  
// Name       :  Emad Tirmizi
// SID        :  31400222
// Course     :  IT114 
// Section    :  
// Instructor :  Maura Deek
// T.A        :   
//===================================================  
//===================================================  
// Assignment # :  2
// Date         :  10/18/2018
//===================================================  
//===================================================  
// Description: This program will create create a 
// program that creates a GUI that allows the user to 
// design/build your own car. It displays the various 
// amenities, colors, brands, and models, you can 
// choose from and outputs the price added up. 
// The user should have the ability to choose from a
// various selection of car brands, models, colors, 
// and amenities. The program should tally up all
// these variables and display the costs and specs to 
//the customer, along with the customer name in the 
//display
//===================================================  

import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.ColumnConstraints;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;

//Create Main Class
public class Main extends Application{	
	//set variables
   Stage window;
   Scene scene;
  
   Label lb1;
   Label lb2;
   Label lb3;
   Label lb4;
   Label lb5;
   Label lb6;
   
   Button b1;
	Button b2;
	Button b3;
   
   ComboBox<String> comboBox1;
   ComboBox<String> comboBox2;
   ComboBox<String> comboBox3;
  
  //main method to launch
   public static void main(String[] args) {
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage) throws Exception{
      window = primaryStage;
      window.setTitle("Car Builder");
          
     //I used grid the get the layout I wanted
      GridPane grid = new GridPane();
		//The padding is to essentially set the margins for which my nodes won't go past
      grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(15);
      
      //label for Customer Name
      Label lb1 = new Label("Customer Name");
		GridPane.setConstraints(lb1, 0, 0);
      
      //label for Customer Name TextField
      TextField nameInput = new TextField();
      //I set a constraint as to how wide it should be because it was messing up the buttons look
      nameInput.setMaxWidth(200);
		GridPane.setConstraints(nameInput, 1, 0);
      
      //label for Car Make
      Label lb2 = new Label("Car Brand");
		GridPane.setConstraints(lb2, 0, 1);
		
      //label for Car Make combo box
      comboBox1 = new ComboBox<>();
      comboBox1.getItems().addAll("Cadillac $30,000", "Ford $13,000", "GM $15,000", "Honda $20,000", "Mercedes $45,000", "Nissan $14,000");
      GridPane.setConstraints(comboBox1, 1, 1);
      
      //label for Car Model
		Label lb3 = new Label("Car Model");
		GridPane.setConstraints(lb3, 0, 2);
		
      //label for Car Model combo box
      comboBox2 = new ComboBox<>();
      comboBox2.getItems().addAll("Convertible $14,250", "Coupe $12,000", "Hatchback $10,000", "Sedan $15,550", "SUV $25,750");
      GridPane.setConstraints(comboBox2, 1, 2);
      
      //label for Car Color
		Label lb4 = new Label("Car Color");
		GridPane.setConstraints(lb4, 0, 3);
		
      //label for Car Color combo box
      comboBox3 = new ComboBox<>();
      comboBox3.getItems().addAll("Black", "Blue", "Red", "Silver", "White");
      GridPane.setConstraints(comboBox3, 1, 3);

      //label for the check box Amenities Title
		Label lb5 = new Label("Amenities/Add-Ons");
		GridPane.setConstraints(lb5, 0, 4);
		 
      //label for Check Box 1
      CheckBox c1 = new CheckBox("Air Conditioned Seats $750");
		GridPane.setConstraints(c1, 1, 4);
      
      //label for Check Box 2
      CheckBox c2 = new CheckBox("Automatic Emergency Braking $5000");
		GridPane.setConstraints(c2, 2, 4);
      
      //label for Check Box 3
      CheckBox c3 = new CheckBox("Backup Camera $550");
		GridPane.setConstraints(c3, 1, 5);
      
      //label for Check Box 4
      CheckBox c4 = new CheckBox("Blue-Tooth Connectivity $550");
		GridPane.setConstraints(c4, 2, 5);
      
      //label for Check Box 5
      CheckBox c5 = new CheckBox("Heated Seats $750");
		GridPane.setConstraints(c5, 1, 6);
      
      //label for Check Box 6
      CheckBox c6 = new CheckBox("Keyless Entry $650");
		GridPane.setConstraints(c6, 2, 6);
      
      //label for Check Box 7
      CheckBox c7 = new CheckBox("Navigation System $1100");
		GridPane.setConstraints(c7, 1, 7);
      
      //label for Check Box 8
      CheckBox c8 = new CheckBox("Super Sound System $1,200");
      GridPane.setConstraints(c8, 2, 7);
      
      
      //label and text box for output 
		Label lb6 = new Label("Car Specs and Price");
		GridPane.setConstraints(lb6, 0, 8);
		
      TextArea Out = new TextArea();
      //I set a constraint as to how wide it should be because it was messing up the buttons look
      Out.setMaxWidth(300);
      GridPane.setConstraints(Out, 1, 8);
    
      //label for button1
      Button b1 = new Button("Close Program");
		GridPane.setConstraints(b1, 0, 9);
      //using lambda I shortened the expression to close when the button is pressed
      b1.setOnAction(e -> System.exit(0));
      
      //label for button2
      //Button 2 clears the programd so you can start a new build
		Button b2 = new Button("Clear");
      GridPane.setConstraints(b2, 1, 9);
      //This is my manual reset of all the fields
      b2.setOnAction(e -> {
         //set the nameInput box to an empty string
         nameInput.setText("");
         //set the comboBoxes to null to clear the selection
         comboBox1.setValue(null);
         comboBox2.setValue(null);
         comboBox3.setValue(null);
         //set all the checkboxes to false
         c1.setSelected(false);
         c2.setSelected(false);
         c3.setSelected(false);
         c4.setSelected(false);
         c5.setSelected(false);
         c6.setSelected(false);
         c7.setSelected(false);
         c8.setSelected(false);
         //set the Output TextArea to an empty string
         Out.setText("");
		});//end button action
      
		
      //label for button3
		Button b3 = new Button("Calculate Car costs");
		GridPane.setConstraints(b3, 2, 9);
      b3.setOnAction(e -> {
         //Create an empty string for the Out TextArea
         String output = "";
			//Cost is for when we add the values together
         int cost = 0;
			//First line takes the nameInput and puts it in output
         output = "Customer name : " + nameInput.getText()+"\n";
         //cmake takes the value from the CarMake Check Box and assigns it to cmake
         String brand= "" + comboBox1.getValue();
         //Takes the chosen car and adds the string to output and the adds the price to cost
         if(brand.equals("Cadillac $30,000")){
             output = output + "Car Brand and Price: Cadillac $30,000\n";
             cost = cost + 30000; 
         }//end if
         //Takes the chosen car and adds the string to output and the adds the price to cost
         else if(brand.equals("Ford $13,000")){
             output = output + "Car Brand and Price: Ford $13,000\n";
             cost = cost + 13000;
         }//end else if
         //Takes the chosen car and adds the string to output and the adds the price to cost
         else if(brand.equals("GM $15,000")){
             output = output + "Car Brand and Price: GM $15,000\n";
             cost = cost + 15000;
         }//end else if
         //Takes the chosen car and adds the string to output and the adds the price to cost
         else if(brand.equals("Honda $20,000")){
             output = output + "Car Brand and Price: Honda $20,000\n";
             cost = cost + 20000;
         }//end else if
         //Takes the chosen car and adds the string to output and the adds the price to cost
         else if(brand.equals("Mercedes $45,000")){
             output = output + "Car Brand and Price: Mercedes $45,000\n";
             cost = cost + 45000;
         }//end else if        
         //If no chosen car brand it defaults to Nissan and adds the string to output and the adds the price to cost
         else{
             output = output + "Car Brand and Price: Nissan $14,000\n";
             cost = cost + 14000;              
         }//end else
         //creates a String model to hold information about which car model was chosen
         String model= "" + comboBox2.getValue();
         
         //Takes the chosen model and adds the string to output and the adds the price to cost
         if(model.equals("Convertible $14,250")){
             output = output + "Model: Convertible $14,250\n";
             cost = cost + 14250;
         }//end if
         //Takes the chosen model and adds the string to output and the adds the price to cost
         else if(model.equals("Coupe $12,000")){
             output = output + "Model: Coupe $12,000\n";
             cost = cost + 12000;
         }//end else if              
         //Takes the chosen model and adds the string to output and the adds the price to cost
         else if(model.equals("Hatchback $10,000")){
             output = output + "Model: Hatchback $10,000\n";
             cost = cost + 10000;              
         }//end else if 
         //Takes the chosen model and adds the string to output and the adds the price to cost
         else if(model.equals("Sedan $15,550")){
             output = output + "Model: Sedan $15,550\n";
             cost = cost + 15550;
         }//end else if                   
         //If no chosen model it defaults to SUV and adds the string to output and the adds the price to cost
         else{
             output = output + "Model: SUV $25,750\n";
             cost = cost + 25750;             
         }//end else
         //Takes the chosen color and adds the string to output
         String color= "" + comboBox3.getValue();
         if(color.equals("Black")){
             output = output + "Car color: Black\n";
         }//end if
         //Takes the chosen color and adds the string to output
         else if(color.equals("Blue")){
             output = output + "Car color: Blue\n";
         }//end else if
         //Takes the chosen color and adds the string to output
         else if(color.equals("Red")){
             output = output + "Car color: Red\n";
         }//end else if
         //Takes the chosen color and adds the string to output
         else if(color.equals("Silver")){
             output = output +"Car color: Silver\n";
         }//end else if
         //If no chosen color it will default to white and add the string to output
         else{
            output = output + "Car color: White\n";
         }//end else
         //if the checkbox is selected the system will add the price to the cost and the output string   
         if(c1.isSelected()){
             output = output + "Added Amenities/Add-Ons: Air Conditioned Seats $750\n";
             cost = cost + 750;
         }//end if
          //if the checkbox is selected the system will add the price to the cost and the output string
			if(c2.isSelected()){
             output = output + "Added Amenities/Add-Ons: Automatic Emergency Braking $5000\n";
             cost = cost+5000;
         }//end if
          //if the checkbox is selected the system will add the price to the cost and the output string
         if(c3.isSelected()){
             output = output + "Added Amenities/Add-Ons: Backup Camera $550\n";
             cost = cost + 550;
         }//end if
          //if the checkbox is selected the system will add the price to the cost and the output string
			if(c4.isSelected()){
             output = output + "Added Amenities/Add-Ons: Blue-Tooth Connectivity $550\n";
             cost = cost + 50;
         }//end if
          //if the checkbox is selected the system will add the price to the cost and the output string
			if(c5.isSelected()){
             output = output + "Added Amenities/Add-Ons: Heated Seats $750\n";
             cost = cost + 750;
         }//end if
          //if the checkbox is selected the system will add the price to the cost and the output string
         if(c6.isSelected()){
             output = output + "Added Amenities/Add-Ons: Keyless Entry $650\n";
             cost = cost + 650;
         }//end if
          //if the checkbox is selected the system will add the price to the cost and the output string
	      if(c7.isSelected()){
             output = output + "Added Amenities/Add-Ons: Navigation System $1100\n";
             cost = cost + 1100;
         }//end if
          //if the checkbox is selected the system will add the price to the cost and the output string
         if(c8.isSelected()){
             output = output + "Added Amenities/Add-Ons: Super Sound System $1,200\n";
             cost=cost + 1200;
         }//end if
         //Adds the Total Cost to the Output string
         output = output + "The Total Price of the car will be: $" + cost;
         //places the output string in the Out TextArea
         Out.setText(output);
      });//end button action
		
      //combining them all together using getChildren
		grid.getChildren().addAll(nameInput, lb1, lb2, lb3, lb4, lb5, lb6, b1, b2,
      b3, comboBox1, comboBox2, comboBox3, Out, c1,c2,c3,c4,c5,c6,c7,c8);

      //set scene parameter to grid as the layout profile 
      scene = new Scene(grid, 800, 800);
      //set scene
      window.setScene(scene);
      //show display the stage
      window.show();
   }//end method
}//end class