-- Category
INSERT INTO tb_category (id, name) VALUES (1, 'Colares');
INSERT INTO tb_category (id, name) VALUES (2, 'Brincos');
INSERT INTO tb_category (id, name) VALUES (3, 'Pulseiras');
INSERT INTO tb_category (id, name) VALUES (4, 'Anéis');
INSERT INTO tb_category (id, name) VALUES (5, 'Conjuntos');

-- User - password: 123
INSERT INTO tb_user(display_name, username, password) VALUES ('Administrador', 'admin','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');
--INSERT INTO tb_user(display_name, username, password) VALUES ('Teste', 'test','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');

-- COLAR (ID: 1)
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Colar Duplo', 'Novidade da semana. Colar Duplo em banho dourado.', 159.90, 'https://images.tcdn.com.br/img/img_prod/928620/trio_de_colares_luxo_liso_theteu_4449_1_a61bbf04761f31103698c9545e585cfa.jpg', 1);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Colar com Pingente Gota', 'Novidade da semana. Colar curto com pingente de gota.', 69.90, 'https://morana.vtexassets.com/arquivos/ids/254561-1200-auto?v=638965876527830000&width=1200&height=auto&aspect=true', 1);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Colar Snake', 'Colar de corrente com design de cobra (snake).', 99.90, 'https://morana.vtexassets.com/arquivos/ids/252340-1200-auto?v=638953627181300000&width=1200&height=auto&aspect=true', 1);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Colar com Símbolo Masculino', 'Colar curto com símbolo masculino. Banho Dourado.', 39.90, 'https://morana.vtexassets.com/arquivos/ids/174863-1200-auto?v=638025861740200000&width=1200&height=auto&aspect=true', 1);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Colar com Cristais e Pedras', 'Acessório de corrente com aplicação de cristais e pedras de vidro.', 59.90, 'https://morana.vtexassets.com/arquivos/ids/172398-1200-auto?v=637998228738200000&width=1200&height=auto&aspect=true', 1);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Colar com Pingente de Signo Áries', 'Colar com pingente redondo do signo de Áries.', 59.90, 'https://morana.vtexassets.com/arquivos/ids/227660-1200-auto?v=638699561656300000&width=1200&height=auto&aspect=true', 1);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Colar com Pingente de Coração', 'Colar com pingente de coração liso. Banho Dourado.', 69.90, 'https://morana.vtexassets.com/arquivos/ids/256023-1200-auto?v=638972805125670000&width=1200&height=auto&aspect=true', 1);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Colar Letra "P"', 'Colar de corrente veneziana com pingente de letra P.', 59.90, 'https://morana.vtexassets.com/arquivos/ids/245616-1200-auto?v=638844883235100000&width=1200&height=auto&aspect=true', 1);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Colar Assimétrico com Pérolas', 'Colar com design moderno e pérolas de tamanhos variados.', 99.90, 'https://morana.vtexassets.com/arquivos/ids/166660-1200-auto?v=637915215942830000&width=1200&height=auto&aspect=true', 1);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Colar Duplo de Correntaria', 'Colar duplo de correntaria, bijuteria fina banhada em metal nobre.', 89.90, 'https://morana.vtexassets.com/arquivos/ids/250789-1200-auto?v=638914757397730000&width=1200&height=auto&aspect=true', 1);

