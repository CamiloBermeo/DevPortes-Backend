-- Seed data: locations + canchas (fields)
-- Ejecutar contra la base de datos golaya_db
-- Re-ejecutable: limpia datos anteriores antes de insertar

-- Limpiar datos existentes
DELETE FROM fields;
DELETE FROM locations;

-- ============================================
-- LOCATIONS (3 sedes)
-- ============================================
INSERT INTO locations (name, headquarters, address, description, state)
VALUES
  ('Sede Chapinero', 'Sede Principal', 'Cra 7 #45-12, Bogota', 'Complejo deportivo ubicado en el corazon de Chapinero, con multiples canchas y zonas de descanso.', true),
  ('Sede Usaquen', 'Sede Norte', 'Cra 19 #145-30, Bogota', 'Espacio deportivo en la zona norte de la ciudad, ideal para familias y grupos de amigos.', true),
  ('Sede Norte', 'Sede Deportiva', 'Cra 15 #80-20, Bogota', 'Centro deportivo con instalaciones techadas y al aire libre para toda clase de deportes.', true);

-- ============================================
-- FIELDS (10 canchas)
-- ============================================

-- Cancha 1: Estadio Principal - Futbol 11 (Chapinero)
INSERT INTO fields (name, capacity, sport, surface, description, hourly_rate, state, details, url_pictures, location_id)
VALUES (
  'Estadio Principal',
  '22',
  'Futbol 11',
  'Grama Natural Pro',
  'Nuestra joya del complejo. Una cancha con medidas oficiales optima para partidos grandes.',
  60000,
  'DISPONIBLE',
  ARRAY['Capacidad ideal: 22 jugadores', 'Graderias laterales para acompanantes', 'Incluye petos de entrenamiento y balones oficiales'],
  ARRAY['https://raw.githubusercontent.com/CamiloBermeo/devPortes/refs/heads/main/assets/img/canchas/futbol-estadio-principal.webp'],
  (SELECT id FROM locations WHERE name = 'Sede Chapinero')
);

-- Cancha 2: Coliseo Multi-deporte - Futbol Sala / Baloncesto (Norte)
INSERT INTO fields (name, capacity, sport, surface, description, hourly_rate, state, details, url_pictures, location_id)
VALUES (
  'Coliseo Multi-deporte',
  '10',
  'Futbol Sala',
  'Madera Pulida / PVC',
  'Espacio totalmente techado y protegido del clima.',
  45000,
  'DISPONIBLE',
  ARRAY['Tableros de baloncesto hidraulicos ajustables', 'Excelente ventilacion e iluminacion cenital', 'Arcos de futsal con mallas reforzadas'],
  ARRAY['https://raw.githubusercontent.com/CamiloBermeo/devPortes/refs/heads/main/assets/img/canchas/baloncesto-coliseo.webp'],
  (SELECT id FROM locations WHERE name = 'Sede Norte')
);

-- Cancha 3: Club de Tenis Las Palmas - Tenis (Usaquen)
INSERT INTO fields (name, capacity, sport, surface, description, hourly_rate, state, details, url_pictures, location_id)
VALUES (
  'Club de Tenis Las Palmas',
  '4',
  'Tenis',
  'Superficie Sintetica Rapida',
  'Disenada para amantes de la velocidad y precision.',
  35000,
  'DISPONIBLE',
  ARRAY['Excelente rebote controlado de bola', 'Entorno libre de ruidos disruptivos', 'Alquiler disponible de raquetas y tubos de bolas'],
  ARRAY['https://raw.githubusercontent.com/CamiloBermeo/devPortes/refs/heads/main/assets/img/canchas/tenis-las-palmas.webp'],
  (SELECT id FROM locations WHERE name = 'Sede Usaquen')
);

-- Cancha 4: Padel Arena Celeste - Padel (Chapinero)
INSERT INTO fields (name, capacity, sport, surface, description, hourly_rate, state, details, url_pictures, location_id)
VALUES (
  'Padel Arena Celeste',
  '4',
  'Padel',
  'Vidrio Templado Panoramico',
  'Disfruta del deporte con mayor crecimiento mundial.',
  40000,
  'DISPONIBLE',
  ARRAY['Estructura panoramica de alta visibilidad', 'Iluminacion LED antideslumbrante orientada al cielo', 'Zona de descanso integrada para hidratacion'],
  ARRAY['https://raw.githubusercontent.com/CamiloBermeo/devPortes/refs/heads/main/assets/img/canchas/padel-arena.webp'],
  (SELECT id FROM locations WHERE name = 'Sede Chapinero')
);

