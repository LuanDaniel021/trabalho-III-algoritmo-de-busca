package com.jtg;

import java.util.HashSet;
import java.util.Set;

import com.jdm.Document;
import com.jtg.ui.Screen;
import com.jtg.util.Cidade;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public final class App extends Application {

	public static void main(String[] args) { launch(args); }

	ComboBox<String> combo;

	// ----- CIDADES (pontos) -----
	static Cidade[] cidades = {
	        new Cidade("Cidade - A",  0,  0),
	        new Cidade("Cidade - B", 20, 20),
	        new Cidade("Cidade - C", 40, 10),
	        new Cidade("Cidade - D", 60, 30),
	        new Cidade("Cidade - E", 20, 50),
	        new Cidade("Cidade - F", 80, 70), // cidade 6 :: teste
	};

	@Override
	public void start(Stage stage) throws Exception {
		Document doc = new Document( Screen.class, (p) -> { return new Scene(p, 800, 500 ); } );

		stage.setTitle( "App - Trabalho");

		stage.setScene( doc.getScene() );

		ObservableList<String> ob = FXCollections.observableArrayList();

		ComboBox<String> of = doc.getNodeById("of-destination");

		ComboBox<String> to = doc.getNodeById("to-destination");

		Set<String> ligadas = new HashSet<>();

		Pane pane = doc.getNodeById("pane");

		combo = of;

		of.setOnMouseClicked( e -> combo = of );

		to.setOnMouseClicked( e -> combo = to );

		cidades[0].adddAdjacentes( cidades[1] );

		cidades[1].adddAdjacentes( cidades[0], cidades[2], cidades[4] );

		cidades[2].adddAdjacentes( cidades[1], cidades[3] );

		cidades[3].adddAdjacentes( cidades[2], cidades[4] );

		cidades[4].adddAdjacentes( cidades[1], cidades[3] );

	    for ( Cidade cidade : cidades ) {

	        for ( Cidade a : cidade.adjacentes ) {

	            String key1 = cidade.name + "-" + a.name;

	            String key2 = a.name + "-" + cidade.name;

	            if ( ligadas.contains(key1) || ligadas.contains(key2) ) continue;

	            else {
	            	Line line = new Line( cidade.x, cidade.y, a.x, a.y );

		            pane.getChildren().add(line);

		            ligadas.add(key1);
	            }

	        }

	        Circle c = new Circle( cidade.x, cidade.y, 4 );

			Label l = new Label( cidade.name );

			ob.add( cidade.name );

			l.setLayoutX( cidade.x );

			l.setLayoutY( cidade.y );

			pane.getChildren().add( l );

			pane.getChildren().add( c );

			c.setOnMouseClicked(e -> combo.setValue( cidade.name ) );

			l.setOnMouseClicked(e -> combo.setValue( cidade.name ) );

	    }

		of.getItems().addAll( ob );
		to.getItems().addAll( ob );

		of.setValue( ob.get(0) );
		to.setValue( ob.get(0) );

		stage.show();
	}

}
