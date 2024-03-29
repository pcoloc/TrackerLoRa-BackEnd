package com.trackerlora.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "ttnmapper")
public class TtnMapper {
    //the id is called id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer uid;

    private String session;

    private String dev_id;

    private long time;

    private Integer fport;

    private Integer fcount;

    private long frequency;

    private long bandwidth;

    private long spreading_factor;

    private String coding_rate;

    private String gateway_id;

    private Integer antenna_index;

    private long gateway_time;

    private long gateway_timestamp;

    private Integer channel_index;

    private Integer rssi;

    private Integer snr;

    private float gateway_latitude;

    private float gateway_longitude;

    private long gateway_altitude;

    private float latitude;

    private float longitude;

    private float altitude;

    private float accuracy_meters;

    //Getter and Setter methods are automatically generated
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getDevID() {
        return dev_id;
    }

    public void setDevID(String dev_id) {
        this.dev_id = dev_id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getFPort() {
        return fport;
    }

    public void setFPort(Integer fport) {
        this.fport = fport;
    }

    public long getFCount() {
        return fcount;
    }

    public void setFCount(Integer fcount) {
        this.fcount = fcount;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public long getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(long bandwidth) {
        this.bandwidth = bandwidth;
    }

    public long getSpreadingFactor() {
        return spreading_factor;
    }

    public void setSpreadingFactor(long spreading_factor) {
        this.spreading_factor = spreading_factor;
    }

    public String getCodingRate() {
        return coding_rate;
    }

    public void setCodingRate(String coding_rate) {
        this.coding_rate = coding_rate;
    }

    public String getGatewayID() {
        return gateway_id;
    }

    public void setGatewayID(String gateway_id) {
        this.gateway_id = gateway_id;
    }

    public long getAntennaIndex() {
        return antenna_index;
    }

    public void setAntennaIndex(Integer antenna_index) {
        this.antenna_index = antenna_index;
    }

    public long getGatewayTime() {
        return gateway_time;
    }

    public void setGatewayTime(long gateway_time) {
        this.gateway_time = gateway_time;
    }

    public long getGatewayTimestamp() {
        return gateway_timestamp;
    }

    public void setGatewayTimestamp(long gateway_timestamp) {
        this.gateway_timestamp = gateway_timestamp;
    }

    public long getChannelIndex() {
        return channel_index;
    }

    public void setChannelIndex(Integer channel_index) {
        this.channel_index = channel_index;
    }

    public long getRssi() {
        return rssi;
    }

    public void setRssi(Integer rssi) {
        this.rssi = rssi;
    }

    public long getSnr() {
        return snr;
    }

    public void setSnr(Integer snr) {
        this.snr = snr;
    }

    public float getGatewayLatitude() {
        return gateway_latitude;
    }

    public void setGatewayLatitude(float gateway_latitude) {
        this.gateway_latitude = gateway_latitude;
    }

    public float getGatewayLongitude() {
        return gateway_longitude;
    }

    public void setGatewayLongitude(float gateway_longitude) {
        this.gateway_longitude = gateway_longitude;
    }

    public long getGatewayAltitude() {
        return gateway_altitude;
    }

    public void setGatewayAltitude(long gateway_altitude) {
        this.gateway_altitude = gateway_altitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public float getAccuracyMeters() {
        return accuracy_meters;
    }

    public void setAccuracyMeters(float accuracy_meters) {
        this.accuracy_meters = accuracy_meters;
    }

    @Override
    public String toString() {
        return "TtnMapper [id=" + id + ", uid=" + uid + ", Session=" + session + ", DevID=" + dev_id + ", Time="
                + time + ", FPort=" + fport + ", FCount=" + fcount + ", Frequency=" + frequency + ", Bandwidth="
                + bandwidth + ", SpreadingFactor=" + spreading_factor + ", CodingRate=" + coding_rate + ", GatewayID="
                + gateway_id + ", AntennaIndex=" + antenna_index + ", GatewayTime=" + gateway_time + ", GatewayTimestamp="
                + gateway_timestamp + ", ChannelIndex=" + channel_index + ", Rssi=" + rssi + ", Snr=" + snr
                + ", GatewayLatitude=" + gateway_latitude + ", GatewayLongitude=" + gateway_longitude
                + ", GatewayAltitude=" + gateway_altitude + ", Latitude=" + latitude + ", Longitude=" + longitude
                + ", Altitude=" + altitude + ", AccuracyMeters=" + accuracy_meters + "]";
    }

    public TtnMapper(Integer id, Integer uid, String session, String devID, long time, Integer fPort,
            Integer fCount, long frequency, long bandwidth, long spreadingFactor, String codingRate,
            String gatewayID, Integer antennaIndex, long gatewayTime, long gatewayTimestamp, Integer channelIndex,
            Integer rssi, Integer snr, float gatewayLatitude, float gatewayLongitude, long gatewayAltitude,
            float latitude, float longitude, float altitude, float accuracyMeters) {
        super();
        this.id = id;
        this.uid = uid;
        this.session = session;
        this.dev_id = devID;
        this.time = time;
        this.fport = fPort;
        this.fcount = fCount;
        this.frequency = frequency;
        this.bandwidth = bandwidth;
        this.spreading_factor = spreadingFactor;
        this.coding_rate = codingRate;
        this.gateway_id = gatewayID;
        this.antenna_index = antennaIndex;
        this.gateway_time = gatewayTime;
        this.gateway_timestamp = gatewayTimestamp;
        this.channel_index = channelIndex;
        this.rssi = rssi;
        this.snr = snr;
        this.gateway_latitude = gatewayLatitude;
        this.gateway_longitude = gatewayLongitude;
        this.gateway_altitude = gatewayAltitude;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.accuracy_meters = accuracyMeters;

    }
    public TtnMapper() {
    }
}
