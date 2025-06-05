INSERT INTO pessoa (
    pessoa_id, nome, cpf, telefone, email, senha, role, creation_timestamp, update_timestamp
) VALUES (
    '11111111-1111-1111-1111-111111111111',
    'Administrador',
    '000.000.000-00',
    '(00) 00000-0000',
    'admin@condominio.com',
    '$2a$12$FWcI8qm7gAyAYmhoSNI2UuttstrrlNG9D8yVy38clz8xuQeE.DA8K', -- senha: Oceano-1481
    'ROLE_ADMIN',
    now(),
    now()
);
