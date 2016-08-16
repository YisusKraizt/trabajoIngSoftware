insert into ingrediente values(1,'patatas','tuberculo','america',2);
insert into ingrediente values(2,'huevo','lacteo','huelva',1);
insert into ingrediente values(3,'pan','levadura','guijuelo',150);
insert into ingrediente values(4,'lomo','hierro','malaga',23);

insert into TipoPlato values(1,'segundo');
insert into TipoPlato values(2,'postre');
insert into TipoPlato values(3,'segundo');
insert into TipoPlato values(4,'segundo');
insert into TipoPlato values(5,'primero');
insert into TipoPlato values(6,'primero');

insert into Dibujo values(1,'foto1','www.prueba1.es');
insert into Dibujo values(2,'foto2','www.prueba2.es');
insert into Dibujo values(3,'foto3','www.prueba3.es');
insert into Dibujo values(4,'foto4','www.prueba4.es');
insert into Dibujo values(5,'foto5','www.prueba5.es');
insert into Dibujo values(6,'foto6','www.prueba6.es');

insert into video values(1,'http://www.youtube.com/watch?v=ZjnDw-u3uhg','patatas bravas');
insert into video values(2,'http://www.youtube.com/watch?v=th8kEN5Yezo','Flan casero microondas');
insert into video values(3,'http://www.youtube.com/watch?v=NQBIgD7oxyM','Migas');
insert into video values(4,'http://www.youtube.com/watch?v=sJOXvN00uZ0','Lomo de cerdo a la naranja');
insert into video values(5,'http://www.youtube.com/watch?v=oTf0hA3Zmwc','Pescado en adobo');
insert into video values(6,'http://www.youtube.com/watch?v=e6sA8X-A4Wg','Potaje');

insert into receta values(1,1,1,1,'patatas bravas',1,14,'Valencia','picantonas');
insert into receta values(2,2,2,2,'flan',12,7,'Aragon','flan de nata rico rico');
insert into receta values(3,3,3,3,'migas',4,5,'Murcia','migas, y no son de pan');
insert into receta values(4,4,4,4,'lomo',3,25,'Orense','lomo iberico');
insert into receta values(5,5,5,5,'lenguado',18,50,'Lugo','lenguado al horno');
insert into receta values(6,6,6,6,'merluza',14,10,'La Rioja','merluza a la riojana');

insert into receta_has_ingrediente values(1,1);
insert into receta_has_ingrediente values(1,3);
insert into receta_has_ingrediente values(2,1);
insert into receta_has_ingrediente values(2,3);
insert into receta_has_ingrediente values(3,3);
insert into receta_has_ingrediente values(4,4);