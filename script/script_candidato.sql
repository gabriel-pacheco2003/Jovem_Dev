select * from cargo;

select * from cidade order by qt_vereadores ;

select * from cidade where qt_vereadores > 9 ;

select count(*) from cidade where qt_vereadores > 9 ;

select max(qt_vereadores) from cidade ; 

select c.nome from cidade c where qt_vereadores = (select max(qt_vereadores) from cidade) ;

select * from candidato c where cargo = 1 order by c.nome; 

select * from candidato where cargo = 2 order by nome like 'MARIA';

select c.nome from candidato c where c.cargo = 2 order by c.nome like 'Y%';

select c.nome from candidato c
inner join cidade city 
on city.id = c.cidade where c.cargo = 1 ; 