
package gui;

import java.sql.Connection;
import java.sql.ResultSet;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class Highscorescherm {
    HoofdScherm hoofdscherm;
    private ObservableList<ObservableList> data;
    private TableView tableview;
    Highscorescherm(HoofdScherm hoofdscherm) {
        this.hoofdscherm = hoofdscherm;
//         
//
//          Connection c ;
//          data = FXCollections.observableArrayList();
//          try{
//            c = DBConnect.connect();
//            //SQL FOR SELECTING ALL OF CUSTOMER
//            String SQL = "SELECT * from CUSTOMer";
//            //ResultSet
//            ResultSet rs = c.createStatement().executeQuery(SQL);
//
//            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
//                //We are using non property style for making dynamic table
//                final int j = i;                
//                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
//                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
//                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
//                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
//                    }                    
//                });
//
//                tableview.getColumns().addAll(col); 
//                System.out.println("Column ["+i+"] ");
//            }
//
//            /********************************
//             * Data added to ObservableList *
//             ********************************/
//            while(rs.next()){
//                //Iterate Row
//                ObservableList<String> row = FXCollections.observableArrayList();
//                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
//                    //Iterate Column
//                    row.add(rs.getString(i));
//                }
//                System.out.println("Row [1] added "+row );
//                data.add(row);
//
//            }
//
//            
//            tableview.setItems(data);
//          }catch(Exception e){
//              e.printStackTrace();
//              System.out.println("Error on Building Data");             
//          }
      }
}

