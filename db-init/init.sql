CREATE TABLE IF NOT EXISTS team (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS player (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    team_id INT REFERENCES team(id)
);

-- Insert sample team and player
INSERT INTO team (id, name) VALUES (1, 'Lakers') ON CONFLICT DO NOTHING;
INSERT INTO player (id, name, team_id) VALUES (1, 'LeBron James', 1) ON CONFLICT DO NOTHING;
