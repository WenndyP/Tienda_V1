
package com.Tienda_v1.dao;

import com.Tienda_v1.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoDao extends JpaRepository <Producto, Long>{
    
}
