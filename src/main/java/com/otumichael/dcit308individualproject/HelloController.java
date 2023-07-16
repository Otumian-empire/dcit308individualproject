package com.otumichael.dcit308individualproject;

import com.otumichael.dcit308individualproject.db.repository.*;
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
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    // Observable lists
    ObservableList<GoodPresenter> goodsObservableList;
    ObservableList<BillPresenter> billObservableList;
    ObservableList<IssuedGoodPresenter> issuedGoodObservableList;
    ObservableList<VendorPresenter> vendorObservableList;
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

    // view sell goods tab (issue good)
    @FXML
    private Tab issueGoodTab;

    @FXML
    private ChoiceBox<String> issueGoodNameChoiceBox;

    @FXML
    private TextField issueGoodQuantityText;

    @FXML
    private ChoiceBox<String> issueGoodCustomerChoiceBox;

    @FXML
    protected void onAddGoodClearButtonClick(ActionEvent event) {
        clearAddGoodForm();
    }

    @FXML
    protected void onAddGoodInsertButtonClick(ActionEvent event) {
        try {
            System.out.println("Insert form");
            String goodName = goodNameText.getText();
            int goodPrice = Integer.parseInt(goodPriceText.getText());
            int goodQuantity = Integer.parseInt(goodQuantityText.getText());
            String goodDescription = goodDescriptionText.getText();
            String goodCategoryName = goodCategoryChoiceBox.getSelectionModel().getSelectedItem();
            String goodVendorName = goodVendorChoiceBox.getSelectionModel().getSelectedItem();

            GoodRepository goodRepository = new GoodRepository();
            goodRepository.insertGood(goodName, goodPrice, goodQuantity, goodCategoryName, goodVendorName, goodDescription);

            // display success alert
            displayAlert(Alert.AlertType.INFORMATION, "Success", "Good added", "");

            // clear form after the alert is closed
            clearAddGoodForm();

            // load the goods
            // view goods - populate the view groups table
            viewGoods();

        } catch (Exception e) {
            displayAlert(Alert.AlertType.WARNING, "Warning", "An error occurred", e.getMessage());
        }
    }

    @FXML
    void onIssueGoodClearButtonClick(ActionEvent event) {
        clearIssueGoodForm();
    }

    @FXML
    void onIssueGoodInsertButtonClick(ActionEvent event) {
        try {
            System.out.println("Insert issue good");
            String issueGoodName = issueGoodNameChoiceBox.getSelectionModel().getSelectedItem();
            int issueGoodQuantity = Integer.parseInt(issueGoodQuantityText.getText());
            String issueGoodCustomer = issueGoodCustomerChoiceBox.getSelectionModel().getSelectedItem();

            IssueGoodRepository issueGoodRepository = new IssueGoodRepository();
            issueGoodRepository.insertIssueGood(issueGoodName, issueGoodQuantity, issueGoodCustomer);

            // TODO: insert bill record


            // display success alert
            displayAlert(Alert.AlertType.INFORMATION, "Success", "Good issued successfully", "");

            // clear form after the alert is closed
            clearIssueGoodForm();

            // load the goods
            // view goods - populate the view groups table
            viewGoods();

            // TODO: reload view bills

            // reload view issued goods
            viewIssuedGoods();

        } catch (Exception e) {
            displayAlert(Alert.AlertType.WARNING, "Warning", "An error occurred", e.getMessage());
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            // load data for presentation

            // add good
            // get the values of the categories
            loadGoodCategoryAndVendorList();

            // view goods - populate the view groups table
            viewGoods();

            // view bills
            viewBills();

            // load the choice box
            loadIssueGoodQuantityAndCustomerList();

            // view issued goods
            viewIssuedGoods();

            // view vendor
            viewVendor();
        } catch (Exception e) {
            displayAlert(Alert.AlertType.WARNING, "Warning", "An error occurred", e.getMessage());
        }
    }

    public void loadIssueGoodQuantityAndCustomerList() throws Exception {
        GoodRepository goodRepository = new GoodRepository();
        List<Good> goodList = goodRepository.getGoods();

        final int GOOD_SIZE = goodList.size();
        String[] goodNameValues = new String[GOOD_SIZE];

        for (int i = 0; i < GOOD_SIZE; i++) {
            goodNameValues[i] = goodList.get(i).getName();
        }

        CustomerRepository customerRepository = new CustomerRepository();
        List<Customer> customerList = customerRepository.getCustomers();

        final int CUSTOMER_SIZE = customerList.size();
        String[] customerNameValues = new String[CUSTOMER_SIZE];

        for (int i = 0; i < CUSTOMER_SIZE; i++) {
            customerNameValues[i] = customerList.get(i).getName();
        }

        // populate the category choice box and select the first category as default
        issueGoodNameChoiceBox.getItems().addAll(goodNameValues);
        issueGoodNameChoiceBox.getSelectionModel().select(0);
        // goodCategoryChoiceBox.setOnAction();

        // populate the vendor choice box and select the first vendor as default
        issueGoodCustomerChoiceBox.getItems().addAll(customerNameValues);
        issueGoodCustomerChoiceBox.getSelectionModel().select(0);
        // goodVendorChoiceBox.setOnAction();
    }

    public void loadGoodCategoryAndVendorList() throws Exception {
        CategoryRepository categoryRepository = new CategoryRepository();
        List<Category> categoryList = categoryRepository.getCategories();

        VendorRepository vendorRepository = new VendorRepository();
        List<Vendor> vendorList = vendorRepository.getVendors();

        final int CATEGORY_SIZE = categoryList.size();
        String[] categoryValues = new String[CATEGORY_SIZE];

        final int VENDOR_SIZE = vendorList.size();
        String[] vendorValues = new String[VENDOR_SIZE];

        for (int i = 0; i < CATEGORY_SIZE; i++) {
            categoryValues[i] = categoryList.get(i).getName();
        }

        for (int i = 0; i < VENDOR_SIZE; i++) {
            vendorValues[i] = vendorList.get(i).getName();
        }

        // populate the category choice box and select the first category as default
        goodCategoryChoiceBox.getItems().addAll(categoryValues);
        goodCategoryChoiceBox.getSelectionModel().select(0);
        // goodCategoryChoiceBox.setOnAction();

        // populate the vendor choice box and select the first vendor as default
        goodVendorChoiceBox.getItems().addAll(vendorValues);
        goodVendorChoiceBox.getSelectionModel().select(0);
        // goodVendorChoiceBox.setOnAction();
    }

    private void viewGoods() throws Exception {
        GoodRepository goodRepository = new GoodRepository();
        List<Good> goodArrayList = goodRepository.getGoods();
        GoodPresenter[] goodPresenters = PresenterUtil.getPresentedGoods(goodArrayList.size(), goodArrayList);
        goodsObservableList = FXCollections.observableArrayList(goodPresenters);

        viewGoodsIdColumn.setCellValueFactory(new PropertyValueFactory<GoodPresenter, Integer>("id"));
        viewGoodsNameColumn.setCellValueFactory(new PropertyValueFactory<GoodPresenter, String>("name"));
        viewGoodsPriceColumn.setCellValueFactory(new PropertyValueFactory<GoodPresenter, String>("price"));
        viewGoodsQuantityColumn.setCellValueFactory(new PropertyValueFactory<GoodPresenter, String>("quantity"));
        viewGoodsCategoryColumn.setCellValueFactory((new PropertyValueFactory<GoodPresenter, String>("categoryName")));
        viewGoodsVendorColumn.setCellValueFactory((new PropertyValueFactory<GoodPresenter, String>("vendorName")));
        viewGoodsDescriptionColumn.setCellValueFactory(new PropertyValueFactory<GoodPresenter, String>("description"));
        viewGoodsTable.setItems(goodsObservableList);
    }

    public void viewBills() {
//        BillPresenter[] billPresenters = PresenterUtil.getPresentedBills(data.getBills().size(), data.getBills());
//        billObservableList = FXCollections.observableArrayList(billPresenters);
//
//        viewBillsIdColumn.setCellValueFactory(new PropertyValueFactory<BillPresenter, Integer>("id"));
//        viewBillsNameColumn.setCellValueFactory(new PropertyValueFactory<BillPresenter, String>("name"));
//        viewBillsQuantityColumn.setCellValueFactory(new PropertyValueFactory<BillPresenter, Integer>("quantity"));
//        viewBillsPriceColumn.setCellValueFactory(new PropertyValueFactory<BillPresenter, Integer>("price"));
//        viewBillsDateColumn.setCellValueFactory(new PropertyValueFactory<BillPresenter, String>("dateBilled"));
//        viewBillsCustomerColumn.setCellValueFactory(new PropertyValueFactory<BillPresenter, String>("name"));
//        viewBillsTable.setItems(billObservableList);
    }

    public void viewIssuedGoods() throws SQLException {
        IssueGoodRepository issueGoodRepository = new IssueGoodRepository();
        List<IssuedGood> issuedGoodList = issueGoodRepository.getIssueGoods();

        IssuedGoodPresenter[] issuedGoodPresenters = PresenterUtil.getPresentedIssuedGoods(issuedGoodList.size(), issuedGoodList);
        issuedGoodObservableList = FXCollections.observableArrayList(issuedGoodPresenters);

        viewIssuedGoodsIdColumn.setCellValueFactory(new PropertyValueFactory<IssuedGoodPresenter, Integer>("id"));
        viewIssuedGoodsNameColumn.setCellValueFactory(new PropertyValueFactory<IssuedGoodPresenter, String>("goodName"));
        viewIssuedGoodsQuantityColumn.setCellValueFactory(new PropertyValueFactory<IssuedGoodPresenter, Integer>("quantity"));
        viewIssuedGoodsCustomerColumn.setCellValueFactory(new PropertyValueFactory<IssuedGoodPresenter, String>("customerName"));
        viewIssuedGoodsDateColumn.setCellValueFactory(new PropertyValueFactory<IssuedGoodPresenter, String>("dateIssued"));
        viewIssuedGoodsTable.setItems(issuedGoodObservableList);
    }

    public void viewVendor() throws Exception {
        VendorRepository vendorRepository = new VendorRepository();
        List<Vendor> vendorArrayList = vendorRepository.getVendors();
        VendorPresenter[] vendorPresenters = PresenterUtil.getPresentedVendors(vendorArrayList.size(), vendorArrayList);
        vendorObservableList = FXCollections.observableArrayList(vendorPresenters);

        viewVendorsIdColumn.setCellValueFactory(new PropertyValueFactory<VendorPresenter, Integer>("id"));
        viewVendorsNameColumn.setCellValueFactory(new PropertyValueFactory<VendorPresenter, String>("name"));
        viewVendorsEmailColumn.setCellValueFactory(new PropertyValueFactory<VendorPresenter, String>("email"));
        viewVendorsTable.setItems(vendorObservableList);
    }

    public void clearAddGoodForm() {
        // clear the content
        System.out.println("Clear form");
        goodNameText.clear();
        goodPriceText.clear();
        goodQuantityText.clear();
        goodDescriptionText.clear();
        goodCategoryChoiceBox.getSelectionModel().select(0);
        goodVendorChoiceBox.getSelectionModel().select(0);
    }

    public void clearIssueGoodForm() {
        // clear the content
        System.out.println("Clear form");
        issueGoodQuantityText.clear();
        issueGoodNameChoiceBox.getSelectionModel().select(0);
        issueGoodCustomerChoiceBox.getSelectionModel().select(0);
    }

    public void displayAlert(Alert.AlertType alertType, String title, String headerText, String contextText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contextText);
        alert.showAndWait();
    }
}
