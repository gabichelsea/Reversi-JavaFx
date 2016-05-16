INSERT INTO public."player" (id, user_name, password) VALUES (10, 'first', '12345');
INSERT INTO public."player" (id, user_name, password) VALUES (11, 'second', '12345');
INSERT INTO public."player" (id, user_name, password) VALUES (12, '22222', '12345');

INSERT INTO public."player_result" (id, player_id, number_of_matches, win, draw, lose, won_pieces, lost_pieces) VALUES (100, 10, 3, 1, 1, 1, 50, 20);
INSERT INTO public."player_result" (id, player_id, number_of_matches, win, draw, lose, won_pieces, lost_pieces) VALUES (101, 11, 3, 2, 1, 0, 60, 20);
INSERT INTO public."player_result" (id, player_id, number_of_matches, win, draw, lose, won_pieces, lost_pieces) VALUES (102, 12, 3, 0, 0, 3, 30, 60);

