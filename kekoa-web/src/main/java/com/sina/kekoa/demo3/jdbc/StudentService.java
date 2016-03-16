package com.sina.kekoa.demo3.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.sina.kekoa.datasource.DynamicDataSourceContextHolder;
import com.sina.kekoa.datasource.TargetDataSource;

@Service
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @TargetDataSource(name="ds1")
    public List<Student> getList(){
//    	DynamicDataSourceContextHolder.setDataSourceType("ds1");
        String sql = "SELECT id,name,age FROM kekoa_student";
        return (List<Student>) jdbcTemplate.query(sql, new RowMapper<Student>(){

            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student stu = new Student();
                stu.setId(rs.getInt("ID"));
                stu.setAge(rs.getInt("AGE"));
                stu.setName(rs.getString("NAME"));
                return stu;
            }

        });
    }

    @TargetDataSource(name="ds1")
    public String testAOP() {
        return "OK";
    }
}