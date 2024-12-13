CREATE TABLE Vagon_Class(
	id VARCHAR(25) PRIMARY KEY,
    number_of_elements int,
    stand_up_capacity INT,
    class_price_index float
);

CREATE TABLE Vagon (
   id INT AUTO_INCREMENT PRIMARY KEY,
   vagon_class VARCHAR(25),
   FOREIGN KEY (vagon_class) REFERENCES Vagon_Class(id)
);

CREATE TABLE TrainLoadedVagons (
   id INT NOT NULL PRIMARY KEY,
   train_id INT NULL,
   FOREIGN KEY (train_id) REFERENCES Train(id)
);

CREATE TABLE TrainVagon(
    train_loaded_vagons_id INT,
    vagon_id INT,
    vagon_index INT,

    FOREIGN KEY (train_loaded_vagons_id) REFERENCES TrainLoadedVagons(id),
    FOREIGN KEY (vagon_id) REFERENCES Vagon(id)
);


