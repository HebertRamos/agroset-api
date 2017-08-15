

-- Usuário

insert into public.tb_usuario (us_id, us_email, us_nome, us_senha) values (nextval('public.seq_usuario'), 'hramos@teste.com', 'hebert', '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.');

insert into public.tb_roles (rl_id, rl_nome, us_id) values (nextval('public.seq_roles'), 'teste', 1);

-- Fornecedores

insert into public.tb_fornecedor (fo_id, fo_nome, fo_documento) values (nextval('public.seq_fornecedor'), 'Fornecedor1', '76193019000163');
insert into public.tb_fornecedor (fo_id, fo_nome, fo_documento) values (nextval('public.seq_fornecedor'), 'Fornecedor2', '22766812000185');
insert into public.tb_fornecedor (fo_id, fo_nome, fo_documento) values (nextval('public.seq_fornecedor'), 'Fornecedor2', '62805796000107');