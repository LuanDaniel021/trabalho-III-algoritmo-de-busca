package com.jtg;

import com.jdm.Document;
import com.jtg.ui.Screen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public final class App extends Application {

	public static void main(String[] args) { launch(args); }

	ComboBox<String> combo;
	
	@Override
	public void start(Stage stage) throws Exception {
		Document doc = new Document( Screen.class, (p) -> { return new Scene(p, 800, 500 ); } );

		stage.setTitle( "App - Trabalho");

		stage.setScene( doc.getScene() );

		ComboBox<String> of = doc.getNodeById("of-destination");

		ComboBox<String> to = doc.getNodeById("to-destination");

		combo = of;

		of.setOnMouseClicked( e -> combo = of );

		to.setOnMouseClicked( e -> combo = to );

		for ( int i = 0; i < 5; i++) {

			int count = i + 1; 

			Circle c = doc.getNodeById( "Circle-" + count ); 

			c.setOnMouseClicked(e -> combo.setValue("OP - " + count));
		}

		stage.show();
	}

}
