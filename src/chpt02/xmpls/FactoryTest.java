// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.3 - Collections
 *
 *  Listing: - 3.3.21 - FactoryTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.xmpls;

import java.util.Arrays;
import java.util.List;

public class FactoryTest {

    public static void main(String[] args) {

        DataMapper mapper = DataMapperFactory.getMapper(DataMapperFactory.Type.MYSQL);
        mapper.create(Arrays.asList("Peter", "Parker", "Spiderman"));
        List<String> row = mapper.read(20);
        List<List<String>> rows = mapper.readAll();
        if(mapper.delete(10)) {
            System.out.println("wurde gelöscht");
        }
    }

}

class DataMapperFactory {

    static enum Type {
        FILE, MYSQL, SQLITE;
    }

    public static DataMapper getMapper(Type type) {

        switch(type) {
            case FILE:
                return new FileDataMapper();
            case MYSQL:
                return new MySQLDataMapper();
            case SQLITE:
                return new SQLiteDataMapper();

                default:
                    throw new UnsupportedOperationException();
        }
        // return null;
    }
}

interface DataMapper {

    // Create Read Update Delete CRUD
    void create(List<String> list);

    List<List<String>> readAll();

    List<String> read(int id);

    boolean update(List<String> list, int id);

    boolean delete(int id);

}

class FileDataMapper implements DataMapper {

    @Override
    public void create(List<String> list) {

    }

    @Override
    public List<List<String>> readAll() {
        return null;
    }

    @Override
    public List<String> read(int id) {
        return null;
    }

    @Override
    public boolean update(List<String> list, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}

class MySQLDataMapper implements DataMapper {
    @Override
    public void create(List<String> list) {

    }

    @Override
    public List<List<String>> readAll() {
        return null;
    }

    @Override
    public List<String> read(int id) {
        return null;
    }

    @Override
    public boolean update(List<String> list, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}

class SQLiteDataMapper implements DataMapper {
    @Override
    public void create(List<String> list) {

    }

    @Override
    public List<List<String>> readAll() {
        return null;
    }

    @Override
    public List<String> read(int id) {
        return null;
    }

    @Override
    public boolean update(List<String> list, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}