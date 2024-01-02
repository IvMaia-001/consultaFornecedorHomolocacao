module fonecedorTeste {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.base;
	requires jdk.incubator.vector;
	
	exports gui;
	opens gui to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
	
	opens model.entities to javafx.base;
}
