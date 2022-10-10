package MapsObjects;

import org.openqa.selenium.By;

import ClasesBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectWidget extends ClaseBase {

	//CONSTRUCTOR DE LA CLASE
		public MapObjectWidget(AppiumDriver<MobileElement> driver)
		{
			super(driver);
		}
		//ELEMENTOS PAGINA INICIAL
		protected By btnVentana=By.xpath("//android.widget.ImageButton[@content-desc='Cambiar o cerrar pestañas']");
		protected By nuevaVentana=By.xpath("//android.widget.ImageView[@content-desc='Nueva pestaña']");
		protected By btnBuscarGoogle=By.xpath("//android.widget.EditText[@text='Busca o escribe la dirección web']");
		protected By btnWidget=By.xpath("//android.widget.TextView[@text='Widgets']");
		protected By btnDatePicker=By.xpath("//android.widget.TextView[@text='Date Picker']");
		protected By txtDate=By.xpath("//android.widget.EditText[@resource-id='datePickerMonthYearInput']");
		protected By txtDate2=By.xpath("//android.widget.EditText[@resource-id='dateAndTimePickerInput']");
		protected By btnHora=By.xpath("//android.view.View[@text='12:15']");
}
