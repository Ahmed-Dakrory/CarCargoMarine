/**
 * 
 */
package main.com.carService.customssettings;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dakrory
 *
 */
@Service("customssettingsFacadeImpl")
public class customssettingsAppServiceImpl implements IcustomssettingsAppService{

	@Autowired
	customssettingsRepository customssettingsDataRepository;
	
	
	@Override
	public List<customssettings> getAll() {
		try{
			List<customssettings> course=customssettingsDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public customssettings addcustomssettings(customssettings data) {
		try{
			customssettings data2=customssettingsDataRepository.addcustomssettings(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(customssettings data)throws Exception {
		// TODO Auto-generated method stub
		try{
			customssettingsDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public customssettings getById(int id) {
		// TODO Auto-generated method stub
		try{
			customssettings so=customssettingsDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}




	



	@Override
	public List<customssettings> getAllByUserId(int userId) {
		try{
			List<customssettings> course=customssettingsDataRepository.getAllByUserId(userId);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	
	
	
}
		
		

	
		
	


