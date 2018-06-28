INSERT INTO public.role (role_id, role) VALUES (1, 'ADMIN');
INSERT INTO public.role (role_id, role) VALUES (2, 'PROFESSOR');
INSERT INTO public.role (role_id, role) VALUES (3, 'STUDENT');

INSERT INTO public.chapter (chapter_id, chapter_name, chapter_theory) VALUES (0, 'Vocabulary', 'There are many variations of passages of Lorem Ipsum available');
INSERT INTO public.chapter (chapter_id, chapter_name, chapter_theory) VALUES (1, 'Grammar', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters');
INSERT INTO public.chapter (chapter_id, chapter_name, chapter_theory) VALUES (2, 'Writing', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.');

INSERT INTO public.logs (id, chapter_id, student_stats, user_id) VALUES (1, 0, 0, 1);
INSERT INTO public.logs (id, chapter_id, student_stats, user_id) VALUES (2, 1, 66.67, 1);
INSERT INTO public.logs (id, chapter_id, student_stats, user_id) VALUES (3, 1, 50, 2);
INSERT INTO public.logs (id, chapter_id, student_stats, user_id) VALUES (4, 1, 50, 2);
INSERT INTO public.logs (id, chapter_id, student_stats, user_id) VALUES (5, 1, 50, 3);
INSERT INTO public.logs (id, chapter_id, student_stats, user_id) VALUES (6, 2, 100, 3);
INSERT INTO public.logs (id, chapter_id, student_stats, user_id) VALUES (7, 0, 100, 3);
INSERT INTO public.logs (id, chapter_id, student_stats, user_id) VALUES (8, 0, 100, 4);
INSERT INTO public.logs (id, chapter_id, student_stats, user_id) VALUES (9, 3, 33.33, 3);
INSERT INTO public.logs (id, chapter_id, student_stats, user_id) VALUES (10, 3, 55, 2);
INSERT INTO public.logs (id, chapter_id, student_stats, user_id) VALUES (11, 3, 66, 4);
INSERT INTO public.logs (id, chapter_id, student_stats, user_id) VALUES (12, 3, 66.67, 1);

--Chapter 0 Vocabulary questions
INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'The author died after a ______ illness.', 0);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'procuring', false, 1);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'profuse', true, 1);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'protracted', false, 1);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'prolapsed', false, 1);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'I asked an old couple for directions, but _____ of them knew where the cinema was.', 0);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'all', false, 2);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'both', false, 2);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'none', false, 2);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'neither', true, 2);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'I’m not feeling well. I’d rather _______ in tonight.', 0);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'stay', true, 3);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'to stay', false, 3);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'you to stay', false, 3);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'staying', false, 3);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'I’m afraid I _____ used to working in an open-plan office.', 0);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'haven''t ever', false, 4);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'haven''t', false, 4);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'haven''t got', true, 4);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'have', false, 4);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'The bathroom floor is all wet. Who ______ a shower?', 0);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'had', false, 5);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'has been having', true, 5);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'had had', false, 5);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'had been having', false, 5);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'Our company receives hundreds of ______ emails every day.', 0);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'unstated', false, 6);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'unsolicited', true, 6);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'unrequited', false, 6);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'unkempt', false, 6);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'You are taking this very lightly, ______ your mother is dead serious.', 0);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'whence', false, 7);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'since', false, 7);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'as', false, 7);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'whereas', true, 7);

INSERT INTO public.question (id, question_text, chapter_id) VALUES (default, 'I got a _____ box for my birthday.', 0);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'white small wooden', false, 8);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'small white wooden', false, 8);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'small wooden white', true, 8);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'wooden small white', false, 8);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'We _____ watch Star Trek with my brother every evening when we were children.', 0);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'had', false, 9);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'would', true, 9);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'were used to', false, 9);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'use to', false, 9);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default,'The guest room is quite small, but there should be enough space for you there. You only have a few ____ and pieces.',0);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'bits', false, 10);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'clothes', true, 10);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'stuff', false, 10);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'books', false, 10);

