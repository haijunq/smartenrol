/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.search;

import java.util.ArrayList;
import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.event.EventHandler;


import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import org.javafxdata.control.TableViewFactory;
import org.springframework.beans.factory.annotation.Autowired;

import smartenrol.dao.ProgramDAO;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.UserDAO;
import smartenrol.model.Program;
import smartenrol.model.Course;
import smartenrol.model.User;
import smartenrol.model.ProgramSearchResult;
import smartenrol.model.view.CourseTable;
import smartenrol.model.UserSearchResult;
import smartenrol.page.Navigator;
import smartenrol.page.PageController;
import smartenrol.page.SmartEnrolController;
import smartenrol.page.entities.course.CoursePageController;

/**
 *
 * @author Jeremy
 */
public class SearchController extends SmartEnrolController {

    @FXML
    protected TextField mainSearchField;
    @FXML
    private BorderPane innerContent;
    @FXML
    private BorderPane searchResultsArea;
    @Autowired
    private ResultsPaneController resultsPane;
    @Autowired
    private FilterController filterController;
    @Autowired
    private Navigator navigator;
    @Autowired
    private PageController pageController;
    @FXML
    private ComboBox searchType;
    private String lastSearchQuery="";

    public void init() {

        innerContent.setLeft(filterController.getView());
        searchResultsArea.setTop(resultsPane.getView());
        filterController.init();
    }

    /**
     * Parse a string into words, and store them in a string array
     *
     * @param	input string
     * @return string array of words delimited by white space
     */
    private String[] parseKeyword(String input) {
        String delims = "[ ]+";
        String[] tokens = input.split(delims);
        String[] keywords = new String[3];
        int i = 0;
        int maxtokens = tokens.length;
        if (maxtokens > 3) {
            maxtokens = 3;
        }

        for (i = 0; i < maxtokens; i++) {
            keywords[i] = tokens[i];
        }
        for (i = tokens.length; i < 3; i++) {
            keywords[i] = "";
        }

        return keywords;
    }
    /**
     * 
     * @return 
     */
    private String getSearchType() {
        return ((String) searchType.getValue());
    }

    /**
     * 
     * @param searchQuery
     * @param type 
     */
    public void search(String searchQuery, String type) {

        resultsPane.setText(0, searchQuery, type);
        mainSearchField.setText(searchQuery);
        if (type.equalsIgnoreCase(getSearchType())) {
            filterController.resetFilters();
            doSearch();
        } else {
            searchType.setValue(type);
        }
    }

    public void lastSearch() {
        mainSearchField.setText(lastSearchQuery);
        doSearch();
    }

    public void onSearchTypeFilterChange() {
        filterController.createFilters((String) searchType.getValue());
        doSearch();
    }

    public void loadSelectedItem(TableView tableView, String type) {
        Object selectedItem = null;
        selectedItem = tableView.getFocusModel().getFocusedItem();
        if (!(selectedItem == null)) {
            //userSidebarController.setLastSearchVisible(true);
            if (type.equalsIgnoreCase("course")) {
                CourseTable result = (CourseTable) selectedItem;
                ((CoursePageController) navigator.navigate(Page.COURSE)).load(result.getIdDepartment(), result.getIdCourse());
            }

        }


    }

    public void showAll() {
        mainSearchField.clear();
        onSearchTypeFilterChange();
    }

    /**
     *
     */
    public void doSearch() {

        String filterValue1 = "";
        String filterValue2 = "";
        String filterValue3 = "";
        
        //pageController.setLastSearchVisible(false);
        lastSearchQuery=mainSearchField.getText();
        
        int levelFilter = 0;

        filterValue1 = filterController.getFilterValue(1);
        filterValue2 = filterController.getFilterValue(2);
        filterValue3 = filterController.getFilterValue(3);

        String type=getSearchType();
        if (type==null)
        {
            type="course";
        }
        
        
        if (type.equalsIgnoreCase("course")) {
            try {
                levelFilter = Integer.parseInt(filterValue2);
            } catch (NumberFormatException e) {
                levelFilter = 0;
            }
            courseSearch(mainSearchField.getText(), filterValue1, levelFilter, filterValue3);

        }

        if (type.equalsIgnoreCase("program")) {
            programSearch(mainSearchField.getText(), filterValue1);
        }

        if (type.equalsIgnoreCase("people")) {
            userSearch(mainSearchField.getText(), filterValue1);
        }
        

    }