-- Cancha 5: Zona de Entrenamiento - Cancha Indoor (Norte)
INSERT INTO fields (name, capacity, sport, surface, description, hourly_rate, state, details, url_pictures, location_id)
VALUES (
  'Zona de Entrenamiento',
  '12',
  'Cancha Indoor',
  'Piso de Concreto',
  'Disenada especialmente para sesiones enfocadas en la tecnica.',
  25000,
  'DISPONIBLE',
  ARRAY['Excelente acustica y concentracion', 'Redes de aro en nylon de alta densidad', 'Ideal para practicas libres o rutinas fisicas'],
  ARRAY['https://raw.githubusercontent.com/CamiloBermeo/devPortes/refs/heads/main/assets/img/canchas/indoor-entrenamiento.webp'],
  (SELECT id FROM locations WHERE name = 'Sede Norte')
);

-- Cancha 6: La Catedral del Basket - Baloncesto / 3x3 (Norte)
INSERT INTO fields (name, capacity, sport, surface, description, hourly_rate, state, details, url_pictures, location_id)
VALUES (
  'La Catedral del Basket',
  '10',
  'Baloncesto',
  'Madera Deportiva',
  'Espacio techado con pista reglamentaria y zona 3x3 para partidos rapidos.',
  30000,
  'DISPONIBLE',
  ARRAY['Tableros homologados con red reglamentaria', 'Iluminacion LED de alta intensidad', 'Marcador electronico digital integrado'],
  ARRAY['https://raw.githubusercontent.com/CamiloBermeo/devPortes/refs/heads/main/assets/img/canchas/baloncesto-coliseo.webp'],
  (SELECT id FROM locations WHERE name = 'Sede Norte')
);

-- Cancha 7: Olas del Norte - Voley Playa / Indoor (Norte)
INSERT INTO fields (name, capacity, sport, surface, description, hourly_rate, state, details, url_pictures, location_id)
VALUES (
  'Olas del Norte',
  '12',
  'Voley Playa',
  'Arena Sintetica',
  'Cancha de voley con arena sintetica de alta calidad y red reglamentaria.',
  28000,
  'DISPONIBLE',
  ARRAY['Arena sintetica certificada para competencia', 'Red ajustable para playa o indoor', 'Sector de calentamiento lateral'],
  ARRAY['https://raw.githubusercontent.com/CamiloBermeo/devPortes/refs/heads/main/assets/img/canchas/padel-arena.webp'],
  (SELECT id FROM locations WHERE name = 'Sede Norte')
);

-- Cancha 8: El Potrero Sintetico - Futbol 7 / Futsal (Chapinero) - MANTENIMIENTO
INSERT INTO fields (name, capacity, sport, surface, description, hourly_rate, state, details, url_pictures, location_id)
VALUES (
  'El Potrero Sintetico',
  '14',
  'Futbol 7',
  'Cesped Sintetico 4G',
  'Cancha sintetica con dimensiones oficiales de futbol 7, en mantenimiento preventivo.',
  38000,
  'MANTENIMIENTO',
  ARRAY['Cesped sintetico de ultima generacion 4G', 'Dimensiones reglamentarias FIFA', 'Actualmente en mantenimiento preventivo del cesped'],
  ARRAY['https://raw.githubusercontent.com/CamiloBermeo/devPortes/refs/heads/main/assets/img/canchas/futbol-estadio-principal.webp'],
  (SELECT id FROM locations WHERE name = 'Sede Chapinero')
);

-- Cancha 9: Los Cristales Padel Club - Padel / Padel Cross (Usaquen)
INSERT INTO fields (name, capacity, sport, surface, description, hourly_rate, state, details, url_pictures, location_id)
VALUES (
  'Los Cristales Padel Club',
  '4',
  'Padel',
  'Cristal Templado Panoramico',
  'Club de padel con estructura panoramica y zona para padel cross.',
  42000,
  'DISPONIBLE',
  ARRAY['Muro panoramico sin perfiles verticales', 'Iluminacion cenital homologada', 'Zona adaptada para padel cross y entrenamiento'],
  ARRAY['https://raw.githubusercontent.com/CamiloBermeo/devPortes/refs/heads/main/assets/img/canchas/padel-arena.webp'],
  (SELECT id FROM locations WHERE name = 'Sede Usaquen')
);

-- Cancha 10: Tierra y Red - Tenis / Tenis de Mesa (Usaquen) - MANTENIMIENTO
INSERT INTO fields (name, capacity, sport, surface, description, hourly_rate, state, details, url_pictures, location_id)
VALUES (
  'Tierra y Red',
  '4',
  'Tenis',
  'Polvo de Ladrillo',
  'Cancha de tenis con superficie de polvo de ladrillo en renovacion.',
  32000,
  'MANTENIMIENTO',
  ARRAY['Superficie de arcilla roja natural', 'Red reglamentaria con poste de acero', 'Actualmente en proceso de nivelacion del court'],
  ARRAY['https://raw.githubusercontent.com/CamiloBermeo/devPortes/refs/heads/main/assets/img/canchas/tenis-las-palmas.webp'],
  (SELECT id FROM locations WHERE name = 'Sede Usaquen')
);
