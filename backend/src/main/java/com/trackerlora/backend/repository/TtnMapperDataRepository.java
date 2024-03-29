package com.trackerlora.backend.repository;

import com.trackerlora.backend.entity.TtnMapperData;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"https://tracker.lopezcarrillo.com", "http://localhost:80"})
public interface TtnMapperDataRepository extends CrudRepository<TtnMapperData, String> {

    TtnMapperData findById(Integer id);
    List<TtnMapperData> findAll();
    void deleteById(Integer id);
    @Query("SELECT COUNT(*) FROM Gateways")
    long getAllGatewayRows();
    @Query("SELECT COUNT(*) FROM Gateways gw WHERE gw.gtwId=:#{#gateway}")
    long getAllGatewayIdRows(@Param("gateway") String gateway);
    @Query("SELECT COUNT(*) FROM TtnMapperData tn WHERE tn.spreadingFactor=?#{[0]}")
    long getAllSfRows(int sf);
    @Query("SELECT COUNT(*) FROM TtnMapperData tn WHERE tn.potencia=?#{[0]}")
    long getAllPwRows(int pw);
    @Query("SELECT COUNT(*) FROM TtnMapperData tn WHERE tn.spreadingFactor=?#{[0]} AND tn.potencia=?#{[1]}")
    long getAllSfPwRows(int sf, int pw);
    long countByGateways_gtwId_AndSpreadingFactor(String gtwId, Integer spreadingFactor);
    long countByGateways_gtwId_AndPotencia(String gtwId, Integer potencia);
    long countByGateways_gtwId_AndPotencia_AndSpreadingFactor(String gtwId, Integer potencia, Integer spreadingFactor);
}
