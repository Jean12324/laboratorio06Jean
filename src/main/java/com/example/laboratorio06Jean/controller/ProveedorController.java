/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.laboratorio06Jean.controller;

import com.example.laboratorio06Jean.model.Proveedor;
import com.example.laboratorio06Jean.service.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jeanc
 */
@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorService service;

    public ProveedorController(ProveedorService service) {
        this.service = service;
    }

    @GetMapping
    public String listarProveedores(Model model) {
        model.addAttribute("proveedores", service.listarTodos());
        return "proveedores";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "formularioProveedor";
    }

    @PostMapping
    public String guardarProveedor(@ModelAttribute Proveedor proveedor) {
        service.guardar(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("proveedor", service.buscarPorId(id)
            .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id)));
        return "formularioProveedor";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/proveedores";
    }
}
