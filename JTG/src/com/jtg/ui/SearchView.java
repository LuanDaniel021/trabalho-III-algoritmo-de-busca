package com.jtg.ui;

import com.jdm.meta.ID;
import com.jdm.meta.Layout;
import com.jdm.meta.Styles;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

@SuppressWarnings("unused")
public class SearchView extends BorderPane {

	@ID("viewport")
	@Layout( region = "center" )
	BorderPane viewport = new BorderPane() {
		
		@Layout( region = "top" )
		HBox header = new HBox() {
			
			@ID( "btn-switch-Arad/Bucareste" )
			Button btn_switch_A = new Button("Arad - Bucareste");
			
			@ID( "btn-switch-User/Curitiba" )
			Button btn_switch_B = new Button("____ -  Curitiba");
		};

		@ID("view-content")
		@Styles(
	        background_color = "#ffffff",
	        border_color = "#dcdcdc",
	        border_radius = "8",
	        alignment = "center"
	    )
	    @Styles(
			target = "Circle",
			fill = "#3498db",
			stroke = "#2980b9"
		)
	    @Styles(
			target = "Line",
			stroke = "#bdc3c7",
			stroke_width = "2"
		)
	    @Styles(
			target = "Circle:hover",
			cursor = "hand",
			fill = "#e74c3c"
		)
		@Styles(
			target = "Label, CheckBox",
			font_weight = "bold"
		)
		@Layout( region = "center" )
	    Pane viewcontent = new Pane();
	};

    @ID( "sidebar" )
    @Styles(
        background_color = "#f9f9f9",
        border_color = "#bdc3c7",
        border_radius = "8",
        padding = "20",
        min_width = "250"
    )
    @Layout( region = "right" )
    BorderPane sidebar = new BorderPane() {

        @ID("header")
        @Styles(
        	font_size = "20",
        	font_weight = "bold",
        	text_fill = "#2c3e50"
        )
        @Layout( region = "top" )
        Label title = new Label("Configuração de Busca");

        @ID( "settings-grid" )
        @Styles( spacing = "20" )
        @Styles(
        	target = "Label, CheckBox",
        	font_size = "12",
        	text_fill = "#7f8c8d",
        	font_weight = "bold"
        )
        @Styles(
        	target = "ComboBox",
        	pref_width = "200"
        )
        @Layout( region = "center" )
        VBox settings = new VBox() {

        	VBox originGroup = new VBox(5) {

        		Label lbl = new Label("PONTO DE ORIGEM");

        		@ID( "of-destination" )
        		ComboBox<String> box;

        	};
            
        	VBox targetGroup = new VBox(5) {

        		Label lbl = new Label("PONTO DE DESTINO");

        		@ID( "to-destination" )
        		ComboBox<String> box;

        	};
        	
        	CheckBox pedagio = new CheckBox( "Evitar pedagios ");
        		
        	CheckBox turitico = new CheckBox( "Priorizar pontos turisticos" );

        };

        @ID( "action-area" )
        @Layout( region = "bottom" )
        VBox actions = new VBox() {
            
        	@ID( "btn-action" )
        	@Styles(
                background_color = "#2ecc71",
                text_fill = "white",
                font_weight = "bold",
                padding = "10 20",
                cursor = "hand"
            )
            @Styles(
        		state = "hover",
        		background_color = "#27ae60"
            )
            Button btnAction = new Button("INICIAR BUSCA");

            {
            	btnAction.setMaxWidth(Double.MAX_VALUE);
            }
        };

        {
            setMargin(title, new Insets(0, 0, 20, 0));
            setAlignment(title, Pos.CENTER);
        }
    };

    {
        setMargin(viewport, new Insets(15));
        setMargin(sidebar, new Insets(15, 15, 15, 0));
    }
}
