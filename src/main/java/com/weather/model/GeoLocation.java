package com.weather.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "geo_location")
public class GeoLocation {

    @Id
    private String id;
    private String name;
    @Indexed
    private String timezone;
    private Double longitude;
    private Double latitude;


	public GeoLocation(String id, String name, String timezone, Double longitude, Double latitude) {
		super();
		this.id = id;
		this.name = name;
		this.timezone = timezone;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoLocation country = (GeoLocation) o;
        return name == country.name &&
                Objects.equals(id, country.id) &&
                Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GeoLocation{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append('}');
        return sb.toString();
    }
}