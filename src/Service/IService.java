/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface IService<T> {
    void insert(T t);
    boolean update(T t);
    boolean delete(T t);
    List<T> displayAll();
    Map<Integer, List<T>> displayAll2();
    List<T> search(int t);
}
