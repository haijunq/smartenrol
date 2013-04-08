/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.search;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
import smartenrol.model.CourseSearchResult;
import smartenrol.page.AbstractController;

/**
 *
 * @author Jeremy
 */
public class SearchController extends AbstractController {
    
    @FXML protected TextField mainSearchField;
    @FXML private BorderPane innerContent;
    @FXML private BorderPane searchResultsArea;
   
    @Autowired private ResultsPaneController resultsPane;
    @Autowired private FilterController filterController;
    //@Autowired private SearchTableController searchTableController;

    @FXML private ComboBox searchType;
    
    
    
    public void init() {
        
    }    
    
    
    /**
    Parse a string into words, and store them in a string array
    @param	input string
    @return string array of words delimited by white space
    */
    
    private String[] parseKeyword(String input)
    {
	String delims = "[ ]+";
	String[] tokens = input.split(delims);
	String[] keywords= new String[3];
        int i=0;
        for (i=0;i<tokens.length;i++)
        {
            keywords[i]=tokens[i];
        }
        for (i=tokens.length;i<3;i++)
        {
            keywords[i]="";
        }
        
        return keywords;
    }
    
    private int getSearchType()
    {
        int type=0;
        //type=searchType.getValue();
        return type;
    }
    
    public void search(String searchQuery) {
       
       resultsPane.setText(0,searchQuery,"course");
       mainSearchField.setText(searchQuery);
       innerContent.setLeft(filterController.getView());
       searchResultsArea.setTop(resultsPane.getView());
       
//       String[] keywords=parseKeyword(searchQuery);
//       String deptFilter="";
//       
//       ProgramDAO pDAO = new ProgramDAO();
//       ArrayList<Program> programList=pDAO.searchProgrambyKeyword(keywords, deptFilter);
//       ArrayList<ProgramSearchResults> programResult=null;
//       
//       for (Program p: programList)
//       {
//           programResult.add(new ProgramSearchResults(p));
//       }
//       
//       
//                    
//       TableView tableView = TableViewFactory.
//         create(ProgramSearchResults.class, programResult).
//         selectColumns("Program", "Name", "Department", "totalcredit").
////         renameColumn("Id Department", "Dept").
////         renameColumn("Id Course", "Num").
//         buildTableView();
//         
//       
//       searchResultsArea.setCenter(tableView);
    
    }
    
    
    /**
     *
     */
    public void doSearch() {
        courseSearch(mainSearchField.getText());
    }
    
    
    private void programSearch(String searchQuery)
    {
       resultsPane.setText(0,searchQuery,"course");
       mainSearchField.setText(searchQuery);
       innerContent.setLeft(filterController.getView());
       searchResultsArea.setTop(resultsPane.getView());
       
       String[] keywords=parseKeyword(searchQuery);
       String deptFilter="";
       
       ProgramDAO pDAO = new ProgramDAO();
       ArrayList<Program> programList=new ArrayList<>();
       programList=pDAO.searchProgrambyKeyword(keywords, deptFilter);
       ArrayList<ProgramSearchResult> programResult=new ArrayList<>();
            
       if (programList.size()>0)
       {
           for (Program p: programList)
           {
               programResult.add(new ProgramSearchResult(p));
           }
          
                    
           TableView tableView = TableViewFactory.
           create(ProgramSearchResult.class, programResult).
            selectColumns("Program", "Name", "Department", "totalcredit").
//          renameColumn("Id Department", "Dept").
//          renameColumn("Id Course", "Num").
            buildTableView();
            
            searchResultsArea.setCenter(tableView);
       }
    }
    
     public void courseSearch(String searchQuery)
    {
       resultsPane.setText(0,searchQuery,"course");
       mainSearchField.setText(searchQuery);
       innerContent.setLeft(filterController.getView());
       searchResultsArea.setTop(resultsPane.getView());
       
       String[] keywords=parseKeyword(searchQuery);
       String deptFilter="";
       String programFilter="";
       int levelFilter=0;
       
       CourseDAO cDAO = new CourseDAO();
       ArrayList<Course> courseList=new ArrayList<>();
       courseList=cDAO.searchCourseByKeyword(keywords, deptFilter, levelFilter, programFilter);
       
       
       ArrayList<CourseSearchResult> courseResult=new ArrayList<>();
            
       if (courseList.size()>0)
       {
           for (Course c: courseList)
           {
               courseResult.add(new CourseSearchResult(c));
           }
          
                    
           TableView tableView = TableViewFactory.
           create(CourseSearchResult.class, courseResult).
//  
//          renameColumn("Id Department", "Dept").
//          renameColumn("Id Course", "Num").
            buildTableView();
            
            searchResultsArea.setCenter(tableView);
       }
    }
    
}
