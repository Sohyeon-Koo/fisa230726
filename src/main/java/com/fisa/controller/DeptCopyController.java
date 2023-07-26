package com.fisa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisa.exception.DeptNotFoundException;
import com.fisa.model.dao.DeptCopyRepository;
import com.fisa.model.domain.entity.DeptCopy;

@RestController
public class DeptCopyController {

	@Autowired	//타입에 맞는 spring bean 등록
	private DeptCopyRepository dao;
	
	
	@PostMapping("insert")
	public DeptCopy insertDeptCopy(DeptCopy datas) {
		System.out.println("*****" + datas);
		return dao.save(datas);
	}
	
	@GetMapping("deptone")
	public DeptCopy getDept(int deptno) throws Exception {
		Optional<DeptCopy> dept = dao.findById(deptno);
		System.out.println(dept);

		dept.orElseThrow(Exception::new);
		return dept.get();
	}
	
	//예외 전담 처리 메소드
	@ExceptionHandler
	public String exHandler(Exception e) {
		e.printStackTrace();		
		return "요청시 입력 데이터 재 확인 부탁합니다";
	}
	
	
	@GetMapping("deptall")
	public Iterable<DeptCopy> getDeptAll(){
		return dao.findAll();
	}
	
	@GetMapping("deptdelete")
	public String deleteDept(int deptno) throws DeptNotFoundException {
		dao.findById(deptno).orElseThrow(DeptNotFoundException::new);
		dao.deleteById(deptno);
		return "delete 성공";
	}
	
	
	//특정 부서 번호로 삭제 
	

}