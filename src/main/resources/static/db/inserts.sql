

insert into public.tb_usuario (us_id, us_email, us_nome, us_senha) values (nextval('public.seq_usuario'), 'hramos@teste.com', 'hebert', '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.');

insert into public.tb_roles (rl_id, rl_nome, us_id) values (nextval('public.seq_roles'), 'teste', 1);