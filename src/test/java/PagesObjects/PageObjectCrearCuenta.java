package PagesObjects;

import java.io.File;
import MapsObjects.MapObjectCrearCuenta;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class PageObjectCrearCuenta extends MapObjectCrearCuenta{
	//CREAR CONSTRUCTOR DE LA CLASE
	public PageObjectCrearCuenta(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
		
	}
	public void crearCuenta(String correo,File rutaCarpeta,String generarEvidencia) throws Exception
	{
		//DAMOS CLICK EN CREAR CUENTA
		click(btnCrearCuenta, rutaCarpeta, generarEvidencia,"Damos click en el boton crear cuenta");
		//DAMOS UN TIEMPO DE ESPERA
		tiempoEspera(4000);
		//DAMOS CLICK EN ACEPTAR TERMINOS Y CONDICIONES
		click(terminosCondiciones, rutaCarpeta,generarEvidencia,"Damos click en el boton de terminos y condiciones");
		//DAMOS UN TIEMPO DE ESPERA
		tiempoEspera(2000);
		//CLICK EN CONTINUAR
		click(btnContinuar, rutaCarpeta,generarEvidencia,"Damos click en el boton continuar");
		//DAMOS UN TIEMPO DE ESPERA
		tiempoEspera(2000);
		//DAMOS CLICK EN EL BOTON VALIDAR
		click(btnValidar, rutaCarpeta, generarEvidencia,"Damos click en el boton de validar");
		//DAMOS UN TIEMPO DE ESPERA
		tiempoEspera(2000);
		//ENVIAMOS EL EMAIL
		sendkey(correo, txtEmail, rutaCarpeta,2000, generarEvidencia,"Enviamos información al campo de texto");
	}
}
