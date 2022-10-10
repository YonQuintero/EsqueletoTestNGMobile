package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectAlertasM extends ClaseBase 
{
	//CONSTRUCTOR DE LA CLASE
	public MapObjectAlertasM(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}
	
	//ELEMENTOS PAGINA INICIAL
	protected By btnVentana=By.xpath("//android.widget.ImageButton[@content-desc='Cambiar o cerrar pestañas']");
	protected By nuevaVentana=By.xpath("//android.widget.ImageView[@content-desc='Nueva pestaña']");
	protected By btnBuscarGoogle=By.xpath("//android.widget.EditText[@text='Busca o escribe la dirección web']");
	protected By btnAlerts=By.xpath("//android.widget.TextView[@text='Alerts, Frame & Windows']");
	protected By btnAlertas=By.xpath("//android.widget.TextView[@text='Alerts']");
	protected By btnAlerta1=By.xpath("//android.widget.Button[@resource-id='alertButton']");
	protected By btnAceptar=By.xpath("//android.widget.Button[@text='Aceptar']");
	protected By btnAlerta2=By.xpath("//android.widget.Button[@resource-id='timerAlertButton']");
	protected By btnAlerta3=By.xpath("//android.widget.Button[@resource-id='confirmButton']");
	protected By btnCancelar=By.xpath("//android.widget.Button[@text='Cancelar']");
	protected By btnAlerta4=By.xpath("//android.widget.Button[@resource-id='promtButton']");
	protected By txtInfo=By.xpath("//android.widget.EditText[@text='']");
	
	}

