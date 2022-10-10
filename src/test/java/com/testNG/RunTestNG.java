package com.testNG;

import org.testng.annotations.Test;

import ClasesBase.ClaseBase;
import PagesObjects.PageObjectAlertasM;
import PagesObjects.PageObjectCalculadora;
import PagesObjects.PageObjectCrearCuenta;
import PagesObjects.PageObjectMercadoLibre;
import PagesObjects.PageObjectWidget;
import Utilidades.ExcelUtilidades;
import Utilidades.GenerarReportePdf;
import Utilidades.MyScreenRecorder;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;

import org.testng.annotations.AfterClass;

public class RunTestNG {
	AppiumDriver<MobileElement> driver;

	ClaseBase claseBase;
	PageObjectCalculadora operaciones;
	GenerarReportePdf generarReportePdf;
	PageObjectMercadoLibre tienda;
	PageObjectCrearCuenta crearCuenta;
	PageObjectAlertasM alertas;
	PageObjectWidget widget;
	String rutaImagenCalculadora;
	String rutaImagenMercadoLibre;
	String rutaImagenTools;
	String rutaOutput;
	String platformName;
	String deviceName;
	String platformVersion;
	String noReset;
	String autoGrantPermissior;

	@BeforeClass
	@Parameters({ "rutaOutput", "rutaImagenCalculadora", "rutaImagenMercadoLibre", "rutaImagenTools", "platformName",
			"deviceName", "platformVersion", "noReset", "autoGrantPermissior" })
	public void beforeClass(@Optional("default") String rutaOutput1, @Optional("default") String rutaImagenCalculadora1,
			@Optional("default") String rutaMercadoLibre1, @Optional("default") String rutaTools1,
			@Optional("default") String platformName1, @Optional("default") String deviceName1,
			@Optional("default") String platformVersion1, @Optional("default") String noReset1,
			@Optional("default") String autoGrantPermissior1) {

		// AGREGAR IMAGEN EN EL ENCABEZADO DEL PDF
		generarReportePdf = new GenerarReportePdf();
		// generarReportePdf.setRutaImagen("./imagenes/LogoMercadoLibre.PNG");
		rutaImagenCalculadora = rutaImagenCalculadora1;
		rutaImagenMercadoLibre = rutaMercadoLibre1;
		rutaImagenTools = rutaTools1;
		platformName = platformName1;
		deviceName = deviceName1;
		platformVersion = platformVersion1;
		noReset = noReset1;
		autoGrantPermissior = autoGrantPermissior1;

	}
/*
	@DataProvider(name = "Calculadora")
	public Object[][] datos() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/PruebaMobil.xlsx", "calculadora");
		return arreglo;

	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "Calculadora", priority = 1)
	public void operacion(String ejecutarCaso, String generarEvidencia, String operacion, String valor1, String valor2,
			String appPackage, String appActivity) throws Exception {
		// ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver = ClaseBase.appiumDriverConnetion(platformName, deviceName, platformVersion, appPackage, appActivity,
				noReset, autoGrantPermissior);
		// INSTANCIAR LA CLASE PAGEOBJECT
		operaciones = new PageObjectCalculadora(driver);
		// INSTANCIAR LA CLASE BASE
		claseBase = new ClaseBase(driver);
		// OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(nomTest);
		if (ejecutarCaso.equals("Si")) {

			if (generarEvidencia.contains("Si")) {
				// IMAGEN DEL ENCABEZADO
				generarReportePdf.setRutaImagen(rutaImagenCalculadora);
				// INICIA GRABACION DEL VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				operaciones.suma(operacion, valor1, valor2, rutaCarpeta, generarEvidencia);
				// FINALIZA GRABACION DEL VIDEO
				MyScreenRecorder.stopRecording();
				// FINALIZA CREACION DE REPORTE PDF
				generarReportePdf.cerrarPlantilla();
			} else {

				// ACCEDER AL METODO DE PRUEBA INICIAL
				operaciones.suma(operacion, valor1, valor2, rutaCarpeta, generarEvidencia);
			}
		} else {
			System.out.println("La automatización no se ejecutara");
		}

	}
*/
	@DataProvider(name = "mercadoLibre")
	public Object[][] datos1() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/PruebaMobil.xlsx", "mercadoLibre");
		return arreglo;

	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "mercadoLibre", priority = 2)
	public void compra(String ejecutarCaso, String generarEvidencia, String appPackage, String appActivity,
			String Correo, String Productos, String Google) throws Exception {
		// ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver = ClaseBase.appiumDriverConnetion(platformName, deviceName, platformVersion, appPackage, appActivity,
				noReset, autoGrantPermissior);
		// INSTANCIAR LA CLASE PAGEOBJECT
		tienda = new PageObjectMercadoLibre(driver);
		crearCuenta = new PageObjectCrearCuenta(driver);
		// INSTANCIAR LA CLASE BASE
		claseBase = new ClaseBase(driver);
		// OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(nomTest);
		if (ejecutarCaso.equals("Si")) {

			if (generarEvidencia.contains("Si")) {
				// IMAGEN DEL ENCABEZADO
				generarReportePdf.setRutaImagen(rutaImagenMercadoLibre);
				// INICIA GRABACION DEL VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				tienda.pagina(Productos, Google, rutaCarpeta, generarEvidencia);
				crearCuenta.crearCuenta(Correo, rutaCarpeta, generarEvidencia);
				// FINALIZA GRABACION DEL VIDEO
				MyScreenRecorder.stopRecording();
				// FINALIZA CREACION DE REPORTE PDF
				generarReportePdf.cerrarPlantilla();
			} else {

				// ACCEDER AL METODO DE PRUEBA INICIAL
				tienda.pagina(Productos, Google, rutaCarpeta, generarEvidencia);
				crearCuenta.crearCuenta(Correo, rutaCarpeta, generarEvidencia);
			}
		} else {
			System.out.println("La automatización no se ejecutara");
		}

	}
