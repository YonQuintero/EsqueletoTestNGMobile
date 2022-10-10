package PagesObjects;

import java.io.File;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



import MapsObjects.MapObjectCalculadora;


public class PageObjectCalculadora extends MapObjectCalculadora
{
	
	//CREAR CONSTRUCTOR DE LA CLASE
	public PageObjectCalculadora(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}
	
	
	
	//METODO PRIMERA PRUEBA
	public void suma(String operacion,String valor1,String valor2,File rutaCarpeta,String generarEvidencia) throws Exception
	{
		try {
			//DAMOS CLICK EN EL PRIMERO NUMERO 
		    digitos(valor1,numero1, rutaCarpeta, generarEvidencia);
			//DAMOS UN TIEMPO DE ESPERA
			tiempoEspera(1000);
			//DAMOS CLICK EN EL ICONO DE SUMA
			click(localizadorVariable(btnOperacion,operacion), rutaCarpeta, generarEvidencia,"Damos click en el boton de alguna operación" );
			//DAMOS UN TIEMPO DE ESPERA
			tiempoEspera(1000);
			//DAMOS CLICK EN EL SEGUNDO NUMERO 
			digitos(valor2,numero1, rutaCarpeta,generarEvidencia);
			//DAMOS UN TIEMPO DE ESPERA
			tiempoEspera(1000);
			//DAMOS CLICK EN IGUAL
			click(igual, rutaCarpeta, generarEvidencia,"Damos click en el boton igual");
			//DAMOS UN TIEMPO DE ESPERA
			tiempoEspera(1000);
			//DAMOS CLICK PARA BORRAR 
			click(btnCe,rutaCarpeta, generarEvidencia,"Damos click en el boton CE para dejar la calculadora limpia");
			//DAMOS UN TIEMPO DE ESPERA
			tiempoEspera(1000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
		
}
