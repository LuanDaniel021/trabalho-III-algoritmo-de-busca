package com.jtg.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ResultView extends BorderPane {
	
	public Label name_A = new Label("GULOSO");
	public Label count_A = new Label("Nós Explorados: 42");
	public Label time_A = new Label("Tempo Decorrido: 124ms");
	public Label path_A = new Label("Caminho Total: 152.4 units");
	
	public ListView<String> pathDetails_A = new ListView<>();;
	
	public Label name_B = new Label("GULOSO");
	public Label count_B = new Label("Nós Explorados: 42");
	public Label time_B = new Label("Tempo Decorrido: 124ms");
	public Label path_B = new Label("Caminho Total: 152.4 units");

	public ListView<String> pathDetails_B = new ListView<>();
	
	public Button btn_action = new Button("Nova Busca");
	
	{
		HBox grid;
		VBox content;
		VBox result_A;
		VBox result_B;
		
		VBox vbox_2;
		VBox vbox_4;
		Label label_1;
		
		setCenter(
			content = new VBox(
				label_1 = new Label("Busca Concluída!"), 
    			grid = new HBox(
    				result_A = new VBox(
						vbox_2 = new VBox(
    						name_A,
    						count_A,
    						time_A,
    						path_A
    					),
    					pathDetails_A
    				),
    				result_B = new VBox(
						vbox_4 = new VBox(
    						name_B,
    						count_B,
    						time_B,
    						path_B
    					),
    					pathDetails_B
    				)
    			),
    			btn_action
    		)
		);

		HBox.setHgrow(result_A, Priority.ALWAYS);
        HBox.setHgrow(result_B, Priority.ALWAYS);

        vbox_2.setId("VBox-2");
        vbox_4.setId("VBox-4");
		label_1.setId("Label-1");
		
        content.setId("result-container");
        pathDetails_A.setId("gulosa-path");
        pathDetails_B.setId("aestrela-path");
        btn_action.setId("btn-action");
        grid.setId("data-grid");

        btn_action.setMaxWidth(Double.MAX_VALUE);
	}
   
}
