Create database Alke_Wallet;

use Alke_Wallet;

CREATE TABLE Usuarios (
  USU_ID INT NOT NULL AUTO_INCREMENT,
  USU_NAME VARCHAR(45) NOT NULL,
  USU_EMAIL VARCHAR(45) NOT NULL,
  USU_PASSWORD VARCHAR(45) NOT NULL,
  PRIMARY KEY (USU_ID)
  );
  
CREATE TABLE Monedas (
  CURR_ID INT NOT NULL UNIQUE,
  CURR_NAME VARCHAR(45) NOT NULL UNIQUE,
  CURR_SYMBOL VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (CURR_ID)
  );

CREATE TABLE Cuentas (
  CUENTA_ID INT NOT NULL AUTO_INCREMENT UNIQUE,
  USU_ID INT NOT NULL,
  CUENTA_SALDO DECIMAL (10.2) NOT NULL,
  CURR_ID INT NOT NULL,
  PRIMARY KEY (CUENTA_ID),
  FOREIGN KEY (USU_ID) REFERENCES Alke_Wallet.Usuarios (USU_ID),
  FOREIGN KEY (CURR_ID) REFERENCES Alke_Wallet.Monedas (CURR_ID)
);

CREATE TABLE Alke_Wallet.Transacciones (
  TRANS_ID INT NOT NULL UNIQUE AUTO_INCREMENT,
  TRANS_IMPORTE DECIMAL (10.2) NOT NULL,
  TRANS_DATE DATE NOT NULL,
  SENDER_CUENTA_ID INT NOT NULL,
  RECEIVER_CUENTA_ID INT NOT NULL,
  PRIMARY KEY (TRANS_ID),
  FOREIGN KEY (SENDER_CUENTA_ID) REFERENCES Alke_Wallet.Cuentas (CUENTA_ID),
  FOREIGN KEY (RECEIVER_CUENTA_ID) REFERENCES Alke_Wallet.Cuentas (CUENTA_ID),
  CHECK (RECEIVER_CUENTA_ID != SENDER_CUENTA_ID)
);

CREATE TABLE Alke_Wallet.Contactos (
  CONT_ID INT NOT NULL AUTO_INCREMENT,
  CONT_NOMBRE VARCHAR(45),
  CONT_RUT VARCHAR(10) NOT NULL,
  CONT_N_CUENTA INT NOT NULL,
  USU_ID INT NOT NULL,
  PRIMARY KEY (CONT_ID),
  FOREIGN KEY (USU_ID) REFERENCES Alke_Wallet.usuarios (USU_ID)
  );
  
  INSERT INTO Alke_Wallet.Usuarios (USU_NAME, USU_EMAIL, USU_PASSWORD) VALUE 
  ('Roberto', 'roberto@gmail.com', '12345'),
  ('Manuel', 'manu123@gmail.com', 'asddfg'),
  ('Leonardo', 'leodelosfanchis@hotmail.com', 'j3g4u4ij'),
  ('Cintia', 'cintiaperalta@gmail.com', '888d8d78'),
  ('Manuela', 'manuelita@gmail.com', 'fgfgfgf'),
  ('Roberto', 'robin@hotmail.com',  'contraseña'),
  ('Josefa', 'josejose888@gmail.com', 'password'),
  ('Iris', 'siriris@gmail.com', 'holamundo');

INSERT INTO Alke_Wallet.Monedas (CURR_ID, CURR_NAME, CURR_SYMBOL) VALUE 
(1, 'Dolar estadounidense', '$$'),
(2, 'Euro', '€'),
(3, 'Yuan', '¥'),
(4, 'Peso chileno', '$');

INSERT INTO Alke_Wallet.Cuentas (USU_ID, CUENTA_SALDO, CURR_ID) VALUE 
(1, 500000, 3), 
(1, 750000, 4), 
(1, 200000, 1), 
(2, 1000000, 4), 
(2, 400000, 4), 
(3, 99900, 1), 
(4, 10000, 3), 
(5, 1000000, 1), 
(5, 500000, 4), 
(6, 500500, 4), 
(7, 100000, 2), 
(7, 5000, 1), 
(7, 1000000, 2), 
(8, 5000, 1);

INSERT INTO Alke_Wallet.Contactos (CONT_NOMBRE, CONT_RUT, CONT_N_CUENTA, USU_ID) VALUE 
('Patricio', '17876698-2', 123, 1), 
('Amadis', '14686309-5', 234, 2), 
('Miguel', '20874532-0', 345, 3), 
('José', '19967342-6', 456, 3), 
('Alfonsina', '18098346-2', 567, 4), 
('Sabrina', '22009875-1', 678, 5), 
('Magdalena', '16711874-7', 789, 6), 
('Héctor', '20765091-1', 987, 7), 
('Milenko', '13009666-K', 876, 7), 
('Amelia', '18478396-1', 765, 8);

INSERT INTO Alke_Wallet.Transacciones (TRANS_IMPORTE, TRANS_DATE, SENDER_CUENTA_ID, RECEIVER_CUENTA_ID) VALUE 
(500000, '2024-03-01', 14, 7), 
(5000, '2024-03-02', 2, 3), 
(40000, '2024-03-03', 13, 1), 
(340000, '2024-03-04', 13, 4), 
(32000, '2024-03-05', 5, 1), 
(5900, '2024-03-06', 13, 6), 
(10000, '2024-03-07', 4, 7), 
(200900, '2024-03-08', 6, 7), 
(2000, '2024-03-09', 2, 1), 
(5400, '2024-03-10', 4, 5), 
(98700, '2024-03-11', 6, 7), 
(33000, '2024-03-12', 4, 7);

-- Consulta para obtener el nombre de la moneda elegida por un usuario específico
SELECT CURR_NAME FROM Monedas WHERE CURR_ID IN (
	SELECT CURR_ID FROM Cuentas WHERE USU_ID=?
);

-- Consulta para obtener todas las transacciones registradas
SELECT * FROM Transacciones;

-- Consulta para obtener todas las transacciones realizadas por un usuario específico
SELECT * FROM Transacciones WHERE SENDER_CUENTA_ID IN 
	(SELECT CUENTA_ID FROM Cuentas WHERE USU_ID=?) OR RECEIVER_CUENTA_ID IN 
    (SELECT CUENTA_ID FROM Cuentas WHERE USU_ID=?);

-- Sentencia DML para modificar el campo correo electrónico de un usuario específico
UPDATE Usuarios
SET USU_EMAIL = "nuevo_correo@correo.com"
WHERE USU_ID = ?;

-- Sentencia para eliminar los datos de una transacción (eliminado de la fila completa)
DELETE FROM Transacciones WHERE TRAN_ID = ?;