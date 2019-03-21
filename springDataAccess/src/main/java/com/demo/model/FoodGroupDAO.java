package com.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Repository("foodGroupDAO")
public class FoodGroupDAO {

	private NamedParameterJdbcTemplate namedJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert simpleJdbcInsert;
	private SimpleJdbcCall simpleJdbcCall;
	
	public NamedParameterJdbcTemplate getNamedJJdbcTemplate() {
		return namedJdbcTemplate;
	}

//	@Autowired
	public void setNamedJdbcTemplate(DataSource dataSource) {
		namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("foodgroup").usingGeneratedKeyColumns("id");
		simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("read_foodgroup_name_desc");
	}
	
	public List<FoodGroup> getAllFoodGroups() {
		return getFoodGroups("SELECT * from foodgroup", null);
	}

	public List<FoodGroup> getJustFriutsFoodGroups() {
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("groupName", "fruits");
//		return getFoodGroups("SELECT * from foodgroup where name='fruits'", sps);
		return getFoodGroups("SELECT * from foodgroup where name=:groupName", sps);
	}

	private List<FoodGroup> getFoodGroups(String quaryString, SqlParameterSource sps) {
		return namedJdbcTemplate.query(quaryString, sps, new FoodGroupRawMapper());
	}

	public FoodGroup getFoodGroup(int id) {
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("id", id);
		return namedJdbcTemplate.queryForObject("SELECT * from foodgroup where id=:id", sps, new FoodGroupRawMapper());
	}
	
	public FoodGroup getFoodGroupProc(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("in_id", id);
		Map<String, Object> outValues = simpleJdbcCall.execute(params);
		
		return new FoodGroup(id, (String)outValues.get("group_name"), (String)outValues.get("group_description"));
	}

	public boolean addDefinedFoodGroup(String name, String description) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("description", description);
		params.addValue("name", name);
		
		return insertFoodGroup(params);
	}
	
	public boolean addBeanFoodGroup(FoodGroup fg) {
		return insertFoodGroup(new BeanPropertySqlParameterSource(fg));
	}
	
	public int add_SI_BeanFoodGroup(FoodGroup fg) {
		return simpleJdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(fg)).intValue();
	}
	
	private boolean insertFoodGroup(SqlParameterSource params) {
		boolean res = false;
		
		int numberOfRowsAffected = namedJdbcTemplate.update("insert into foodgroup (name, description) values (:name, :description)", params);
		
		if(numberOfRowsAffected == 1) {
			System.out.println("One row added to the table succesfully");
			res = true;
		} else {
			System.out.println("Tehere was a problem adding to table foodgroups");
		}
		
		return res;
	}
	
	@Transactional("transactionManager")
	public int[] addFoodGroups(List<FoodGroup> foodGroups) {
//		ArrayList<MapSqlParameterSource> paramsArrayList = new ArrayList<MapSqlParameterSource>();
//		
//		for(FoodGroup fg : foodGroups) {
//			MapSqlParameterSource tempParam = new MapSqlParameterSource();
//			tempParam.addValue("name", fg.getName());
//			tempParam.addValue("description", fg.getDescription());
//			
//			paramsArrayList.add(tempParam);
//		}
//		
//		SqlParameterSource[] batchParams = new MapSqlParameterSource[paramsArrayList.size()];
//		paramsArrayList.toArray(batchParams);
		
		SqlParameterSource[] batchParams = SqlParameterSourceUtils.createBatch(foodGroups.toArray());
		int[] numberOfRowsAffectedArray = namedJdbcTemplate.batchUpdate("insert into foodgroup (name, description) values (:name, :description)", batchParams);
		
		return numberOfRowsAffectedArray;
	}
	
	public boolean updateBeanFoodGroup(FoodGroup fg) {
		boolean res = false;
		
		int numberOfRowsAffected = namedJdbcTemplate.update("update foodgroup set name=:name, description=:description where id=:id", new BeanPropertySqlParameterSource(fg));
		
		if(numberOfRowsAffected == 1) {
			System.out.println("One row updated to the table succesfully");
			res = true;
		} else {
			System.out.println("There was a problem updating to table foodgroup");
		}
		
		return res;
	}
	
	public boolean deleteDescriptionFoodGroup(int id) {
		boolean res = false;
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		int numberOfRowsAffected = namedJdbcTemplate.update("delete from foodgroup where id=:id", params);
		
		if(numberOfRowsAffected == 1) {
			System.out.println("One row deleted to the table succesfully");
			res = true;
		} else {
			System.out.println("There was a problem deleting from the table foodgroup");
		}
		
		return res;
	}
	
	public void quaryForObjectDemo() {
		System.out.println("Number of items in the table: " + jdbcTemplate.queryForObject("select count(*) from foodgroup", Integer.class));
		System.out.println("Name of 4th item in the table: " + jdbcTemplate.queryForObject("select name from foodgroup where id='4'", String.class));
		
		System.out.println(jdbcTemplate.queryForObject("select * from foodgroup where id='4'", new RowMapper<FoodGroup>() {

			public FoodGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new FoodGroup(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
			}}).talkAboutYourself());
	}
	
	
	private static class FoodGroupRawMapper implements RowMapper<FoodGroup> {

		public FoodGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
			FoodGroup fg = new FoodGroup();
			fg.setId(rs.getInt("id"));
			fg.setName(rs.getString("name"));
			fg.setDescription(rs.getString("description"));

			return fg;
		}
	}
}
