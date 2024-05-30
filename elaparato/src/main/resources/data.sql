--Para poder ejecutar este archivo se debió haber creado anteriormente la tabla elaparato
--de igual manera se tuvo que haber ejecutado el proyecto de Spring Boot y creado las siguientes tablas de forma automática:
--producto, venta, producto_lista_ventas, producto_seq, venta_seq

--En caso de que así sea, ejecutar las siguientes consultas SQL:

--Insertar productos
INSERT INTO Producto (id, nombre, descripcion, precio, cantidad)
VALUES
  (1, 'Lavadora Samsung', 'Lavadora de carga frontal con capacidad de 15 kg', 1299.99, 10),
  (2, 'Refrigeradora LG', 'Refrigeradora de 3 puertas con capacidad de 25 pies cúbicos', 1599.99, 5),
  (3, 'Televisor Sony', 'Televisor LED 4K de 55 pulgadas con Android TV', 899.99, 15),
  (4, 'Horno eléctrico Whirlpool', 'Horno eléctrico de acero inoxidable con capacidad de 6.4 pies cúbicos', 799.99, 7),
  (5, 'Aspiradora Dyson', 'Aspiradora inalámbrica con tecnología Cyclone V10', 499.99, 20);
--
----Insertar Ventas
INSERT INTO Venta (id_venta, fecha)
VALUES
  (1, '2023-01-15'),
  (2, '2023-02-05'),
  (3, '2023-03-10'),
  (4, '2023-04-20'),
  (5, '2023-05-01');
--
----Insertar los productos comprados en cada venta
INSERT INTO producto_sales_list (product_list_id, sales_list_id_venta)
VALUES
  (1, 1),
  (2, 1),
  (3, 1),
  (1, 2),
  (4, 2),
  (2, 3),
  (5, 3),
  (3, 3),
  (1, 4),
  (2, 4),
  (5, 4),
  (3, 5),
  (4, 5);

--Modificar las secuencias de producto_seq
--UPDATE producto_seq
--SET next_val = 6;

--Modificar las secuencias de venta_seq
--UPDATE venta_seq
--SET next_val = 6;