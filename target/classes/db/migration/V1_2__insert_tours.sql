INSERT INTO Tour (name, country, city, check_in_date, check_out_date, max_capacity, available_spots, price, hotel, rating, description)
VALUES
('Rome Historical Tour', 'Italy', 'Rome', '2025-06-01', '2025-06-10', 20, 15, 1200.50, 'Hotel Roma', 4, 'A beautiful tour of Rome including historical sites and local cuisine.'),
('Paris City Explorer', 'France', 'Paris', '2025-07-05', '2025-07-12', 25, 20, 1500.00, 'Hotel Parisian', 5, 'Explore the beauty of Paris with a guided city tour and visits to top museums.'),
('Barcelona Beach & Culture', 'Spain', 'Barcelona', '2025-08-10', '2025-08-17', 18, 12, 1100.00, 'Catalonia Hotel', 4, 'Enjoy sunny beaches, Gaudí architecture, and delicious tapas.'),
('Tokyo Experience', 'Japan', 'Tokyo', '2025-09-15', '2025-09-25', 15, 8, 2200.00, 'Tokyo Garden Hotel', 5, 'Experience Tokyo modern life, ancient temples, and sushi tours.'),
('New York Adventure', 'USA', 'New York', '2025-10-01', '2025-10-07', 30, 25, 1800.00, 'Manhattan Stay', 4, 'Visit the Statue of Liberty, Times Square, and enjoy Broadway shows.'),
('Athens Ancient Wonders', 'Greece', 'Athens', '2025-05-20', '2025-05-28', 22, 18, 950.00, 'Acropolis View Hotel', 3, 'Walk through ancient ruins and enjoy Mediterranean food.'),
('Berlin History Tour', 'Germany', 'Berlin', '2025-11-10', '2025-11-17', 20, 16, 1300.00, 'Hotel Brandenburg', 4, 'Explore historical landmarks and experience Berlin vibrant culture.'),
('Bangkok Street Food Adventure', 'Thailand', 'Bangkok', '2025-12-01', '2025-12-10', 16, 10, 1000.00, 'River Palace Hotel', 4, 'Enjoy floating markets, temples, and Thai street food.'),
('Rio Beach Paradise', 'Brazil', 'Rio de Janeiro', '2026-01-15', '2026-01-22', 24, 20, 1600.00, 'Copacabana Inn', 4, 'Relax on world-famous beaches and visit Christ the Redeemer.'),
('Sydney Harbor Experience', 'Australia', 'Sydney', '2026-02-10', '2026-02-18', 12, 5, 2500.00, 'Harbour View Hotel', 5, 'See the Opera House, Bondi Beach, and go on a harbor cruise.');

UPDATE Tour SET activities = ARRAY['sightseeing', 'cultural tours', 'food tours'] WHERE id = 1;
UPDATE Tour SET activities = ARRAY['museums', 'city tours', 'shopping'] WHERE id = 2;
UPDATE Tour SET activities = ARRAY['beach', 'architecture', 'nightlife'] WHERE id = 3;
UPDATE Tour SET activities = ARRAY['temples', 'sushi tours', 'shopping'] WHERE id = 4;
UPDATE Tour SET activities = ARRAY['landmarks', 'broadway shows', 'shopping'] WHERE id = 5;
UPDATE Tour SET activities = ARRAY['ancient ruins', 'history walks', 'local cuisine'] WHERE id = 6;
UPDATE Tour SET activities = ARRAY['museums', 'historical landmarks', 'art galleries'] WHERE id = 7;
UPDATE Tour SET activities = ARRAY['street food', 'markets', 'temples'] WHERE id = 8;
UPDATE Tour SET activities = ARRAY['beaches', 'statue tour', 'samba nights'] WHERE id = 9;
UPDATE Tour SET activities = ARRAY['harbor cruise', 'opera house', 'beach walks'] WHERE id = 10;


UPDATE Tour SET images_url = ARRAY['https://plus.unsplash.com/premium_photo-1675975706513-9daba0ec12a8?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 'https://images.unsplash.com/photo-1529154036614-a60975f5c760?q=80&w=1176&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 'https://plus.unsplash.com/premium_photo-1661964123160-8d049fa07f0c?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'] WHERE id = 1;
UPDATE Tour SET images_url = ARRAY['paris1.jpg', 'paris2.jpg', 'paris3.jpg'] WHERE id = 2;
UPDATE Tour SET images_url = ARRAY['barcelona1.jpg', 'barcelona2.jpg', 'barcelona3.jpg'] WHERE id = 3;
UPDATE Tour SET images_url = ARRAY['tokyo1.jpg', 'tokyo2.jpg', 'tokyo3.jpg'] WHERE id = 4;
UPDATE Tour SET images_url = ARRAY['ny1.jpg', 'ny2.jpg', 'ny3.jpg'] WHERE id = 5;
UPDATE Tour SET images_url = ARRAY['athens1.jpg', 'athens2.jpg', 'athens3.jpg'] WHERE id = 6;
UPDATE Tour SET images_url = ARRAY['berlin1.jpg', 'berlin2.jpg', 'berlin3.jpg'] WHERE id = 7;
UPDATE Tour SET images_url = ARRAY['bangkok1.jpg', 'bangkok2.jpg', 'bangkok3.jpg'] WHERE id = 8;
UPDATE Tour SET images_url = ARRAY['rio1.jpg', 'rio2.jpg', 'rio3.jpg'] WHERE id = 9;
UPDATE Tour SET images_url = ARRAY['sydney1.jpg', 'sydney2.jpg', 'sydney3.jpg'] WHERE id = 10;
