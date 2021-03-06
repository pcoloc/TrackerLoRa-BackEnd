package com.trackerlora.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "apis")
public class Api {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuid;

    private String name;

    private String description;

    private String apiKey;

    private String ownerUuid;

    private boolean isActive;

    private String clientUuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getOwnerUuid() {
        return ownerUuid;
    }

    public void setOwnerUuid(String ownerUuid) {
        this.ownerUuid = ownerUuid;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getClientUuid() {
        return clientUuid;
    }

    public void setClientUuid(String clientUuid) {
        this.clientUuid = clientUuid;
    }

    public Api() {
    }

    public Api(String uuid, String name, String description, String apiKey, String ownerUuid, boolean isActive, String clientUuid) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.apiKey = apiKey;
        this.ownerUuid = ownerUuid;
        this.isActive = isActive;
        this.clientUuid = clientUuid;
    }

    @Override
    public String toString() {
        return "Api{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", ownerUuid='" + ownerUuid + '\'' +
                ", isActive=" + isActive +
                ", clientUuid='" + clientUuid + '\'' +
                '}';
    }


}
