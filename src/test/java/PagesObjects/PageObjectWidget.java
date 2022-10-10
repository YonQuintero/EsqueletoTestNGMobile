package PagesObjects;

import java.io.File;


import MapsObjects.MapObjectWidget;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class PageObjectWidget extends MapObjectWidget{
	
	//CREAR CONSTRUCTOR DE LA CLASE
		public PageObjectWidget(AppiumDriver<MobileElement> driver)
		{
			super(driver);
			this.driver = (AppiumDriver<MobileElement>) driver;
		}
		
		//METODO PRIMERA PRUEBA
		public void widget(String url,File rutaCarpeta,String generarEvidencia) throws Exception
		{
			//DAMOS CLICK EN VENTANAS
			click(btnVentana, rutaCarpeta,generarEvidencia,"Se da click en el boton de pestañas");
			//Y DAMOS CLICK EN NUEVA PESTAÑA 
			click(nuevaVentana, rutaCarpeta,generarEvidencia,"Abrimos una nueva ventana");
			//DAMOS CLICK EN EL BOTON MI ALIBABA
			click(btnBuscarGoogle, rutaCarpeta,generarEvidencia,"Damos click para realizar una busqueda");
			tiempoEspera(1000);
			//ENVIAMOS UN VALOR A BUSCAR
			sendkey(url, btnBuscarGoogle, rutaCarpeta,0,generarEvidencia,"Enviamos el valor a buscar");
			//AGREGAMOS UN ENTER PARA INGRESAR A LA PAGINA 
			enter(rutaCarpeta, 0);
			//DAMOS UN TIEMPO DE ESPERA 
			tiempoEspera(1500);
			//BAJAMOS UN POCO CON EL SCROLL
			scrollVertical(rutaCarpeta,500,2021,735,3);
			//DAMOS UN TIEMPO DE ESPERA 
			tiempoEspera(3000);
			//DAMOS CLICK EN WIDGETS
			click(btnWidget, rutaCarpeta, generarEvidencia,"Damos click en el boton widgets");
			//DAMOS UN TIEMPO DE ESPERA 
			tiempoEspera(1500);
			//DAMOS CLICK EN DATAPICKER
			click(btnDatePicker, rutaCarpeta, generarEvidencia,"Damos click en datapicker");
			//DAMOS UN TIEMPO DE ESPERA 
			tiempoEspera(1500);
			//DAR CLICK PARA SELECIONAR LA CAJA
		    click(txtDate, rutaCarpeta, generarEvidencia,"Damos click para enfocar el campo");
		    tiempoEspera(2000);
			//LIMPIAR CAJA DE TEXTO
			borrar(txtDate, rutaCarpeta, 2000,generarEvidencia,"Limpiamos el campo de texto");
		    //ENVIAMOS UNA FECHA
		    sendkey("08/08/2021",txtDate, rutaCarpeta, 2000 ,generarEvidencia,"Enviamos la información");
		    enter(rutaCarpeta, 0);
		}
		
		public void fecha2(String url,File rutaCarpeta,String generarEvidencia) throws Exception
		{
			
			//LIMPIAR CAJA DE TEXTO
			borrar(txtDate2, rutaCarpeta, 2000,generarEvidencia,"Limpiamos el campo de texto de la segunda fecha");
			//ENVIAMOS UNA FECHA Y UNA HORA
		    sendkey("August 7, 2020 12:15PM",txtDate2, rutaCarpeta, 2000,generarEvidencia,"Enviamos la información" );
		   
		    
		}
}
