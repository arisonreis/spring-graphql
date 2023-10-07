CREATE TABLE public.product (
id UUID NOT NULL,
name TEXT,
price INTEGER,
category_id UUID,
PRIMARY KEY (id)
);
