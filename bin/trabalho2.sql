-- Database: trabalho2


CREATE TABLE nome_produto (
    id SERIAL PRIMARY KEY  NOT NULL,
    descricao VARCHAR(255),
    categoria VARCHAR(100),
    preco_custo DECIMAL(10, 2),
    preco_venda DECIMAL(10, 2),
    quantidade INTEGER,
    data_entrada DATE
);

select * from nome_produto

select count(*) from nome_produtos where id = ?


delete from nome_produto