package application;
	


import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,400,400, Color.GRAY);
			
			//Czerwona Linia
			Line redLine = new Line(10, 10, 200,10);
			redLine.setStroke(Color.RED);
			redLine.setStrokeWidth(10);
			redLine.setStrokeLineCap(StrokeLineCap.ROUND);
			root.getChildren().add(redLine);
			
			//Linia niebieska przerywana
			Line blueLine = new Line(10, 40, 200, 40);
			blueLine.setStroke(Color.BLUE);
			blueLine.setStrokeWidth(10);
			blueLine.setStrokeLineCap(StrokeLineCap.SQUARE);
			blueLine.getStrokeDashArray().addAll(40d,20d,20d,40d);
			blueLine.setStrokeDashOffset(0);
			root.getChildren().add(blueLine);
			
			// Suwak sterujący StrokeDashOffset
			Slider slider = new Slider(0d,80d,45d); // (wart. min, wart. max, wart. bieżąca)
			slider.setLayoutX(10);
			slider.setLayoutY(60);
			slider.setOrientation(Orientation.HORIZONTAL);
			slider.setRotate(180);
			blueLine.strokeDashOffsetProperty().bind(slider.valueProperty());
			root.getChildren().add(slider);
			
			//CubicCurve
			CubicCurve cubicCurve = new CubicCurve(
					50,75, 		// pkt startu
					80,-25,		// pkt kontrolny 1
					110,175, 	// pkt kont 2
					140,75		// pkt koncowy
					);
			cubicCurve.setStrokeWidth(3);
			cubicCurve.setTranslateX(150);
			cubicCurve.setTranslateY(100);
			cubicCurve.setStroke(Color.AQUA);
			cubicCurve.setFill(Color.TRANSPARENT);
			root.getChildren().add(cubicCurve);
			
			// Rysowanie po ścieżce
			Path path = new Path();
			path.setStrokeWidth(5);
			MoveTo moveTo = new MoveTo(50,150);
			QuadCurveTo quadCurveTo = new QuadCurveTo();
			quadCurveTo.setX(150);
			quadCurveTo.setY(150);
			quadCurveTo.setControlX(100);
			quadCurveTo.setControlY(50);
			LineTo lineTo1 = new LineTo(50,150);
			LineTo lineTo2 = new LineTo(100,275);
			LineTo lineTo3 = new LineTo(150,150);
			path.getElements().addAll(moveTo, quadCurveTo, lineTo1, lineTo2, lineTo3);
			
			root.getChildren().add(path);
			Slider slider1 = new Slider(-100,100,80);
			Slider slider2 = new Slider(-150,150,-25);
			slider1.setOrientation(Orientation.HORIZONTAL);
			slider2.setOrientation(Orientation.VERTICAL);
			slider1.setLayoutX(180);
			slider1.setLayoutY(100);
			slider2.setLayoutX(320);
			slider2.setLayoutY(110);
			root.getChildren().addAll(slider1, slider2);
			
			cubicCurve.controlX1Property().bind(slider1.valueProperty());
			cubicCurve.controlY1Property().bind(slider2.valueProperty());
			
			// Donut z dwóch elisp
			Ellipse bigEllipse = new Ellipse(
					100, 100, 	// środek
					50, 		// promien po X
					36 		// promien po Y
					);
			
			Ellipse smallEllipse = new Ellipse(
					100, 100,
					17,
					12
					);
			
			Shape donut = Path.subtract(bigEllipse, smallEllipse);
			donut.setFill(Color.rgb(255, 200, 0));
			donut.setStroke(Color.BLACK);
			donut.setStrokeWidth(2);
			donut.setTranslateX(160);
			donut.setTranslateY(210);
			root.getChildren().add(donut);
			
			// efekt Cienia
			DropShadow dropShadow = new DropShadow(
					5,	// rozmycie krawędzi cienia
					12,	// przesunięcie po osiX
					12,	// przesunienie po osiY
					Color.rgb(100, 100, 100)
					);
			
			donut.setEffect(dropShadow);
			
			// wypełnienie
			Rectangle roundRect = new Rectangle(250,250,100,70);
			roundRect.setArcHeight(20);
			roundRect.setArcWidth(20);
			root.getChildren().add(roundRect);
			
			LinearGradient lgradient = new LinearGradient(0.25, 0.25,
					0.75, 0.75,
					true,
					CycleMethod.NO_CYCLE,
					new Stop(0, Color.RED),
					new Stop(1, Color.BLUE),
					new Stop(0.3, Color.AQUA),
					new Stop(0.7, Color.GOLD)
					);
			roundRect.setFill(lgradient);
			
			// gradient radialny
			Ellipse ellipse1 = new Ellipse(100,300,70,70);
			
			RadialGradient rgradient = new RadialGradient(
					0, 0,		//focus konta
					0.5, 0.5,	// punkt
					0.4,		// promien
					true,		// proportional
					CycleMethod.NO_CYCLE,
					new Stop(0, Color.RED),
					new Stop(1, Color.BLACK)
					);
			ellipse1.setFill(rgradient);
 			root.getChildren().add(ellipse1);
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
