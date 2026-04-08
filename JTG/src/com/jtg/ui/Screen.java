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

				@ID("pane")
				@Styles(
					target="Circle, Label",
					state="hover",
					cursor="hand"
				)
				@Styles( target="Circle", fill = "red" )
				@Styles( target ="Line", stroke = "black" )
				Pane pane;

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
					ComboBox<String> box;

				};

				VBox box_to_destination = new VBox() {

					Label lbl = new Label( "Destino:" );

					@ID("to-destination")
					ComboBox<String> box;

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
