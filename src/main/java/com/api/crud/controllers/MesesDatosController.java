package com.api.crud.controllers;

import com.api.crud.models.MesesDatos;
import com.api.crud.repositories.MesesDatosRepository;
import com.api.crud.repositories.MesesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/meses-datos")
public class MesesDatosController {

    @Autowired
    private MesesDatosRepository mesesDatosRepository;

    @Autowired
    private MesesRepository mesesRepository; // Agregado @Autowired

    @PostMapping("/bulk")
    public ResponseEntity<String> saveMesesDatos(@RequestBody List<Map<String, Object>> mesesDatos) {
        try {
            for (Map<String, Object> data : mesesDatos) {
                MesesDatos mesesDatosEntity = new MesesDatos();
                mesesDatosEntity.setDepartamento((String) data.get("departamento")); // Corregido para usar departamento
                mesesDatosEntity.setGestion((Integer) data.get("gestion"));
                mesesDatosEntity.setMes((String) data.get("mes"));
                mesesDatosEntity.setAuditor((String) data.get("auditor"));

                // Asigna los datos de los días dinámicamente
                for (int i = 1; i <= 31; i++) {
                    String diaKey = "dia_" + i;
                    String diaValue = (String) data.getOrDefault(diaKey, ""); // Maneja valores null
                    switch (i) {
                        case 1: mesesDatosEntity.setDia_1(diaValue); break;
                        case 2: mesesDatosEntity.setDia_2(diaValue); break;
                        case 3: mesesDatosEntity.setDia_3(diaValue); break;
                        case 4: mesesDatosEntity.setDia_4(diaValue); break;
                        case 5: mesesDatosEntity.setDia_5(diaValue); break;
                        case 6: mesesDatosEntity.setDia_6(diaValue); break;
                        case 7: mesesDatosEntity.setDia_7(diaValue); break;
                        case 8: mesesDatosEntity.setDia_8(diaValue); break;
                        case 9: mesesDatosEntity.setDia_9(diaValue); break;
                        case 10: mesesDatosEntity.setDia_10(diaValue); break;
                        case 11: mesesDatosEntity.setDia_11(diaValue); break;
                        case 12: mesesDatosEntity.setDia_12(diaValue); break;
                        case 13: mesesDatosEntity.setDia_13(diaValue); break;
                        case 14: mesesDatosEntity.setDia_14(diaValue); break;
                        case 15: mesesDatosEntity.setDia_15(diaValue); break;
                        case 16: mesesDatosEntity.setDia_16(diaValue); break;
                        case 17: mesesDatosEntity.setDia_17(diaValue); break;
                        case 18: mesesDatosEntity.setDia_18(diaValue); break;
                        case 19: mesesDatosEntity.setDia_19(diaValue); break;
                        case 20: mesesDatosEntity.setDia_20(diaValue); break;
                        case 21: mesesDatosEntity.setDia_21(diaValue); break;
                        case 22: mesesDatosEntity.setDia_22(diaValue); break;
                        case 23: mesesDatosEntity.setDia_23(diaValue); break;
                        case 24: mesesDatosEntity.setDia_24(diaValue); break;
                        case 25: mesesDatosEntity.setDia_25(diaValue); break;
                        case 26: mesesDatosEntity.setDia_26(diaValue); break;
                        case 27: mesesDatosEntity.setDia_27(diaValue); break;
                        case 28: mesesDatosEntity.setDia_28(diaValue); break;
                        case 29: mesesDatosEntity.setDia_29(diaValue); break;
                        case 30: mesesDatosEntity.setDia_30(diaValue); break;
                        case 31: mesesDatosEntity.setDia_31(diaValue); break;
                    }
                }

                mesesDatosRepository.save(mesesDatosEntity);
            }
            return ResponseEntity.ok("Datos guardados correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar los datos.");
        }
    }

