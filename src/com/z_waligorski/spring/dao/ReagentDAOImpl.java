package com.z_waligorski.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.z_waligorski.spring.model.Reagent;

public class ReagentDAOImpl implements ReagentDAO {
	
	private JdbcTemplate jdbcTemplate;
	// Put here your table name. It will work only if columns names are the same.
	private static final String TABLE_NAME = "table_name";
	
	public ReagentDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addReagent(Reagent reagent) {
		String sql = "INSERT INTO " + TABLE_NAME + " (name, amount, lot, provider, deliverydate) VALUES"
				+ "(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, reagent.getName(), reagent.getAmount(), reagent.getLot(), 
				reagent.getProvider(), reagent.getDeliveryDate());
	}

	@Override
	public void updateReagent(int id, Reagent reagent) {
		String sql = "UPDATE " + TABLE_NAME + " SET name=?, amount=?, lot=?, provider=?, deliverydate=? WHERE id=?";
		jdbcTemplate.update(sql, reagent.getName(), reagent.getAmount(), reagent.getLot(), reagent.getProvider(), 
				reagent.getDeliveryDate(), id);
	}

	@Override
	public void deleteReagent(int reagentId) {
		String sql = "DELETE FROM " + TABLE_NAME + " WHERE id=?";
		jdbcTemplate.update(sql, reagentId);
	}

	@Override
	public Reagent getReagent(int reagentId) {
		Reagent reagent = null;
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		try {
			reagent = jdbcTemplate.queryForObject(sql, new Object[] {reagentId}, new ReagentMapper());
		} catch(Exception e){
			e.printStackTrace();
		}
		return reagent;
	}

	@Override
	public List<Reagent> getAllReagents() {
		List<Reagent> list = null;
		String sql = "SELECT * FROM " + TABLE_NAME;
		try{
			list = jdbcTemplate.query(sql, new ReagentMapper());
		} catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	private static final class ReagentMapper implements RowMapper<Reagent>{
		
		@Override
		public Reagent mapRow(ResultSet rs, int rowNum) throws SQLException {
			Reagent reagent = new Reagent();
			reagent.setId(rs.getInt("id"));
			reagent.setName(rs.getString("name"));
			reagent.setAmount(rs.getString("amount"));
			reagent.setLot(rs.getInt("lot"));
			reagent.setProvider(rs.getString("provider"));
			reagent.setDeliveryDate(rs.getString("deliverydate"));
			
			return reagent;
		}
		
	}

}
