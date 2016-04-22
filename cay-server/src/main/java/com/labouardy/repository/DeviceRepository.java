package com.labouardy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labouardy.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>{

}
