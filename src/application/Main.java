package application;
	

import java.sql.Connection;

import dbConection.DB;
import gui.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.dao.impl.ProductDaoSQL;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			Parent parant = loader.load();
			
			Scene mainScene = new Scene(parant);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("CONSULTA FORNECEDOR LE POSTICHE - 1.0");
			primaryStage.show();
			
			Connection conn = DB.getconnnectio();
			ProductDaoSQL productDao = new ProductDaoSQL(conn);
			
			MainViewController controller = loader.getController();
            controller.setProductDao(productDao);
			
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
}
