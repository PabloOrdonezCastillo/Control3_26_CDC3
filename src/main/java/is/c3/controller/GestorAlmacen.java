package is.c3.controller;

import is.c3.model.entities.Almacen;
import is.c3.model.entities.Paquete;
import is.c3.model.Producto;


public class GestorAlmacen {
	public GestorAlmacen(Almacen almacen) {
		super();
		this.almacen = almacen;
	}

	private Almacen almacen;
	
	public static void main(String[] args) {
		
		// Crear una nueva instancia del Alamacen
		Almacen almacen = new Almacen();
		GestorAlmacen responsable=new GestorAlmacen(almacen);
		
		// Crear algunos productos
	    Paquete p1 = new Paquete("raspberry 4", "Calle A", 788);
	    Paquete p2 = new Paquete("raspberry 5", "Calle B", 815);
	    Paquete p3 = new Paquete("Nvidia gtx 1650", "Calle C", 1145);
	    Paquete p4 = new Paquete("Nvidia gtx 960", "Calle D", 985);

	    // Añadir todos los paquetes a la vez
	    Paquete[] paquetes = {p1, p2, p3, p4};
		responsable.llenarAlmacen(paquetes);
		
		responsable.estadoAlmacen();
		
		responsable.entregaPaquete(p1);
	}
	
	private void llenarAlmacen(Paquete [] paquetes) {
	    
	    almacen.saveAll(paquetes);
	}
	
	private void entregaPaquete(Paquete p) {
		
		if (almacen.find(p))
			almacen.delete(p);
	}
	
	private void estadoAlmacen() {
		
		System.out.println("Productos en el almacen BRL2259");
		
		for(Producto p: almacen.getProductos())
			System.out.print(p);
	}
	
}
