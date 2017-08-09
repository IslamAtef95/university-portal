/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author islam
 */
import java.awt.Container;
import java.awt.TextField;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Student {
	private String name;
	private int ID;
	private Double GPA;
	
	LinkedList<String> Subjects ;
	public Student(String m, int ID, double gpa)
	{
		name = m;
		this.ID = ID;
		GPA = gpa;
	}
	public void open()
	{
		Stage primaryStage = new Stage();
		GridPane grid = new GridPane();
		grid.setStyle(
				 "-fx-border-color: red; -fx-background-color: black;"); 
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(100);
		grid.setVgap(10);
		grid.setPadding(new Insets(40, 40, 40, 40));
		Group circles = new Group();
		for (int i = 0; i < 1000; i++) {
		   Circle circle = new Circle(150, Color.web("white", 0.05));
		   circle.setStrokeType(StrokeType.OUTSIDE);
		   circle.setStroke(Color.web("white", 0.16));
		   circle.setStrokeWidth(18);
		   circle.setCenterX(7);
		   circle.setCenterY(7);
		   circles.getChildren().add(circle);
		}
		grid.add(circles,7 , 7);
		Group circles1 = new Group();
		for (int i = 0; i < 1000; i++) {
		   Circle circle = new Circle(150, Color.web("white", 0.05));
		   circle.setStrokeType(StrokeType.OUTSIDE);
		   circle.setStroke(Color.web("white", 0.16));
		   circle.setStrokeWidth(18);
		   circle.setCenterX(7);
		   circle.setCenterY(7);
		   circles1.getChildren().add(circle);
		}
		grid.add(circles1,6 , 7);
		Text m = new Text(name);
		m.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
		m.setFill(Color.RED);
		grid.add(m, 3, 0);
		Label x = new Label("ID: " + ID);
		x.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		grid.add(x, 6, 7);
		
		Label y = new Label("GPA: " + GPA);
		y.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		grid.add(y, 7, 7);
		Button trans = new Button();
		trans.setText("Transcript");
		trans.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
                Stage primaryStage = new Stage();
                GridPane grid = new GridPane();
        		grid.setAlignment(Pos.BASELINE_LEFT);
        		grid.setHgap(10);
        		grid.setVgap(10);
        		grid.setPadding(new Insets(25, 25, 25, 25));
        		transcript(primaryStage, grid);
            }
        });
		
		Button sem = new Button();
		sem.setText("Semester Subjects");
		sem.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
                Stage primaryStage1 = new Stage();
                GridPane grid1 = new GridPane();
        		grid1.setAlignment(Pos.BASELINE_LEFT);
        		grid1.setHgap(10);
        		grid1.setVgap(10);
        		grid1.setPadding(new Insets(25, 25, 25, 25));
        		semester(primaryStage1, grid1);
            }
        });
		
		Button reg = new Button();
		reg.setText("Register new subjects");
		reg.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
                btnReg();
            }
        });
		Button can = new Button();
		can.setText("Cancel Registration");
		can.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
                btnCan();
            }
        });
		grid.add(can, 0, 30, 2, 1);
		grid.add(reg, 0, 11, 2, 1);
		grid.add(trans, 0, 3, 2, 1);
		grid.add(sem, 0, 7, 2, 1);
		grid.backgroundProperty();
		Scene scene = new Scene(grid, 2200, 2000);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Student Portal");
                primaryStage.setMaximized(true);
		primaryStage.show();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Double getGPA() {
		return GPA;
	}

	public void setGPA(Double gPA) {
		GPA = gPA;
	}

	public void transcript(Stage primaryStage, GridPane grid)
	{
		try
		{
			read("transcript", primaryStage, grid);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
			
		
		
	}
	
	public void semester(Stage primaryStage, GridPane grid)
	{
		try
		{
			read("dat", primaryStage, grid);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	public void read(String m , Stage primaryStage, GridPane grid) throws Exception
	{
		int i=0;
		
		int count = 0;
		
		BufferedReader in = new BufferedReader(new FileReader(m+".txt"));
		String line;
		
		while ((line = in.readLine()) != null)
		{
			
			if (this.name.equals(line))
			{
				count ++;
			}
			else if (line.isEmpty() && count == 1)
			{
				break;
			}
			else if (count == 1)
			{
				
				Label x = new Label(line);
				grid.add(x, 0, i, 2, 1);
				i++;
			}
		}
		in.close();
		Text credit = new Text();
		credit.setText("Total number of credit hours: "+ (i*3));
		credit.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(credit, 70, 60);
		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
                primaryStage.setMaximized(true);
		primaryStage.show();
		
		
	}
	
	public void register(String m) 
	{
		String[] nnn;
		try
		{
			int sign = 0;
			int count = 0;
			BufferedReader in = new BufferedReader(new FileReader("dat.txt"));
			 
			while (in.readLine() != null)
			{
				count ++;
			}
			
			in.close();
			in = new BufferedReader(new FileReader("dat.txt"));
			nnn = new String[count+1];
			for (int i=0; i<nnn.length-1; i++)
			{
				nnn[i] = in.readLine();
				
			}
			nnn[nnn.length-1] = "";
			in.close();
		
		BufferedWriter n = new BufferedWriter(new FileWriter("dat.txt"));
		n.close();
		
		n= new BufferedWriter(new FileWriter("dat.txt"));
		
		
			
		for (int i=0; i<nnn.length; i++)
			{
				if (name.equals(nnn[i]))
				{
					n.write(name);
					n.newLine();
					sign = 1;
				}
				else if ((nnn[i].isEmpty()==true) && sign == 1)
				{
					
					n.write(m);
					n.newLine();
					n.newLine();
					sign++;
				}
				else
				{
					n.write(nnn[i]);
					n.newLine();
				}
			}
			n.close();
			
			
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void btnReg () 
	{
		Stage primaryStage = new Stage();
		GridPane grid1 = new GridPane();
		grid1.setAlignment(Pos.BASELINE_LEFT);
		grid1.setHgap(10);
		grid1.setVgap(10);
		grid1.setPadding(new Insets(25, 25, 25, 25));
		RadioButton n = new RadioButton();
		n.setText("Systems Programming");
		grid1.add(n, 0, 0);
		RadioButton j = new RadioButton();
		j.setText("Microprocessors");
		grid1.add(j, 0, 1);
		Scene scene = new Scene(grid1, 300, 275);
		primaryStage.setScene(scene);
		primaryStage.show();
		n.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
            	
                register(n.getText());
                primaryStage.close();
            }
        });
		
		j.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
            	
                register(j.getText());
                primaryStage.close();
            }
        });
		
	}
	public void btnCan()
	{
		String[] nnn;
		try
		{
			int sign = 0;
			int count = 0;
			BufferedReader in = new BufferedReader(new FileReader("dat.txt"));
			 
			while (in.readLine() != null)
			{
				count ++;
			}
			
			in.close();
			in = new BufferedReader(new FileReader("dat.txt"));
			nnn = new String[count+1];
			for (int i=0; i<nnn.length-1; i++)
			{
				nnn[i] = in.readLine();
				
			}
			nnn[nnn.length-1] = "";
			in.close();
		
		BufferedWriter n = new BufferedWriter(new FileWriter("dat.txt"));
		n.close();
		
		n= new BufferedWriter(new FileWriter("dat.txt"));
		
		
			
		for (int i=0; i<nnn.length; i++)
			{
				if (name.equals(nnn[i]))
				{
					sign = 1;
				}
				else if ((nnn[i].isEmpty()==true) && sign == 1)
				{
					sign = 0;
				}
				else
				{
					n.write(nnn[i]);
					n.newLine();
				}
			}
			n.close();
			JOptionPane.showMessageDialog(null, "Done");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
}



