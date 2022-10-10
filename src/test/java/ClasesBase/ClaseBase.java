package ClasesBase;


import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.remote.DesiredCapabilities;

import Utilidades.GenerarReportePdf;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;



public class ClaseBase {
	protected AppiumDriver<MobileElement> driver;

	// CONSTRUCTOR DE CLASE
	public ClaseBase(AppiumDriver<MobileElement> driver) {
		super();
	}

	public void capturaPantalla(File rutaCarpeta, By locator, String generarEvidencia,String msj) throws Exception {
		String hora = HoraSistema();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
		String rutaImagen = new File(rutaCarpeta+"\\"+hora+".png").toString();
		//INSTANCIAMOS LA CLASE GENERAR PDF
		GenerarReportePdf informePdf = new GenerarReportePdf();
		//SE PROCEDE A INSERTAR LOCALIZADOR EN LA IMAGEN PDF
		informePdf.crearBody(locator, rutaImagen, msj);
		
		//ELIMINAR IMAGEN CREADA
		eliminarArchivo(rutaImagen);
	}

	public File crearCarpeta( String nomTest) {
		// ALMACENAMOS LA FECHA DEL SISTEMA
		String fecha = fechaHora();
		// CREAMOS EL NOMBRE DE LA CARPETA
		String nomCarpeta = nomTest + "-" + fecha;
		// OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
		File directorio = new File("./output/" + nomCarpeta);
		// CREAMOS LA CARPETA
		directorio.mkdir();
		return directorio;
	}

	public static String fechaHora() {

		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		// DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}
	public static String fechaHora2()
	{
		//TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		//DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}
	

	public String HoraSistema() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
		// DAR FORMATO A LA FECHA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;
	}

	// METODO DE NAVEGADOR
	@SuppressWarnings("rawtypes")
	public static AppiumDriver appiumDriverConnetion(String platformName, String deviceName, String platformVersion,String appPackage, String appActivity,String noReset, String autoGrantPermissions) throws InterruptedException
    {
        AppiumDriver driver = null;
        try
        {
            // CREARLAS CAPABILITYS DEL MOVIL
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", platformName);
            caps.setCapability("deviceName", deviceName);
            caps.setCapability("platformVersion",platformVersion);
            caps.setCapability("appPackage", appPackage);
            caps.setCapability("appActivity", appActivity);
            caps.setCapability("noReset",noReset);
            caps.setCapability("autoGrantPermissions",autoGrantPermissions);
            
            //INSTANCIAR APPIUM DRIVER
            try
            {
                imprimirConsola("cargando capability de appium, favor esperar ....");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);                    
                
            }
            catch (MalformedURLException e)
            {
            	imprimirConsola(e.getMessage());
            }
        return driver;
        }
        catch (Exception e)
        {
        	imprimirConsola(e.getMessage());
        }
        return driver;
    }
	public void captureScreenError(File rutaCarpeta, By locator, String generarEvidencia, String msnError) throws Exception
    {
        if (generarEvidencia.equals("Si"))
        {
            String hora = HoraSistema();
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
            String rutaImagen =new File(rutaCarpeta+"\\"+hora+".png").toString();
            
            //INSTACIAMOS LA CLASE GENERAR PDF
            GenerarReportePdf informePdf = new GenerarReportePdf();
            //SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
            informePdf.crearbodyError(locator,rutaImagen,msnError);
            //ELIMINAR IMAGEN CREADA
            
            eliminarArchivo(rutaImagen);
        }
    }
	
	public void eliminarArchivo(String rutaImagen)
	{
		File fichero = new File(rutaImagen);
		fichero.delete();
	}
	
	//METODO CLICK
	public void click1(By locator, File rutaCarpeta, String generarEvidencia, String msj) throws InterruptedException, Exception
	
