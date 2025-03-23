package com.api.crud.controllers;


import com.api.crud.models.Archivo;
import com.api.crud.services.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")  // Ajusta el origen según tu frontend

@RestController
@RequestMapping("/api/archivos")
public class ArchivoController {

    private final ArchivoService archivoService;

    @Autowired
    public ArchivoController(ArchivoService archivoService) {
        this.archivoService = archivoService;
    }

    @PostMapping("/subir/{filaId}")
    public ResponseEntity<?> subirArchivo(@PathVariable Long filaId, @RequestParam("archivo") MultipartFile archivo) {
        try {
            System.out.println("Recibido archivo: " + archivo.getOriginalFilename());

            // Llama al método del servicio que guarda el archivo con el filaId
            Archivo archivoGuardado = archivoService.guardarArchivoConFilaId(archivo, filaId);

            System.out.println("Archivo guardado en: " + archivoGuardado.getRutaArchivo() + " para la fila con ID: " + filaId);
            return ResponseEntity.ok(archivoGuardado);
        } catch (Exception e) {
            e.printStackTrace(); // Esto mostrará el error exacto en los logs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo: " + e.getMessage());
        }
    }

    
    @GetMapping("/descargar/{id}")
    public ResponseEntity<Resource> descargarArchivo(@PathVariable Long id) throws IOException {
        Resource recurso = archivoService.cargarArchivo(id);
        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
                .body(recurso);
    }
    @GetMapping("/obtenerPorFila/{filaId}")
    public ResponseEntity<List<Archivo>> obtenerArchivosPorFilaId(@PathVariable Long filaId) {
        try {
            // Usamos el servicio para obtener archivos filtrados por filaId
            List<Archivo> archivos = archivoService.obtenerArchivosPorFilaId(filaId);
            return ResponseEntity.ok(archivos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarArchivo(@PathVariable Long id) {
        try {
            // Lógica para eliminar el archivo de la base de datos y del sistema de archivos
            boolean eliminado = archivoService.eliminarArchivo(id);

            if (eliminado) {
                return ResponseEntity.noContent().build();  // 204 No Content si se elimina correctamente
            } else {
                return ResponseEntity.notFound().build();  // 404 Not Found si el archivo no existe
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  // 500 Internal Server Error en caso de fallo
        }
    }

}
