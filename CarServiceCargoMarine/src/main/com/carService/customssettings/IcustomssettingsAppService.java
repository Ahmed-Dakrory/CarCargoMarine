/**
 * 
 */
package main.com.carService.customssettings;

import java.util.List;

/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface IcustomssettingsAppService {

	public List<customssettings> getAll();
	public List<customssettings> getAllByUserId(int userId);
	public customssettings addcustomssettings(customssettings data);
	public customssettings getById(int id);
	public boolean delete(customssettings data)throws Exception;
}