	{
		try {
			capturaPantalla(rutaCarpeta, locator, generarEvidencia,msj);
			driver.findElement(locator).click();
			tiempoEspera(1000);
		} catch (Exception e) {
			captureScreenError(rutaCarpeta, locator, generarEvidencia,e.toString());
			//throw new InterruptedException();
		}
	}
	//METODO CLICK
		public void click(By locator, File rutaCarpeta, String generarEvidencia, String msj) throws InterruptedException, Exception
		
		{
			try {
				driver.findElement(locator).click();
				tiempoEspera(1000);
				capturaPantalla(rutaCarpeta, locator, generarEvidencia,msj);
			} catch (Exception e) {
				captureScreenError(rutaCarpeta, locator, generarEvidencia,e.toString());
				//throw new InterruptedException();
			}
		}

	

	// TIEMPO DE ESPERA
	protected void tiempoEspera(long tiempo) throws InterruptedException {

		Thread.sleep(tiempo);

	}

	// IMPRIMIR CONSOLA
	protected static void imprimirConsola(String string) throws InterruptedException {

		System.out.println(string);
	}

	// METODO BORRAR
	public void borrar(By locator, File rutaCarpeta, int time,String generarEvidencia,String msj) throws Exception {
		driver.findElement(locator).clear();
		tiempoEspera(time);
		capturaPantalla(rutaCarpeta, locator, generarEvidencia,msj);
	}

	// METODO ENVIAR TEXTO
	public void sendkey(String inputText, By locator, File rutaCarpeta, int time,String generarEvidencia, String msj) throws Exception {
		try {
			driver.findElement(locator).sendKeys(inputText);
			tiempoEspera(time);
			capturaPantalla(rutaCarpeta,locator, generarEvidencia,msj);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	// METODO ENTER SUBMIT
	public void submit(By locator, File rutaCarpeta, int time,String generarEvidencia,String msj) throws Exception {
		driver.findElement(locator).submit();
		tiempoEspera(time);
		capturaPantalla(rutaCarpeta, locator, generarEvidencia,msj);
	}

	// METODO PARA REALIZAR UN SCROLL
	public void scroll(int y, int numMovimientos) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i <= numMovimientos; i++) {
			js.executeScript("window.scrollBy(0," + y + ")");
		}
	}
	//METODO PARA CUALQUIER NUMERO
	public By localizadorVariable(By locator, String valor)throws Exception
	{
		String jj = locator.toString().replace("{0}", valor);
		String kk = jj.replace("By.xpath:", "");
		By localizador=By.xpath(kk);
		return localizador;
	}
	public List<MobileElement> listaElementos(By locator) throws Exception
    {
      
        List<MobileElement> elemento=driver.findElements(locator);
        return elemento;
    }
	public void digitos(String numeros, By locator, File rutaCarpeta, String generarEvidencia )throws Exception
	{
		String[]digito=new String[numeros.length()];
		
		for(int i=0; i<digito.length;i++) {
			digito[i]=String.valueOf(numeros.charAt(i));
			String msj=("Se escribe el número: "+digito[i]);
			click(localizadorVariable(locator,digito[i]),rutaCarpeta, generarEvidencia,msj);
		}
	
		
	}
	  public void scrollVertical(File rutaFile, int xini,int yini, int yfinal, int iteraciones) throws Exception
	    {
	        
	        for (int i = 1 ;i<=iteraciones;i++)
	        {
	            @SuppressWarnings("rawtypes")
	            TouchAction touch = new TouchAction(driver);
	            touch.press(PointOption.point(xini,yini))
	            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
	            .moveTo(PointOption.point(xini,yfinal))
	            .release().perform();
	           // capturaPantalla(rutaFile, locator, generarEvidencia);
	        }
	    }
	    
	    public void tocarPantalla(int x, int y)
	    {
	        @SuppressWarnings("rawtypes")
	        TouchAction touch = new TouchAction(driver);
	        touch.press(PointOption.point(x,y)).release().perform();
	        
	    }
	    public void enter(File rutaCarpeta, int time)throws Exception
        {
            String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
            ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
            tiempoEspera(time);
            //capturaPantalla(rutaCarpeta, locator, generarEvidencia);
        }
}
