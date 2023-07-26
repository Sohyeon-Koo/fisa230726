package com.fisa.model.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity(name = "fisadept02")
public class DeptCopy {	//dept_copy
	@Id
	private int deptno;	//dept_no
	private String dname;
	private String loc;
	

}
