package com.sunway.cms.repo.order;

import com.sunway.cms.entity.order.OderParticular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderParticularRepo extends JpaRepository<OderParticular, Integer> {
}