-- BRINCOS (ID: 2)
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Brinco de Pérolas', 'Brinco com uma pérola e detalhe de zircônia.', 89.90, 'https://morana.vtexassets.com/arquivos/ids/254650-1200-auto?v=638965876918770000&width=1200&height=auto&aspect=true', 2);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Brinco Vazado', 'Brinco pequeno de formato geométrico vazado. Banho Dourado.', 29.90, 'https://morana.vtexassets.com/arquivos/ids/255675-1200-auto?v=638972801539630000&width=1200&height=auto&aspect=true', 2);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Piercing Fake Cravejado', 'Piercing de encaixe (fake) com aplicação de zircônias. Banho Dourado.', 139.90, 'https://morana.vtexassets.com/arquivos/ids/254554-1200-auto?v=638965876498200000&width=1200&height=auto&aspect=true', 2);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Argola Trabalhada', 'Argola média com design trançado. Banho Dourado.', 59.90, 'https://morana.vtexassets.com/arquivos/ids/253174-1200-auto?v=638955375939400000&width=1200&height=auto&aspect=true', 2);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Brinco Delicado', 'Brinco pequeno e minimalista, ideal para o dia a dia.', 59.90, 'https://morana.vtexassets.com/arquivos/ids/254372-1200-auto?v=638965875699130000&width=1200&height=auto&aspect=true', 2);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Brinco Riviera', 'Brinco de pino com fileira de zircônias. Banho Dourado.', 49.90, 'https://morana.vtexassets.com/arquivos/ids/254343-1200-auto?v=638965875575370000&width=1200&height=auto&aspect=true', 2);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Brinco Coração', 'Brinco de pino em formato de coração. Banho Prateado.', 49.90, 'https://morana.vtexassets.com/arquivos/ids/254305-1200-auto?v=638965875401430000&width=1200&height=auto&aspect=true', 2);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Brinco Folha', 'Brinco pequeno com design orgânico de folha.', 49.90, 'https://morana.vtexassets.com/arquivos/ids/254170-1200-auto?v=638965874806200000&width=1200&height=auto&aspect=true', 2);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Argola com Zircônias', 'Argola de tamanho médio cravejada com zircônias.', 59.90, 'https://morana.vtexassets.com/arquivos/ids/244983-1200-auto?v=638841514191300000&width=1200&height=auto&aspect=true', 2);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Mini Argola com Zircônia', 'Mini argola perfeita para segundo furo ou discreto.', 39.90, 'https://morana.vtexassets.com/arquivos/ids/242311-1200-auto?v=638811842522930000&width=1200&height=auto&aspect=true', 2);

-- PULSEIRAS (ID: 3)
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Pulseira Trabalhada', 'Pulseira de elos com detalhes trabalhados. Banho Dourado.', 119.90, 'https://morana.vtexassets.com/arquivos/ids/254557-1200-auto?v=638965876510500000&width=1200&height=auto&aspect=true', 3);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Pulseira de Elos', 'Pulseira de elos simples e lisos. Banho Dourado.', 59.90, 'https://morana.vtexassets.com/arquivos/ids/253330-1200-auto?v=638955376265370000&width=1200&height=auto&aspect=true', 3);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Pulseira com Zircônias', 'Pulseira delicada com aplicação de zircônias. Banho Dourado.', 79.90, 'https://morana.vtexassets.com/arquivos/ids/257418-1200-auto?v=638981387378370000&width=1200&height=auto&aspect=true', 3);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Pulseira de Corações', 'Pulseira de corrente com pequenos pingentes de coração. Banho Dourado.', 79.90, 'https://morana.vtexassets.com/arquivos/ids/253368-1200-auto?v=638955376341770000&width=1200&height=auto&aspect=true', 3);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Pulseira Trabalhada Simples', 'Pulseira de corrente com detalhe trabalhado no fecho. Banho Dourado.', 69.90, 'https://morana.vtexassets.com/arquivos/ids/257488-1200-auto?v=638981387502500000&width=1200&height=auto&aspect=true', 3);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Pulseira de Elos Prateada', 'Pulseira de elos largos. Banho Prateado.', 69.90, 'https://morana.vtexassets.com/arquivos/ids/254657-1200-auto?v=638965876948930000&width=1200&height=auto&aspect=true', 3);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Pulseira de Elos Grossa', 'Pulseira de elos mais grossos. Banho Dourado.', 69.90, 'https://morana.vtexassets.com/arquivos/ids/255907-1200-auto?v=638972803927200000&width=1200&height=auto&aspect=true', 3);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Pulseira de Corações Lisa', 'Pulseira rígida com detalhes de corações lisos. Banho Dourado.', 119.90, 'https://morana.vtexassets.com/arquivos/ids/251979-1200-auto?v=638949354801270000&width=1200&height=auto&aspect=true', 3);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Pulseira Rígida', 'Pulseira no estilo bracelete rígido. Banho Dourado.', 89.90, 'https://morana.vtexassets.com/arquivos/ids/253253-1200-auto?v=638955376111230000&width=1200&height=auto&aspect=true', 3);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Maxi Pulseira Rígida', 'Pulseira rígida larga (Maxi). Banho Dourado.', 149.90, 'https://morana.vtexassets.com/arquivos/ids/236457-1200-auto?v=638797205634670000&width=1200&height=auto&aspect=true', 3);

