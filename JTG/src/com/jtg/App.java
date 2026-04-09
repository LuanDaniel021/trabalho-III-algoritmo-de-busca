package com.jtg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.jdm.Document;
import com.jtg.ui.Screen;
import com.jtg.util.Cidade;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public final class App extends Application {

	public static void main(String[] args) { launch(args); }

	static int ofSetY = 500;

	static Cidade[] cidades = {
	    new Cidade("Arad",            91, ofSetY - 492),
	    new Cidade("Zerind",         108, ofSetY - 531),
	    new Cidade("Oradea",         131, ofSetY - 571),
	    new Cidade("Sibiu",          207, ofSetY - 457),
	    new Cidade("Timisoara",       94, ofSetY - 410),
	    new Cidade("Lugoj",          165, ofSetY - 379),
	    new Cidade("Mehadia",        168, ofSetY - 339),
	    new Cidade("Drobeta",        165, ofSetY - 299),
	    new Cidade("Craiova",        253, ofSetY - 288),
	    new Cidade("Rimnicu Vilcea", 233, ofSetY - 410),
	    new Cidade("Fagaras",        305, ofSetY - 449),
	    new Cidade("Pitesti",        320, ofSetY - 368),
	    new Cidade("Bucareste",      400, ofSetY - 327),
	    new Cidade("Giurgiu",        375, ofSetY - 270),
	    new Cidade("Urziceni",       456, ofSetY - 350),
	    new Cidade("Hirsova",        534, ofSetY - 350),
	    new Cidade("Eforie",         562, ofSetY - 293),
	    new Cidade("Vaslui",         509, ofSetY - 444),
	    new Cidade("Iasi",           473, ofSetY - 506),
	    new Cidade("Neamt",          406, ofSetY - 537)
	};

	Map<String, Cidade> map = new HashMap<>();

	ComboBox<String> combo;

	public void start2(Stage stage) throws Exception { // teste
		Document doc = new Document( Screen.class, (p) -> { return new Scene(p, 850, 500 ); } );

		stage.setTitle( "App - Trabalho");

		stage.setScene( doc.getScene() );
		
		stage.show();
	}
	
	int count = 0;
	
	public void start(Stage stage) throws Exception {
		Document doc = new Document( Screen.class, p -> { return new Scene( p, 850, 500 ); });

		stage.setTitle( "App - Trabalho");

		stage.setScene( doc.getScene() );

		doc.setPersists( "search_view" );

		ObservableList<String> ob = FXCollections.observableArrayList();

		ComboBox<String> of = doc.getNodeById("of-destination");

		ComboBox<String> to = doc.getNodeById("to-destination");

		Set<String> ligadas = new HashSet<>();

		Pane viewport = doc.getNodeById("viewport");

		of.setOnMouseClicked( e -> combo = of );

		to.setOnMouseClicked( e -> combo = to );

		combo = of;
		
		for (Cidade cidade : cidades) {
		    map.put(cidade.name, cidade);
		}

		adjacentes();

		int ofsetX = 65;
		int ofsetY = 150;

	    for ( Cidade cidade : cidades ) {

	        for ( Cidade a : cidade.adjacentes ) {

	            String key1 = cidade.name + "-" + a.name;

	            String key2 = a.name + "-" + cidade.name;

	            if ( ligadas.contains(key1) || ligadas.contains(key2) ) continue;

	            else {
	            	Line line = new Line( cidade.x - ofsetX, cidade.y + ofsetY, a.x  - ofsetX, a.y + ofsetY );

	            	viewport.getChildren().add(line);

		            ligadas.add(key1);
	            }

	        }

	        Circle c = new Circle( cidade.x - ofsetX, cidade.y + ofsetY, 4 );

			Label l = new Label( cidade.name );

			ob.add( cidade.name );

			l.setLayoutX( (cidade.x - ofsetX) + 5);

			l.setLayoutY( (cidade.y + ofsetY) + 5);

			viewport.getChildren().add( l );

			viewport.getChildren().add( c );

			c.setOnMouseClicked(e -> combo.setValue( cidade.name ) );

			l.setOnMouseClicked(e -> combo.setValue( cidade.name ) );

	    }

		of.getItems().addAll( ob );
		to.getItems().addAll( ob );

		of.setValue( ob.get(0) );
		to.setValue( ob.get(12) );

		Button start = doc.getNodeById( "btn-start" );
		
		start.setOnAction( e -> doc.swap( "result_view" ) );
			
		doc.on(Document.SWAP, "result_view", () -> {

			Button btn = doc.getNodeById( "btn-action" );

			btn.setOnAction( e -> doc.swap( "search_view" ) );

		});

		stage.setResizable( false );

		stage.show();
	}
	
	private void adjacentes() {
		cidade("Arad").adddAdjacentes(
			cidade("Zerind"),
			cidade("Sibiu"),
			cidade("Timisoara")
		);

		cidade("Zerind").adddAdjacentes(
			cidade("Arad"),
			cidade("Oradea")
		);

		cidade("Oradea").adddAdjacentes(
			cidade("Zerind"),
			cidade("Sibiu")
		);

		cidade("Sibiu").adddAdjacentes(
			cidade("Arad"),
			cidade("Oradea"),
			cidade("Fagaras"),
			cidade("Rimnicu Vilcea")
		);

		cidade("Timisoara").adddAdjacentes(
			cidade("Arad"),
			cidade("Lugoj")
		);

		cidade("Lugoj").adddAdjacentes(
			cidade("Timisoara"),
			cidade("Mehadia")
		);

		cidade("Mehadia").adddAdjacentes(
			cidade("Lugoj"),
			cidade("Drobeta")
		);

		cidade("Drobeta").adddAdjacentes(
			cidade("Mehadia"),
			cidade("Craiova")
		);

		cidade("Craiova").adddAdjacentes(
			cidade("Drobeta"),
			cidade("Rimnicu Vilcea"),
			cidade("Pitesti")
		);

		cidade("Rimnicu Vilcea").adddAdjacentes(
			cidade("Sibiu"),
			cidade("Craiova"),
			cidade("Pitesti")
		);

		cidade("Fagaras").adddAdjacentes(
			cidade("Sibiu"),
			cidade("Bucareste")
		);

		cidade("Pitesti").adddAdjacentes(
			cidade("Rimnicu Vilcea"),
			cidade("Craiova"),
			cidade("Bucareste")
		);

		cidade("Bucareste").adddAdjacentes(
			cidade("Fagaras"),
			cidade("Pitesti"),
			cidade("Giurgiu"),
			cidade("Urziceni")
		);

		cidade("Giurgiu").adddAdjacentes( cidade("Bucareste") );

		cidade("Urziceni").adddAdjacentes(
			cidade("Bucareste"),
			cidade("Hirsova"),
			cidade("Vaslui")
		);

		cidade("Hirsova").adddAdjacentes(
				cidade("Urziceni"),
				cidade("Eforie")
		);

		cidade("Eforie").adddAdjacentes( cidade("Hirsova") );

		cidade("Vaslui").adddAdjacentes(
				cidade("Urziceni"),
				cidade("Iasi")
		);

		cidade("Iasi").adddAdjacentes(
			cidade("Vaslui"),
			cidade("Neamt")
		);

		cidade("Neamt").adddAdjacentes( cidade("Iasi") );
	}

	Cidade cidade(String nome) {
	    return map.get(nome);
	}

}
