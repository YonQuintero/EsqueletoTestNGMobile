package PagesObjects;

import java.io.File;
import MapsObjects.MapObjectMercadoLibre;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjectMercadoLibre extends MapObjectMercadoLibre {
	// CREAR CONSTRUCTOR DE LA CLASE
	public PageObjectMercadoLibre(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	public void pagina(String Productos, String Google, File rutaCarpeta, String generarEvidencia) throws Exception {
		try {
			// DAMOS CLICK EN EL BOTON MI ALIBABA
			click(btnBuscarGoogle, rutaCarpeta, generarEvidencia,"Damos click en el boton para realizar una busqueda");
			// DAMOS UN TIEMPO DE ESPERA
			tiempoEspera(1000);
			// ENVIAMOS UN VALOR A BUSCAR
			sendkey(Google, btnBuscarGoogle, rutaCarpeta, 0, generarEvidencia,"Enviamos un valor a buscar");
			// AGREGAMOS UN ENTER PARA REALIZAR LA BUSQUEDA EN GOOGLE			
			enter(rutaCarpeta, 1000);
			// DAMOS CLICK PARA ENFOCAR EL CUADRO DE BUSQUEDA
			click(btnBuscar, rutaCarpeta, generarEvidencia,"Damos click en el boton para realizar una busqueda de un producto");
			// ENVIAMOS EL PRODUCTO A BUSCAR
			sendkey(Productos, btnBuscar, rutaCarpeta, 2000, generarEvidencia,"Enviamos el producto a buscar");
			enter(rutaCarpeta, 1000);
			// DAMOS UN TIEMPO DE ESPERA
			tiempoEspera(4000);
			// DAMOS CLICK EN EL PRIMER ELEMENTO
			click(primerElemento, rutaCarpeta, generarEvidencia,"Damos click en el primer producto");
			// DAMOS UN TIEMPO DE ESPERA
			tiempoEspera(3000);
			// BAJAMOS UN POCO CON EL SCROLL
			scrollVertical(rutaCarpeta, 500, 2021, 735, 1);
			// DAMOS CLICK EN AGREGAR AL CARRITO
			click(btnCarrito, rutaCarpeta, generarEvidencia,"Damos click en el boton agregar al carrito");
			// DAMOS UN TIEMPO DE ESPERA
			tiempoEspera(2000);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
