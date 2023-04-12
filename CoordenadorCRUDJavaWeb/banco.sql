create database
  IF NOT EXISTS tedweb;

create table
  IF NOT EXISTS coordenador(id serial PRIMARY KEY, nome varchar(60));

create table
  IF NOT EXISTS cursos(
    id serial PRIMARY KEY,
    nome varchar(60),
    sigla varchar(60)
  );

create table
  IF NOT EXISTS periodos(
    id serial PRIMARY KEY,
    dia varchar(60),
    horario varchar(60)
  );

create table
  IF NOT EXISTS cursos_coordenador(
    id_coordenador int,
    id_curso int,
    CONSTRAINT fk_coordenador_cursos FOREIGN KEY(id_coordenador) REFERENCES coordenador(id),
    CONSTRAINT fk_cursos_coordenador FOREIGN KEY(id_curso) REFERENCES cursos(id)
  );

create table
  IF NOT EXISTS periodos_coordenador(
    id_coordenador int,
    id_periodo int,
    CONSTRAINT fk_coordenador_periodos FOREIGN KEY(id_coordenador) REFERENCES coordenador(id),
    CONSTRAINT fk_periodos_coordenador FOREIGN KEY(id_periodo) REFERENCES periodos(id)
  );

INSERT INTO
  cursos(id, nome, sigla)
values
  (1, 'Engenharia de Software', 'BES'),
  (2, 'Medicina', 'MED')
  (3, 'Análise e Dessenvolvimento de Sistemas', 'ADS'),
  (4, 'Direito', 'DIR'),
  (5, 'Nutrição', 'NUTRI'),
  (6, 'Psicologia', 'PSI'),
  (7, 'Engenharia Elétrica', 'ENG.ELE'),
  (8, 'Engenharia Mecânica', 'ENG.MEC'),
  (9, 'Matemática', 'MAT'),
  (8, 'Física', 'FIS'),
  (9, 'Bio Medicina', 'BIO MED'),
  (10, 'Educação Física', 'ED.FIS'),


  ;

INSERT INTO
  periodos(id, dia, horario)
values
  (1, 'Segunda', '7:00-8:15'),
  (2, 'Segunda', '8:25-9:40'),
  (3, 'Segunda', '9:50-11:05'),
  (4, 'Segunda', '11:15-12:30'),
  
  (5, 'Terca', '7:00-8:15'),
  (6, 'Terca', '8:25-9:40'),
  (7, 'Terca', '9:50-11:05'),
  (8, 'Terca', '11:15-12:30'),
  
  (9,  'Quarta', '7:00-8:15'),
  (10, 'Quarta', '8:25-9:40'),
  (11, 'Quarta', '9:50-11:05'),
  (12, 'Quarta', '11:15-12:30'),

  (13, 'Quinta', '7:00-8:15'),
  (14, 'Quinta', '8:25-9:40'),
  (15, 'Quinta', '9:50-11:05'),
  (16, 'Quinta', '11:15-12:30'),
  
  
  (17, 'Sexta', '7:00-8:15'),
  (18, 'Sexta', '8:25-9:40'),
  (19, 'Sexta', '9:50-11:05'),
  (20, 'Sexta', '11:15-12:30'),
  
  (21, 'Sabado', '7:00-8:15'),
  (22, 'Sabado', '8:25-9:40'),
  (23, 'Sabado', '9:50-11:05'),
  (24, 'Sabado', '11:15-12:30'),
  
  ;


SELECT
  c.id as idCoordenador,
  c.nome as NomeCoordenador,
  cu.id as idCurso,
  cu.nome as nomeCurso,
  cu.sigla as siglaCurso,
  p.id as idPeriodo,
  p.dia as diaPeriodo,
  p.horario as horarioPeriodo
FROM
  coordenador c
  INNER JOIN cursos_coordenador cc on cc.id_coordenador = c.id
  INNER JOIN cursos cu on cu.id = cc.id_curso
  INNER JOIN periodos_coordenador pc on pc.id_coordenador = c.id
  INNER JOIN periodos p on p.id = pc.id_periodo;