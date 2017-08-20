

-- Usuário

insert into public.tb_usuario (us_id, us_email, us_nome, us_senha) values (nextval('public.seq_usuario'), 'hramos@teste.com', 'hebert', '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.');

insert into public.tb_roles (rl_id, rl_nome, us_id) values (nextval('public.seq_roles'), 'teste', 1);

-- Fornecedores

insert into public.tb_fornecedor (fo_id, fo_nome, fo_documento) values (nextval('public.seq_fornecedor'), 'Fornecedor1', '76193019000163');
insert into public.tb_fornecedor (fo_id, fo_nome, fo_documento) values (nextval('public.seq_fornecedor'), 'Fornecedor2', '22766812000185');
insert into public.tb_fornecedor (fo_id, fo_nome, fo_documento) values (nextval('public.seq_fornecedor'), 'Fornecedor2', '62805796000107');

-- Categorias
insert into public.tb_categoria (ct_id, ct_nome, ct_id_pai) values (nextval('public.seq_categoria'), 'Saúde', null);
insert into public.tb_categoria (ct_id, ct_nome, ct_id_pai) values (nextval('public.seq_categoria'), 'Carrapato', (select ct.ct_id from public.tb_categoria ct where ct.ct_nome = 'Saúde'));
insert into public.tb_categoria (ct_id, ct_nome, ct_id_pai) values (nextval('public.seq_categoria'), 'Moscas', (select ct.ct_id from public.tb_categoria ct where ct.ct_nome = 'Saúde'));
insert into public.tb_categoria (ct_id, ct_nome, ct_id_pai) values (nextval('public.seq_categoria'), 'Vacinas', (select ct.ct_id from public.tb_categoria ct where ct.ct_nome = 'Saúde'));

insert into public.tb_categoria (ct_id, ct_nome, ct_id_pai) values (nextval('public.seq_categoria'), 'Nutrição', null);
insert into public.tb_categoria (ct_id, ct_nome, ct_id_pai) values (nextval('public.seq_categoria'), 'Engorda', (select ct.ct_id from public.tb_categoria ct where ct.ct_nome = 'Nutrição'));
insert into public.tb_categoria (ct_id, ct_nome, ct_id_pai) values (nextval('public.seq_categoria'), 'Confinamento', (select ct.ct_id from public.tb_categoria ct where ct.ct_nome = 'Nutrição'));
insert into public.tb_categoria (ct_id, ct_nome, ct_id_pai) values (nextval('public.seq_categoria'), 'Gado Leiteiro', (select ct.ct_id from public.tb_categoria ct where ct.ct_nome = 'Nutrição'));



--Criado de produto
-- insert into public.tb_produto_venda(pvd_id, pvd_preco, pvd_foto, ic_id) values(nextval('public.seq_produto_venda'), 100.80, 'foto', (select ic_id from public.tb_item_compra where ic_nome = 'Item1'));
-- insert into public.tb_categoria_produto(pvd_id, ct_id) values ((select pvd.pvd_id from public.tb_produto_venda pvd join public.tb_item_compra ic on pvd.ic_id = ic.ic_id where ic.ic_nome = 'Item1'), (select ct_id from public.tb_categoria where ct_nome = 'Engorda'))