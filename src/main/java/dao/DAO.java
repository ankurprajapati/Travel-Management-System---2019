/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;

/**
 *
 * @author Alex Christian
 */
public interface DAO<T> {
    public int add(T t);
    public int update(T t);
    public int delete(T t);
    public T getById(String id);
    public List<T> getAll();
}
