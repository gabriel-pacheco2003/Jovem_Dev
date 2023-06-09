//1
select * from cargo;

//2
select * from cidade order by qt_vereadores ;

//3
select * from cidade where qt_vereadores > 9 ;

//4
select count(*) from cidade where qt_vereadores > 9 ;

//5
select max(qt_vereadores) from cidade ; 

//6
select c.nome from cidade c where qt_vereadores = (select max(qt_vereadores) from cidade) ;

//7
select c.nome, cargo.nome
from candidato c 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito'
order by c.nome;

//8
select c.nome vereador
from candidato c
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador'
where c.nome like '%MARIA %'
order by c.nome;

//9
select c.nome vereador
from candidato c
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador'
where c.nome like 'Y%'
order by c.nome;

//10
select cidade.nome cidade, candidato.nome candidato
from cidade 
inner join candidato on candidato.cidade = cidade.id 
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
order by cidade.nome, candidato.nome;

//11
select c.nome, cid.nome
from cidade cid 
inner join candidato c on c.cidade = cid.id and cid.nome = 'TUBARÃO'
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito' 
order by c.nome; 

//12
select c.nome
from candidato c
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito'
inner join cidade cid on cid.id = c.cidade and cid.qt_eleitores = (select max(qt_eleitores) from cidade)
order by c.nome;

//13
select count(*)
from candidato c
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador'
inner join cidade on c.cidade = cidade.id and cidade.nome = 'TUBARÃO'; 

//14
select cidade.nome, count(*)
from candidato c 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador'
inner join cidade on c.cidade = cidade.id 
group by cidade.nome 
order by cidade.nome;

//15
select cargo.nome, vi.nulos, vi.brancos
from cargo 
inner join voto_invalido vi on vi.cargo = cargo.id 
inner join cidade on cidade.id = vi.cidade and cidade.nome = 'TUBARÃO'; 

//16
select vi.nulos + vi.brancos as total
from cargo 
inner join voto_invalido vi on vi.cargo = cargo.id and cargo.nome = 'Prefeito' 
inner join cidade on cidade.id = vi.cidade and cidade.nome = 'TUBARÃO';

//17
select candidato.nome, voto.voto
from candidato 
inner join voto on voto.candidato = candidato.id 
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
order by voto desc;

//18
select candidato.nome, voto.voto as votos
from candidato 
inner join voto on voto.candidato = candidato.id 
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Vereador'
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
order by votos desc;

//19
select cidade.nome, max(voto.voto)
from cidade
inner join candidato on candidato.cidade = cidade.id  
inner join voto on voto.candidato = candidato.id
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
group by cidade.nome;

//20
select partido.sigla, sum(voto.voto) as votos
from partido 
inner join candidato on candidato.partido = partido.id 
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join voto on voto.candidato = candidato.id
group by partido.sigla 
order by votos desc;

//21
select
	ci. nome, sum((v.voto) + vi.nulos + vi.brancos) as votos
from
	voto v
inner join
	candidato c on
	v.candidato = c.id 
inner join
	cidade ci on
	c.cidade = ci.id 
	and ci.nome = 'TUBARÃO'
inner join 
	voto_invalido vi on
	vi.cidade = ci.id 
inner join 
	cargo on 
	vi.cargo = cargo.id 
	and cargo.nome = 'Prefeito'
group by 1 , vi.brancos,vi.nulos;

//22
select 
	 (sum((v.voto) + vi.nulos + vi.brancos)) - ci.qt_eleitores
from 
	voto v
inner join 
	candidato c on
	v.candidato = c.id 
inner join 
	cidade ci on
	c.cidade = ci.id 
inner join 	
	voto_invalido vi on
	vi.cidade = ci.id 
	and ci.nome = 'TUBARÃO'
group by ci.qt_eleitores , vi.nulos, vi.brancos;

//23
select 
	ci.nome, (sum((v.voto) + vi.nulos + vi.brancos)) - ci.qt_eleitores
from 
	voto v
inner join 
	candidato c on
	v.candidato = c.id 
inner join 
	cidade ci on
	c.cidade = ci.id 
inner join 	
	voto_invalido vi on
	vi.cidade = ci.id 
inner join 
	cargo on
	vi.cargo = cargo.id 
group by ci.nome, ci.qt_eleitores , vi.nulos, vi.brancos
order by ci.qt_eleitores desc;

//24
select 
	ci.nome, ((sum((v.voto) + vi.nulos + vi.brancos)) - ci.qt_eleitores)/ci.qt_eleitores as perc
from 
	voto v
inner join 
	candidato c on
	v.candidato = c.id 
inner join 
	cidade ci on
	c.cidade = ci.id 
inner join 	
	voto_invalido vi on
	vi.cidade = ci.id 
inner join 
	cargo on
	vi.cargo = cargo.id 
group by ci.nome, ci.qt_eleitores , vi.nulos, vi.brancos
order by perc desc;

//25
select 
	distinct on
	(ci.nome) ci.nome,
	c.nome,
	v.voto
from 
	voto v
inner join
	candidato c on
	v.candidato = c.id 
inner join 	
	cidade ci on
	c.cidade = ci.id 
inner join 
	cargo on
	c.cargo = cargo.id 
order by ci.nome, v.voto desc;