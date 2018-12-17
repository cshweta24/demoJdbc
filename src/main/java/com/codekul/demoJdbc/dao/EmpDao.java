package com.codekul.demoJdbc.dao;

import com.codekul.demoJdbc.model.Emp;
import com.codekul.demoJdbc.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDao implements EmpRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Emp> getList()
    {
        String str="select * from emp";
        List<Emp>emps=jdbcTemplate.query(str,new BeanPropertyRowMapper<>(Emp.class));
        return emps;
    }

    @Override
    public List<Emp> findById(Integer id) {
        return null;
    }

    @Override
   public String insertData(Emp emp)
   {
       String sql="insert into emp values(?,?,?)";

      jdbcTemplate.update(sql,new Object[]{emp.getId(),emp.getName(),emp.getCity()});
       return "success";
   }

    @Override
    public String updateData(Integer id, String name) {

        String sql="update emp set name=? where id=?";
        jdbcTemplate.update(sql,new Object[]{name,id});


        return "updated";
    }

    @Override
    public String deletedData(Integer id) {
        String sql="delete from emp where id=?";
        jdbcTemplate.update(sql,new Object[]{id});
        return "deleted";
    }




    /*@Override
    public Emp findById(Integer id) {
        String str="select * from emp where id=?";
        Emp emp=jdbcTemplate.queryForObject(str,new Object[]{id},new BeanPropertyRowMapper<>(Emp.class));
        return emp;
    }*/


}
