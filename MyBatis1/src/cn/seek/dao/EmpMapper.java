package cn.seek.dao;

import cn.seek.domain.Emp;

import java.util.List;

public interface EmpMapper {

    public Emp findById(int id);

    public List<Emp> FuzzyfindByName(String value);

    int insertEmp(Emp emp);
    int deleteEmp(int id);
    int updateEmp(Emp emp);
    int insertbackid1(Emp emp);
    int insertbackid2(Emp emp);

}
