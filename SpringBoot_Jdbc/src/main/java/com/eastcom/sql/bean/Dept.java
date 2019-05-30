package com.eastcom.sql.bean;

public class Dept {
    private Integer deptno;

    private String dname;

    private String location;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

	public Dept(Integer deptno, String dname, String location) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.location = location;
	}
    public Dept() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", location=" + location + "]";
	}
    
}