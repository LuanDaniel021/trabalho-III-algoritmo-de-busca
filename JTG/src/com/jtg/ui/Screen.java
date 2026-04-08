package com.jtg.ui;

import com.jdm.meta.ID;
import com.jdm.meta.Layout;
import com.jdm.meta.Styles;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

@SuppressWarnings("unused")
public class Screen {

	BorderPane root = new BorderPane() {

		@Styles(
			alignment = "center",
			border_color = "#000",
			border_radius = "5%"
		)
		@Layout( region = "center" )
		HBox hcenter = new HBox() {
			@Styles( alignment = "center" )
			VBox vcenter = new VBox() {

				@Styles(
					target="Circle",
					state="hover",
					cursor="hand"
				)
				@Styles( target="Circle", fill = "red" )
				@Styles( target ="Line", stroke = "black" )
				Pane pane = new Pane() {
	
					// ----- LINHAS (arestas) -----
			        Line l1 = new Line(0, 0, 20, 20); // c1 -> c2
			        Line l2 = new Line(20, 20, 40, 10); // c2 -> c3
			        Line l3 = new Line(40, 10, 60, 30); // c3 -> c4
			        Line l4 = new Line(20, 20, 20, 50); // c2 -> c5
			        Line l5 = new Line(20, 50, 60, 30); // c5 -> c4

			        // ----- CIDADES (pontos) -----
			        Circle c1 = new Circle(0, 0, 4); // cidade 1
			        Circle c2 = new Circle(20, 20, 4); // cidade 2
			        Circle c3 = new Circle(40, 10, 4); // cidade 3
			        Circle c4 = new Circle(60, 30, 4); // cidade 4
			        Circle c5 = new Circle(20, 50, 4); // cidade 5

				};

			};
		};
		
		@Styles(
			background_color = "#f4f4f4",
			border_color = "#000",
			border_radius = "10%",
			padding = "25"
		)
		@Layout( region = "right" )
		BorderPane control = new BorderPane() {
			
			@Styles(
				font_size = "18",
				font_weight = "bold"
			)
			@Layout( region = "top" )
			Label title = new Label("Algorithm");

			@ID("grid")
			@Styles( spacing = "35" )
			@Styles(
				target = "Label",
				font_size = "13",
				font_weight = "bold"
			)
			@Styles(
				target = "TextField",
				font_size = "15"
			)
			@Layout( region = "center" )
			VBox grid = new VBox() {

				VBox box_of_destination = new VBox() {

					Label lbl = new Label( "Saida:" );

					@ID("of-destination")
					ComboBox<String> box = new ComboBox<>(
						FXCollections.observableArrayList(
							"OP-1",
							"OP-2",
							"OP-3",
							"OP-4",
							"OP-5"
						)
					);
					
					{ box.setValue( box.getItems().get(0) ); }

				};
				
				VBox box_to_destination = new VBox() {

					Label lbl = new Label( "Destino:" );
					
					@ID("to-destination")
					ComboBox<String> box = new ComboBox<>(
						FXCollections.observableArrayList(
							"OP-1",
							"OP-2",
							"OP-3",
							"OP-4",
							"OP-5"
						)
					);
					
					{ box.setValue( box.getItems().get(0) ); }

				};

			};

			@ID("start")
			@Styles( alignment = "center" )
			@Styles(
				state = "hover",
				cursor = "hand"
			)
			@Layout( region = "bottom" )
			Button btn = new Button("inicio");

			{
				setAlignment(title, Pos.CENTER);
				setAlignment(btn, Pos.CENTER);
				btn.setMaxWidth( Double.MAX_VALUE );
			}

		};

		{
			setMargin(hcenter, new Insets( 10, 10, 10, 10));
			setMargin(control, new Insets( 10, 10, 10, 10));
		}

	};

}
