package com.cg.onlineflatrental.repository;

import org.springframework.data.repository.CrudRepository;
import com.cg.onlineflatrental.entity.Tenant;

public interface ITenantRepository extends CrudRepository <Tenant,Integer>{

}
