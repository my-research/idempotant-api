package com.github.dhslrl321.payment.domain;

import com.github.dhslrl321.payment.domain.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static java.util.Objects.nonNull;

@Repository
@RequiredArgsConstructor
public class PaymentRepository {

    private final JdbcTemplate jdbcTemplate;

    private final String INSERT_QUERY =
            "INSERT INTO payments " +
            "(id, user_id, order_id, status, paid_amount, paid_at) " +
            "VALUES (?,?,?,?,?,?)";

    private final String COUNT_BY_userId_orderId_QUERY =
            "SELECT count(*) FROM payments " +
            "WHERE " +
            "user_id = ? AND " +
            "order_id = ?";


    public void save(Payment payment) {
        jdbcTemplate.update(INSERT_QUERY,
                payment.getId(),
                payment.getUserId(),
                payment.getOrderId(),
                payment.getStatus(),
                payment.getPaidAmount(),
                payment.getPaidAt());
    }

    public boolean existBy(long userId, long orderId) {
        Integer count = jdbcTemplate.queryForObject(
                COUNT_BY_userId_orderId_QUERY,
                Integer.class,
                userId,
                orderId);

        return nonNull(count) && count == 1;
    }
}
