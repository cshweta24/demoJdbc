package com.codekul.demoJdbc.controller;

import com.codekul.demoJdbc.model.Emp;
import com.codekul.demoJdbc.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {


    @Autowired
    private EmpRepo empRepo;

    @RequestMapping(value ="/getList")
    public List<Emp> getList()
    {
        List<Emp>emp=empRepo.getList();
        return emp;
    }


   /* @GettMapping(value = "findById/{id}")
    public List<Emp>findById(@PathVariable Integer id)
    {
        List<Emp>emp=empRepo.findById(id);
        return emp;

    }*/

    @PostMapping(value ="insertData" )
    public String insertData(@RequestBody Emp emp)
    {
        empRepo.insertData(emp);
        return "inserted";
    }


   @GetMapping(value = "update/{id}/{name}")
    public String update(@PathVariable Integer id,@PathVariable String name)
   {
       empRepo.updateData(id,name);
       return "update";
   }

   @GetMapping(value = "deleted/{id}")
    public String deletedData(@PathVariable Integer id)
   {
       empRepo.deletedData(id);
       return "deleted";
   }

}
