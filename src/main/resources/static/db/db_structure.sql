
-------------- Usuário --------------
create table public.tb_usuario(
 us_id integer not null,
 us_email character varying(64) not null,
 us_nome character varying(64) not null,
 us_senha character varying(64) not null
);

create index in_us_id on public.tb_usuario (us_id)
;

alter table public.tb_usuario add constraint pk_us_id primary key (us_id)
;

create sequence public.seq_usuario
 increment by 1
 start with 1
 no maxvalue
 no minvalue
 cache 1
;


-------------- Roles --------------

create table public.tb_roles(
 rl_id integer not null,
 rl_nome character varying(64) not null,
 us_id integer not null
);

create index in_rl_id on public.tb_roles (rl_id)
;

alter table public.tb_roles add constraint pk_rl_id primary key (rl_id)
;

alter table public.tb_roles add constraint fk_roles_us_id foreign key (us_id) references public.tb_usuario (us_id) on delete no action on update no action
;

create sequence public.seq_roles
 increment by 1
 start with 1
 no maxvalue
 no minvalue
 cache 1
;


-------------- Fornecedor --------------

create table public.tb_fornecedor(
 fo_id integer not null,
 fo_nome character varying(64) not null,
 fo_documento character varying(64) not null
);

create index in_fo_id on public.tb_fornecedor (fo_id)
;

alter table public.tb_fornecedor add constraint pk_fo_id primary key (fo_id)
;

create sequence public.seq_fornecedor
 increment by 1
 start with 1
 no maxvalue
 no minvalue
 cache 1
;


----------------Item Compra -----------


create table public.tb_item_compra(
 ic_id integer not null,
 ic_nome character varying(64) not null,
 ic_codigo character varying(64) not null,
 ic_unidade_medida character varying(64) not null,
 ic_situacao character varying(64) not null,
 ic_estoque_minimo integer not null
);

create index in_ic_id on public.tb_item_compra (ic_id)
;

alter table public.tb_item_compra add constraint pk_ic_id primary key (ic_id)
;

create sequence public.seq_item_compra
 increment by 1
 start with 1
 no maxvalue
 no minvalue
 cache 1
;

------------- Entrada Item --------------

create table public.tb_entrada_item(
 ei_id integer not null,
 ei_data timestamp(6) not null,
 ei_quantidade numeric(18,8) not null,
 ic_id integer not null,
 fo_id integer not null,
 us_id integer not null
);

create index in_ei_id on public.tb_entrada_item (ei_id)
;

alter table public.tb_entrada_item add constraint pk_ei_id primary key (ei_id)
;

alter table public.tb_entrada_item add constraint fk_entrada_item_ic_id foreign key (ic_id) references public.tb_item_compra (ic_id) on delete no action on update no action
;

alter table public.tb_entrada_item add constraint fk_entrada_item_fo_id foreign key (fo_id) references public.tb_fornecedor (fo_id) on delete no action on update no action
;

alter table public.tb_entrada_item add constraint fk_entrada_item_us_id foreign key (us_id) references public.tb_usuario (us_id) on delete no action on update no action
;

create sequence public.seq_entrada_item
 increment by 1
 start with 1
 no maxvalue
 no minvalue
 cache 1
;

------------- Saida Item --------------

create table public.tb_saida_item(
 si_id integer not null,
 si_data timestamp(6) not null,
 si_quantidade numeric(18,8) not null,
 si_tipo character varying(64) not null,
 si_justificativa character varying(254) null,
 ic_id integer not null,
 us_id integer not null
);

create index in_si_id on public.tb_saida_item (si_id)
;

alter table public.tb_saida_item add constraint pk_si_id primary key (si_id)
;

alter table public.tb_saida_item add constraint fk_saida_item_ic_id foreign key (ic_id) references public.tb_item_compra (ic_id) on delete no action on update no action
;

alter table public.tb_saida_item add constraint fk_saida_item_us_id foreign key (us_id) references public.tb_usuario (us_id) on delete no action on update no action
;

create sequence public.seq_saida_item
 increment by 1
 start with 1
 no maxvalue
 no minvalue
 cache 1
;


------------- Produto Venda --------------

create table public.tb_produto_venda(
 pvd_id integer not null,
 pvd_preco numeric(18,8) not null,
 pvd_foto character varying(254) not null,
 ic_id integer not null
);

create index in_pvd_id on public.tb_produto_venda (pvd_id)
;
alter table public.tb_produto_venda add constraint pk_pvd_id primary key (pvd_id)
;
alter table public.tb_produto_venda add constraint fk_produto_venda_ic_id foreign key (ic_id) references public.tb_item_compra (ic_id) on delete no action on update no action
;

create sequence public.seq_produto_venda
 increment by 1
 start with 1
 no maxvalue
 no minvalue
 cache 1
;


------------- Venda --------------

create table public.tb_venda(
 vd_id integer not null,
 vd_data timestamp(6) not null,
 vd_tipo character varying(64) not null,
 vd_status character varying(64) not null,
 us_id integer not null
);

create index in_vd_id on public.tb_venda (vd_id)
;

alter table public.tb_venda add constraint pk_vd_id primary key (vd_id)
;

alter table public.tb_venda add constraint fk_compra_us_id foreign key (us_id) references public.tb_usuario (us_id) on delete no action on update no action
;

create sequence public.seq_venda
 increment by 1
 start with 1
 no maxvalue
 no minvalue
 cache 1
;


------------- Item Venda --------------

create table public.tb_item_venda(
 ivd_id integer not null,
 ivd_quantidade numeric(18,8) not null,
 vd_id integer not null,
 pvd_id integer not null
);

create index in_irs_id on public.tb_item_venda (ivd_id)
;

alter table public.tb_item_venda add constraint pk_ivd_id primary key (ivd_id)
;

alter table public.tb_item_venda add constraint fk_item_reserva_vd_id foreign key (vd_id) references public.tb_venda (vd_id) on delete no action on update no action
;

alter table public.tb_item_venda add constraint fk_item_compra_pvd_id foreign key (pvd_id) references public.tb_produto_venda (pvd_id) on delete no action on update no action
;

create sequence public.seq_item_venda
 increment by 1
 start with 1
 no maxvalue
 no minvalue
 cache 1
;

--------------- View Estoque Item Compra -------------

create or replace view public.vi_estoque_item_compra as
select
ic.ic_id
,ic.ic_nome
,ic.ic_codigo
,ic.ic_unidade_medida
,ic.ic_situacao
,COALESCE( ei_qtd.quantidade, 0 )  - COALESCE( si_qtd.quantidade, 0 )  as ic_estoque
,iv_reserva.quantidade as ic_estoque_reservado
from public.tb_item_compra ic
left join (

	select ei.ic_id, sum(COALESCE( ei.ei_quantidade , 0 )) as quantidade
	from public.tb_entrada_item ei
	group by ei.ic_id

) as ei_qtd on ei_qtd.ic_id = ic.ic_id
left join (
	select si.ic_id, sum(COALESCE( si.si_quantidade , 0 )) as quantidade
	from public.tb_saida_item si
	group by si.ic_id

) as si_qtd on si_qtd.ic_id = ic.ic_id
left join (

	select pvd.ic_id, sum(COALESCE( iv.ivd_quantidade , 0 )) as quantidade
	from public.tb_item_venda iv
	join public.tb_produto_venda pvd on pvd.pvd_id = iv.pvd_id
	join public.tb_venda vd on vd.vd_id = iv.vd_id and vd.vd_tipo = 'RESERVA'
	group by pvd.ic_id

) as iv_reserva on iv_reserva.ic_id = ic.ic_id
