package tw.leonchen.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity@Table(name = "department")
public class Department implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id @Column(name = "DEPTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptid;
	
	@Column(name = "DEPTNAME")
	private String deptname;

	public int getDeptid() {
		return deptid;
		
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

}