    @GetMapping
    public ResponseEntity<?> getMesesDatos(
            @RequestParam("departamento") String departamento,
            @RequestParam("mes") String mes,
            @RequestParam("gestion") Integer gestion) {
        try {
            List<MesesDatos> mesesDatos = mesesDatosRepository.findByDepartamentoAndMesAndGestion(departamento, mes, gestion); // Corregido método
            return ResponseEntity.ok(mesesDatos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener los datos.");
        }
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<String> updateMesesDatos(@PathVariable Long id, @RequestBody Map<String, Object> updateData) {
        try {
            // Busca el registro por ID
            Optional<MesesDatos> optionalDatos = mesesDatosRepository.findById(id);

            if (optionalDatos.isPresent()) {
                MesesDatos mesesDatosEntity = optionalDatos.get();

                // Actualiza los campos según la entrada
                if (updateData.containsKey("departamento")) {
                    mesesDatosEntity.setDepartamento((String) updateData.get("departamento"));
                }
                if (updateData.containsKey("gestion")) {
                    mesesDatosEntity.setGestion((Integer) updateData.get("gestion"));
                }
                if (updateData.containsKey("mes")) {
                    mesesDatosEntity.setMes((String) updateData.get("mes"));
                }
                if (updateData.containsKey("auditor")) {
                    mesesDatosEntity.setAuditor((String) updateData.get("auditor"));
                }

                // Actualiza los datos de los días
                for (int i = 1; i <= 31; i++) {
                    String diaKey = "dia_" + i;
                    if (updateData.containsKey(diaKey)) {
                        String diaValue = (String) updateData.get(diaKey);
                        switch (i) {
                            case 1: mesesDatosEntity.setDia_1(diaValue); break;
                            case 2: mesesDatosEntity.setDia_2(diaValue); break;
                            case 3: mesesDatosEntity.setDia_3(diaValue); break;
                            case 4: mesesDatosEntity.setDia_4(diaValue); break;
                            case 5: mesesDatosEntity.setDia_5(diaValue); break;
                            case 6: mesesDatosEntity.setDia_6(diaValue); break;
                            case 7: mesesDatosEntity.setDia_7(diaValue); break;
                            case 8: mesesDatosEntity.setDia_8(diaValue); break;
                            case 9: mesesDatosEntity.setDia_9(diaValue); break;
                            case 10: mesesDatosEntity.setDia_10(diaValue); break;
                            case 11: mesesDatosEntity.setDia_11(diaValue); break;
                            case 12: mesesDatosEntity.setDia_12(diaValue); break;
                            case 13: mesesDatosEntity.setDia_13(diaValue); break;
                            case 14: mesesDatosEntity.setDia_14(diaValue); break;
                            case 15: mesesDatosEntity.setDia_15(diaValue); break;
                            case 16: mesesDatosEntity.setDia_16(diaValue); break;
                            case 17: mesesDatosEntity.setDia_17(diaValue); break;
                            case 18: mesesDatosEntity.setDia_18(diaValue); break;
                            case 19: mesesDatosEntity.setDia_19(diaValue); break;
                            case 20: mesesDatosEntity.setDia_20(diaValue); break;
                            case 21: mesesDatosEntity.setDia_21(diaValue); break;
                            case 22: mesesDatosEntity.setDia_22(diaValue); break;
                            case 23: mesesDatosEntity.setDia_23(diaValue); break;
                            case 24: mesesDatosEntity.setDia_24(diaValue); break;
                            case 25: mesesDatosEntity.setDia_25(diaValue); break;
                            case 26: mesesDatosEntity.setDia_26(diaValue); break;
                            case 27: mesesDatosEntity.setDia_27(diaValue); break;
                            case 28: mesesDatosEntity.setDia_28(diaValue); break;
                            case 29: mesesDatosEntity.setDia_29(diaValue); break;
                            case 30: mesesDatosEntity.setDia_30(diaValue); break;
                            case 31: mesesDatosEntity.setDia_31(diaValue); break;
                        }
                    }
                }

                mesesDatosRepository.save(mesesDatosEntity);
                return ResponseEntity.ok("Datos actualizados correctamente.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Datos no encontrados.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Muestra la excepción en la consola
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar los datos: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMesesDatos(@PathVariable Long id) {
        try {
            // Busca el registro por ID
            Optional<MesesDatos> optionalDatos = mesesDatosRepository.findById(id);

            if (optionalDatos.isPresent()) {
                mesesDatosRepository.delete(optionalDatos.get());
                return ResponseEntity.ok("Datos eliminados correctamente.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Datos no encontrados.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Muestra la excepción en la consola
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar los datos: " + e.getMessage());
        }
    }


}
