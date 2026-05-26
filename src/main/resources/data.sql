-- 1. Inserir 1 Campeonato
INSERT INTO Championship (name, matchQuantity) 
SELECT 'Campeonato Brasileiro', 38 WHERE NOT EXISTS (SELECT 1 FROM Championship WHERE champID = 1);

-- 2. Inserir 10 Times Brasileiros
INSERT INTO Team (name, points, matchesPlayed, classification, champId) 
SELECT 'Palmeiras', 0, 0, 1, 1 WHERE NOT EXISTS (SELECT 1 FROM Team WHERE teamID = 1);
INSERT INTO Team (name, points, matchesPlayed, classification, champId) 
SELECT 'Flamengo', 0, 0, 2, 1 WHERE NOT EXISTS (SELECT 1 FROM Team WHERE teamID = 2);
INSERT INTO Team (name, points, matchesPlayed, classification, champId) 
SELECT 'Atlético-MG', 0, 0, 3, 1 WHERE NOT EXISTS (SELECT 1 FROM Team WHERE teamID = 3);
INSERT INTO Team (name, points, matchesPlayed, classification, champId) 
SELECT 'Fluminense', 0, 0, 4, 1 WHERE NOT EXISTS (SELECT 1 FROM Team WHERE teamID = 4);
INSERT INTO Team (name, points, matchesPlayed, classification, champId) 
SELECT 'Botafogo', 0, 0, 5, 1 WHERE NOT EXISTS (SELECT 1 FROM Team WHERE teamID = 5);
INSERT INTO Team (name, points, matchesPlayed, classification, champId) 
SELECT 'Grêmio', 0, 0, 6, 1 WHERE NOT EXISTS (SELECT 1 FROM Team WHERE teamID = 6);
INSERT INTO Team (name, points, matchesPlayed, classification, champId) 
SELECT 'Athletico-PR', 0, 0, 7, 1 WHERE NOT EXISTS (SELECT 1 FROM Team WHERE teamID = 7);
INSERT INTO Team (name, points, matchesPlayed, classification, champId) 
SELECT 'São Paulo', 0, 0, 8, 1 WHERE NOT EXISTS (SELECT 1 FROM Team WHERE teamID = 8);
INSERT INTO Team (name, points, matchesPlayed, classification, champId) 
SELECT 'Internacional', 0, 0, 9, 1 WHERE NOT EXISTS (SELECT 1 FROM Team WHERE teamID = 9);
INSERT INTO Team (name, points, matchesPlayed, classification, champId) 
SELECT 'Fortaleza', 0, 0, 10, 1 WHERE NOT EXISTS (SELECT 1 FROM Team WHERE teamID = 10);

