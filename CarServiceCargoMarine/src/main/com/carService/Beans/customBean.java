package main.com.carService.Beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import main.com.carService.customssettings.customssettings;
import main.com.carService.customssettings.customssettingsAppServiceImpl;
import main.com.carService.loginNeeds.user;


@ManagedBean(name = "customBean")
@SessionScoped
public class customBean implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842440236769354416L;


	/**
	 * 
	 */
	
	
 
	

	@ManagedProperty(value = "#{loginBean}")
	private main.com.carService.loginNeeds.loginBean loginBean; 
	 


	private List<customssettings> customSettingsListForThisUser;

	@ManagedProperty(value = "#{customssettingsFacadeImpl}")
	private customssettingsAppServiceImpl customssettingsFacade;
	
	private user theUserOfThisAccount;
	

	private customssettings addedNewCustomSetting;
	private customssettings selectedCustomSetting;
	
	@PostConstruct
	public void init() {

		theUserOfThisAccount = loginBean.getTheUserOfThisAccount();
		refresh();
		
		
	}
	
	
	public void refresh(){
		
		customSettingsListForThisUser = customssettingsFacade.getAllByUserId(theUserOfThisAccount.getId());
		
	}


	
	public void goToAddNewcustomSetting() {
		addedNewCustomSetting=new customssettings();
		addedNewCustomSetting.setUserId(theUserOfThisAccount);
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/admin/customs/customSettings/addCustomSetting.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		
	
	public void selectcustomsSettings(int id) {
		selectedCustomSetting = customssettingsFacade.getById(id);
		
		try {
			FacesContext.getCurrentInstance()
			   .getExternalContext().redirect("/pages/secured/admin/customs/customSettings/editCustomSetting.jsf?faces-redirect=true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 
	 * the Getter and setter for the bean
	 */
	
	
	
	

	public main.com.carService.loginNeeds.loginBean getLoginBean() {
		return loginBean;
	}


	public customssettings getAddedNewCustomSetting() {
		return addedNewCustomSetting;
	}


	public void setAddedNewCustomSetting(customssettings addedNewCustomSetting) {
		this.addedNewCustomSetting = addedNewCustomSetting;
	}


	public void setLoginBean(main.com.carService.loginNeeds.loginBean loginBean) {
		this.loginBean = loginBean;
	}


	public List<customssettings> getCustomSettingsListForThisUser() {
		return customSettingsListForThisUser;
	}


	public void setCustomSettingsListForThisUser(List<customssettings> customSettingsListForThisUser) {
		this.customSettingsListForThisUser = customSettingsListForThisUser;
	}


	public customssettingsAppServiceImpl getCustomssettingsFacade() {
		return customssettingsFacade;
	}


	public void setCustomssettingsFacade(customssettingsAppServiceImpl customssettingsFacade) {
		this.customssettingsFacade = customssettingsFacade;
	}


	public user getTheUserOfThisAccount() {
		return theUserOfThisAccount;
	}


	public void setTheUserOfThisAccount(user theUserOfThisAccount) {
		this.theUserOfThisAccount = theUserOfThisAccount;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public customssettings getSelectedCustomSetting() {
		return selectedCustomSetting;
	}


	public void setSelectedCustomSetting(customssettings selectedCustomSetting) {
		this.selectedCustomSetting = selectedCustomSetting;
	}
	
	

}
