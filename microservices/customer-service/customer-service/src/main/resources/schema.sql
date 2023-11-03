DROP TABLE IF EXISTS tbl_categories;

CREATE TABLE tbl_regions (
                                id BIGINT AUTO_INCREMENT  PRIMARY KEY,
                                name VARCHAR(250) NOT NULL
);


DROP TABLE IF EXISTS tbl_products;

CREATE TABLE tbl_customers (
                              id BIGINT AUTO_INCREMENT  PRIMARY KEY,
                              number_id VARCHAR(10) NOT NULL,
                              first_name VARCHAR(250) NOT NULL,
                              last_name VARCHAR(250) NOT NULL,
                              email VARCHAR(250) NOT NULL,
                              region_id BIGINT,
                              state VARCHAR(250) NOT NULL
);