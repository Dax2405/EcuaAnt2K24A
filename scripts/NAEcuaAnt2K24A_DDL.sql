DROP TABLE IF EXISTS NAHormiga;
DROP TABLE IF EXISTS NACatalogo;
CREATE TABLE NACatalogo (
    IdCatalogo INTEGER PRIMARY KEY AUTOINCREMENT,
    IdCatalogoPadre INTEGER,
    Nombre VARCHAR(20) UNIQUE NOT NULL,
    Detalle VARCHAR(50),
    Estado CHAR(1) DEFAULT 'A' NOT NULL,
    FechaCrea DATETIME DEFAULT (datetime('now', 'localtime')) NOT NULL,
    FechaModifica DATETIME,
    FOREIGN KEY (IdCatalogoPadre) REFERENCES NACatalogo(IdCatalogo)
);
CREATE TABLE NAHormiga (
    IdHormiga INTEGER PRIMARY KEY AUTOINCREMENT,
    IdCatalogoTipo INTEGER NOT NULL,
    IdCatalogoSexo INTEGER NOT NULL,
    IdCatalogoEstado INTEGER NOT NULL,
    IdCatalogoGenoAlimento INTEGER,
    IdCatalogoIngestaNativa INTEGER,
    Nombre VARCHAR(20),
    Evolucionado BOOLEAN DEFAULT 0 NOT NULL,
    Estado CHAR(1) DEFAULT 'A' NOT NULL,
    FechaCrea DATETIME DEFAULT (datetime('now', 'localtime')) NOT NULL,
    FechaModifica DATETIME,
    FOREIGN KEY (IdCatalogoTipo) REFERENCES NACatalogo(IdCatalogo),
    FOREIGN KEY (IdCatalogoSexo) REFERENCES NACatalogo(IdCatalogo),
    FOREIGN KEY (IdCatalogoEstado) REFERENCES NACatalogo(IdCatalogo),
    FOREIGN KEY (IdCatalogoGenoAlimento) REFERENCES NACatalogo(IdCatalogo),
    FOREIGN KEY (IdCatalogoIngestaNativa) REFERENCES NACatalogo(IdCatalogo)
);