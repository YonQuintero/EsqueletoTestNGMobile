package MapsObjects;

import org.openqa.selenium.By;

import ClasesBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectCrearCuenta extends ClaseBase {
	
		//CONSTRUCTOR DE LA CLASE
			public MapObjectCrearCuenta(AppiumDriver<MobileElement> driver)
			{
				super(driver);
			}
			//ELEMENTOS PAGINA INICIAL
			protected By btnCrearCuenta=By.xpath("//android.view.View[@content-desc='Crear cuenta']");
			protected By terminosCondiciones=By.xpath("//android.widget.CheckBox");
			protected By btnContinuar=By.xpath("//android.widget.TextView[@text='Continuar']");
			protected By btnValidar=By.xpath("//android.widget.Button[@text='Validar']");
			protected By txtEmail=By.xpath("//android.widget.EditText[@text='']");
}
