
-- criar tabela para copiar no exercicio 1
Create table Cidade 
(
  IDCidade  int         not null,
  Nome      varchar(30) not null,
  UF        varchar(2)  not null,
    constraint PK_Cidade primary key (IDCidade)
);	

Create table Associado 
(
  IDAssociado    int         not null,
  Nome           varchar(50) not null,
  DataNascimento datetime    not null,
  Sexo           char(1)     not null,
  CPF            varchar(11) ,
  Endereco       varchar(35),
  Bairro         varchar(25),
  Complemento    varchar(20),
  IDCidade       int,
     constraint PK_Associado primary key (IDAssociado),
	 constraint FK_Associado foreign key (IDCidade)
	    references Cidade (IDCidade)
);

insert into Cidade (IDCidade, Nome, UF)
   values (1, 'Sao Leopoldo', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (2, 'Porto Alegre', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (3, 'Parobe', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (4, 'Taquara', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (105, 'S�o Paulo', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (106, 'Guarulhos', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (27, 'Rio de Janeiro', 'RJ');
insert into Cidade (IDCidade, Nome, UF)
   values (108, 'Brasilia', 'DF');
insert into Cidade (IDCidade, Nome, UF)
   values (109, 'Belo Horizonte', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (110, 'Uberl�ndia', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (5, 'Cidade de Alagoas', 'AL');
insert into Cidade (IDCidade, Nome, UF)
   values (6, 'Maceio', 'AL');
insert into Cidade (IDCidade, Nome, UF)
   values (7, 'Itu', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (8, 'Campinas', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (9, 'Guaratingueta', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (10, 'Santa Barbara', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (11, 'Campos dos Goitacases', 'RJ');
insert into Cidade (IDCidade, Nome, UF)
   values (12, 'Sao Gabriel', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (13, 'Brasopolis', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (14, 'Cristina', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (15, 'Umbuzeiro', 'PB');
insert into Cidade (IDCidade, Nome, UF)
   values (16, 'Vicosa', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (17, 'Macae', 'RJ');
insert into Cidade (IDCidade, Nome, UF)
   values (18, 'Sao Luis', 'MA');
insert into Cidade (IDCidade, Nome, UF)
   values (19, 'Cuiaba', 'MT');
insert into Cidade (IDCidade, Nome, UF)
   values (20, 'Sao Borja', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (21, 'Natal', 'RN');
insert into Cidade (IDCidade, Nome, UF)
   values (22, 'Diamantina', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (23, 'Campo Grande', 'MS');
insert into Cidade (IDCidade, Nome, UF)
   values (24, 'Fortaleza', 'CE');
insert into Cidade (IDCidade, Nome, UF)
   values (25, 'Bage', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (26, 'Bento Goncalves', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (28, 'Pinheiro', 'MA');
insert into Cidade (IDCidade, Nome, UF)
   values (29, 'Salvador', 'BA');
insert into Cidade (IDCidade, Nome, UF)
   values (30, 'Garanhuns', 'PE');
Insert into Cidade (IDCidade, Nome, UF)
   values (31, 'S�o Paulo', 'SP');    
Insert into Cidade (IDCidade, Nome, UF)
   values (32, 'Guarulhos', 'SP');    
Insert into Cidade (IDCidade, Nome, UF)
   values (33, 'Rio de Janeiro', 'RJ');    
Insert into Cidade (IDCidade, Nome, UF)
   values (34, 'Brasilia', 'DF');    
Insert into Cidade (IDCidade, Nome, UF)
   values (35, 'Belo Horizonte', 'MG');        
Insert into Cidade (IDCidade, Nome, UF)
   values  (36, 'Uberl�ndia', 'MG');      
Insert into Cidade (IDCidade, Nome, UF)
   values  (37, 'Santana do Livramento', 'RS');
Insert into Cidade (IDCidade, Nome, UF)
   values  (38, 'Santa Maria', 'RS');
Insert into Cidade (IDCidade, Nome, UF)
   values  (39, 'Santa Rosa', 'RS');
Insert into Cidade (IDCidade, Nome, UF)
   values  (40, 'S�o Francisco de Paula', 'RS');    

-- ASSOCIADOS...
insert into Associado 
      (IDAssociado, 
       Nome, 
       DataNascimento, 
       Sexo)
  values 
      (1, 
       'Ana Paula Padrao', 
       convert(datetime, '10/05/1980', 103), 
       'F' );
--
insert into Associado 
      (IDAssociado, 
       Nome, 
       DataNascimento, 
       Sexo)
  values  
      (2, 
       'Joao Soares', 
       convert(datetime, '20/02/1980', 103), 
       'M' );

--exercicio 1
Select * into CidadeAux from Cidade;

--exercicio 2
truncate table CidadeAux;

Select * from CidadeAux;

Insert into CidadeAux (IDCidade, Nome, UF) 
		Select IDCidade, Nome, UF 
		From Cidade 
		Where UF = 'RS';

-- exercicio 3
Create table Produto 
(
  IDProduto        int identity   not null,
  NomeCurto        varchar(30)    not null,
  NomeDescritivo   varchar(100)   not null,
  DataCriacao      datetime       not null,
  LocalEstoque     varchar(100)   not null,
  Quantidade       int            not null,
  Preco            decimal(16,2)  not null,
    constraint PK_Produto primary key (IDProduto)
);	

-- exercicio 4 
insert into Produto(NomeCurto,NomeDescritivo,DataCriacao,LocalEstoque,Quantidade,Preco)
values ('bola','bola de volei', getdate() , 'prateleira 2', 5, 100.0);

insert into Produto(NomeCurto,NomeDescritivo,DataCriacao,LocalEstoque,Quantidade,Preco)
values ('bolsa','bola de couro preta', getdate(), 'balcao 77', 100, 329.0);

Select * from Produto

drop table Produto

select getdate() -- getdate : metodo que pega a hora do servidor 

-- select CONVERT( DATE, '28/04/2017', 103) : converte pro padr�o brasil de horario 


--SELECT : APELIDOS FUNCIONAM S� PARA PROJE��O, PARA NOMES COM ESPA�O USAR COLCHETES 