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

select c.nome
from candidato c
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito'
inner join cidade cid on cid.id = c.cidade and cid.qt_eleitores = (select max(qt_eleitores) from cidade)
order by c.nome;

select count(*)
from candidato c
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador'
inner join cidade on c.cidade = cidade.id and cidade.nome = 'TUBARÃO'; 

select cidade.nome, count(*)
from candidato c 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador'
inner join cidade on c.cidade = cidade.id 
group by cidade.nome 
order by cidade.nome;

select cargo.nome, vi.nulos, vi.brancos
from cargo 
inner join voto_invalido vi on vi.cargo = cargo.id 
inner join cidade on cidade.id = vi.cidade and cidade.nome = 'TUBARÃO'; 

select vi.nulos + vi.brancos as total
from cargo 
inner join voto_invalido vi on vi.cargo = cargo.id and cargo.nome = 'Prefeito' 
inner join cidade on cidade.id = vi.cidade and cidade.nome = 'TUBARÃO';

select candidato.nome, voto.voto
from candidato 
inner join voto on voto.candidato = candidato.id 
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
order by voto desc;

select candidato.nome, voto.voto as votos
from candidato 
inner join voto on voto.candidato = candidato.id 
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Vereador'
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
order by votos desc;

select cidade.nome, max(voto.voto)
from cidade
inner join candidato on candidato.cidade = cidade.id  
inner join voto on voto.candidato = candidato.id
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
group by cidade.nome;

select partido.sigla, sum(voto.voto) as votos
from partido 
inner join candidato on candidato.partido = partido.id 
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join voto on voto.candidato = candidato.id
group by partido.sigla 
order by votos desc;

select 
	sum(v.voto) as votos, sum(vi.brancos) as brancos, sum(vi.nulos) as nulos
from
	voto v
inner join candidato c on
	v.candidato = c.id
	and c.cargo = 1
inner join cidade ci on
	c.cidade = ci.id 
	and ci.nome = 'TUBARÃO'
inner join voto_invalido vi on
	c.cargo = vi.cargo
	and ci.id = vi.cidade;

select count(*)
from cidade c
inner join voto on c.qt_eleitores - voto.voto and c.nome = 'TUBARÃO'
inner join voto_invalido vi on c.qt_eleitores - (vi.brancos + vi.nulos);

select count(*)

//24

select c.nome prefeito, cidade.nome cidade
from candidato c 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito'
inner join cidade on cidade.id = c.cidade
inner join voto on voto.candidato = c.id and voto.voto = (select max(voto) from voto)
order by cidade.nome;

//teste 22
select
	(
	select
		ci.qt_eleitores)
from
	cidade ci
where
	c.nome = 'TUBARÃO') - (
	select
		sum (v.voto))
from
	voto v
inner join candidato c on
	c.id = v.candidato
inner join cidade ci on
	ci.id = c.cidade
	and ci.nome = 'TUBARÃO'
inner join cargo on
	cargo.id = c.cargo 