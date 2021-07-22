package usersmanagement.service;

import java.util.List;

public interface CRUDService<T, ST> {

    List<T> listAll();

    T getById(Long id);

    ST saveOrUpdate(T domainObject);

    void delete(Long id);
    
}
