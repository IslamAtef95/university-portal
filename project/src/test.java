/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author islam
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class test extends Application {

	
	TextField pwBox = new TextField();
	TextField userTextField = new TextField();
        static String [] u;

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		u = args;
		
		launch(args);
	}
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Welcome to Student Portal");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("Name:");
		grid.add(userName, 0, 1);

		Label pw = new Label("ID:");
		grid.add(pw, 0, 2);
		
		Button ok = new Button();
		ok.setText("LOGIN");
		ok.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
                try {
                        
					if (identify())
					{
						Student student = new Student(userTextField.getText(), Integer.valueOf(pwBox.getText()), GetGPA());
						student.open();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		grid.add(ok, 1, 3);
		grid.add(userTextField, 1, 1);
		grid.add(pwBox, 1, 2);
		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public boolean identify() throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("identify.txt"));
		String Line;
		while((Line= in.readLine())!=null)
		{
			if(Line.equals(userTextField.getText()))
			{
				Line = in.readLine();
				if(Line.equals(pwBox.getText()))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		return false;
	}
	
	public double GetGPA() throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("gpa.txt"));
		String Line;
		while((Line= in.readLine())!=null)
		{
			if(Line.equals(userTextField.getText()))
			{
				Line = in.readLine();
				return Double.valueOf(Line);
			}
		}
		return 0;
		
	}


}

