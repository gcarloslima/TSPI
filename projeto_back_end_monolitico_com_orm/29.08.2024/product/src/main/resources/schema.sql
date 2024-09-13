CREATE TABLE nota_fiscal (
  id INT PRIMARY KEY,
  id_nf INT,
  id_item INT,
  cod_prod INT,
  valor_unit DECIMAL(10, 2),
  quantidade INT,
  desconto DECIMAL(10, 2)
);
