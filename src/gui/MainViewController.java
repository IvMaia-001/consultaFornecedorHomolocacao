package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dao.impl.ProductDaoSQL;
import model.entities.Product;

public class MainViewController implements Initializable{

	@FXML
	private TextField textCodProduct;
	
	@FXML
	private Button buttonSearch;
	
	@FXML
	private TableView<Product> tableView;
	
	@FXML
	private TableColumn<Product, String> columnDescProduct;
	
	@FXML
	private TableColumn<Product, String> columnDescManufacturer;
	
	
	private ProductDaoSQL productDao;
	
	public MainViewController() {
	}
	
	@SuppressWarnings("exports")
	public void setProductDao(ProductDaoSQL productDao) {
		this.productDao = productDao;
	}
	
	@SuppressWarnings("exports")
	public MainViewController(ProductDaoSQL productDao) {
		this.productDao = productDao;
	}
	
	@FXML
	void onButtonSearch(ActionEvent ecent) {
		try {
			Long codProduct = Long.valueOf(textCodProduct.getText());
			Product product = productDao.findByProduct(codProduct);
			
			ObservableList<Product> products = FXCollections.observableArrayList();
			
			if(codProduct != null && product != null) {
				products.add(product);
				tableView.setItems(products);
			}else {
				System.out.println("Produto não encontrado ou não Cadastrado.");
			}
			
		}catch (NumberFormatException e) {
			System.out.println("Cogido Inválido.");
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		columnDescProduct.setCellValueFactory(new PropertyValueFactory<>("descProduct"));
		
		columnDescManufacturer.setCellValueFactory(new PropertyValueFactory<>("descManufacturer"));
		
	}
}