/*
	@DataProvider(name = "Alertas")
	public Object[][] datos2() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/PruebaMobil.xlsx", "toolsMobile");
		return arreglo;

	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "Alertas", priority = 3)
	public void alertas(String ejecutarCaso, String generarEvidencia, String appPackage, String appActivity, String url)
			throws Exception {
		// ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver = ClaseBase.appiumDriverConnetion(platformName, deviceName, platformVersion, appPackage, appActivity,
				noReset, autoGrantPermissior);
		// INSTANCIAR LA CLASE PAGEOBJECT
		alertas = new PageObjectAlertasM(driver);

		// INSTANCIAR LA CLASE BASE
		claseBase = new ClaseBase(driver);
		// OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(nomTest);
		if (ejecutarCaso.equals("Si")) {

			if (generarEvidencia.contains("Si")) {
				// IMAGEN DEL ENCABEZADO
				generarReportePdf.setRutaImagen(rutaImagenTools);
				// INICIA GRABACION DEL VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				alertas.alertas(url, rutaCarpeta, generarEvidencia);
				// FINALIZA GRABACION DEL VIDEO
				MyScreenRecorder.stopRecording();
				// FINALIZA CREACION DE REPORTE PDF
				generarReportePdf.cerrarPlantilla();
			} else {

				// ACCEDER AL METODO DE PRUEBA INICIAL
				alertas.alertas(url, rutaCarpeta, generarEvidencia);

			}
		} else {
			System.out.println("La automatización no se ejecutara");
		}
	}

	@DataProvider(name = "Widgets")
	public Object[][] datos3() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/PruebaMobil.xlsx", "toolsMobile");
		return arreglo;

	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "Widgets", priority = 4)
	public void widgets(String ejecutarCaso, String generarEvidencia, String appPackage, String appActivity, String url)
			throws Exception {
		// ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver = ClaseBase.appiumDriverConnetion(platformName, deviceName, platformVersion, appPackage, appActivity,
				noReset, autoGrantPermissior);
		// INSTANCIAR LA CLASE PAGEOBJECT
		widget = new PageObjectWidget(driver);
		// INSTANCIAR LA CLASE BASE
		claseBase = new ClaseBase(driver);
		// OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(nomTest);
		if (ejecutarCaso.equals("Si")) {

			if (generarEvidencia.contains("Si")) {
				// IMAGEN DEL ENCABEZADO
				generarReportePdf.setRutaImagen(rutaImagenTools);
				// INICIA GRABACION DEL VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				widget.widget(url, rutaCarpeta, generarEvidencia);
				widget.fecha2(url, rutaCarpeta, generarEvidencia);
				// FINALIZA GRABACION DEL VIDEO
				MyScreenRecorder.stopRecording();
				// FINALIZA CREACION DE REPORTE PDF
				generarReportePdf.cerrarPlantilla();
			} else {

				// ACCEDER AL METODO DE PRUEBA INICIAL
				widget.widget(url, rutaCarpeta, generarEvidencia);
				widget.fecha2(url, rutaCarpeta, generarEvidencia);
			}
		} else {
			System.out.println("La automatización no se ejecutara");
		}
	}
*/
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
