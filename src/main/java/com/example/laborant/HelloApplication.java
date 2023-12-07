package com.example.laborant;

import com.google.gson.JsonElement;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        Table table = new Table("equipment");
        // Создание таблицы
        TableView<Row> tableView = new TableView<>();

        // Создание столбцов
        TableColumn<Row, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Row, String> sectionColumn = new TableColumn<>("Section");
        sectionColumn.setCellValueFactory(new PropertyValueFactory<>("section"));

        TableColumn<Row, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<Row, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Row, String> referenceColumn = new TableColumn<>("Reference");
        referenceColumn.setCellValueFactory(new PropertyValueFactory<>("reference"));

        TableColumn<Row, String> timeColumn = new TableColumn<>("Time");
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

        TableColumn<Row, String> repairColumn = new TableColumn<>("Repair");
        repairColumn.setCellValueFactory(new PropertyValueFactory<>("repair"));

        TableColumn<Row, ImageView> imageColumn = new TableColumn<>("Image");
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("imageView"));

// Добавление столбцов в таблицу
        tableView.getColumns().addAll(nameColumn, sectionColumn, quantityColumn, typeColumn, referenceColumn, timeColumn, repairColumn, imageColumn);

        // Создание данных для таблицы
        ObservableList<Row> data = FXCollections.observableArrayList();
        int l = 0;
        for (JsonElement jsonElem: table.jsonTable) {
            l+=1;
            System.out.println(l);


            String name = null;
            JsonElement nameElement = jsonElem.getAsJsonObject().get("name");
            if (nameElement != null && !nameElement.isJsonNull()) {
                name = nameElement.getAsString();
            }

            String section = null;
            JsonElement sectionElement = jsonElem.getAsJsonObject().get("section");
            if (sectionElement != null && !sectionElement.isJsonNull()) {
                section = sectionElement.getAsString();
            }

            String quantity = null;
            JsonElement quantityElement = jsonElem.getAsJsonObject().get("quantity");
            if (quantityElement != null && !quantityElement.isJsonNull()) {
                quantity = quantityElement.getAsString();
            }

            String type = null;
            JsonElement typeElement = jsonElem.getAsJsonObject().get("type");
            if (typeElement != null && !typeElement.isJsonNull()) {
                type = typeElement.getAsString();
            }

            String reference = null;
            JsonElement referenceElement = jsonElem.getAsJsonObject().get("reference");
            if (referenceElement != null && !referenceElement.isJsonNull()) {
                reference = referenceElement.getAsString();
            }

            String time = null;
            JsonElement timeElement = jsonElem.getAsJsonObject().get("time");
            if (timeElement != null && !timeElement.isJsonNull()) {
                time = timeElement.getAsString();
            }

            String repair = null;
            JsonElement repairElement = jsonElem.getAsJsonObject().get("repair");
            if (repairElement != null && !repairElement.isJsonNull()) {
                repair = repairElement.getAsString();
            }

            String image = null;
            JsonElement imageElement = jsonElem.getAsJsonObject().get("image");
            if (imageElement != null && !imageElement.isJsonNull()) {
                image = imageElement.getAsString();
            }

            Row row = new Row(name, section, quantity, type, reference, time, repair, image);
            data.add(row);
        }
        // Установка данных в таблицу
        tableView.setItems(data);

        // Создание сцены
        Scene scene = new Scene(tableView, 300, 200);

        // Настройка и отображение главного окна
        primaryStage.setTitle("Table View Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class Row {
        private String name;
        private String section;
        private String quantity;
        private String type;
        private String reference;
        private String time;
        private String repair;
        private String image;
        private ImageView imageView;

        public ImageView getImageView() {
            return imageView;
        }
        public Row(String name, String section, String quantity, String type, String reference, String time, String repair, String image) {
            this.name = name;
            this.section = section;
            this.quantity = quantity;
            this.type = type;
            this.reference = reference;
            this.time = time;
            this.repair = repair;
            this.image = image;
//            domain =
//            folder = "/img"
            String url = "http://rixem16044.temp.swtest.ru/img/" + image;
            System.out.println(url);
            Image img = new Image(url);
            ImageView imageView = new ImageView(img);
            imageView.setFitWidth(20);
            imageView.setFitHeight(20);
            this.imageView = imageView;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSection() {
            return section;
        }

        public void setSection(String section) {
            this.section = section;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getRepair() {
            return repair;
        }

        public void setRepair(String repair) {
            this.repair = repair;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}