-- 3. Inserir 10 Jogadores de modelo (Corrigido para os nomes de colunas gerados pelo JPA/Hibernate)
INSERT INTO Player (name, age, team, position, goals, yellow_cards, red_cards, assists, matches_played) 
SELECT 'Raphael Veiga', 28, 'Palmeiras', 'Meio-Campo', 3, 1, 0, 2, 4 WHERE NOT EXISTS (SELECT 1 FROM Player WHERE id = 1);
INSERT INTO Player (name, age, team, position, goals, yellow_cards, red_cards, assists, matches_played) 
SELECT 'Pedro', 26, 'Flamengo','Atacante', 5, 0, 0, 1, 4 WHERE NOT EXISTS (SELECT 1 FROM Player WHERE id = 2);
INSERT INTO Player (name, age, team, position, goals, yellow_cards, red_cards, assists, matches_played) 
SELECT 'Hulk', 37, 'Atlético-MG','Atacante', 2, 2, 0, 3, 4 WHERE NOT EXISTS (SELECT 1 FROM Player WHERE id = 3);
INSERT INTO Player (name, age, team, position, goals, yellow_cards, red_cards, assists, matches_played) 
SELECT 'Ganso', 34, 'Fluminense', 'Meio-Campo', 1, 1, 0, 4, 3 WHERE NOT EXISTS (SELECT 1 FROM Player WHERE id = 4);
INSERT INTO Player (name, age, team, position, goals, yellow_cards, red_cards, assists, matches_played) 
SELECT 'Tiquinho Soares', 33, 'Botafogo', 'Atacante', 4, 0, 0, 0, 4 WHERE NOT EXISTS (SELECT 1 FROM Player WHERE id = 5);
INSERT INTO Player (name, age, team, position, goals, yellow_cards, red_cards, assists, matches_played) 
SELECT 'Yeferson Soteldo', 26, 'Grêmio', 'Atacante', 1, 1, 0, 2, 3 WHERE NOT EXISTS (SELECT 1 FROM Player WHERE id = 6);
INSERT INTO Player (name, age, team, position, goals, yellow_cards, red_cards, assists, matches_played) 
SELECT 'Pablo', 31, 'Athletico-PR', 'Atacante', 2, 0, 0, 1, 4 WHERE NOT EXISTS (SELECT 1 FROM Player WHERE id = 7);
INSERT INTO Player (name, age, team, position, goals, yellow_cards, red_cards, assists, matches_played) 
SELECT 'Jonathan Calleri', 30, 'São Paulo', 'Atacante', 3, 2, 0, 0, 4 WHERE NOT EXISTS (SELECT 1 FROM Player WHERE id = 8);
INSERT INTO Player (name, age, team, position, goals, yellow_cards, red_cards, assists, matches_played) 
SELECT 'Alan Patrick', 33, 'Internacional', 'Meio-Campo', 2, 0, 0, 3, 4 WHERE NOT EXISTS (SELECT 1 FROM Player WHERE id = 9);
INSERT INTO Player (name, age, team, position, goals, yellow_cards, red_cards, assists, matches_played) 
SELECT 'Juan Martín Lucero', 32, 'Fortaleza', 'Atacante', 3, 1, 0, 1, 4 WHERE NOT EXISTS (SELECT 1 FROM Player WHERE id = 10);

-- 4. Inserir 5 Jogos
INSERT INTO Match_Table (teamHouse, teamHouseID, teamVisitor, teamVisitorID, championship, champID, goalHouse, goalVisitor, matchDate) 
SELECT 'Palmeiras', 1, 'Flamengo', 2, 'Campeonato Brasileiro', 1, 2, 1, '2026-05-20' WHERE NOT EXISTS (SELECT 1 FROM Match_Table WHERE matchID = 1);
INSERT INTO Match_Table (teamHouse, teamHouseID, teamVisitor, teamVisitorID, championship, champID, goalHouse, goalVisitor, matchDate) 
SELECT 'Atlético-MG', 3, 'Fluminense', 4, 'Campeonato Brasileiro', 1, 0, 0, '2026-05-20' WHERE NOT EXISTS (SELECT 1 FROM Match_Table WHERE matchID = 2);
INSERT INTO Match_Table (teamHouse, teamHouseID, teamVisitor, teamVisitorID, championship, champID, goalHouse, goalVisitor, matchDate) 
SELECT 'Botafogo', 5, 'Grêmio', 6, 'Campeonato Brasileiro', 1, 1, 3, '2026-05-21' WHERE NOT EXISTS (SELECT 1 FROM Match_Table WHERE matchID = 3);
INSERT INTO Match_Table (teamHouse, teamHouseID, teamVisitor, teamVisitorID, championship, champID, goalHouse, goalVisitor, matchDate) 
SELECT 'Athletico-PR', 7, 'São Paulo', 8, 'Campeonato Brasileiro', 1, 2, 2, '2026-05-21' WHERE NOT EXISTS (SELECT 1 FROM Match_Table WHERE matchID = 4);
INSERT INTO Match_Table (teamHouse, teamHouseID, teamVisitor, teamVisitorID, championship, champID, goalHouse, goalVisitor, matchDate) 
SELECT 'Internacional', 9, 'Fortaleza', 10, 'Campeonato Brasileiro', 1, 1, 0, '2026-05-22' WHERE NOT EXISTS (SELECT 1 FROM Match_Table WHERE matchID = 5);
