/**
 * 
 */
package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author usuario
 *
 */
public class TestLogin {

	//Global la variable para ser llamada desde el test
	WebDriver driverChrome;
	
	
	/**
	 * Preparar setup
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		/**
		 * PARA INGRESO AL CURSO correo: ddemostracion6@gmail.com contraseña :
		 * Prueba2019*
		 */

		// BUSCA EL DRIVER EN EL COMPUTADOR
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

		// INSTANCIAR EL DRIVER
		driverChrome = new ChromeDriver();

		//Abrir la página
		driverChrome.get("https://startupslab.co/");
		
		// Maximizar la pantalla
		driverChrome.manage().window().maximize(); 

		//Espera
		try {

			Thread.sleep(5000);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	
	
	

	@Test
	public void testLogin() {

		//Buscar botón inicio de sesión
		WebElement botonInicioSesion = driverChrome.findElement(By.xpath("//*[@class=\"btn btn-secondary mx-md-3 btn-block btn-sm-inline\"]"));

		botonInicioSesion.click();

		//Tiempo de espera
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			
		}

		// Obtener elemento email e ingresar usuario
		WebElement usuarioIngreso = driverChrome.findElement(By.xpath("//*[@type=\"email\"]"));
		
		usuarioIngreso.sendKeys("ddemostracion6@gmail.com");
		

		// Obtener elemento password e ingresarla 
		WebElement claveIngreso = driverChrome.findElement(By.xpath("//*[@name=\"password\"]"));

		claveIngreso.sendKeys("Prueba2019*");

		
		// Obtener y dar click al botón de ingreso
		WebElement botonIngresar = driverChrome.findElement(By.xpath("//*[@class=\"btn btn-secondary\"]"));

		botonIngresar.click();

		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			
		}

		
		// Traer elemento y guardarlo en una variable
		WebElement nombreSesion = driverChrome.findElement(By.id("userDropdown")); // Buscando por id

		String textoDelElemento = nombreSesion.getText();

		String textoQueYoEsperaba = "¡Hola, Prueba!";

		
		// comparar usando assert de Junit
		assertEquals(textoQueYoEsperaba, textoDelElemento);

		
		// MENSAJE QUE IMPRIME EN CONSOLA
		System.out.println("Prueba exitosa = " + textoDelElemento);

		
		}

	
	
	/**
	 * Demoler teardown
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
			//cerrar o quitar el driver
			driverChrome.quit();
	}

}
