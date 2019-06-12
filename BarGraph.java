package project2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class BarGraph extends Application
{
    HBox mainPane = new HBox(10);
    Scene scene = new Scene(mainPane);

    @Override
    public void start(Stage primaryStage)
    {
        setup();
        
        primaryStage.setTitle("Bars");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setup()
    {
    	String[][] allData = readData();
        mainPane.setStyle("-fx-padding: 10 10 10 10 ;");
		mainPane.setStyle("-fx-background-color: #C0C0C0;");

    	int count = 0;
    	String name = "";
    	double[] values = new double[allData[0].length];
    	String[] labels = new String[allData[0].length];
        for(int i = 0; i < allData.length; i++) {
        	if(count == 0) {    	
	        	name = "";
	        	values = new double[allData[i+1].length];
	        	labels = new String[allData[i+2].length];
        	}
        	for(int j = 0; j < allData[i].length; j++) {
	            	if(count == 0) {
	            		name += allData[i][j] + " ";
	            	}else if(count == 1) {
	            		values[j] = Double.valueOf(allData[i][j]);
	            	}else {
	            		labels[j] = allData[i][j];
	            		count = -1;
	            	}
            }
    		if(count == -1) {
        	CustomPane customPane = new CustomPane(true, name ,values, labels);
        	VBox vBox = customPane.getSubPane();
        	mainPane.getChildren().add(vBox);
        	}
    		count++;
        }
        

        
    }

    public static String[][] readData()
    {	//TODO Complete this method as required in the Project instructions
        String text = "";
		try {
			Scanner	scan = new Scanner(new File("src\\project2\\data.txt"));
			while(scan.hasNext()) {
				text += scan.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        String[] longText = text.split("\n");
        String[][] arr = new String[longText.length][];
        
        for(int i = 0; i < longText.length; i++) {
        	String[] temp = longText[i].split(" ");
    		arr[i] = new String[temp.length];
        	for(int j = 0; j < temp.length; j++) {
            	arr[i][j] = temp[j];
            }
        }
        
//        for(int i = 0; i < arr.length; i++) {
//        	for(int j = 0; j < arr[i].length; j++) {
//            	System.out.print(arr[i][j] + " ");
//            }
//        	System.out.println();
//        }
        
        return arr;
    }
    
    public static void main(String[] args)
    {
        Application.launch(args);
    }
    
}
