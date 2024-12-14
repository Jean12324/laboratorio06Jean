/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.laboratorio06Jean.repository;

import com.example.laboratorio06Jean.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jeanc
 */
@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
