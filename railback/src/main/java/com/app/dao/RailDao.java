package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Railway;

public interface RailDao extends JpaRepository<Railway,Long> {
	
}
