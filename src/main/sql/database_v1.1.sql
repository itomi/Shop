CREATE TABLE public.authorities (
  id bigint PRIMARY KEY NOT NULL,
  authority character varying(255),
  username character varying(255)
);

CREATE TABLE public.users (
  id bigint PRIMARY KEY NOT NULL,
  address character varying(255),
  email character varying(255),
  enabled boolean,
  first_name character varying(255),
  gender character varying(255),
  last_name character varying(255),
  password character varying(255),
  username character varying(255),
  authority_id bigint,
  FOREIGN KEY (authority_id) REFERENCES authorities (id)
  MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE UNIQUE INDEX uk_h6k33r31i2nvrri9lok4r163j ON users USING BTREE (username);

CREATE TABLE public.categories (
  id bigint PRIMARY KEY NOT NULL,
  name character varying(255),
  id_parent_category bigint,
  FOREIGN KEY (id_parent_category) REFERENCES categories (id)
  MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE public.category_product_relation (
  id bigint PRIMARY KEY NOT NULL,
  category_id bigint,
  product_id bigint,
  FOREIGN KEY (category_id) REFERENCES categories (id)
  MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
  FOREIGN KEY (product_id) REFERENCES products (id)
  MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE public.order_items (
  id bigint PRIMARY KEY NOT NULL,
  quantity integer,
  id_product bigint,
  id_order bigint,
  FOREIGN KEY (id_product) REFERENCES products (id)
  MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
  FOREIGN KEY (id_order) REFERENCES orders (id)
  MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE public.orders (
  id bigint PRIMARY KEY NOT NULL,
  date date,
  total double precision,
  id_user bigint,
  FOREIGN KEY (id_user) REFERENCES users (id)
  MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE public.products (
  id bigint PRIMARY KEY NOT NULL,
  name character varying(255),
  price double precision,
  quantity integer
);