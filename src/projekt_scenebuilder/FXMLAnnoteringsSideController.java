/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_scenebuilder;

import projekt_scenebuilder.FXMLDICOMFolderController;

import com.pixelmed.dicom.DicomException;
import com.pixelmed.display.SourceImage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.ImageIcon;

/**
 * FXML Controller class
 *
 * @author mathi
 */
public class FXMLAnnoteringsSideController implements Initializable {

    @FXML
    private Button newSeries;
    @FXML
    private Button toMainMenu;

    @FXML
    private Label jLabelImageDisplay;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // load the image
        //("file:\\C:\\Users\\mathi\\OneDrive\\Dokumenter\\NetBeansProjects\\Projekt_SceneBuilder\\src\\projekt_scenebuilder\\DAN-R\\010007\\DICOM\\ST00001\\SE00001");
    }

    @FXML
    private void backToSeriesSelectionChangeScreenButtomPushed(ActionEvent event) throws IOException {
        Parent toDicomFolderParent = FXMLLoader.load(getClass().getResource("FXMLDICOMFolder.fxml"));
        Scene toDicomFolderScene = new Scene(toDicomFolderParent);
        // Næste linje får "Stage" information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();   // Vi har "event" fra Action event, og typeCaster det som er "Node". Node type object, hvorved vi kan få Scene og Window.Typecaster igen til Stage

        window.setScene(toDicomFolderScene);
        window.show();
    }

    @FXML
    private void backToMainMenuChangeScreenButtomPushed(ActionEvent event) throws IOException {
        Parent toMainMenuParent = FXMLLoader.load(getClass().getResource("FXMLFrontpage.fxml"));
        Scene toMainMenuScene = new Scene(toMainMenuParent);
        // Næste linje får "Stage" information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();   // Vi har "event" fra Action event, og typeCaster det som er "Node". Node type object, hvorved vi kan få Scene og Window.Typecaster igen til Stage

        window.setScene(toMainMenuScene);
        window.show();
    }

    private void loadDICOMIMAGE(ActionEvent event) {
        File selectedURI = new File("file:\\C:\\Users\\mathi\\OneDrive\\Dokumenter\\NetBeansProjects\\Projekt_SceneBuilder\\src\\projekt_scenebuilder\\DAN-R\\010007\\DICOM\\ST00001\\SE00001");
        loadAndDisplay(selectedURI);
    }

    @FXML  // https://www.youtube.com/watch?v=HhXhXrlzWkM
    public void loadAndDisplay(File selectedURI) {
        try { // "file:\\C:\\Users\\mathi\\OneDrive\\Dokumenter\\NetBeansProjects\\Projekt_SceneBuilder\\src\\projekt_scenebuilder\\DAN-R\\010007\\DICOM\\ST00001\\SE00001"
            SourceImage sImg = new SourceImage(selectedURI.getAbsolutePath());
            BufferedImage img = sImg.getBufferedImage();
            ImageIcon icon = new ImageIcon(img);
            jLabelImageDisplay.setIcon(icon);
        } catch (IOException | DicomException ex) {
            Logger.getLogger(FXMLAnnoteringsSideController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}


