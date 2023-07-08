package com.otumichael.dcit308individualproject;

import com.otumichael.dcit308individualproject.mapper.*;
import com.otumichael.dcit308individualproject.presenter.BillPresenter;
import com.otumichael.dcit308individualproject.presenter.GoodPresenter;
import com.otumichael.dcit308individualproject.presenter.IssuedGoodPresenter;
import com.otumichael.dcit308individualproject.presenter.VendorPresenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    // add view tab
    // add goods properties
    @FXML
    private TextField goodNameText;
    @FXML
    private TextField goodPriceText;
    @FXML
    private TextField goodQuantityText;
    @FXML
    private TextArea goodDescriptionText;
    @FXML
    private ChoiceBox<String> goodCategoryChoiceBox;
    @FXML
    private ChoiceBox<String> goodVendorChoiceBox;


    // view goods tab
    // view goods table's properties
    @FXML
    private Tab viewGoodsTab;
    @FXML
    private TableView<GoodPresenter> viewGoodsTable;
    @FXML
    private TableColumn<GoodPresenter, Integer> viewGoodsIdColumn;
    @FXML
    private TableColumn<GoodPresenter, String> viewGoodsNameColumn;
    @FXML
    private TableColumn<GoodPresenter, String> viewGoodsQuantityColumn;
    @FXML
    private TableColumn<GoodPresenter, String> viewGoodsPriceColumn;
    @FXML
    private TableColumn<GoodPresenter, String> viewGoodsCategoryColumn;
    @FXML
    private TableColumn<GoodPresenter, String> viewGoodsVendorColumn;
    @FXML
    private TableColumn<GoodPresenter, String> viewGoodsDescriptionColumn;


    // view bills tab
    // view bills table's properties
    @FXML
    private Tab viewBillsTab;
    @FXML
    private TableView<BillPresenter> viewBillsTable;
    @FXML
    private TableColumn<BillPresenter, Integer> viewBillsIdColumn;
    @FXML
    private TableColumn<BillPresenter, String> viewBillsNameColumn;
    @FXML
    private TableColumn<BillPresenter, Integer> viewBillsQuantityColumn;
    @FXML
    private TableColumn<BillPresenter, Integer> viewBillsPriceColumn;
    @FXML
    private TableColumn<BillPresenter, String> viewBillsCustomerColumn;
    @FXML
    private TableColumn<BillPresenter, String> viewBillsDateColumn;


    // view issued goods tab
    // view issued goods table's properties
    @FXML
    private Tab viewIssuedGoodsTab;
    @FXML
    private TableView<IssuedGoodPresenter> viewIssuedGoodsTable;
    @FXML
    private TableColumn<IssuedGoodPresenter, Integer> viewIssuedGoodsIdColumn;
    @FXML
    private TableColumn<IssuedGoodPresenter, String> viewIssuedGoodsNameColumn;
    @FXML
    private TableColumn<IssuedGoodPresenter, Integer> viewIssuedGoodsQuantityColumn;
    @FXML
    private TableColumn<IssuedGoodPresenter, String> viewIssuedGoodsCustomerColumn;
    @FXML
    private TableColumn<IssuedGoodPresenter, String> viewIssuedGoodsDateColumn;


    // view vendor tab
    // view vendor table's properties
    @FXML
    private Tab viewVendorsTab;
    @FXML
    private TableView<VendorPresenter> viewVendorsTable;
    @FXML
    private TableColumn<VendorPresenter, Integer> viewVendorsIdColumn;
    @FXML
    private TableColumn<VendorPresenter, String> viewVendorsNameColumn;
    @FXML
    private TableColumn<VendorPresenter, String> viewVendorsEmailColumn;


    // Observable lists
    ObservableList<GoodPresenter> goodsObservableList;
    ObservableList<BillPresenter> billObservableList;
    ObservableList<IssuedGoodPresenter> issuedGoodObservableList;
    ObservableList<VendorPresenter> vendorObservableList;


    Data data = new Data();


    @FXML
    protected void onAddGoodClearButtonClick(ActionEvent event) {
        System.out.println("Clear form");
        goodNameText.clear();
        goodPriceText.clear();
        goodQuantityText.clear();
        goodDescriptionText.clear();
        // goodCategoryChoiceBox.getSelectionModel().clearSelection();
        // goodVendorChoiceBox.getSelectionModel().clearSelection();
        goodCategoryChoiceBox.getSelectionModel().select(0);
        goodVendorChoiceBox.getSelectionModel().select(0);
    }

    @FXML
    protected void onAddGoodInsertButtonClick(ActionEvent event) {
        System.out.println("Insert form");
        String goodName = goodNameText.getText();
        String goodPrice = goodPriceText.getText();
        String goodQuantity = goodQuantityText.getText();
        String goodDescription = goodDescriptionText.getText();
        int goodCategoryIndex = goodCategoryChoiceBox.getSelectionModel().getSelectedIndex();
        int goodVendorIndex = goodVendorChoiceBox.getSelectionModel().getSelectedIndex();

        System.out.println("goodName: " + goodName);
        System.out.println("goodPrice: " + goodPrice);
        System.out.println("goodQuantity: " + goodQuantity);
        System.out.println("goodDescription: " + goodDescription);
        System.out.println(goodCategoryChoiceBox.getSelectionModel().getSelectedItem());
        System.out.println(goodVendorChoiceBox.getSelectionModel().getSelectedItem());

        int nextGoodId = data.getGoods().size() + 1;
        data.getGoods().add(new Good(nextGoodId,
                goodName,
                Integer.parseInt(goodPrice),
                Integer.parseInt(goodQuantity),
                data.getCategories().get(goodCategoryIndex),
                data.getVendors().get(goodVendorIndex),
                goodDescription));

        System.out.println(data.getGoods().toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // constants
        final int CATEGORY_SIZE = 11;
        final int VENDOR_SIZE = 3;

        // load data for presentation
        GoodPresenter[] goodPresenters = PresenterUtil.getPresentedGoods(data.getGoods().size(), data.getGoods());
        goodsObservableList = FXCollections.observableArrayList(goodPresenters);

        BillPresenter[] billPresenters = PresenterUtil.getPresentedBills(data.getBills().size(), data.getBills());
        billObservableList = FXCollections.observableArrayList(billPresenters);

        IssuedGoodPresenter[] issuedGoodPresenters = PresenterUtil.getPresentedIssuedGoods(data.getIssuedGoods().size(), data.getIssuedGoods());
        issuedGoodObservableList = FXCollections.observableArrayList(issuedGoodPresenters);

        VendorPresenter[] vendorPresenters = PresenterUtil.getPresentedVendors(data.getVendors().size(), data.getVendors());
        vendorObservableList = FXCollections.observableArrayList(vendorPresenters);

        // add good
        // get the values of the categories
        String[] categoryValues = new String[CATEGORY_SIZE];
        for (int i = 0; i < CATEGORY_SIZE; i++) {
            categoryValues[i] = data.getCategories().get(i).getName();
        }

        // get the values of the vendors
        String[] vendorValues = new String[VENDOR_SIZE];
        for (int i = 0; i < VENDOR_SIZE; i++) {
            vendorValues[i] = data.getVendors().get(i).getName();
        }

        // populate the category choice box and select the first category as default
        goodCategoryChoiceBox.getItems().addAll(categoryValues);
        goodCategoryChoiceBox.getSelectionModel().select(0);
        // goodCategoryChoiceBox.setOnAction();

        // populate the vendor choice box and select the first vendor as default
        goodVendorChoiceBox.getItems().addAll(vendorValues);
        goodVendorChoiceBox.getSelectionModel().select(0);
        // goodVendorChoiceBox.setOnAction();

        // view goods - populate the view groups table
        viewGoodsIdColumn.setCellValueFactory(new PropertyValueFactory<GoodPresenter, Integer>("id"));
        viewGoodsNameColumn.setCellValueFactory(new PropertyValueFactory<GoodPresenter, String>("name"));
        viewGoodsPriceColumn.setCellValueFactory(new PropertyValueFactory<GoodPresenter, String>("price"));
        viewGoodsQuantityColumn.setCellValueFactory(new PropertyValueFactory<GoodPresenter, String>("quantity"));
        viewGoodsCategoryColumn.setCellValueFactory((new PropertyValueFactory<GoodPresenter, String>("categoryName")));
        viewGoodsVendorColumn.setCellValueFactory((new PropertyValueFactory<GoodPresenter, String>("vendorName")));
        viewGoodsDescriptionColumn.setCellValueFactory(new PropertyValueFactory<GoodPresenter, String>("description"));
        viewGoodsTable.setItems(goodsObservableList);

        // view bills
        viewBillsIdColumn.setCellValueFactory(new PropertyValueFactory<BillPresenter, Integer>("id"));
        viewBillsNameColumn.setCellValueFactory(new PropertyValueFactory<BillPresenter, String>("name"));
        viewBillsQuantityColumn.setCellValueFactory(new PropertyValueFactory<BillPresenter, Integer>("quantity"));
        viewBillsPriceColumn.setCellValueFactory(new PropertyValueFactory<BillPresenter, Integer>("price"));
        viewBillsDateColumn.setCellValueFactory(new PropertyValueFactory<BillPresenter, String>("dateBilled"));
        viewBillsCustomerColumn.setCellValueFactory(new PropertyValueFactory<BillPresenter, String>("name"));
        viewBillsTable.setItems(billObservableList);

        // view issued goods
        viewIssuedGoodsIdColumn.setCellValueFactory(new PropertyValueFactory<IssuedGoodPresenter, Integer>("id"));
        viewIssuedGoodsNameColumn.setCellValueFactory(new PropertyValueFactory<IssuedGoodPresenter, String>("good.name"));
        viewIssuedGoodsQuantityColumn.setCellValueFactory(new PropertyValueFactory<IssuedGoodPresenter, Integer>("quantity"));
        viewIssuedGoodsCustomerColumn.setCellValueFactory(new PropertyValueFactory<IssuedGoodPresenter, String>("customer"));
        viewIssuedGoodsDateColumn.setCellValueFactory(new PropertyValueFactory<IssuedGoodPresenter, String>("dateBilled"));
        viewIssuedGoodsTable.setItems(issuedGoodObservableList);

        // view vendor
        viewVendorsIdColumn.setCellValueFactory(new PropertyValueFactory<VendorPresenter, Integer>("id"));
        viewVendorsNameColumn.setCellValueFactory(new PropertyValueFactory<VendorPresenter, String>("name"));
        viewVendorsEmailColumn.setCellValueFactory(new PropertyValueFactory<VendorPresenter, String>("email"));
        viewVendorsTable.setItems(vendorObservableList);
    }
}
