// ServiceRepository.java
package com.javaweb.QLktx.repository.sql;

import com.javaweb.QLktx.models.sql.ServiceKtx;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceKtxRepository extends JpaRepository<ServiceKtx, String> {
}
