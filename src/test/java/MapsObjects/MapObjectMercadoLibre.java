package MapsObjects;

import org.openqa.selenium.By;

import ClasesBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectMercadoLibre extends ClaseBase{
	//CONSTRUCTOR DE LA CLASE
		public MapObjectMercadoLibre(AppiumDriver<MobileElement> driver)
		{
			super(driver);
		}
		//ELEMENTOS PAGINA INICIAL
		protected By btnBuscarGoogle=By.xpath("//android.widget.EditText[@text='Busca o escribe la dirección web']");
		protected By btnBuscar=By.xpath("//android.widget.EditText[@resource-id='cb1-edit']");
		//protected By btnBuscar=By.xpath("//android.widget.EditText[@text='']");
		protected By btnLupa=By.xpath("//android.widget.Button[@text='Buscar']");
		protected By primerElemento=By.xpath("(//android.view.View)[16]");
		protected By btnCarrito=By.xpath("//android.widget.Button[@text='Agregar al carrito']");
}
