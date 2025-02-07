INSERT INTO NACatalogo (IdCatalogoPadre, Nombre, Detalle)
VALUES (NULL, 'HormigaTipo', 'Tipos de Hormigas'),
    (NULL, 'HormigaSexo', 'Sexo de Hormigas'),
    (NULL, 'HormigaEstado', 'Estado de Hormigas'),
    (
        NULL,
        'GenoAlimento',
        'Tipos de Genes Alimenticios'
    ),
    (NULL, 'IngestaNativa', 'Tipos de Dieta');
INSERT INTO NACatalogo (IdCatalogoPadre, Nombre, Detalle)
VALUES (1, 'Larva', 'Etapa inicial'),
    (1, 'Rastreadora', 'Busca alimento y rutas');
INSERT INTO NACatalogo (IdCatalogoPadre, Nombre, Detalle)
VALUES (2, 'Macho', 'Sexo masculino'),
    (2, 'Hembra', 'Sexo femenino'),
    (2, 'Asexual', 'Sin sexo');
INSERT INTO NACatalogo (IdCatalogoPadre, Nombre, Detalle)
VALUES (3, 'Viva', 'Hormiga activa'),
    (3, 'Muerta', 'Hormiga inactiva');
INSERT INTO NACatalogo (IdCatalogoPadre, Nombre, Detalle)
VALUES (4, 'X', 'Gen X'),
    (4, 'XX', 'Gen XX'),
    (4, 'XY', 'Gen XY');
INSERT INTO NACatalogo (IdCatalogoPadre, Nombre, Detalle)
VALUES (5, 'Carnívoro', 'Dieta a base de carne'),
    (5, 'Herbívoro', 'Dieta a base de plantas'),
    (5, 'Omnívoro', 'Dieta variada'),
    (5, 'Insectívoro', 'Dieta a base de insectos'),
    (5, 'Nectarívoro', 'Dieta a base de nectar');
INSERT INTO NAHormiga (
        IdCatalogoTipo,
        IdCatalogoSexo,
        IdCatalogoEstado,
        IdCatalogoGenoAlimento,
        IdCatalogoIngestaNativa,
        Nombre
    )
VALUES (6, 10, 11, 13, 16, 'Juana'),
    (7, 8, 11, 14, 19, 'Pepe'),
    (6, 9, 12, 15, 17, 'Luisa'),
    (6, 8, 11, 13, 18, 'Maria');