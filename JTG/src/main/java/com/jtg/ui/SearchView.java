package com.jtg.ui;

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

public class SearchView extends BorderPane {

	public Button btn_tab_A = new Button("  Mapa - Arad  ");
	public Button btn_tab_B = new Button("Mapa - Curitiba");
	public Pane content = new Pane();
	
	public ComboBox<String> origin = new ComboBox<String>();
	public ComboBox<String> target = new ComboBox<String>();
	public CheckBox pedagio = new CheckBox("Evitar pedagios");
	public CheckBox turismo = new CheckBox("Priorizar pontos turisticos");
	public Button btn_action = new Button("INICIAR BUSCA");

	{
		BorderPane viewport = new BorderPane();

		HBox hbox_1;
		VBox vbox_1;
		Label label_1;
		VBox vbox_2;
		Label label_2;

		BorderPane sidebar = new BorderPane();
        Label title;
        VBox settings;

        VBox actions;
        setCenter( viewport );
        viewport.setTop(
        	hbox_1 = new HBox(
			    btn_tab_A,
			    btn_tab_B
        	)
        );
        viewport.setCenter( content );

        setRight( sidebar );
        sidebar.setTop(
			title = new Label("Configuração de Busca")
		);
		sidebar.setCenter(
			settings = new VBox(
				vbox_1 = new VBox( 5,
					label_1 = new Label("PONTO DE ORIGEM"),
					origin
				),
				vbox_2 = new VBox(5,
					label_2 = new Label("PONTO DE DESTINO"),
					target 
				),
	        	pedagio,
	        	turismo
			)
		);
		sidebar.setBottom(
			actions = new VBox(
				btn_action
			)
		);

		hbox_1.setId("HBox-1");
		vbox_1.setId("VBox-1");
		vbox_2.setId("VBox-2");
		label_1.setId("Label-1");
		label_2.setId("Label-2");

		viewport.setId( "viewport" );
		btn_tab_A.setId("tab-arad");
		btn_tab_B.setId("tab-curitiba");
		content.setId("view-content");

		sidebar.setId( "sidebar" );
		title.setId("header");
		settings.setId("settings-grid");
		origin.setId("of-destination");
		target.setId("to-destination");
		pedagio.setId("pedagio-check-box");
		turismo.setId("turismo-check-box");
		actions.setId("action-area");
		btn_action.setId("btn-action");

		btn_action.setMaxWidth(Double.MAX_VALUE);
		setMargin(title, new Insets(0, 0, 20, 0));
        setAlignment(title, Pos.CENTER);
        setMargin(viewport, new Insets(15));
        setMargin(sidebar, new Insets(15, 15, 15, 0));
	}

}
