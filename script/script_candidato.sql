select * from cargo;

select * from cidade order by qt_vereadores ;

select * from cidade where qt_vereadores > 9 ;

select count(*) from cidade where qt_vereadores > 9 ;

select max(qt_vereadores) from cidade ; 

select c.nome from cidade c where qt_vereadores = (select max(qt_vereadores) from cidade) ;

select c.nome, cargo.nome
from candidato c 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito'
order by c.nome;

select c.nome vereador
from candidato c
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador'
where c.nome like '%MARIA %'
order by c.nome;

select c.nome vereador
from candidato c
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador'
where c.nome like 'Y%'
order by c.nome;

select cidade.nome cidade, candidato.nome candidato
from cidade 
inner join candidato on candidato.cidade = cidade.id 
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
order by cidade.nome, candidato.nome;

select c.nome, cid.nome
from cidade cid 
inner join candidato c on c.cidade = cid.id and cid.nome = 'TUBARÃO'
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito' 
order by c.nome; 

select c.nome, cid.qt-eleitores
from cidade cid
inner join candidato c on cid.nome =(select max(qt_eleitores) from cidade)
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito'
order by c.nome;

select c.cidade , cidade.nome 
from candidato c
inner join cidade.nome on c.cidade = cidade.id and cidade.nome = 'TUBARÃO'
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador'
inner join 

select count(*) from candidato c where 