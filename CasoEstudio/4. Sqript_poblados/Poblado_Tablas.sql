INSERT INTO public.funcionarios
(funcionario_id, numero_documento, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento)
VALUES(nextval('funcionarios_funcionario_id_seq'::regclass), 87654321, 'Maria Fernanda', 'Garcia­a Torres', 'Casada',
'F', 'CAvenida Siempre Viva 456, Ciudad, PaÃ­s', '+34 987 654 321', '1985-11-30');


INSERT INTO public.funcionarios
( numero_documento, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento)
VALUES( '4382743783', 'Maria Alejandra', 'Ramos Flores', 'casada', ' ', 'Calle3 423', '+57 323415423', '2000-03-11');

UPDATE public.funcionarios
SET numero_documento='12345678', nombres='Juan Jose', apellidos='Perez Herrata', estado_civil='Soltero', sexo='M ', direccion='Calle Falsa 123, Sao Paulo, Brazil', telefono='+34 123 456 789', fecha_nacimiento='1990-05-15'
WHERE funcionario_id=1;


UPDATE public.funcionarios
SET numero_documento='1043783', nombres='Maira ', apellidos='Vargas Herrera', estado_civil='Casada', sexo='F ', direccion='Calle 7 89', telefono='+57314456123', fecha_nacimiento='1999-12-25'
WHERE funcionario_id=2;




--posibles consultas


select * from estadoformacion e ;
select * from estadosciviles e ;
select * from formacionacademica f ;
select * from funcionarios f  ;
select * from grupofamiliar g ;
select * from niveleducativo n ;
select * from rolgrupofamiliar r ;
select * from tiposdocumentos t ;
select * from universidad u ;