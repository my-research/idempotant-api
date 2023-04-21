CREATE TABLE payments
(
    id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    order_id BIGINT NOT NULL,
    status VARCHAR(30) NOT NULL,
    paid_amount INT,
    paid_at TIMESTAMP,

    PRIMARY KEY (id)
);
