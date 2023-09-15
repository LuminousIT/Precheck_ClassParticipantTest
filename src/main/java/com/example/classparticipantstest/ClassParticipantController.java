package com.example.classparticipantstest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ClassParticipantController implements Initializable {
    @javafx.fxml.FXML
    private TextField tfName;
    @javafx.fxml.FXML
    private TextField tfSurname;
    @javafx.fxml.FXML
    private TextField tfAge;
    @javafx.fxml.FXML
    private ComboBox comboSport;
    @javafx.fxml.FXML
    private ComboBox comboAward;
    @javafx.fxml.FXML
    private Label t;
    @javafx.fxml.FXML
    private TextField tfID;
    @javafx.fxml.FXML
    private TableColumn<Participant, Integer> colID;
    @javafx.fxml.FXML
    private TableColumn<Participant, String> colName;
    @javafx.fxml.FXML
    private TableColumn<Participant, String> colSurname;
    @javafx.fxml.FXML
    private TableColumn<Participant, Integer> colAge;
    @javafx.fxml.FXML
    private TableColumn<Participant, String> colSport;
    @javafx.fxml.FXML
    private TableColumn<Participant, String> colAward;

    private String[] sports = {"", "Basketball", "Football", "Volleyball", "Hockey"};
    private String[] awards = {"", "National Best", "Regional Best", "Second Best", "No award"};

    @FXML
    private TableView tableView;
    @FXML
    private Button createBtn;
    @FXML
    private ComboBox comboFilterSport;
    @FXML
    private ComboBox comboFilterAward;
    @FXML
    private Button filterBtn;



    public ClassParticipantController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboSport.getItems().removeAll(comboSport.getItems());
        comboSport.getItems().addAll(FXCollections.observableArrayList(sports));

        comboAward.getItems().removeAll(comboSport.getItems());
        comboAward.getItems().addAll(FXCollections.observableArrayList(awards));

        comboFilterSport.getItems().removeAll(comboSport.getItems());
        comboFilterSport.getItems().addAll(FXCollections.observableArrayList(sports));

        comboFilterAward.getItems().removeAll(comboSport.getItems());
        comboFilterAward.getItems().addAll(FXCollections.observableArrayList(awards));

        showParticipants();
    }

    public Connection getConnection(){
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/classparticipants", "postgres", "luminous");
            return connection;
        }catch(Exception ex) {
            System.out.println("Error DB Connection: " + ex.getMessage());
            return null;
        }
    }

    public ObservableList<Participant> getParticipantList(){
        ObservableList<Participant> participantsList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "Select * from Participants";
        Statement statement;
        ResultSet resultSet;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            Participant participants;
            while (resultSet.next()){
                participants = new Participant(resultSet.getInt("matricID"), resultSet.getString("firstname"), resultSet.getString("surname"), resultSet.getInt("age"), resultSet.getString("sportType"), resultSet.getString("award"));
                participantsList.add(participants);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return participantsList;
    }

    public void showParticipants(){
        ObservableList<Participant> list = getParticipantList();
        colID.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("matricID"));
        colName.setCellValueFactory(new PropertyValueFactory<Participant, String>("firstname"));
        colSurname.setCellValueFactory(new PropertyValueFactory<Participant, String>("surname"));
        colAge.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("age"));
        colAward.setCellValueFactory(new PropertyValueFactory<Participant, String>("award"));
        colSport.setCellValueFactory(new PropertyValueFactory<Participant, String >("sportType"));

        tableView.setItems(list);
    }

    public void showFilterParticipants(){
        ObservableList<Participant> list = filterParticipant();
        colID.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("matricID"));
        colName.setCellValueFactory(new PropertyValueFactory<Participant, String>("firstname"));
        colSurname.setCellValueFactory(new PropertyValueFactory<Participant, String>("surname"));
        colAge.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("age"));
        colAward.setCellValueFactory(new PropertyValueFactory<Participant, String>("award"));
        colSport.setCellValueFactory(new PropertyValueFactory<Participant, String >("sportType"));

        tableView.setItems(list);
    }


    public void createParticipant(){
        String query = "INSERT INTO participants VALUES (" + tfID.getText() + ",'" + tfName.getText() + "','" + tfSurname.getText() + "'," + tfAge.getText() + ",'" + comboAward.getValue() + "','" + comboSport.getValue() + "')";
        executeQuery(query);
        showParticipants();
    }

    public void executeQuery(String query){
        Connection connection = getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            resetFields();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ObservableList<Participant> filterParticipant(){
        String query = "SELECT * FROM participants WHERE award = '" + comboFilterAward.getValue() + "' OR sporttype = '" + comboFilterSport.getValue() + "'";

        ObservableList<Participant> participantsList = FXCollections.observableArrayList();
        Connection connection = getConnection();

        Statement statement;
        ResultSet resultSet;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            Participant participants;
            while (resultSet.next()){
                participants = new Participant(resultSet.getInt("matricID"), resultSet.getString("firstname"), resultSet.getString("surname"), resultSet.getInt("age"), resultSet.getString("sportType"), resultSet.getString("award"));
                participantsList.add(participants);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return participantsList;

    }

    @FXML
    public void onSportSelect(ActionEvent actionEvent) {
        System.out.println(comboSport.getValue() + " is selected");
    }

    @FXML
    public void onAwardSelect(ActionEvent actionEvent) {
        System.out.println(comboAward.getValue() + " is selected");
    }

    @FXML
    public void handleCreateParticipant(ActionEvent actionEvent) {
        if (actionEvent.getSource() == createBtn) {
            createParticipant();
        }
    }

    public void resetFields(){
        tfID.setText("");
        tfName.setText("");
        tfSurname.setText("");
        tfAge.setText("");
    }

    @FXML
    public void onFilter(ActionEvent actionEvent) {
        if (actionEvent.getSource() == filterBtn){
            showFilterParticipants();
        }
    }
}
