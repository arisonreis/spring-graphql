ALTER TABLE public.product
    ADD CONSTRAINT FK_product_category
        FOREIGN KEY (category_id)
            REFERENCES public.category(id);

CREATE INDEX IDX_product_category_id ON public.product (category_id);