-- ANÉIS (ID: 4)
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Anel Trabalhado', 'Anel com design moderno e superfície trabalhada. Novidade da semana.', 99.90, 'https://morana.vtexassets.com/arquivos/ids/254494-1200-auto?v=638965876236330000&width=1200&height=auto&aspect=true', 4);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Anel com Zircônia Simples', 'Anel solitário simples com uma zircônia.', 35.00, 'https://morana.vtexassets.com/arquivos/ids/240023-1200-auto?v=638797440195700000&width=1200&height=auto&aspect=true', 4);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Anel com Zircônias', 'Anel com múltiplas zircônias cravejadas. Banho Dourado.', 79.90, 'https://morana.vtexassets.com/arquivos/ids/236795-1200-auto?v=638797207315570000&width=1200&height=auto&aspect=true', 4);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Anel Casual', 'Anel com design confortável para uso diário.', 45.00, 'https://morana.vtexassets.com/arquivos/ids/241444-1200-auto?v=638798927691130000&width=1200&height=auto&aspect=true', 4);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Anel Max Trabalhado', 'Anel robusto com detalhes trabalhados.', 119.90, 'https://morana.vtexassets.com/arquivos/ids/231225-1200-auto?v=638727252505570000&width=1200&height=auto&aspect=true', 4);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Anel Coração', 'Anel com topo em formato de coração.', 79.90, 'https://morana.vtexassets.com/arquivos/ids/248142-1200-auto?v=638877700725970000&width=1200&height=auto&aspect=true', 4);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Anel com Zircônias', 'Anel de aro fino com zircônias.', 69.90, 'https://morana.vtexassets.com/arquivos/ids/246350-1200-auto?v=638850748633230000&width=1200&height=auto&aspect=true', 4);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Anel de Dedo Médio Trabalhado', 'Anel pequeno trabalhado para ser usado em qualquer dedo.', 35.00, 'https://morana.vtexassets.com/arquivos/ids/251124-1200-auto?v=638924126275770000&width=1200&height=auto&aspect=true', 4);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Anel Entrelaçado', 'Anel ajustável entrelaçado. Banho Dourado.', 45.00, 'https://morana.vtexassets.com/arquivos/ids/221271-1200-auto?v=638657290398570000&width=1200&height=auto&aspect=true', 4);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Anel Cravejado', 'Anel de festa, completamente cravejado com zircônias.', 59.90, 'https://morana.vtexassets.com/arquivos/ids/240170-1200-auto?v=638797440974730000&width=1200&height=auto&aspect=true', 4);

