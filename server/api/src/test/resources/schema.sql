drop table if exists product;
drop table if exists seller;
drop table if exists productImage;

CREATE TABLE product
    {
        id          bigint         not null AUTO_INCREMENT PRIMARY KEY,
        seller_id   bigint         not null,
        code        varchar,
        name        varchar,
        price       int,
        sale_price  int,
        rating      varchar,
        detail_page_url varchar,
        delivery    varchar,
        review_count    int,
        buy_satisfy     int,
        is_minor    varchar,
        quantity    bigint,
        FOREIGN KEY (seller_id)
            REFERENCES seller (seller_id) ON DELETE CASCADE
    }

CREATE TABLE seller
    {
        id          bigint         not null AUTO_INCREMENT PRIMARY KEY,
        nick_name   varchar,
        user_name   varchar,
        grd         int
    }

CREATE TABLE product_image
    {
        id          bigint         not null AUTO_INCREMENT PRIMARY KEY,
        product_id  bigint         not null
        base        varchar,
        size110     varchar,
        size120     varchar,
        size130     varchar,
        size140     varchar,
        size150     varchar,
        size170     varchar,
        size200     varchar,
        size250     varchar,
        size270     varchar,
        size300     varchar,
        FOREIGN KEY (product_id)
            REFERENCES product (product_id) ON DELETE CASCADE
    }
