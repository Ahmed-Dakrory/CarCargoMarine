package main.com.carService.customssettings;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import main.com.carService.loginNeeds.user;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="customssettings.getAll",
		     query="SELECT c FROM customssettings c where c.deleted = false"
		     )
	,
	@NamedQuery(name="customssettings.getById",
	query = "from customssettings d where d.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="customssettings.getAllByUserId",
	query = "from customssettings d where d.userId.id = :id and d.deleted = false"
			)
	
	

})

@Entity
@Table(name = "customssettings")
public class customssettings {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	
	
	@Column(name = "st")
	private String st;
	
	@Column(name = "ibt")
	private String ibt;
	
	@Column(name = "poe")
	private String poe;

	@Column(name = "cod")
	private String cod;
	
	@Column(name = "pou")
	private String pou;
	
	@Column(name = "mot")
	private String mot;
	
	
	@Column(name = "rcc")
	private String rcc;
	
	@Column(name = "haz")
	private String haz;
	
	@Column(name = "rt")
	private String rt;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private user userId;
	

	@Column(name = "deleted")
	private boolean deleted;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}



	


	public String getSt() {
		return st;
	}


	public void setSt(String st) {
		this.st = st;
	}


	public String getIbt() {
		return ibt;
	}


	public void setIbt(String ibt) {
		this.ibt = ibt;
	}


	public String getPoe() {
		return poe;
	}


	public void setPoe(String poe) {
		this.poe = poe;
	}


	public String getCod() {
		return cod;
	}


	public void setCod(String cod) {
		this.cod = cod;
	}


	public String getPou() {
		return pou;
	}


	public void setPou(String pou) {
		this.pou = pou;
	}



	public String getMot() {
		return mot;
	}


	public void setMot(String mot) {
		this.mot = mot;
	}


	public String getRcc() {
		return rcc;
	}


	public void setRcc(String rcc) {
		this.rcc = rcc;
	}


	public String getHaz() {
		return haz;
	}


	public void setHaz(String haz) {
		this.haz = haz;
	}


	public String getRt() {
		return rt;
	}


	public void setRt(String rt) {
		this.rt = rt;
	}


	public user getUserId() {
		return userId;
	}


	public void setUserId(user userId) {
		this.userId = userId;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
	
	
	
}
