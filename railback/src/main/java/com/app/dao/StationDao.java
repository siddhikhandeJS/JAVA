package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Station;

public interface StationDao extends JpaRepository<Station, Long>{

}
