CREATE CACHED TABLE tb_cliente  ( 
	cpf CHAR(11) NOT NULL,
	nome VARCHAR(100) NOT NULL,
	PRIMARY KEY(cpf)
);
	
CREATE CACHED TABLE tb_gerente  ( 
	id INTEGER NOT NULL IDENTITY,
	nome VARCHAR(100) NOT NULL,
	fone CHAR(12) NOT NULL,
	celular CHAR(12) NOT NULL,
	email CHAR(50) NOT NULL,
	PRIMARY KEY(id) 
);

CREATE CACHED TABLE tb_conta    (
	id INTEGER NOT NULL IDENTITY,
	tb_cliente_cpf CHAR(11) NOT NULL,
	numero VARCHAR(10) NOT NULL,
	saldo DECIMAL(16,4) NOT NULL,
	tipo TINYINT NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(tb_cliente_cpf) REFERENCES tb_cliente(cpf) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE CACHED TABLE tb_endereco (
	tb_cliente_cpf CHAR(11) NOT NULL,
	CEP CHAR(8) NULL,
	numero CHAR(5) NULL,
	Complemento CHAR(100) NULL,
	PRIMARY KEY(tb_cliente_cpf),
	FOREIGN KEY(tb_cliente_cpf) REFERENCES tb_cliente(cpf) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE CACHED TABLE tb_gerentes_cliente (
	tb_gerente_id INTEGER NOT NULL,
	tb_cliente_cpf CHAR(11) NOT NULL,
	PRIMARY KEY(tb_gerente_id, tb_cliente_cpf),
	FOREIGN KEY(tb_gerente_id) REFERENCES tb_gerente(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
	FOREIGN KEY(tb_cliente_cpf) REFERENCES tb_cliente(cpf) ON DELETE NO ACTION ON UPDATE NO ACTION
);