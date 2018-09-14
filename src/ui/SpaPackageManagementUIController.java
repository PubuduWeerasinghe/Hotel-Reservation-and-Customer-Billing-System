/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Tharana
 */
public class SpaPackageManagementUIController implements Initializable {

    @FXML
    private JFXTextField txtSearchByCode;
    @FXML
    private JFXTextField txtPackagePrice;
    @FXML
    private JFXButton btnNewFoodItemCategory;
    @FXML
    private TextArea txtDescription;
    @FXML
    private JFXTextField txtCode;
    @FXML
    private JFXTextField txtPackageName;
    @FXML
    private JFXComboBox<?> cmbPackageCategory;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnClear;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXTextField txtSearchByPackage;
    @FXML
    private Pagination pagination;
    @FXML
    private TableView<?> tblPackage;
    @FXML
    private TableColumn<?, ?> colCode;
    @FXML
    private TableColumn<?, ?> colItem;
    @FXML
    private TableColumn<?, ?> colCategory;
    @FXML
    private JFXComboBox<?> cmbSearchByCategory;
    @FXML
    private JFXButton btnSearchClear;

       //<editor-fold defaultstate="collapsed" desc="Form-Data">
    Spapackage spaPackage;
    Spapackage oldSpaPackage;

    Stage spaPackageCategoryStage;

    String initial;
    String valid;
    String invalid;
    String updated;

    int page;
    int row;

    //boolean photoSelected;
    BigDecimal packageCost;

    //public static File lastDirectory;
//</editor-fold>
     //<editor-fold defaultstate="collapsed" desc="Initializing-Methods">
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initial = Style.initial;
        valid = Style.valid;
        invalid = Style.invalid;
        updated = Style.updated;

        loadForm();

        loadTable();
    }
    public void loadForm() {

        spaPackage = new Spapackage();
        oldSpaPackage = null;

        cmbPackageCategory.setItems(SpaPackageCategoryDao.getAll());//get all cmb details
        cmbPackageCategory.getSelectionModel().clearSelection();//clear the selected item

        txtCode.setText("");
        txtPackageName.setText("");
        txtPackagePrice.setText("");
        txtDescription.setText("");

        dissableButtons(false, false, true, true);

        setStyle(initial);

    }

    private void setStyle(String style) {

        cmbPackageCategory.setStyle(style);

        txtCode.setStyle(style);
        txtPackageName.setStyle(style);
        txtPackagePrice.setStyle(style);
        txtDescription.setStyle(style);

        if (!txtDescription.getChildrenUnmodifiable().isEmpty()) {

            ((ScrollPane) txtDescription.getChildrenUnmodifiable().get(0)).getContent().setStyle(style);

        }

        cmbSearchByCategory.setStyle(style);
        txtSearchByCode.setStyle(style);
        txtSearchByPackage.setStyle(style);

    }

    private void dissableButtons(boolean select, boolean insert, boolean update, boolean delete) {

        btnAdd.setDisable(insert);
        btnUpdate.setDisable(update);
        btnDelete.setDisable(delete);

    }

    private void loadTable() {

        cmbSearchByCategory.setItems(SpaPackageCategoryDao.getAll());
        cmbSearchByCategory.getSelectionModel().clearSelection();

        txtSearchByCode.setText("");
        txtSearchByPackage.setText("");

        colCode.setCellValueFactory(new PropertyValueFactory("code"));
        colItem.setCellValueFactory(new PropertyValueFactory("name"));
        colCategory.setCellValueFactory(new PropertyValueFactory("spapackagecategoryId"));

//        tblEmployee.setRowFactory(new Callback<TableView<Employee>, TableRow<Employee>>() {
//
//            @Override
//            public TableRow<Employee> call(TableView<Employee> dateTableView) {
//
//                return new TableRow<Employee>() {
//
//                    @Override
//                    protected void updateItem(Employee date, boolean b) {
//                        super.updateItem(date, b);
//
//                        setStyle("-fx-background-color: linear-gradient(#04ef57 1%, #FFFFFF 100%);");
//
//                    }
//
//                };
//
//            }
//
//        });


        row = 0;
        page = 0;

        fillTable(SpaPackageDao.getAll());

        pagination.setCurrentPageIndex(0);

    }

    private void fillTable(ObservableList<Spapackage> employees) {

        if (employees != null && !employees.isEmpty()) {

            int rowsCount = 5;
            int pageCount = ((employees.size() - 1) / rowsCount) + 1;
            pagination.setPageCount(pageCount);

            pagination.setPageFactory((Integer pageIndex) -> {
                int start = pageIndex * rowsCount;
                int end = pageIndex == pageCount - 1 ? employees.size() : pageIndex * rowsCount + rowsCount;
                tblPackage.getItems().clear();
                tblPackage.setItems(FXCollections.observableArrayList(employees.subList(start, end)));
                return tblPackage;
            });

        } else {

            pagination.setPageCount(1);
            tblPackage.getItems().clear();

        }

        pagination.setCurrentPageIndex(page);
        tblPackage.getSelectionModel().select(row);

    }   

    @FXML
    private void txtSearchByCodeKR(KeyEvent event) {
    }

    @FXML
    private void txtUnitPriceKR(KeyEvent event) {
    }

    @FXML
    private void btnNewFoodItemCategoryAP(ActionEvent event) {
    }

    @FXML
    private void txtDescriptionKR(KeyEvent event) {
    }

    @FXML
    private void txtCodeKR(KeyEvent event) {
    }

    @FXML
    private void txtItemNameKR(KeyEvent event) {
    }

    @FXML
    private void cmbItemCategoryAP(ActionEvent event) {
    }

    @FXML
    private void btnAddAP(ActionEvent event) {
    }

    @FXML
    private void btnClearAP(ActionEvent event) {
    }

    @FXML
    private void btnUpdateAP(ActionEvent event) {
    }

    @FXML
    private void btnDeleteAP(ActionEvent event) {
    }

    @FXML
    private void txtSearchByItemKR(KeyEvent event) {
    }

    @FXML
    private void tblFoodItemMC(MouseEvent event) {
    }

    @FXML
    private void tblFoodItemKR(KeyEvent event) {
    }

    @FXML
    private void cmbSearchByCategoryAP(ActionEvent event) {
    }

    @FXML
    private void btnSearchClearAP(ActionEvent event) {
    }
    
}
