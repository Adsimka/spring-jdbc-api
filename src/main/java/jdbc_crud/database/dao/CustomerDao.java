package jdbc_crud.database.dao;

import jdbc_crud.database.mapper.CustomerRowMapper;
import jdbc_crud.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomerDao {
    
    private static final String SAVE_CUSTOMER = """
            INSERT INTO customer (fio, phone, address)
            VALUES (:fio, :phone, :address) RETURNING ID
            """;

    private static final String FIND_BY_ID = """
            SELECT id,
                   fio,
                   phone,
                   address,
                   created_at
            FROM customer
            WHERE id = :id
            """;

    private static final String UPDATE = """
            UPDATE customer
            SET fio = :fio, phone = :phone, address = :address
            WHERE id = :id
            """;

    private static final String REMOVE = """
            DELETE FROM customer
            WHERE id = :id
            """;

    private final NamedParameterJdbcTemplate template;
    
    public Long createCustomer(Customer customer) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("fio", customer.getFio())
                .addValue("phone", customer.getPhone())
                .addValue("address", customer.getAddress());

        return template.queryForObject(SAVE_CUSTOMER, parameterSource, Long.class);
    }

    public Customer findById(Long id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", id);

        return template.queryForObject(FIND_BY_ID, parameterSource, new CustomerRowMapper());
    }

    public void update(Customer customer) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", customer.getId())
                .addValue("fio", customer.getFio())
                .addValue("phone", customer.getPhone())
                .addValue("address", customer.getAddress());

        template.update(UPDATE, parameterSource);
    }

    public void remove(Long id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", id);

        template.update(REMOVE, parameterSource);
    }
}