    private void programSearch(String searchQuery, String deptFilter) {

  
        String[] keywords = parseKeyword(searchQuery);


        ProgramDAO pDAO = new ProgramDAO();
        ArrayList<Program> programList = new ArrayList<>();
        programList = pDAO.searchProgrambyKeyword(keywords, deptFilter);
        ArrayList<ProgramSearchResult> programResult = new ArrayList<>();
        TableView tableView = null;
        int resultcount = 0;
        if (!(programList == null)) {
            resultcount = programList.size();
        }
        if (resultcount > 0) {
            for (Program p : programList) {
                programResult.add(new ProgramSearchResult(p));
            }


            tableView = TableViewFactory.
                    create(ProgramSearchResult.class, programResult).
                    buildTableView();

        }
        resultsPane.setText(resultcount, searchQuery, "program");
        searchResultsArea.setCenter(tableView);
    }

    private void courseSearch(String searchQuery, String deptFilter, int levelFilter, String programFilter) {

        String[] keywords = parseKeyword(searchQuery);

        CourseDAO cDAO = new CourseDAO();
        ArrayList<Course> courseList = new ArrayList<>();
        courseList = cDAO.searchCourseByKeyword(keywords, deptFilter, levelFilter, programFilter);
//       TableView tableView=null;
        int resultcount = 0;
        if (!(courseList == null)) {
            resultcount = courseList.size();
        }

        ArrayList<CourseTable> courseResult = new ArrayList<>();

        if (resultcount > 0) {
            for (Course c : courseList) {
                courseResult.add(new CourseTable(c));
            }

        }

        final TableView<CourseTable> tableView = new TableView<>();

        TableColumn idDepartmentCol = new TableColumn("Deptartment");
        TableColumn idCourseCol = new TableColumn("Number");
        TableColumn courseNameCol = new TableColumn("Name");
        TableColumn creditsCol = new TableColumn("Credits");

        idDepartmentCol.setMaxWidth(80);
        idDepartmentCol.setMinWidth(80);

        idCourseCol.setMaxWidth(60);
        idCourseCol.setMinWidth(60);

        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                if (me.getClickCount() > 1) {
                    loadSelectedItem(tableView, "course");
                }
                
            }
        });


        idDepartmentCol.setCellValueFactory(
                new PropertyValueFactory<CourseTable, String>("idDepartment"));
        idCourseCol.setCellValueFactory(
                new PropertyValueFactory<CourseTable, Integer>("idCourse"));
        courseNameCol.setCellValueFactory(
                new PropertyValueFactory<CourseTable, String>("name"));
        creditsCol.setCellValueFactory(
                new PropertyValueFactory<CourseTable, Float>("credit"));

        tableView.setItems(FXCollections.observableList(courseResult));
        tableView.getColumns().addAll(idDepartmentCol, idCourseCol, courseNameCol, creditsCol);

        tableView.setEditable(false);


        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        searchResultsArea.setCenter(tableView);
        resultsPane.setText(resultcount, searchQuery, "course");
    }

    private void userSearch(String searchQuery, String typeFilter) {

     
        String[] keywords = parseKeyword(searchQuery);

        UserDAO uDAO = new UserDAO();
        ArrayList<User> userList = new ArrayList<>();
        userList = uDAO.searchUserbyKeyword(keywords, typeFilter);
        ArrayList<UserSearchResult> userResult = new ArrayList<>();
        int resultcount = 0;
        TableView tableView = null;
        if (!(userList == null)) {
            resultcount = userList.size();
        }
        if (resultcount > 0) {
            for (User u : userList) {
                userResult.add(new UserSearchResult(u));
            }


            tableView = TableViewFactory.
                    create(UserSearchResult.class, userResult).
                    //  
                    buildTableView();

        }
        searchResultsArea.setCenter(tableView);
        resultsPane.setText(resultcount, searchQuery, "people");
    }
}
