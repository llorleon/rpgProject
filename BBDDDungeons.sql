use dungeon;


#Creamos tabla Arma, que referencia a objeto con Nombre, usamos como FK el PK del objeto con Nombre
CREATE TABLE arma(
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY ( nombre ),
puntosAtaque INT NOT NULL
);
INSERT INTO arma (nombre,puntosAtaque) VALUES ('Espada de Madera',2);
INSERT INTO arma (nombre,puntosAtaque) VALUES ('Daga Dentada',4);
INSERT INTO arma (nombre,puntosAtaque) VALUES ('Arco Curvo',7);
INSERT INTO arma (nombre,puntosAtaque) VALUES ('Hacha de Guerra',6);
INSERT INTO arma (nombre,puntosAtaque) VALUES ('Bastón Cariano',4);

DROP TABLE arma;
SELECT * FROM arma;

#Creamos tabla objetoDefensivo, que referencia a objeto con Nombre, usamos como FK el PK del objeto con Nombre
CREATE TABLE objetoDefensivo(
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY ( nombre ),
puntosDefensivos INT NOT NULL
);
INSERT INTO objetoDefensivo (nombre,puntosDefensivos) VALUES ('Saco de Harina',2);
INSERT INTO objetoDefensivo (nombre,puntosDefensivos) VALUES ('Armadura de Cuero',5);
INSERT INTO objetoDefensivo (nombre,puntosDefensivos) VALUES ('Cota de Malla',6);
INSERT INTO objetoDefensivo (nombre,puntosDefensivos) VALUES ('Armadura de placas de Hierro',8);
INSERT INTO objetoDefensivo (nombre,puntosDefensivos) VALUES ('Tunica de Mago',4);

DROP TABLE objetoDefensivo;

SELECT * FROM objetoDefensivo;

CREATE TABLE pocionVida(
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY ( nombre ),
vidaRecuperada INT NOT NULL
);

INSERT INTO pocionVida (nombre,vidaRecuperada) VALUES ('Frascos de Estus',15);



CREATE TABLE pocionMana(
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY ( nombre ),
manaRecuperada INT NOT NULL
);

INSERT INTO pocionMana (nombre,manaRecuperada) VALUES ('Frasco de Mana',20);
