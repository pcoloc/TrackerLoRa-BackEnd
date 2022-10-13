package com.trackerlora.backend.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trackerlora.backend.entity.Gateways;
import com.trackerlora.backend.entity.Power;
import com.trackerlora.backend.entity.TtnMapperData;
import com.trackerlora.backend.repository.PowerRepository;
import com.trackerlora.backend.repository.TtnMapperDataRepository;
import com.trackerlora.backend.service.CsvExportService;

import java.io.Writer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;


@RestController
@RequestMapping("/ttnMapperData")
@CrossOrigin(origins = {"https://tracker.lopezcarrillo.com", "http://localhost:4200"})
public class TtnMapperDataController {

    @Autowired
    private TtnMapperDataRepository ttnMapperDataRepository;
    private PowerRepository powerRepository;
    Logger logger = org.slf4j.LoggerFactory.getLogger(TtnMapperDataController.class);
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CsvExportService.class);

        @GetMapping("/{id}")
        public ResponseEntity<TtnMapperData> getTtnMapperData(@PathVariable("id") Integer id) {
            TtnMapperData ttnMapperData = ttnMapperDataRepository.findById(id);
            logger.warn("ttnMapperData: " + ttnMapperData);
            return new ResponseEntity<TtnMapperData>(ttnMapperData, HttpStatus.OK);
        }

        @GetMapping("/all")
        public ResponseEntity<List<TtnMapperData>> getAllTtnMapperData() {
            List<TtnMapperData> ttnMapperData = ttnMapperDataRepository.findAll();
            return new ResponseEntity<List<TtnMapperData>>(ttnMapperData, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<TtnMapperData> addTtnMapperData(@RequestBody TtnMapperData ttnMapperData) {
            logger.warn("ttnMapperData: " + ttnMapperData);
            Gateways router = ttnMapperData.getGateways().get(0);
            //TODO: añadir en esta clase un modificador de la distancia y de la potencia a ver si funciona.
            ttnMapperData.setPotencia(14);
            List<Gateways> gateways = new ArrayList<Gateways>();
            for(Gateways gateway : ttnMapperData.getGateways()) {
                gateway.setMetros(ttnMapperData.getDistance(gateway.getLatitude(), gateway.getLongitude()));
                gateways.add(gateway);
            }
            ttnMapperData.setGateways(gateways);
            ttnMapperData.setMetros(ttnMapperData.getDistance(router.getLatitude(), router.getLongitude()));
            TtnMapperData newTtnMapperData = ttnMapperDataRepository.save(ttnMapperData);
            return new ResponseEntity<TtnMapperData>(newTtnMapperData, HttpStatus.OK);
        }

        @PutMapping("/update")
        public ResponseEntity<TtnMapperData> updateTtnMapperData(@RequestBody TtnMapperData ttnMapperData) {
            TtnMapperData updatedTtnMapperData = ttnMapperDataRepository.save(ttnMapperData);
            return new ResponseEntity<TtnMapperData>(updatedTtnMapperData, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<TtnMapperData> deleteTtnMapperData(@PathVariable("id") Integer id) {
            ttnMapperDataRepository.deleteById(id);
            return new ResponseEntity<TtnMapperData>(HttpStatus.OK);
        }

        @RequestMapping(value = "/greeting", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
        @ResponseBody
        public String greetingJson(HttpEntity<String> httpEntity) {
            String json = httpEntity.getBody();
            // json contains the plain json string
            logger.warn("json: " + json);
            return json;
        }

        @GetMapping("/cleaned")
        public List<Map<String, Object>> getCleanedTtnMapperData() {
            List<TtnMapperData> ttnMapperData = ttnMapperDataRepository.findAll();
            List<Map<String, Object>> cleanedTtnMapperData = new ArrayList<Map<String,Object>>();

            for(TtnMapperData ttnMapperDataItem : ttnMapperData) {
                Integer index = 1;
                Map<String, Object> map =  new HashMap<>();
                for(Gateways gateway : ttnMapperDataItem.getGateways()) {
                    Map<String, Object> gatewayMap = new HashMap<>();
                    gatewayMap.put("name" , gateway.getGtw_id() != null ? gateway.getGtw_id() : "Unknown Gateway");
                    gatewayMap.put("rssi", (Double) gateway.getRssi() != null ? gateway.getRssi() : -10000 );
                    gatewayMap.put("snr", (Double) gateway.getSnr() != null ? gateway.getSnr() : -10000 );
                    gatewayMap.put("latitud", gateway.getLatitude() != null ? gateway.getLatitude() : -10000);
                    gatewayMap.put("longitud", gateway.getLongitude() != null ?gateway.getLongitude() : -10000);
                    gatewayMap.put("metros", ttnMapperDataItem.getDistance(gateway.getLatitude(), gateway.getLongitude()));
                    map.put("gateway_"+index, gatewayMap);
                    index++;
                }
                map.put("cliente", ttnMapperDataItem.getDev_id() != null ? ttnMapperDataItem.getDev_id() : "Unknown Device");
                map.put("sf", ttnMapperDataItem.getSpreading_factor() != null ? ttnMapperDataItem.getSpreading_factor() : -10000);
                map.put("latitud", ttnMapperDataItem.getLatitude() != null ?  ttnMapperDataItem.getLatitude() : -10000);
                map.put("longitud", ttnMapperDataItem.getLongitude() != null ? ttnMapperDataItem.getLongitude() : -10000);
                cleanedTtnMapperData.add(map);

            }
            return cleanedTtnMapperData;
        }
        @GetMapping("/csv")
        public void getAlTtnMapperDataCsv(HttpServletResponse servletResponse) throws IOException {
            List<TtnMapperData> ttnMapperData = ttnMapperDataRepository.findAll();
            CsvExportService csvExportService = new CsvExportService(ttnMapperDataRepository);
            servletResponse.setContentType("text/csv");
            servletResponse.addHeader("Content-Disposition","attachment; filename=\"ttnMapper.csv\"");
            Writer writer = servletResponse.getWriter();
            //csvExportService.writeEmployeesToCsv(servletResponse.getWriter());
            try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
                for (TtnMapperData ttnMapperItem : ttnMapperData) {
                    csvPrinter.printRecord(ttnMapperItem.getId());
                }
            } catch (IOException e) {
                log.error("Error While writing CSV ", e);
            }
        }

}
