package com.javaweb.QLktx.services.sql;

import com.javaweb.QLktx.models.sql.ServiceKtx;

import java.util.List;
import java.util.Optional;

public interface ServiceKtxService {

    public List<ServiceKtx> getAllServices();

    public Optional<ServiceKtx> getServiceById(String id);

    public ServiceKtx saveService(ServiceKtx serviceKtx);

    public void deleteService(String id);
}
