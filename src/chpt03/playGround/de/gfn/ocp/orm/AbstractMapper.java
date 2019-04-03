// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.2 - Generics
 *
 *  Listing: - 3.2.06 - AbstractMapper.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.orm;

import java.util.List;

public abstract class AbstractMapper<T extends AbstractEntity> {
    
    // CRUD 
    
    public abstract List<T> findAll();
    
    public abstract T find(int id);
    
    public boolean save(T t) {
        if(t.getId() == 0){
            return insert(t);
        }
        else {
            return update(t);
        }
        
    }
    
    protected abstract boolean insert(T t);
    
    protected abstract boolean update(T t);
    
    public abstract boolean delete(T t);
    
}
