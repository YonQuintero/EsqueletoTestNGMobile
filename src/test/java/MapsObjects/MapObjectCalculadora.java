package MapsObjects;

import org.openqa.selenium.By;
import ClasesBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectCalculadora extends ClaseBase 
{
	//CONSTRUCTOR DE LA CLASE
	public MapObjectCalculadora(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}
	
	//ELEMENTOS PAGINA INICIAL
	protected By numero1=By.xpath("//android.widget.Button[@text='{0}']");
	protected By btnOperacion=By.xpath("//android.widget.Button[@content-desc='{0}']");
	protected By igual=By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal");
	protected By btnCe=	By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_clear");	
	}

