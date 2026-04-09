package com.jtg;

import java.util.HashSet;
import java.util.Set;

import com.jdm.Document;
import com.jtg.ui.Screen;
import com.jtg.util.Cidade;
import com.jtg.util.Content;
import com.jtg.util.Mapas;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public final class App extends Application {

	//public static void main(String[] args) { launch(args); }

	static final int MAP_A = 0;
	static final int MAP_B = 1;

	String[] start = { "Arad", "Porto União" };

	String map;
	
	String of = start[ 0 ];

	String to = "Bucareste";
	
	ComboBox<String> of_ComboBox;
	ComboBox<String> to_ComboBox;
	Pane viewcontent;

	public void start(Stage stage) throws Exception {
		Document doc = new Document( Screen.class );

		stage.setTitle( "App - Trabalho");

		stage.setScene( doc.getScene() );

		doc.setPersists( "search_view" );

		of_ComboBox = doc.getNodeById("of-destination");
		to_ComboBox = doc.getNodeById("to-destination");
		viewcontent = doc.getNodeById( "view-content" );
		
		Button btn_switch_A = doc.getNodeById( "btn-switch-Arad/Bucareste" );
		btn_switch_A.setOnAction( e -> {
			if ( !to.equals( "Bucareste" ) ) {
				of = start[ 0 ];
				to = "Bucareste";
				update( doc );	
			}
		});
		
		Button btn_switch_B = doc.getNodeById( "btn-switch-User/Curitiba" );
		btn_switch_B.setOnAction( e -> {
			if ( !to.equals( "Curitiba" ) ) {
				of = start[ 1 ];
				to = "Curitiba";
				update( doc );
			}
		});

		Button btn_action = doc.getNodeById( "btn-action" );

		btn_action.setOnAction( e -> doc.swap( "result_view") );

		doc.on(Document.SWAP, "result_view", () -> {
			Button btn = doc.getNodeById( "btn-action" );
			btn.setOnAction( e -> {
				doc.swap( "search_view");
				of_ComboBox.requestFocus();
			});
		});

		stage.setWidth( 900 );

		stage.setResizable( false );

		update( doc );

		stage.show();
	}
	
	private void update(Document doc) {

		Content content = Mapas.get( to ).pack();

		Cidade[] cidades = content.getCidades();

		Set<String> ligadas = new HashSet<>();

		ObservableList<String> ob = of_ComboBox.getItems();

		ob.clear();

		viewcontent.getChildren().clear();

		int ofsetX = content.getOfsetX();
		int ofsetY = content.getOfsetY();

	    for ( Cidade cidade : cidades ) {

	        for ( Cidade a : cidade.adjacentes ) {

	            String key1 = cidade.name + "-" + a.name;

	            String key2 = a.name + "-" + cidade.name;

	            if ( ligadas.contains(key1) || ligadas.contains(key2) ) continue;

	            else {
	            	Line line = new Line( cidade.x + ofsetX, cidade.y + ofsetY, a.x  + ofsetX, a.y + ofsetY );

	            	viewcontent.getChildren().add(line);

		            ligadas.add(key1);
	            }

	        }

	        Circle c = new Circle( cidade.x + ofsetX, cidade.y + ofsetY, 4 );

			Label l = new Label( cidade.name );
			
			ob.add( cidade.name );

			l.setLayoutX( (cidade.x + ofsetX));

			l.setLayoutY( (cidade.y + ofsetY) + 5);

			viewcontent.getChildren().add( l );

			viewcontent.getChildren().add( c );

			c.setOnMouseClicked(e -> of_ComboBox.setValue( cidade.name ) );

			l.setOnMouseClicked(e -> of_ComboBox.setValue( cidade.name ) );

	    }
	    
	    ObservableList<String> ob_to = to_ComboBox.getItems();

	    ob_to.clear();
	    
	    ob_to.add( to );

		of_ComboBox.setValue( of );
		to_ComboBox.setValue( to );
		
		of_ComboBox.requestFocus();
		
	}

}