--Chapter 1 Grammar questions
INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'Nobody should think they''re above _____ .', 1);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'approach', false, 11);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'reproach', true, 11);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'blame', false, 11);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'responsibility', false, 11);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'I’m not sure if I shut down the computer. I can’t really remember _______ it down.', 1);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'have shut', false, 12);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'shutting', true, 12);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'to shut', false, 12);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'I shut', false, 12);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'We _____ watch Star Trek with my brother every evening when we were children.', 1);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'had', true, 13);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'would', false, 13);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'were used to', false, 13);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'use to', false, 13);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'I know I was supposed to stay serious, but I couldn''t help ', 1);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'to laugh', false, 14);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'laughed', false, 14);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'with laughing', false, 14);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'laughing', true, 14);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'The author died after a ______ illness.', 1);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'procuring', false, 15);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'profuse', true, 15);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'protracted', false, 15);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'prolapsed', false, 15);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'Do you mind if I open the window?’ ’I’d rather you ______.', 1);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'don''t', false, 16);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'won''t', false, 16);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'do', false, 16);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'didn''t', true, 16);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'I asked an old couple for directions, but _____ of them knew where the cinema was.', 1);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'all', false, 17);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'both', false, 17);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'none', false, 17);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'neither', true, 17);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'If you ______ to see Mary, could you say hello to her for me?', 1);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'likely', false, 18);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'possibly', false, 18);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'happen', true, 18);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'might', false, 18);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'Increasing currency ______ is making exchange rates more volatile.', 1);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'intervention', false, 19);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'speculation', true, 19);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'laundering', false, 19);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'endorsment', false, 19);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'Seldom _____ anything funnier.', 1);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'I have seen', false, 20);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'I see', false, 20);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'have I seen', true, 20);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'I saw', false, 20);

--Chapter 2 Writing questions
INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'I don’t know when the term ’hipster’ was ____ , but it has become quite popular lately.', 2);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'fabricated', false, 21);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'carved', false, 21);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'uttered', true, 21);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'coined', false, 21);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'Joe showed me photos of his new car, _____ he bought last week.', 2);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'which', true, 22);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'that', false, 22);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'what', false, 22);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'whom', false, 22);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, '_____ not been for his help, I couldn''t have passed.', 2);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'If it', false, 23);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'Was he', false, 23);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'Had it', true, 23);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'If he had', false, 23);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'Everyone wanted to hear the president''s ______ address.', 2);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'inaudible', false, 24);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'inbound', false, 24);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'inaugural', false, 24);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'indented', true, 24);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'When I stopped _____ to him, he was repairing his watch. We had a good chat.', 2);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'speaking', false, 25);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'to speak', true, 25);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'spoke', false, 25);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'having spoken', false, 25);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'The trial, in which Ms Jones was accused of conspiracy, was scheduled to end ______ week.', 2);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'any', false, 26);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'that very', true, 26);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'in the last', false, 26);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'after', false, 26);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, '______ the people I interviewed, one in ten said they had already lied to someone that day.', 2);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'around', false, 27);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'between', false, 27);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'among', true, 27);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'along', false, 27);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'If you ______ to see Mary, could you say hello to her for me?', 2);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'likely', false, 28);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'possibly', false, 28);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'happen', true, 28);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'might', false, 28);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'Although the lunar landing ______, the crew managed to take some invaluable photos of the Moon''s surface.', 2);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'was abhorred', true, 29);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'was aborted', false, 29);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'was accomplished', false, 29);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'was abolished', false, 29);

INSERT INTO public.question (id, question_text, chapter_id)
VALUES (default, 'Increasing currency ______ is making exchange rates more volatile.', 2);

INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'intervention', false, 30);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'speculation', true, 30);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'laundering', false, 30);
INSERT INTO public.answer (id, answer_text, is_correct, question_id) VALUES (default, 'endorsment', false, 30);