-- CONJUNTOS (ID: 5)
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Conjunto de Pérola e Zircônias', 'Conjunto (colar e brinco) com pérolas e zircônias. Banho Prateado.', 99.90, 'https://morana.vtexassets.com/arquivos/ids/254224-1200-auto?v=638965875044230000&width=1200&height=auto&aspect=true', 5);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Conjunto com Pedra de Vidro', 'Conjunto trabalhado com zircônias e pedra de vidro. Banho Dourado.', 79.90, 'https://morana.vtexassets.com/arquivos/ids/254644-1200-auto?v=638965876892200000&width=1200&height=auto&aspect=true', 5);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Conjunto Olho Grego', 'Conjunto (colar e brinco) olho grego cravejado. Banho Dourado.', 89.90, 'https://morana.vtexassets.com/arquivos/ids/257386-1200-auto?v=638981387322100000&width=1200&height=auto&aspect=true', 5);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Conjunto de Esferas', 'Conjunto de colar e brinco com esferas. Corrente cadeado. Banho Dourado.', 99.90, 'https://morana.vtexassets.com/arquivos/ids/253254-1200-auto?v=638955376113100000&width=1200&height=auto&aspect=true', 5);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Conjunto Geométrico', 'Conjunto com detalhes em zircônia e formato geométrico. Banho Dourado.', 179.90, 'https://morana.vtexassets.com/arquivos/ids/250275-1200-auto?v=638907804225230000&width=1200&height=auto&aspect=true', 5);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Conjunto Liso com Zircônias', 'Conjunto liso e moderno com detalhe em zircônias. Banho Dourado.', 169.90, 'https://morana.vtexassets.com/arquivos/ids/250233-1200-auto?v=638907804019830000&width=1200&height=auto&aspect=true', 5);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Conjunto Ponto de Luz', 'Conjunto clássico ponto de luz em zircônia. Corrente veneziana. Banho Dourado.', 79.90, 'https://morana.vtexassets.com/arquivos/ids/252271-1200-auto?v=638953626814600000&width=1200&height=auto&aspect=true', 5);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Conjunto Coração Trabalhado', 'Conjunto (colar e brinco) coração trabalhado com zircônias. Banho Dourado.', 99.90, 'https://morana.vtexassets.com/arquivos/ids/254536-1200-auto?v=638965876420730000&width=1200&height=auto&aspect=true', 5);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Conjunto Flor', 'Conjunto (colar e brinco) com zircônias em formato de flor. Banho Dourado.', 79.90, 'https://morana.vtexassets.com/arquivos/ids/257345-1200-auto?v=638981387246200000&width=1200&height=auto&aspect=true', 5);
INSERT INTO tb_product (name, description, price, url_img, category_id)
VALUES ('Conjunto Cravejado', 'Conjunto completamente cravejado com zircônias. Banho Dourado.', 129.90, 'https://morana.vtexassets.com/arquivos/ids/255775-1200-auto?v=638972802564630000&width=1200&height=auto&aspect=true', 5);

-- Endereço do Administrador
--INSERT INTO tb_address (street, complement, zip_code, city, state, country, user_id)
--VALUES ('Av. Brasil, 1000', 'Ap 101', '85501-000', 'Pato Branco', 'Paraná', 'Brasil', 1);

--INSERT INTO tb_address (street, complement, zip_code, city, state, country, user_id)
--VALUES ('Rua das Flores, 250', NULL, '80030-120', 'Curitiba', 'Paraná', 'Brasil', 1);

-- Endereço do Usuário Teste
--INSERT INTO tb_address (street, complement, zip_code, city, state, country, user_id)
--VALUES ('Rua Central, 55', 'Casa', '85810-230', 'Foz do Iguaçu', 'Paraná', 'Brasil', 2);



-- Order
-- Pedido do Administrador (usuário id = 1, endereço id = 1)
--INSERT INTO tb_order (date_order, total_price, user_id, address_id, forma_pagamento, forma_entrega)
--VALUES ('2025-09-27T18:30:00', 5298.80, 1, 1, 'CARTAO_CREDITO', 'ENTREGA_NORMAL');

-- Pedido do Usuário Teste (usuário id = 2, endereço id = 3)
--INSERT INTO tb_order (date_order, total_price, user_id, address_id, forma_pagamento, forma_entrega)
--VALUES ('2025-09-27T19:00:00', 4299.00, 2, 3, 'PIX', 'ENTREGA_EXPRESSA');

--Order Itens
-- Itens do pedido do Administrador (pedido id = 1)
--INSERT INTO tb_order_item (order_id, product_id, price, quantity)
--VALUES (1, 1, 4999.90, 1); -- Smartphone Galaxy S24
--INSERT INTO tb_order_item (order_id, product_id, price, quantity)
--VALUES (1, 4, 399.90, 1); -- Mouse Gamer Logitech G502

-- Itens do pedido do Usuário Teste (pedido id = 2)
--INSERT INTO tb_order_item (order_id, product_id, price, quantity)
--VALUES (2, 2, 4299.00, 1); -- Notebook Acer Aspire 15
