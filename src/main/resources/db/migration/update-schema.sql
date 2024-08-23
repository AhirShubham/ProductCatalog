CREATE TABLE category
(
    id              BIGINT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    status          SMALLINT NULL,
    name            VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE jc_four_wheeler
(
    id             INT NOT NULL,
    steering_wheel VARCHAR(255) NULL,
    car_name       VARCHAR(255) NULL,
    CONSTRAINT pk_jc_four_wheeler PRIMARY KEY (id)
);

CREATE TABLE jc_two_wheeler
(
    id              INT NOT NULL,
    steering_handle VARCHAR(255) NULL,
    bike_name       VARCHAR(255) NULL,
    CONSTRAINT pk_jc_two_wheeler PRIMARY KEY (id)
);

CREATE TABLE jc_vehicle
(
    vehicle_id   INT NOT NULL,
    vehicle_name VARCHAR(255) NULL,
    vehicle_type VARCHAR(255) NULL,
    CONSTRAINT pk_jc_vehicle PRIMARY KEY (vehicle_id)
);

CREATE TABLE product
(
    id              BIGINT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    status          SMALLINT NULL,
    name            VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    price DOUBLE NULL,
    image_url       VARCHAR(255) NULL,
    category_id     BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE st_vehicle
(
    vehicle_id      INT NOT NULL,
    type            INT NULL,
    vehicle_name    VARCHAR(255) NULL,
    vehicle_type    VARCHAR(255) NULL,
    steering_wheel  VARCHAR(255) NULL,
    car_name        VARCHAR(255) NULL,
    steering_handle VARCHAR(255) NULL,
    bike_name       VARCHAR(255) NULL,
    CONSTRAINT pk_st_vehicle PRIMARY KEY (vehicle_id)
);

CREATE TABLE tpc_four_wheeler
(
    vehicle_id     INT NOT NULL,
    vehicle_name   VARCHAR(255) NULL,
    vehicle_type   VARCHAR(255) NULL,
    steering_wheel VARCHAR(255) NULL,
    car_name       VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_four_wheeler PRIMARY KEY (vehicle_id)
);

CREATE TABLE tpc_two_wheeler
(
    vehicle_id      INT NOT NULL,
    vehicle_name    VARCHAR(255) NULL,
    vehicle_type    VARCHAR(255) NULL,
    steering_handle VARCHAR(255) NULL,
    bike_name       VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_two_wheeler PRIMARY KEY (vehicle_id)
);

CREATE TABLE tpc_vehicle
(
    vehicle_id   INT NOT NULL,
    vehicle_name VARCHAR(255) NULL,
    vehicle_type VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_vehicle PRIMARY KEY (vehicle_id)
);


CREATE TABLE category
(
    id              BIGINT       NOT NULL,
    created_at      datetime     NULL,
    last_updated_at datetime     NULL,
    status          SMALLINT     NULL,
    name            VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE jc_four_wheeler
(
    id             INT          NOT NULL,
    steering_wheel VARCHAR(255) NULL,
    car_name       VARCHAR(255) NULL,
    CONSTRAINT pk_jc_four_wheeler PRIMARY KEY (id)
);

CREATE TABLE jc_two_wheeler
(
    id              INT          NOT NULL,
    steering_handle VARCHAR(255) NULL,
    bike_name       VARCHAR(255) NULL,
    CONSTRAINT pk_jc_two_wheeler PRIMARY KEY (id)
);

CREATE TABLE jc_vehicle
(
    vehicle_id   INT          NOT NULL,
    vehicle_name VARCHAR(255) NULL,
    vehicle_type VARCHAR(255) NULL,
    CONSTRAINT pk_jc_vehicle PRIMARY KEY (vehicle_id)
);

CREATE TABLE product
(
    id              BIGINT       NOT NULL,
    created_at      datetime     NULL,
    last_updated_at datetime     NULL,
    status          SMALLINT     NULL,
    name            VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    price           DOUBLE       NULL,
    image_url       VARCHAR(255) NULL,
    category_id     BIGINT       NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE st_vehicle
(
    vehicle_id      INT          NOT NULL,
    type            INT          NULL,
    vehicle_name    VARCHAR(255) NULL,
    steering_wheel  VARCHAR(255) NULL,
    car_name        VARCHAR(255) NULL,
    steering_handle VARCHAR(255) NULL,
    bike_name       VARCHAR(255) NULL,
    CONSTRAINT pk_st_vehicle PRIMARY KEY (vehicle_id)
);

CREATE TABLE test_model
(
    id              BIGINT       NOT NULL,
    created_at      datetime     NULL,
    last_updated_at datetime     NULL,
    status          SMALLINT     NULL,
    name            VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    price           DOUBLE       NULL,
    image_url       VARCHAR(255) NULL,
    CONSTRAINT pk_testmodel PRIMARY KEY (id)
);

CREATE TABLE tpc_four_wheeler
(
    vehicle_id     INT          NOT NULL,
    vehicle_name   VARCHAR(255) NULL,
    vehicle_type   VARCHAR(255) NULL,
    steering_wheel VARCHAR(255) NULL,
    car_name       VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_four_wheeler PRIMARY KEY (vehicle_id)
);

CREATE TABLE tpc_two_wheeler
(
    vehicle_id      INT          NOT NULL,
    vehicle_name    VARCHAR(255) NULL,
    vehicle_type    VARCHAR(255) NULL,
    steering_handle VARCHAR(255) NULL,
    bike_name       VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_two_wheeler PRIMARY KEY (vehicle_id)
);

CREATE TABLE tpc_vehicle
(
    vehicle_id   INT          NOT NULL,
    vehicle_name VARCHAR(255) NULL,
    vehicle_type VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_vehicle PRIMARY KEY (vehicle_id)
);

ALTER TABLE jc_four_wheeler
    ADD CONSTRAINT FK_JC_FOUR_WHEELER_ON_ID FOREIGN KEY (id) REFERENCES jc_vehicle (vehicle_id);

ALTER TABLE jc_two_wheeler
    ADD CONSTRAINT FK_JC_TWO_WHEELER_ON_ID FOREIGN KEY (id) REFERENCES jc_vehicle (vehicle_id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);