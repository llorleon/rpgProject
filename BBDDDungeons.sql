use dungeon;

CREATE TABLE hechizo(
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY ( nombre ),
puntosAtaque INT,
costeMana INT
);



INSERT INTO hechizo VALUES ('Bola de Fuego',10,5);
INSERT INTO hechizo VALUES ('Descarga de Escarcha',7,3);



CREATE TABLE mago(
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY ( nombre ),
vida INT,
ataque INT,
defensa INT,
hechizo VARCHAR(100),
FOREIGN KEY (hechizo) REFERENCES hechizo(nombre)
);

ALTER TABLE mago ADD COLUMN mana INTEGER;


INSERT INTO mago VALUES ('Gideon',100,4,8,'Bola de Fuego',100);


CREATE TABLE guerrero(
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY ( nombre ),
vida INT,
ataque INT,
defensa INT
);

INSERT INTO guerrero VALUES ('Freekiller',120,7,10);

CREATE TABLE arquero(
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY ( nombre ),
vida INT,
ataque INT,
defensa INT
);

INSERT INTO arquero VALUES ('Laion',80,10,6);


CREATE TABLE enemigo(
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY ( nombre ),
vida INT,
ataque INT,
defensa INT
);

INSERT INTO enemigo VALUES ('Globlin Escavador',20,3,2);
INSERT INTO enemigo VALUES ('Globlin Mimico',40,1,6);
INSERT INTO enemigo VALUES ('Globlin Escondido',20,7,1);
INSERT INTO enemigo VALUES ('Orco bufon',15,3,5);
INSERT INTO enemigo VALUES ('Naga Arquero',20,5,2);
INSERT INTO enemigo VALUES ('Elemental de Tierra',30,2,7);
INSERT INTO enemigo VALUES ('Diablillo',10,5,2);
INSERT INTO enemigo VALUES ('Golem de Piedra',18,7,8);
INSERT INTO enemigo VALUES ('Señor del Foso',28,5,4);
INSERT INTO enemigo VALUES ('Sucubo',13,6,6);
INSERT INTO enemigo VALUES ('Zombie Descerebrado',12,3,6);
INSERT INTO enemigo VALUES ('Elemental del Vacio',30,4,6);

CREATE TABLE jefeFinal(
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY ( nombre ),
vida INT,
ataque INT,
defensa INT
);

INSERT INTO jefeFinal VALUES ('Cermuzork, El Goblin Primigenio',80,5,7);

CREATE TABLE arma(
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY ( nombre ),
puntosDeAtaque INT
);

INSERT INTO arma VALUES ('Arco Curvo',10);
INSERT INTO arma VALUES ('Espadon',7);

CREATE TABLE objetoDefensivo(
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY ( nombre ),
puntosDeDefensa INT
);
INSERT INTO objetoDefensivo VALUES ('Tunica de Mago',2);
INSERT INTO objetoDefensivo VALUES ('Armadura de Cuero',4);
INSERT INTO objetoDefensivo VALUES ('Cota de malla',7);

CREATE TABLE pocionVida(
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY ( nombre ),
vidaRecuperada INT
);

INSERT INTO pocionVida VALUES ('Frasco Estus',15);


CREATE TABLE pocionMana(
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY ( nombre ),
manaRecuperado INT
);

INSERT INTO pocionMana VALUES ('Pocion Mana',20);

CREATE TABLE lugares (
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY ( nombre )
);

INSERT INTO lugares VALUES ('Pantano humedo');
INSERT INTO lugares VALUES ('Cienaga de la bruja');
INSERT INTO lugares VALUES ('Cenec'); #ENEMIGO FINAL
INSERT INTO lugares VALUES ('Fortaleza de Freekiller');
INSERT INTO lugares VALUES ('Cueva Goblin');
INSERT INTO lugares VALUES ('Pradera loca');
INSERT INTO lugares VALUES ('Crisol de los Goblins');
INSERT INTO lugares VALUES ('Sotano satanico');
INSERT INTO lugares VALUES ('Templo Oscuro');
INSERT INTO lugares VALUES ('Camaras Mogu');
INSERT INTO lugares VALUES ('Solio del Trueno');
INSERT INTO lugares VALUES ('Fortaleza Orca');
INSERT INTO lugares VALUES ('Sima Ignea');
INSERT INTO lugares VALUES ('Cavernas de los lamentos');
INSERT INTO lugares VALUES ('Monasterio Escarlata');
INSERT INTO lugares VALUES ('Profundidades Roca Negra');
INSERT INTO lugares VALUES ('Bancal del Magiste');
INSERT INTO lugares VALUES ('El Nexo');
INSERT INTO lugares VALUES ('Forja de Almas');
INSERT INTO lugares VALUES ('Villa Dorada');
INSERT INTO lugares VALUES ('Naxxramas');
INSERT INTO lugares VALUES ('Sagrario Obsidiana');
INSERT INTO lugares VALUES ('Ulduar');
INSERT INTO lugares VALUES ('Sagrario Rubí');




