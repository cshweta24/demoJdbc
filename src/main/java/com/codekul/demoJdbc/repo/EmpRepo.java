package com.codekul.demoJdbc.repo;

import com.codekul.demoJdbc.model.Emp;

import java.util.List;

public interface EmpRepo  {
    
    
    List<Emp> getList();

    List<Emp> findById(Integer id);

    String insertData(Emp emp);

    String updateData(Integer id, String name);

    String deletedData(Integer id);
}
