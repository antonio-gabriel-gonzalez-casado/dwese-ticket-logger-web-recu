-- Inserts de las Comunidades Autónomas, ignora si se produce un error en la insercción
INSERT IGNORE INTO regions (id, code, name) VALUES
(1, '01', 'ANDALUCÍA'),
(2, '02', 'ARAGÓN'),
(3, '03', 'ASTURIAS'),
(4, '04', 'BALEARES'),
(5, '05', 'CANARIAS'),
(6, '06', 'CANTABRIA'),
(7, '07', 'CASTILLA Y LEÓN'),
(8, '08', 'CASTILLA-LA MANCHA'),
(9, '09', 'CATALUÑA'),
(10, '10', 'COMUNIDAD VALENCIANA'),
(11, '11', 'EXTREMADURA'),
(12, '12', 'GALICIA'),
(13, '13', 'MADRID'),
(14, '14', 'MURCIA'),
(15, '15', 'NAVARRA'),
(16, '16', 'PAÍS VASCO'),
(17, '17', 'LA RIOJA'),
(18, '18', 'CEUTA Y MELILLA');


-- Insertar algunas categorias en la tabla 'categories'
INSERT IGNORE INTO categories (id, name, image, parent_id) VALUES
(1, 'Electrónica', NULL, NULL),
(2, 'Ropa', NULL, NULL),
(3, 'Hogar y Cocina', NULL, NULL),
(4, 'Smartphones', NULL, 1),
(5, 'Portátiles', NULL, 1),
(6, 'Televisores', NULL, 1),
(7, 'Ropa de Hombre', NULL, 2),
(8, 'Ropa de Mujer', NULL, 2),
(9, 'Ropa Infantil', NULL, 2),
(10, 'Muebles', NULL, 3),
(11, 'Electrodomésticos de Cocina', NULL, 3),
(12, 'Decoración', NULL, 3);
