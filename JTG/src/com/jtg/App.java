package com.jtg;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jdm.Document;
import com.jtg.algorithm.AEstrela;
import com.jtg.algorithm.Adjacente;
import com.jtg.algorithm.BuscaGulosa;
import com.jtg.algorithm.Vertice;
import com.jtg.ui.ResultView;
import com.jtg.ui.SearchView;
import com.jtg.util.Cidade;
import com.jtg.util.Content;
import com.jtg.util.Mapas;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public final class App extends Application {

	public static void main(String[] args) { launch(args); }

	static class Screen {

		SearchView search_view;

		ResultView result_view;

	}

	static final int BUCHAREST = 0;
	static final int CURITIBA  = 1;

	String[] of = { "Arad", "Porto União" };

	String to = "Bucareste";

	String target;

	ComboBox<String> of_ComboBox;
	ComboBox<String> to_ComboBox;
	CheckBox pedagio;
	CheckBox turismo;
	Pane viewcontent;

	Content content;
	
	List<Vertice> caminhoA;
	List<Adjacente> caminhoB;

	public void start(Stage stage) throws Exception {
		Document doc = new Document( Screen.class );

		stage.setTitle( "App - Trabalho" );

		stage.setScene( doc.getScene() );

		doc.setPersists( "search_view" );

		pedagio = doc.getNodeById( "pedagio-check-box" );
		turismo = doc.getNodeById( "turismo-check-box" );
		of_ComboBox = doc.getNodeById("of-destination");
		to_ComboBox = doc.getNodeById("to-destination");

		viewcontent = doc.getNodeById( "view-content" );

		Button btn_switch_A = doc.getNodeById( "tab-arad" );
		btn_switch_A.setOnAction( e -> {
			of[ CURITIBA ] = of_ComboBox.getValue();
			to = "Bucareste";
			update( doc );
		});

		Button btn_switch_B = doc.getNodeById( "tab-curitiba" );
		btn_switch_B.setOnAction( e -> {
				of[ BUCHAREST ] = of_ComboBox.getValue();
				to = "Curitiba";
				update( doc );
		});

		Button btn_action = doc.getNodeById( "btn-action" );
		btn_action.setOnAction( e -> {

			Adjacente.PEDAGIO = pedagio.isSelected();
			Adjacente.TURISMO = turismo.isSelected();

			target =  to.equals( "Curitiba" ) ? "Curitiba" : "Bucharest";
			
			BuscaGulosa gulosa = new BuscaGulosa( content.get( target ).vertice );
			gulosa.buscar( content.get( of_ComboBox.getValue() ).vertice );
			caminhoA = gulosa.caminho;
			
			content.map.forEach( (k, value) -> value.vertice.visitado = false );
			
			AEstrela aestrela = new AEstrela( content.get( target ).vertice );
			aestrela.buscar( content.get( of_ComboBox.getValue() ).vertice );
			caminhoB = aestrela.caminho;
			
			content.map.forEach( (k, value) -> value.vertice.visitado = false );

			doc.swap( "result_view" );
		});

		doc.on(Document.SWAP, "result_view", () -> {
			
			ListView<String> pathA = doc.getNodeById( "gulosa-path" );
			ObservableList<String> obA = pathA.getItems();
			caminhoA.remove( caminhoA.size() - 1 );
			obA.add( String.format("Origem: %s", of_ComboBox.getValue()) );
			for ( Vertice v : caminhoA ) {
				obA.add( String.format("Passagem: %s", v.rotulo) );
			}
			obA.add( String.format("Destino: %s", to) );
			
			ListView<String> pathB = doc.getNodeById( "aestrela-path" );
			ObservableList<String> obB = pathB.getItems();
			caminhoB.remove( caminhoB.size() - 1 );
			obB.add( String.format("Origem: %s", of_ComboBox.getValue()) );
			for ( Adjacente a : caminhoB ) {
				obB.add( String.format("Passagem: %s", a.getVertice().rotulo) );
			}
			obB.add( String.format("Destino: %s", to) );
			
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

		content = Mapas.get( to ).pack();

		Cidade[] cidades = content.getCidades();

		Set<String> ligadas = new HashSet<>();

		ObservableList<String> ob = of_ComboBox.getItems();

		ob.clear();

		viewcontent.getChildren().clear();

		int ofsetX = content.getOfsetX();
		int ofsetY = content.getOfsetY();

	    for ( Cidade cidade : cidades ) {

	        for ( Adjacente a : cidade.vertice.adjacentes ) {

	            String key1 = cidade.name + "-" + a.getVertice().rotulo;

	            String key2 = a.getVertice().rotulo + "-" + cidade.name;

	            if ( ligadas.contains(key1) || ligadas.contains(key2) ) continue;
	            else {
	            	Cidade cidadeA = content.get( a.getVertice().rotulo );

	            	Line line = new Line(
	            		cidade.x + ofsetX,
	            		cidade.y + ofsetY,
	            		cidadeA.x  + ofsetX,
	            		cidadeA.y + ofsetY
	            	);

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

	    to_ComboBox.setValue( to );

		of_ComboBox.setValue( of[ to.equals( "Curitiba" ) ? CURITIBA : BUCHAREST ] );

		of_ComboBox.requestFocus();

	}

}
