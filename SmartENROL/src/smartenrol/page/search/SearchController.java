/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.search;

import java.util.ArrayList;

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
import smartenrol.model.UserSearchResult;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author Jeremy
 */
public class SearchController extends SmartEnrolController {
    
    @FXML protected TextField mainSearchField;
    @FXML private BorderPane innerContent;
    @FXML private BorderPane searchResultsArea;
   
    @Autowired private ResultsPaneController resultsPane;
    @Autowired private FilterController filterController;
    //@Autowired private SearchTableController searchTableController;

    @FXML private ComboBox searchType;
    
    
    
    public void init() {
        
       innerContent.setLeft(filterController.getView());
       searchResultsArea.setTop(resultsPane.getView());
       
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
        int maxtokens=tokens.length;
        if (maxtokens>3)
        {
            maxtokens=3;
        }
        
        for (i=0;i<maxtokens;i++)
        {
            keywords[i]=tokens[i];
        }
        for (i=tokens.length;i<3;i++)
        {
            keywords[i]="";
        }
        
        return keywords;
    }
    
    private String getSearchType()
    {
        return ((String) searchType.getValue());
        
    }
    
   
    
    public void search(String searchQuery, String type) {
       
       resultsPane.setText(0,searchQuery,type);
       mainSearchField.setText(searchQuery);
      
       searchType.setValue(type);
    //   doSearch();
    
    }
    
    public void onSearchTypeFilterChange()
    {
        filterController.createFilters((String) searchType.getValue());
        doSearch();
    }
    
    public void showAll()
    {
        mainSearchField.clear();
        onSearchTypeFilterChange();
    }
    
    /**
     *
     */
    public void doSearch() {
        
        String filterValue1="";
        String filterValue2="";
        String filterValue3="";
        int levelFilter=0;
        
        filterValue1=filterController.getFilterValue(1);
        filterValue2=filterController.getFilterValue(2);
        filterValue3=filterController.getFilterValue(3);
        
        if (getSearchType().equalsIgnoreCase("course"))
        {
           try
           {
               levelFilter=Integer.parseInt(filterValue2);
           }
           catch (NumberFormatException e)
           {
               levelFilter=0;
           }
           courseSearch(mainSearchField.getText(),filterValue1,levelFilter,filterValue3);
           
        }
        
        if (getSearchType().equalsIgnoreCase("program"))
        {
            programSearch(mainSearchField.getText(),filterValue1);
        }
        
        if (getSearchType().equalsIgnoreCase("people"))
        {
            userSearch(mainSearchField.getText(),filterValue1);
        }
        
    }
    
    
    private void programSearch(String searchQuery, String deptFilter)
    {
       
       mainSearchField.setText(searchQuery);
       innerContent.setLeft(filterController.getView());
       searchResultsArea.setTop(resultsPane.getView());
       
       String[] keywords=parseKeyword(searchQuery);
       
       
       ProgramDAO pDAO = new ProgramDAO();
       ArrayList<Program> programList=new ArrayList<>();
       programList=pDAO.searchProgrambyKeyword(keywords, deptFilter);
       ArrayList<ProgramSearchResult> programResult=new ArrayList<>();
       TableView tableView=null;
       int resultcount=0;
       if (!(programList==null))
       {
            resultcount=programList.size();
       }     
       if (resultcount>0)
       {
           for (Program p: programList)
           {
               programResult.add(new ProgramSearchResult(p));
           }
          
                    
           tableView = TableViewFactory.
           create(ProgramSearchResult.class, programResult).
          
            buildTableView();
            
            
           
       }
        resultsPane.setText(resultcount,searchQuery,"program");
        searchResultsArea.setCenter(tableView);
    }
    
     private void courseSearch(String searchQuery, String deptFilter, int levelFilter, String programFilter)
    {
       
       mainSearchField.setText(searchQuery);
       innerContent.setLeft(filterController.getView());
       searchResultsArea.setTop(resultsPane.getView());
       
       String[] keywords=parseKeyword(searchQuery);
      
       
       CourseDAO cDAO = new CourseDAO();
       ArrayList<Course> courseList=new ArrayList<>();
       courseList=cDAO.searchCourseByKeyword(keywords, deptFilter, levelFilter, programFilter);
       TableView tableView=null;
       int resultcount=0;
       if (!(courseList==null))
       {
            resultcount=courseList.size();
       }
      
       
       
       ArrayList<CourseSearchResult> courseResult=new ArrayList<>();
            
       if (resultcount>0)
       {
           for (Course c: courseList)
           {
               courseResult.add(new CourseSearchResult(c));
           }
          
                    
           tableView = TableViewFactory.
           create(CourseSearchResult.class, courseResult).
           buildTableView();
           
        }
       searchResultsArea.setCenter(tableView); 
       resultsPane.setText(resultcount,searchQuery,"course");
    }
     
     
       private void userSearch(String searchQuery,String typeFilter)
    {
       
       mainSearchField.setText(searchQuery);
       innerContent.setLeft(filterController.getView());
       searchResultsArea.setTop(resultsPane.getView());
       
       String[] keywords=parseKeyword(searchQuery);
            
       UserDAO uDAO = new UserDAO();
       ArrayList<User> userList=new ArrayList<>();
       userList=uDAO.searchUserbyKeyword(keywords, typeFilter);
       ArrayList<UserSearchResult> userResult=new ArrayList<>();
       int resultcount=0;
       TableView tableView=null;
       if (!(userList==null))
       {
            resultcount=userList.size();
       }
       if (resultcount>0)
       {
           for (User u: userList)
           {
               userResult.add(new UserSearchResult(u));
           }
          
                    
           tableView = TableViewFactory.
           create(UserSearchResult.class, userResult).
//  
           buildTableView();
                   
       }
       searchResultsArea.setCenter(tableView);
       resultsPane.setText(resultcount,searchQuery,"people");
    }
    
}
