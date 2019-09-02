package main.com.carService.custom;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import main.com.carService.consignee.consignee;
import main.com.carService.customssettings.customssettings;
import main.com.carService.loginNeeds.user;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="custom.getAll",
		     query="SELECT c FROM custom c where c.deleted = false"
		     )
	,
	@NamedQuery(name="custom.getById",
	query = "from custom d where d.id = :id and d.deleted = false"
			)
	,
	@NamedQuery(name="custom.getAllByUserId",
	query = "from custom d where d.userId.id = :id and d.deleted = false"
			)
	
	

})

@Entity
@Table(name = "custom")
public class custom {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "consigneeType")
	private String consigneeType;
	
	@Column(name = "soldEnRoute")
	private String soldEnRoute;
	
	@Column(name = "eda")
	private String eda;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private user userId;
	
	@ManyToOne
	@JoinColumn(name = "freightForwarderId")
	private consignee freightForwarderId;

	@ManyToOne
	@JoinColumn(name = "usppiId")
	private consignee usppiId;
	

	@ManyToOne
	@JoinColumn(name = "ulConsigneeId")
	private consignee ulConsigneeId;
	

	@ManyToOne
	@JoinColumn(name = "interConsigneeId")
	private consignee interConsigneeId;
	
	

	@ManyToOne
	@JoinColumn(name = "freightForwardedId")
	private consignee freightForwardedId;
	

	@ManyToOne
	@JoinColumn(name = "customsSettingsId")
	private customssettings customsSettingsId;
	

	@Column(name = "deleted")
	private boolean deleted;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getConsigneeType() {
		return consigneeType;
	}


	public void setConsigneeType(String consigneeType) {
		this.consigneeType = consigneeType;
	}


	public String getSoldEnRoute() {
		return soldEnRoute;
	}


	public void setSoldEnRoute(String soldEnRoute) {
		this.soldEnRoute = soldEnRoute;
	}


	public String getEda() {
		return eda;
	}


	public void setEda(String eda) {
		this.eda = eda;
	}


	public user getUserId() {
		return userId;
	}


	public void setUserId(user userId) {
		this.userId = userId;
	}


	public consignee getFreightForwarderId() {
		return freightForwarderId;
	}


	public void setFreightForwarderId(consignee freightForwarderId) {
		this.freightForwarderId = freightForwarderId;
	}


	public consignee getUsppiId() {
		return usppiId;
	}


	public void setUsppiId(consignee usppiId) {
		this.usppiId = usppiId;
	}


	public consignee getUlConsigneeId() {
		return ulConsigneeId;
	}


	public void setUlConsigneeId(consignee ulConsigneeId) {
		this.ulConsigneeId = ulConsigneeId;
	}


	public consignee getInterConsigneeId() {
		return interConsigneeId;
	}


	public void setInterConsigneeId(consignee interConsigneeId) {
		this.interConsigneeId = interConsigneeId;
	}


	public consignee getFreightForwardedId() {
		return freightForwardedId;
	}


	public void setFreightForwardedId(consignee freightForwardedId) {
		this.freightForwardedId = freightForwardedId;
	}


	public customssettings getCustomsSettingsId() {
		return customsSettingsId;
	}


	public void setCustomsSettingsId(customssettings customsSettingsId) {
		this.customsSettingsId = customsSettingsId;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	
	
	
}
