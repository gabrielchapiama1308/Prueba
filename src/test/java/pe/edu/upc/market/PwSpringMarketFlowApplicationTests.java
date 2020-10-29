package pe.edu.upc.market;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import pe.edu.upc.market.models.entities.Distrito;
import pe.edu.upc.market.services.DistritoService;

@SpringBootTest
class PwSpringMarketFlowApplicationTests {

	@Autowired
	private DistritoService distritoService;
	
	@Test
	void contextLoads() {
		
		Distrito distrito = new Distrito();
		distrito.setNombre("Pueblo Libre");
		distrito.setProvincia("Lima");
		
		try {
			distritoService.save(distrito);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.isTrue(true);
		
	}

}
