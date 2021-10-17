package tugas1.sivaksin.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vaksin")
public class VaksintModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "vaksin_number", nullable = false)
	private String vaksinNumber;
	

	@NotNull
	@Size(max = 50)
	@Column(name = "origin", nullable = false)
	private String origin;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "destination", nullable = false)
	private String destination;
	
	@NotNull
	@Column(name = "time")
	private Date time;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fakes_licenseNumber", referencedColumnName = "license_number", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private FakesModel fakes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVaksintNumber() {
		return vaksinNumber;
	}

	public void setVaksinNumber(String vaksinNumber) {
		this.vaksinNumber = vaksinNumber;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public FakesModel getFakes() {
		return fakes;
	}

	public void setFakes(FakesModel fakes) {
		this.fakes = fakes;
		
	}
	
	
}