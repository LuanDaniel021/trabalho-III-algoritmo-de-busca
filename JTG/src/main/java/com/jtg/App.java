package com.jtg;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jtg.algorithm.AEstrela;
import com.jtg.algorithm.Adjacente;
import com.jtg.algorithm.BuscaGulosa;
import com.jtg.algorithm.Vertice;
import com.jtg.ui.ScreenView;
import com.jtg.util.Cidade;
import com.jtg.util.Content;
import com.jtg.util.Mapas;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public final class App extends Application {

	public static void main(String[] args) { launch(args); }

	ComboBox<String> origin;
	ComboBox<String> target;
	CheckBox pedagio;
	CheckBox turismo;
	Pane viewcontent;

	Content content;

	Scene scene;

	public void start(Stage stage) throws Exception {
		ScreenView view = new ScreenView();  

		stage.setWidth( 900 );

		stage.setResizable( false );

		stage.setTitle( "App - Trabalho" );

		scene = new Scene( view.search );
		viewcontent = view.search.content;
		pedagio = view.search.pedagio;
		turismo= view.search.turismo;
		origin = view.search.origin;
		target = view.search.target;
		
		scene.getStylesheets().add(
			getClass().getClassLoader().getResource("SearchView.css").toExternalForm()
		);
		
		target.getItems().add("Curitiba");
		target.setValue( "Curitiba" );
		
		stage.setScene( scene );

		view.search.btn_tab_A.setOnAction( e -> update( view ) );
		view.search.btn_tab_B.setOnAction( e -> update( view ) );

		view.search.btn_action.setOnAction( e -> {

			Adjacente.PEDAGIO = pedagio.isSelected();
			Adjacente.TURISMO = turismo.isSelected();

			BuscaGulosa gulosa = new BuscaGulosa( content.get( target.getValue() ).vertice );
			gulosa.buscar( content.get( origin.getValue() ).vertice );
			List<Vertice> caminhoA = gulosa.caminho;
			
			content.map.forEach( (k, value) -> value.vertice.visitado = false );
			
			AEstrela aestrela = new AEstrela( content.get( target.getValue() ).vertice );
			aestrela.buscar( content.get( origin.getValue() ).vertice );
			List<Adjacente> caminhoB = aestrela.caminho;
			
			content.map.forEach( (k, value) -> value.vertice.visitado = false );

			ObservableList<String> obA = view.result.pathDetails_A.getItems();

			obA.clear();
			
			caminhoA.remove( caminhoA.size() - 1 );

			obA.add( String.format("Origem: %s", origin.getValue()) );

			for ( Vertice v : caminhoA ) {
			
				obA.add( String.format("Passagem: %s", v.rotulo) );
			
			}
			
			obA.add( String.format("Destino: %s", target.getValue()) );

			ObservableList<String> obB = view.result.pathDetails_B.getItems();
			obB.clear();
			caminhoB.remove( caminhoB.size() - 1 );
			obB.add( String.format("Origem: %s", origin.getValue()) );
			for ( Adjacente a : caminhoB ) {
				obB.add( String.format("Passagem: %s", a.getVertice().rotulo) );
			}
			obB.add( String.format("Destino: %s", target.getValue()) );

			scene.setRoot( view.result );

			scene.getStylesheets().clear();

			scene.getStylesheets().add(
				getClass().getClassLoader().getResource("ResultView.css").toExternalForm()
			);
			
		});
		
		view.result.btn_action.setOnAction( e -> {
			scene.setRoot( view.search );

			scene.getStylesheets().clear();
			
			scene.getStylesheets().add(
				getClass().getClassLoader().getResource("SearchView.css").toExternalForm()
			);
			
			origin.requestFocus();
		});

		update( view );

		stage.show();
	}
	
	private void update( ScreenView view ) {

		String now = target.getValue().equals( "Curitiba" ) ? "Bucharest" : "Curitiba";

		ObservableList<String> of = origin.getItems();
		ObservableList<String> to = target.getItems();

		of.clear();
		to.clear();
		
		to.add(now);

		content = Mapas.get( now ).pack();
		
		viewcontent.getChildren().clear();

		Set<String> ligadas = new HashSet<>();
		int ofsetX = content.getOfsetX();
		int ofsetY = content.getOfsetY();
	    for ( Cidade cidade : content.getCidades() ) {

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

	            	view.search.content.getChildren().add(line);

		            ligadas.add(key1);
	            }

	        }

	        Circle c = new Circle( cidade.x + ofsetX, cidade.y + ofsetY, 4 );

			Label l = new Label( cidade.name );

			of.add( cidade.name );

			l.setLayoutX( (cidade.x + ofsetX));

			l.setLayoutY( (cidade.y + ofsetY) + 5);

			viewcontent.getChildren().add( l );

			viewcontent.getChildren().add( c );

			c.setOnMouseClicked(e -> origin.setValue( cidade.name ) );

			l.setOnMouseClicked(e -> origin.setValue( cidade.name ) );

	    }

	    target.setValue( now );

	    origin.setValue( of.get(0) );

	    origin.requestFocus();
	}

}
