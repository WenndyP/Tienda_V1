
package com.Tienda_v1.service.impl;

import com.Tienda_v1.dao.ProductoDao;
import com.Tienda_v1.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Tienda_v1.domain.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {
 
    @Autowired
    private ProductoDao productoDao;
 
    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
 
    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }
 
    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }
 
    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
}
 