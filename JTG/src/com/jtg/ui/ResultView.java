package com.jtg.ui;

import com.jdm.meta.ID;
import com.jdm.meta.Layout;
import com.jdm.meta.Styles;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

@SuppressWarnings("unused")
public class ResultView extends BorderPane {

	@ID("result-container")
    @Styles(
        background_color = "#ffffff",
        border_color = "#2ecc71",
        border_radius = "10",
        padding = "20",
        spacing = "15"
    )
    @Layout(region = "center")
    VBox content = new VBox() {

        @Styles(
        	font_size = "22",
        	font_weight = "bold",
        	text_fill = "#27ae60"
        )
        Label lblStatus = new Label("Busca Concluída!");

        @ID("data-grid")
        @Styles(
            spacing = "10",
            padding = "10",
            background_color = "#f4fbf7",
            border_radius = "5"
        )
        @Styles(
        	target = "Label",
        	font_size = "14",
        	font_family = "Monospaced"
        )
        HBox data_grid = new HBox() {

        	VBox content_algoA = new VBox( 5 ) {

        		@Styles(
                    spacing = "10",
                    padding = "10"
                )
        		VBox header = new VBox() {
	        		Label name = new Label("GULOSO");
	        		Label l1 = new Label("Caminho Total: 152.4 units");
	        		Label l2 = new Label("Nós Explorados: 42");
	        		Label l3 = new Label("Tempo Decorrido: 124ms");
        		};

        		@Styles( pref_height = "150" )
                ListView<String> pathDetails = new ListView<String>(
            		FXCollections.observableArrayList(
            			"Origem: A",
            			"Passagem: B",
            			"Passagem: F",
            			"Destino: G",
            			"Origem: A",
            			"Passagem: B",
            			"Passagem: F",
            			"Destino: G"
            		)
                );

            };

            VBox content_algoB = new VBox() {

            	@Styles(
                    spacing = "10",
                    padding = "10"
                )
            	VBox header = new VBox() {
	        		Label name = new Label("AESTRELA");
	        		Label l1 = new Label("Caminho Total: 152.4 units");
	        		Label l2 = new Label("Nós Explorados: 42");
	        		Label l3 = new Label("Tempo Decorrido: 124ms");
        		};

        		@Styles( pref_height = "150" )
                ListView<String> pathDetails = new ListView<String>(
            		FXCollections.observableArrayList(
            			"Origem: A",
            			"Passagem: B",
            			"Passagem: F",
            			"Destino: G"
            		)
                );

            };

            {
            	setHgrow(content_algoA, Priority.ALWAYS);
            	setHgrow(content_algoB, Priority.ALWAYS);
            }
        };

        @ID("btn-action")
        @Styles(
            background_color = "#34495e",
            text_fill = "white",
            cursor = "hand"
        )
        @Styles(
        	state = "hover",
        	background_color = "#2c3e50"
        )
        Button btnBack = new Button("Nova Busca");

        {
            setAlignment(Pos.TOP_CENTER);
            btnBack.setMaxWidth(Double.MAX_VALUE);
        }
    };

}
