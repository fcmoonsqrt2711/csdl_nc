package com.javaweb.QLktx.services.sql;

import com.javaweb.QLktx.models.sql.Visitor;

import java.util.List;
import java.util.Optional;

public interface VisitorService {

    public List<Visitor> getAllVisitors();

    public Optional<Visitor> getVisitorByNationalId(String nationalId);

    public Visitor saveVisitor(Visitor visitor);

    public void deleteVisitor(String nationalId);
}
