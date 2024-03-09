package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TableColumn<Order, String> c1column;

    @FXML
    private TableColumn<Order, Integer> c2column;

    @FXML
    private TableView<Order> tableorders;

    @FXML
    private TextField textc1;

    @FXML
    private TextField textc2;

    //List
    List<Order> orderList = new ArrayList<>();

    //ConvertToObsList
    ObservableList<Order> obsList = FXCollections.observableList(orderList);

    @FXML
    public void onClickBtn(ActionEvent event) {
        //Get info from TFields
        String c1Value = textc1.getText();
        int c2ValueInt = Integer.parseInt(textc2.getText());

        //New Order
        Order getValuesOrder = new Order(c1Value, c2ValueInt);

        //Insert gVO in obsList
        obsList.add(getValuesOrder);

        //clear TFields
        textc1.clear();
        textc2.clear();

    }



    @Override
    public void initialize (URL url, ResourceBundle rb) {
        c1column.setCellValueFactory(new PropertyValueFactory<>("c1"));
        c2column.setCellValueFactory(new PropertyValueFactory<>("c2"));

        tableorders.setItems(obsList);
    }


    public void openWindowNewOrder(ActionEvent event) {
    }
}
