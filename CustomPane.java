package project2;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class CustomPane extends HBox
{
    private VBox subPane;
    private final Colors []colors = Colors.values();
    
    public CustomPane(String name, double[] values, String[] labels)
    {
        subPane = new VBox(10);
        this.preparePane(name, values, labels);
    }
    
    public CustomPane(boolean ordered, String name, double[] values, String[] labels)
    {
        subPane = new VBox(10);
        this.preparePane(true, name, values, labels);
    }
    
    public void preparePane(String name, double[] values, String[] labels)
    {
        //TODO Complete this method as required in the Project instructions
		Insets in = new Insets(10);
		GridPane gridPane = new GridPane();
		gridPane.setStyle("-fx-padding: 20 20 0 20;"); //top right bottom left
		subPane.setStyle("-fx-padding: 20 0 20 0;"); //top right bottom left
		
		for(int i = 0; i < values.length; i++) {
			StackPane stackPane = new StackPane();
			stackPane.setPadding(in);
			Text textSubject = new Text(labels[i]);
			textSubject.setFont(Font.font(null, FontWeight.BOLD, 14));
			textSubject.setRotate(-90);
			Rectangle rec = new Rectangle(32,values[i]);
			rec.setArcHeight(15); 
			rec.setArcWidth(15); 
			Color rColor = Color.valueOf(colors[i] + "");
			rec.setFill(rColor);
			stackPane.getChildren().addAll(rec,textSubject);
			stackPane.setStyle("-fx-padding: 10 0 0 0;"); //top right bottom left

		    VBox vBox = new VBox(5); 
		    vBox.setAlignment(Pos.BOTTOM_CENTER);
			Text textValues = new Text(values[i] + "%");
			textValues.setFont(Font.font(null, FontWeight.BOLD, 12));
			textValues.setRotate(-75);
			vBox.getChildren().addAll(textValues,stackPane);
			
			gridPane.add(vBox,i,0);
			if(i == values.length - 1) { 
				Text textName = new Text(name + "");
				textName.setFont(Font.font(null, FontWeight.BOLD, 14));
				subPane.getChildren().addAll(gridPane,textName);
				subPane.setAlignment(Pos.TOP_CENTER);
			}
				
		}
        
        
    }
    
    public void preparePane(boolean ordered, String name, double[] values, String[] labels)
    {
        //TODO Complete this method as required in the Project instructions
		Insets in = new Insets(10);
		GridPane gridPane = new GridPane();
		gridPane.setStyle("-fx-padding: 20 20 0 20;"); //top right bottom left
		subPane.setStyle("-fx-padding: 20 0 20 0;"); //top right bottom left

		for(int i = 0; i < values.length; i++) { //sort and change the datas.
			for(int j = 0; j < values.length; j++) {
				if(values[i] > values [j]) {
					double tempValues = values[i];
					values[i] = values[j];
					values[j] = tempValues;
					String tempLabels = labels[i];
					labels[i] = labels[j];
					labels[j] = tempLabels;
					Colors tempColors = colors[i];
					colors[i] = colors[j];
					colors[j] = tempColors;
				}
			}
		}
		
		for(int i = 0; i < values.length; i++) {
			StackPane stackPane = new StackPane();
			stackPane.setPadding(in);
			Text textSubject = new Text(labels[i]);
			textSubject.setFont(Font.font(null, FontWeight.BOLD, 14));
			textSubject.setRotate(-90);
			Rectangle rec = new Rectangle(32,values[i]);
			rec.setArcHeight(15); 
			rec.setArcWidth(15); 
			Color rColor = Color.valueOf(colors[i] + "");
			rec.setFill(rColor);
			stackPane.getChildren().addAll(rec,textSubject);
			stackPane.setStyle("-fx-padding: 10 0 0 0;"); //top right bottom left

		    VBox vBox = new VBox(5); 
		    vBox.setAlignment(Pos.BOTTOM_CENTER);
			Text textValues = new Text(values[i] + "%");
			textValues.setFont(Font.font(null, FontWeight.BOLD, 12));
			textValues.setRotate(-75);
			vBox.getChildren().addAll(textValues,stackPane);
			
			gridPane.add(vBox,i,0);
			if(i == values.length - 1) { 
				Text textName = new Text(name + "");
				textName.setFont(Font.font(null, FontWeight.BOLD, 14));
				subPane.getChildren().addAll(gridPane,textName);
				subPane.setAlignment(Pos.TOP_CENTER);
			}
				
		}
    }

    public VBox getSubPane()
    {
        return subPane;
    }
}
