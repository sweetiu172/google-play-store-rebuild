-- liquibase formatted sql

-- changeset lap14922:1727578228553-0
D

-- changeset lap14922:1727578228553-1
CREATE SEQUENCE IF NOT EXISTS category_seq START WITH 1 INCREMENT BY 25;

-- rollback drop sequence if exists category_seq;

-- changeset lap14922:1727578228553-2
CREATE SEQUENCE IF NOT EXISTS product_seq START WITH 1 INCREMENT BY 25;

-- rollback drop sequence if exists product_seq;

-- changeset lap14922:1727578228553-3
CREATE TABLE categories
(
    id          BIGINT NOT NULL,
    created_on  TIMESTAMP WITHOUT TIME ZONE,
    updated_on  TIMESTAMP WITHOUT TIME ZONE,
    deleted_on  TIMESTAMP WITHOUT TIME ZONE,
    name        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

-- rollback drop table if exists categories;

-- changeset lap14922:1727578228553-4
CREATE TABLE product_category
(
    category_id BIGINT NOT NULL,
    product_id  BIGINT NOT NULL,
    CONSTRAINT pk_product_category PRIMARY KEY (category_id, product_id)
);

-- rollback drop table if exists product_category;

-- changeset lap14922:1727578228553-5
CREATE TABLE product_images
(
    id         BIGINT NOT NULL,
    image_url  VARCHAR(255),
    product_id BIGINT,
    CONSTRAINT pk_product_images PRIMARY KEY (id)
);

-- rollback drop table if exists product_images;

-- changeset lap14922:1727578228553-6
CREATE TABLE products
(
    id          BIGINT NOT NULL,
    created_on  TIMESTAMP WITHOUT TIME ZONE,
    updated_on  TIMESTAMP WITHOUT TIME ZONE,
    deleted_on  TIMESTAMP WITHOUT TIME ZONE,
    name        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_products PRIMARY KEY (id)
);

-- rollback drop table if exists products;

-- changeset lap14922:1727578228553-7
ALTER TABLE product_images
    ADD CONSTRAINT FK_PRODUCT_IMAGES_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES products (id);

-- rollback alter table product_images drop constraint FK_PRODUCT_IMAGES_ON_PRODUCT;

-- changeset lap14922:1727578228553-8
ALTER TABLE product_category
    ADD CONSTRAINT fk_procat_on_category FOREIGN KEY (category_id) REFERENCES categories (id);

-- rollback alter table product_category drop constraint fk_procat_on_category;

-- changeset lap14922:1727578228553-9
ALTER TABLE product_category
    ADD CONSTRAINT fk_procat_on_product FOREIGN KEY (product_id) REFERENCES products (id);

-- rollback alter table product_category drop constraint fk_procat_on_product;

