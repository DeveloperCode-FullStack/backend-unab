INSERT INTO users (nombre, email, username, password) VALUES ('jbonilla', 'jbonilla@gmail.com', 'jbonilla', '$2a$10$woVagy.1eE41hjADw2dZROi7H8KOVas4PQTDUwTBdblFVuy2Dotx6');
INSERT INTO users (nombre, email, username, password) VALUES ('Angie', 'angie@gmail.com', 'asaavedra', '$2a$10$KQAgBmpGRk5JHCGmV7XDTerHSUL6kyXHhJMXazXqczKGeieiUL9Ci|');

INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 1);

INSERT INTO equipos(nombre) VALUES ('Huila');
INSERT INTO equipos(nombre) VALUES ('Nacional');
INSERT INTO equipos(nombre) VALUES ('Millonarios');
INSERT INTO equipos(nombre) VALUES ('Santa fe');