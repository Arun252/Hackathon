package com.Areteans.Hackathon.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class AccountRepository {
    private final JdbcTemplate jdbcTemplate;
    public Long create(Map<String,Object> account) {
        Map<String,Object> map = jdbcTemplate.queryForMap("insert into account1(balance,accountno) values(?,?) RETURNING accountid",
                0L,
                account.get("accountno"));
        return (Long) map.get("accountid");
    }

    public Long getbalance(Long accountid) {
        Map<String,Object> map =  jdbcTemplate.queryForMap("select balance from account1 where accountid=?",accountid);
        return (Long) map.get("balance");
    }

    public void update(Long amount , Long accountid) {
        jdbcTemplate.update("update account1 set balance=? where accountid=?" , amount, accountid);
    }
}
