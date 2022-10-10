package PagesObjects;

import java.io.File;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



import MapsObjects.MapObjectAlertasM;


public class PageObjectAlertasM extends MapObjectAlertasM
{
	
	//CREAR CONSTRUCTOR DE LA CLASE
	public PageObjectAlertasM(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}
	
	
	
	//METODO PRIMERA PRUEBA
	public void alertas(String url,File rutaCarpeta,String generarEvidencia) throws Exception
	{
		//DAMOS CLICK EN VENTANAS
		click(btnVentana, rutaCarpeta,generarEvidencia,"Se da click en pestañas");
		//Y DAMOS CLICK EN NUEVA PESTAÑA 
		click(nuevaVentana, rutaCarpeta,generarEvidencia,"Se da click para abrir una nueva ventana en el navegador ");
		//DAMOS CLICK EN EL BOTON MI ALIBABA
		click(btnBuscarGoogle, rutaCarpeta,generarEvidencia,"Se da click para realizar una busqueda");
		//DAMOS TIEMPO DE ESPERA
		tiempoEspera(1000);
		//ENVIAMOS UN VALOR A BUSCAR
		sendkey(url, btnBuscarGoogle, rutaCarpeta,0,generarEvidencia,"Se envia el valor a buscar");
		//AGREGAMOS UN ENTER PARA INGRESAR A LA PAGINA 
		enter(rutaCarpeta, 2000);
		//BAJAMOS UN POCO CON EL SCROLL
		scrollVertical(rutaCarpeta,500,2021,735,2);
		//DAMOS UN TIEMPO DE ESPERA 
		tiempoEspera(2000);
		//DAMOS CLICK EN ALERTAS, FRAME Y WINDOWS
		click1(btnAlerts, rutaCarpeta,generarEvidencia,"Se da click en el boton alerts, frame & window");
		tiempoEspera(1500);
		//DAMOS CLICK EN ALERTAS
		click1(btnAlertas, rutaCarpeta,generarEvidencia,"Se da click en el boto alerts ");
		//tiempoEspera(1500);
		//DAMOS CLICK EN LA PRIMERA ALERTA
		click1(btnAlerta1, rutaCarpeta, generarEvidencia,"Se da click en el boton de la primera alertas");
		//tocarPantalla(172,618);
		tiempoEspera(2000);
		//DAMOS ACEPTAR 
		click(btnAceptar, rutaCarpeta, generarEvidencia,"Damos click en aceptar");
		tiempoEspera(2000);
		//DAMOS CLICK EN LA SEGUNDA ALERTA
		click1(btnAlerta2, rutaCarpeta, generarEvidencia,"Se da click en el boton de la segunda alerta");
		tiempoEspera(6000);
		//DAMOS ACEPTAR 
		click(btnAceptar, rutaCarpeta, generarEvidencia,"Damos click en aceptar");
		tiempoEspera(6000);
		//DAMOS CLICK EN LA TERCERA ALERTA
		click1(btnAlerta3, rutaCarpeta, generarEvidencia,"Se da click en el boton de la tercera alerta");
		tiempoEspera(2000);
		//DAMOS CLICK EN CANCELAR
		click(btnCancelar, rutaCarpeta, generarEvidencia,"Damos click en cancelar");
		tiempoEspera(2000);
		//DAMOS CLICK NUEVAMENTE EN LA TERCERA ALERTA
		click1(btnAlerta3, rutaCarpeta, generarEvidencia,"Volvemos a dar click en el boton de la tercera alerta");
		tiempoEspera(2000);
		//DAMOS CLICK EN ACEPTAR 
		click(btnAceptar, rutaCarpeta, generarEvidencia,"Damos click en aceptar");
		tiempoEspera(2000);
		//DAMOS CLICK EN LA CUARTA ALERTA
		click1(btnAlerta4, rutaCarpeta, generarEvidencia,"Se da click en el boton de la cuarta alerta");
		tiempoEspera(2000);
		//ENVIAMOS LA INFORMACION
		sendkey("Esneider", txtInfo, rutaCarpeta,2000,generarEvidencia,"Enviamos el valor ");
		//DAMOS CLICK EN ACEPTAR
		click(btnAceptar, rutaCarpeta, generarEvidencia,"Damos click en aceptar");
		tiempoEspera(2000);
	}
		
}
