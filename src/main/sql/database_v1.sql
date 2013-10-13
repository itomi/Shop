CREATE TABLE authorities
(
  user_role character varying(255),
  username character varying(255) NOT NULL,
  CONSTRAINT authorities_pkey PRIMARY KEY (username),
  CONSTRAINT fk_e8unhjxiqcqcn2ccjghd0g9bl FOREIGN KEY (username)
      REFERENCES users (username) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE authorities
  OWNER TO postgres;

CREATE TABLE cartitems
(
  id_cartitem bigint NOT NULL,
  quantity integer,
  id_order bigint,
  id_product integer,
  CONSTRAINT cartitems_pkey PRIMARY KEY (id_cartitem),
  CONSTRAINT fk_2mcstt2mhu07qwhk0wexa73yd FOREIGN KEY (id_product)
      REFERENCES products (id_product) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_c7dxnb00rwlj1ksnf1bxka9vh FOREIGN KEY (id_order)
      REFERENCES orders (id_order) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cartitems
  OWNER TO postgres;

CREATE TABLE categories
(
  id_category bigint NOT NULL,
  name character varying(255),
  id_parentcategory bigint,
  CONSTRAINT categories_pkey PRIMARY KEY (id_category),
  CONSTRAINT fk_97drfthn1cmh9fotmki0vyn8q FOREIGN KEY (id_parentcategory)
      REFERENCES categories (id_category) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE categories
  OWNER TO postgres;

CREATE TABLE orders
(
  id_order bigint NOT NULL,
  date date,
  username character varying(255),
  CONSTRAINT orders_pkey PRIMARY KEY (id_order),
  CONSTRAINT fk_ih4exahynoapvboqtwt8g2vmw FOREIGN KEY (username)
      REFERENCES users (username) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE orders
  OWNER TO postgres;

CREATE TABLE orders_cartitems
(
  orders_id_order bigint NOT NULL,
  cartitems_id_cartitem bigint NOT NULL,
  CONSTRAINT fk_7mcbhvjtmf4kt7q9ly6bq2xfv FOREIGN KEY (orders_id_order)
      REFERENCES orders (id_order) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_9ukxde1w21hjle4rs09bex1y7 FOREIGN KEY (cartitems_id_cartitem)
      REFERENCES cartitems (id_cartitem) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_9ukxde1w21hjle4rs09bex1y7 UNIQUE (cartitems_id_cartitem)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE orders_cartitems
  OWNER TO postgres;

CREATE TABLE products
(
  id_product integer NOT NULL,
  name_product character varying(255),
  price integer,
  quantity integer,
  CONSTRAINT products_pkey PRIMARY KEY (id_product)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE products
  OWNER TO postgres;

CREATE TABLE products_categories
(
  products_id_product integer NOT NULL,
  categories_id_category bigint NOT NULL,
  CONSTRAINT fk_6o48kbrjf7xbbm7d5nko0alh5 FOREIGN KEY (categories_id_category)
      REFERENCES categories (id_category) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_c6y4yq6snhiwdvxgtr3ssx82y FOREIGN KEY (products_id_product)
      REFERENCES products (id_product) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE products_categories
  OWNER TO postgres;

CREATE TABLE users
(
  username character varying(255) NOT NULL,
  address character varying(255),
  email character varying(255),
  enabled boolean,
  first_name character varying(255),
  last_name character varying(255),
  password character varying(255),
  postal_code integer,
  CONSTRAINT users_pkey PRIMARY KEY (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;