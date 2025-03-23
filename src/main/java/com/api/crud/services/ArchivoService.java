package com.api.crud.services;


import com.api.crud.models.Archivo;
import com.api.crud.repositories.ArchivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.List;
import java.util.Optional;

@Service
public class ArchivoService {

    private final Path fileStorageLocation;
    private final ArchivoRepository archivoRepository;

    @Autowired
    public ArchivoService(ArchivoRepository archivoRepository) throws IOException {
        this.fileStorageLocation = Paths.get("C:/Users/larteaga/React-Admin-DashBoard/public").toAbsolutePath().normalize();
        this.archivoRepository = archivoRepository;

        // Crear el directorio si no existe
        Files.createDirectories(this.fileStorageLocation);
    }
    public List<Archivo> obtenerArchivosPorFilaId(Long filaId) {
        return archivoRepository.findByFilaId(filaId); // Usar el método en el repositorio
    }


    public Archivo guardarArchivoConFilaId(MultipartFile archivo,Long filaId) throws IOException {
        // Generar un nombre único para el archivo
        String nombreArchivo = System.currentTimeMillis() + "_" + archivo.getOriginalFilename();
        Path destino = this.fileStorageLocation.resolve(nombreArchivo);

        // Guardar el archivo en el sistema de archivos
        Files.copy(archivo.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

        // Guardar los metadatos en la base de datos
        Archivo nuevoArchivo = new Archivo();
        nuevoArchivo.setNombreArchivo(archivo.getOriginalFilename());
        nuevoArchivo.setRutaArchivo(destino.toString());
        nuevoArchivo.setTipoArchivo(archivo.getContentType());
        nuevoArchivo.setTamanoArchivo(archivo.getSize());
        nuevoArchivo.setFilaId(filaId);  // Asignar el ID de la fila


        return archivoRepository.save(nuevoArchivo);
    }

    public Resource cargarArchivo(Long id) throws MalformedURLException {
        Archivo archivo = archivoRepository.findById(id).orElseThrow(() -> new RuntimeException("Archivo no encontrado"));
        Path rutaArchivo = Paths.get(archivo.getRutaArchivo()).normalize();
        Resource recurso = new UrlResource(rutaArchivo.toUri());

        if (recurso.exists()) {
            return recurso;
        } else {
            throw new RuntimeException("Archivo no encontrado");
        }
    }
    public boolean eliminarArchivo(Long id) {
        Optional<Archivo> archivoOptional = archivoRepository.findById(id);

        if (archivoOptional.isPresent()) {
            Archivo archivo = archivoOptional.get();

            // Eliminar el archivo del sistema de archivos
            try {
                Files.deleteIfExists(Paths.get(archivo.getRutaArchivo()));  // Asegúrate de que `getRutaArchivo()` devuelva la ruta correcta
            } catch (IOException e) {
                e.printStackTrace();
                return false;  // Falla si no se puede eliminar del sistema de archivos
            }

            // Eliminar el archivo de la base de datos
            archivoRepository.deleteById(id);
            return true;  // Archivo eliminado exitosamente
        } else {
            return false;  // Archivo no encontrado
        }
    }

}

