package usersmanagement.service;

import java.util.List;

public interface CRUDService<T, T2, T3> {

    List<T3> listAll();

    T3 getById(Long id);

    T3 saveOrUpdate(T domainObject);

    void delete(Long id);
    
}
